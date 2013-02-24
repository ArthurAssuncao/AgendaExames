/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.controller;

import com.arthurassuncao.model.Medico;
import com.arthurassuncao.dao.InterfaceDAO;
import com.arthurassuncao.dao.MedicoDAO;

/**
 *
 * @author Arthur Assuncao
 */
public class MedicoController implements IControllerDAO {
    private Medico medico;
    
    public MedicoController() {
        medico  = new Medico();	
    }
    
    public boolean salvar(){
        InterfaceDAO medicoDao = new MedicoDAO();
        return medicoDao.salvar(medico);
    }
}
