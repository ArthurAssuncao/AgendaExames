/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.dao;

import com.arthurassuncao.model.Usuario;
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
        boolean exists = exists(objeto);

        return exists;
    }

    @Override
    public boolean salvar(Usuario objeto) {
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
    
    public boolean exists(Usuario objeto) {
        session = ConexaoBD.getInstance();
        Query query = session.createQuery("SELECT u FROM Usuario u WHERE u.nome=:nome AND senha=:senha");
        query.setParameter("nome", objeto.getNome());
        query.setParameter("senha", objeto.getSenha());
        Usuario usuario = (Usuario)query.uniqueResult();
        if(usuario == null){
            return false;
        }
        return true;
    }

    @Override
    public Usuario consultar(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean alterar(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean excluir(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
