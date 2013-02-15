/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.dao;

import com.arthurassuncao.bean.Usuario;
import com.arthurassuncao.util.ConexaoBD;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Arthur Assuncao
 */
public class UsuarioDAO implements InterfaceDAO<Usuario> {

    private Session session;

    public boolean verificaLogin(Usuario objeto) {
        session = ConexaoBD.getInstance();
        Transaction transacao = null; //permite transacao com o BD 

        boolean exists = exists(objeto);

        return exists;
    }

    @Override
    public void salvar(Usuario objeto) {
        session = ConexaoBD.getInstance();
        Transaction transacao = null; //permite transacao com o BD 

        try {
            transacao = session.beginTransaction();
            session.save(objeto);
            transacao.commit();//faz a transacao
        } catch (Exception e) {
            //cancela a transcao em caso de falha
            transacao.rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void consultar(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Boolean exists(Usuario objeto) {
        session = ConexaoBD.getInstance();
        Query query = session.createQuery("SELECT u FROM Usuario u WHERE u.nome=:nome");
        query.setParameter("nome", objeto.getNome());
        Usuario usuario = (Usuario)query.uniqueResult();
        if(usuario == null){
            return false;
        }
        return true;
    }
}
