/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.controller;

import com.arthurassuncao.dao.InterfaceDAO;
import com.arthurassuncao.dao.MedicoDAO;
import com.arthurassuncao.model.Medico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Arthur Assuncao
 */
public class MedicoController implements IControllerDAO<MedicoController, Integer> {

    private Medico medico;

    public MedicoController() {
        medico = new Medico();
    }

    private MedicoController(Medico medico) {
        this.medico = medico;
    }

    @Override
    public boolean salvar() {
        System.out.println(medico);
        if(medico.getIdMedico() != null){
            return alterar();
        }
        InterfaceDAO<Medico, Integer> medicoDao = new MedicoDAO();
        boolean salvou = medicoDao.salvar(medico);
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage msg;
        if (salvou) {
            msg = new FacesMessage("Médico cadastrado com sucesso");
            contexto.addMessage("form_cadastro_medico", msg);
            medico = new Medico();
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

    @Override
    public ListDataModel<MedicoController> listar() {
        MedicoDAO medicoDAO = new MedicoDAO();
        List<MedicoController> medicosController = new ArrayList();

        List<Medico> medicos = medicoDAO.findAll();

        if (medicos != null) {
            for (Medico med : medicos) {
                medicosController.add(new MedicoController(med));
            }
            return new ListDataModel(medicosController);
        }
        else {
            return null;
        }
    }

    public String alterarDados(Medico medico) {
        this.medico = medico;
        return "alterar_medico";
    }

    @Override
    public boolean alterar() {
        InterfaceDAO<Medico, Integer> medicoDao = new MedicoDAO();
        return medicoDao.alterar(medico);
    }

    @Override
    public String remover() {
        InterfaceDAO<Medico, Integer> medicoDao = new MedicoDAO();
        if (medicoDao.excluir(medico)) {
            return "removeu_medico";
        }
        else {
            return "nao_removeu_medico";
        }
    }

    @Override
    public MedicoController consultar(Integer chave) {
        InterfaceDAO<Medico, Integer> medicoDao = new MedicoDAO();
        Medico medico = medicoDao.consultar(chave);
        return new MedicoController(medico);
    }
}
