/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.dao;

import com.arthurassuncao.model.Medico;
import com.arthurassuncao.util.ConexaoBD;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Arthur Assuncao
 */
public class MedicoDAO implements InterfaceDAO<Medico> {

    private Session session;

    @Override
    public boolean salvar(Medico objeto) {
        session = ConexaoBD.getInstance();
        Transaction transacao = null; //permite transacao com o BD 

        try {
            transacao = session.beginTransaction();
            session.save(objeto);
            transacao.commit();//faz a transacao
            return true;
        }
        catch (Exception e) {
            //cancela a transcao em caso de falha
            transacao.rollback();
        }
        return false;
    }

    @Override
    public Medico consultar(Medico objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean alterar(Medico objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean excluir(Medico objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
