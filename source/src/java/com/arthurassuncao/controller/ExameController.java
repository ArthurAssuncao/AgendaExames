/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.controller;

import com.arthurassuncao.dao.InterfaceDAO;
import com.arthurassuncao.dao.ExameDAO;
import com.arthurassuncao.model.Exame;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Arthur Assuncao
 */
public class ExameController implements IControllerDAO<ExameController, Integer> {

    private Exame exame;

    public ExameController() {
        exame = new Exame();
    }

    private ExameController(Exame exame) {
        this.exame = exame;
    }

    @Override
    public boolean salvar() {
        System.out.println(exame);
        if(exame.getIdExame() != null){
            return alterar();
        }
        InterfaceDAO<Exame, Integer> exameDao = new ExameDAO();
        boolean salvou = exameDao.salvar(exame);
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage msg;
        if (salvou) {
            msg = new FacesMessage("Exame cadastrado com sucesso");
            contexto.addMessage("form_cadastro_exame", msg);
            exame = new Exame();
            return true;
        }
        msg = new FacesMessage("Não foi possível cadastrar o Exame");
        contexto.addMessage("form_cadastro_exame", msg);
        return false;

    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    @Override
    public ListDataModel<ExameController> listar() {
        ExameDAO exameDAO = new ExameDAO();
        List<ExameController> examesController = new ArrayList();

        List<Exame> exames = exameDAO.findAll();

        if (exames != null) {
            for (Exame med : exames) {
                examesController.add(new ExameController(med));
            }
            return new ListDataModel(examesController);
        } else {
            return null;
        }
    }

    public String alterarDados(Exame exame) {
        this.exame = exame;
        return "alterar_exame";
    }

    @Override
    public boolean alterar() {
        InterfaceDAO<Exame, Integer> exameDao = new ExameDAO();
        return exameDao.alterar(exame);
    }

    @Override
    public String remover() {
        InterfaceDAO<Exame, Integer> exameDao = new ExameDAO();
        if (exameDao.excluir(exame)) {
            return "removeu_exame";
        }
        else {
            return "nao_removeu_exame";
        }
    }
    
    @Override
    public ExameController consultar(Integer chave) {
        InterfaceDAO<Exame, Integer> exameDao = new ExameDAO();
        Exame exame = exameDao.consultar(chave);
        return new ExameController(exame);
    }
}
