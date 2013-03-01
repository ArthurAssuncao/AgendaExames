/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.controller;

import com.arthurassuncao.dao.InterfaceDAO;
import com.arthurassuncao.dao.PacienteDAO;
import com.arthurassuncao.model.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Arthur Assuncao
 */
public class PacienteController implements IControllerDAO<PacienteController, Integer> {

    private Paciente paciente;

    public PacienteController() {
        paciente = new Paciente();
    }

    private PacienteController(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public boolean salvar() {
        System.out.println(paciente);
        if(paciente.getIdPaciente() != null){
            return alterar();
        }
        InterfaceDAO pacienteDao = new PacienteDAO();
        boolean salvou = pacienteDao.salvar(paciente);
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage msg;
        if (salvou) {
            msg = new FacesMessage("Paciente cadastrado com sucesso");
            contexto.addMessage("form_cadastro_paciente", msg);
            paciente = new Paciente();
            return true;
        }
        msg = new FacesMessage("Não foi possível cadastrar o Paciente");
        contexto.addMessage("form_cadastro_paciente", msg);
        return false;

    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public ListDataModel<PacienteController> listar() {
        PacienteDAO pacienteDAO = new PacienteDAO();
        List<PacienteController> pacientesController = new ArrayList();

        List<Paciente> pacientes = pacienteDAO.findAll();

        if (pacientes != null) {
            for (Paciente pac : pacientes) {
                pacientesController.add(new PacienteController(pac));
            }
            return new ListDataModel(pacientesController);
        }
        else {
            return null;
        }
    }

    public String alterarDados(Paciente paciente) {
        this.paciente = paciente;
        return "alterar_paciente";
    }

    @Override
    public boolean alterar() {
        InterfaceDAO<Paciente, Integer> pacienteDao = new PacienteDAO();
        return pacienteDao.alterar(paciente);
    }

    @Override
    public String remover() {
        InterfaceDAO<Paciente, Integer> pacienteDao = new PacienteDAO();
        if (pacienteDao.excluir(paciente)) {
            return "removeu_paciente";
        }
        else {
            return "nao_removeu_paciente";
        }
    }
    
    @Override
    public PacienteController consultar(Integer chave) {
        InterfaceDAO<Paciente, Integer> pacienteDao = new PacienteDAO();
        Paciente paciente = pacienteDao.consultar(chave);
        return new PacienteController(paciente);
    }
}
