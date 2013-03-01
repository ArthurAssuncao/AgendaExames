/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.controller;

import com.arthurassuncao.dao.InterfaceDAO;
import com.arthurassuncao.dao.AgendaDAO;
import com.arthurassuncao.model.Agenda;
import com.arthurassuncao.model.AgendaPK;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Arthur Assuncao
 */
public class AgendaController implements IControllerDAO<AgendaController, AgendaPK> {

    private Agenda agenda;

    public AgendaController() {
        agenda = new Agenda();
        agenda.setAgendaPK(new AgendaPK());
    }

    private AgendaController(Agenda agenda) {
        this.agenda = agenda;
    }

    public AgendaPK getAgendaPK() {
        return agenda.getAgendaPK();
    }

    public void setAgendaPK(AgendaPK agendaPK) {
        agenda.setAgendaPK(agendaPK);
    }

    @Override
    public boolean salvar() {
        System.out.println(agenda);
        if (agenda.getAgendaPK().getDataHora() != null) {
            InterfaceDAO<Agenda, AgendaPK> agendaDao = new AgendaDAO();
            boolean salvou = agendaDao.salvar(agenda);
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg;
            if (salvou) {
                msg = new FacesMessage("Agenda cadastrado com sucesso");
                contexto.addMessage("form_cadastro_agenda", msg);
                agenda = new Agenda();
                return true;
            }
            msg = new FacesMessage("Não foi possível cadastrar o Agenda");
            contexto.addMessage("form_cadastro_agenda", msg);
            return false;
        }
        return false;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    @Override
    public ListDataModel<AgendaController> listar() {
        AgendaDAO agendaDAO = new AgendaDAO();
        List<AgendaController> agendasController = new ArrayList();

        List<Agenda> agendas = agendaDAO.findAll();

        if (agendas != null) {
            for (Agenda med : agendas) {
                agendasController.add(new AgendaController(med));
            }
            return new ListDataModel(agendasController);
        } else {
            return null;
        }
    }

    public String alterarDados(Agenda agenda) {
        this.agenda = agenda;
        return "alterar_agenda";
    }

    @Override
    public boolean alterar() {
        InterfaceDAO<Agenda, AgendaPK> agendaDao = new AgendaDAO();
        return agendaDao.alterar(agenda);
    }

    @Override
    public String remover() {
        InterfaceDAO<Agenda, AgendaPK> agendaDao = new AgendaDAO();
        if (agendaDao.excluir(agenda)) {
            return "removeu_agenda";
        } else {
            return "nao_removeu_agenda";
        }
    }

    @Override
    public AgendaController consultar(AgendaPK chave) {
        InterfaceDAO<Agenda, AgendaPK> agendaDao = new AgendaDAO();
        Agenda agenda = agendaDao.consultar(chave);
        return new AgendaController(agenda);
    }

    public List<AgendaController> buscar(Date dataInicial, Date dataFinal) {
        AgendaDAO agendaDao = new AgendaDAO();
        List<Agenda> agendas = agendaDao.buscar(dataInicial, dataFinal);
        List<AgendaController> agendasController = new ArrayList<AgendaController>();
        for (Agenda a : agendas) {
            agendasController.add(new AgendaController(a));
        }
        return agendasController;
    }
}
