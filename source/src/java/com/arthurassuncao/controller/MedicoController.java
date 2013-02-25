/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.controller;

import com.arthurassuncao.dao.InterfaceDAO;
import com.arthurassuncao.dao.MedicoDAO;
import com.arthurassuncao.model.Medico;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Arthur Assuncao
 */
public class MedicoController implements IControllerDAO {

    private Medico medico;

    public MedicoController() {
        medico = new Medico();
    }

    @Override
    public boolean salvar() {
        InterfaceDAO medicoDao = new MedicoDAO();
        boolean salvou = medicoDao.salvar(medico);
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage msg;
        if (salvou) {
            msg = new FacesMessage("Médico cadastrado com sucesso");
            contexto.addMessage("form_cadastro_medico", msg);
            return true;
        }
        msg = new FacesMessage("Não foi possível cadastrar o Médico");
        contexto.addMessage("form_cadastro_medico", msg);
        return false;

    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
