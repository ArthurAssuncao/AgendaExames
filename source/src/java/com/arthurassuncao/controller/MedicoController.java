/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.controller;

import com.arthurassuncao.bean.Medico;
import com.arthurassuncao.dao.InterfaceDAO;
import com.arthurassuncao.dao.MedicoDAO;

/**
 *
 * @author Arthur Assuncao
 */
public class MedicoController {
    private Medico medico;
    
    public MedicoController() {
        medico  = new Medico();	
    }
    
    public String salvar(){
        InterfaceDAO medicoDao = new MedicoDAO();
        medicoDao.salvar(medico);
        return "salvar";
    }
}
