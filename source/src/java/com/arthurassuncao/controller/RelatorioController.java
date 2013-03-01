/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.controller;

import com.arthurassuncao.model.Exame;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Arthur Assuncao
 */
public class RelatorioController {

    private Date dataInicial;
    private Date dataFinal;
    private double total;

    public RelatorioController() {
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void addTotal(double valor) {
        this.total += valor;
    }
    
    public ListDataModel<AgendaController> listar(){
        total = 0;
        AgendaController agendaController = new AgendaController();

        List<AgendaController> agendasController = agendaController.buscar(dataInicial, dataFinal);
        for (AgendaController agenda : agendasController){
            Exame exame = agenda.getAgenda().getExame();
            total += exame.getValor();
        }

        if (agendasController != null){
            return new ListDataModel(agendasController);
        }
        else{
            return null;
        }
    }
    
    public String consultar(){
        if(dataInicial != null && dataFinal != null){
            return "consultar_relatorio";
        }
        else {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage("Preencha os campos corretamente");
            contexto.addMessage("form_consulta_relatorio", msg);
            return null;
        }
    }
    
}
