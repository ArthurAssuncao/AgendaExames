/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.dao;

import com.arthurassuncao.model.Medico;
import com.arthurassuncao.util.ConexaoBD;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Arthur Assuncao
 */
public class MedicoDAO implements InterfaceDAO<Medico, Integer> {

    private Session session;

    @Override
    public boolean salvar(Medico objeto) {
        session = ConexaoBD.getInstance();
        Transaction transacao = null;

        try {
            transacao = session.beginTransaction();
            session.save(objeto);
            transacao.commit();
            return true;
        }
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            if(transacao.isActive()){
                transacao.rollback();
            }
        }
        finally{
            session.close();
        }
        return false;
    }
    
    @Override
    public List<Medico> findAll(){
        try{
            session = ConexaoBD.getInstance();
            Query q = session.createQuery("SELECT m FROM Medico m ORDER BY nome ASC");

            List<Medico> medicos = q.list();
  
            return medicos;
        }
        catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
        finally{
            session.close();
        }
    }

    @Override
    public Medico consultar(Integer chave) {
        session = ConexaoBD.getInstance();

        Medico med = null;
        try {
            med = (Medico)session.get(Medico.class, chave); 
        }
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        finally{
            session.close();
        }
        return med;
    }

    @Override
    public boolean alterar(Medico objeto) {
        session = ConexaoBD.getInstance();
        Transaction transacao = null;

        try {
            Medico med = (Medico)session.get(Medico.class, objeto.getIdMedico()); 
            med.setCrm(objeto.getCrm());
            med.setNome(objeto.getNome());
            if(med != null){
                transacao = session.beginTransaction();
                session.update(med);
                transacao.commit();
                return true;
            }
        }
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            if(transacao.isActive()){
                transacao.rollback();
            }
        }
        finally{
            session.close();
        }
        return false;
    }

    @Override
    public boolean excluir(Medico objeto) {
        session = ConexaoBD.getInstance();
        Transaction transacao = null;
      
        try {
            transacao = session.beginTransaction();
            session.delete(objeto);
            transacao.commit();
            return true;
        }
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            if(transacao.isActive()){
                transacao.rollback();
            }
        }
        finally{
            session.close();
        }
        return false;
    }
}
