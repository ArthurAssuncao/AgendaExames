/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.dao;

import com.arthurassuncao.model.Agenda;
import com.arthurassuncao.model.AgendaPK;
import com.arthurassuncao.util.ConexaoBD;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Arthur Assuncao
 */
public class AgendaDAO implements InterfaceDAO<Agenda, AgendaPK> {

    private Session session;

    @Override
    public boolean salvar(Agenda objeto) {
        session = ConexaoBD.getInstance();
        Transaction transacao = null;

        try {
            transacao = session.beginTransaction();
            session.saveOrUpdate(objeto);
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
    public List<Agenda> findAll(){
        try{
            session = ConexaoBD.getInstance();
            Query q = session.createQuery("SELECT a FROM Agenda a");

            List<Agenda> agendas = q.list();
  
            return agendas;
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
    public Agenda consultar(AgendaPK objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean alterar(Agenda objeto) {
        session = ConexaoBD.getInstance();
        Transaction transacao = null;

        try {
            Agenda age = (Agenda)session.get(Agenda.class, objeto.getAgendaPK()); 
            age.setExame(objeto.getExame());
            age.setMedico(objeto.getMedico());
            age.setObs(objeto.getObs());
            age.setPaciente(objeto.getPaciente());
            age.setResultado(objeto.getResultado());
            if(age != null){
                transacao = session.beginTransaction();
                session.update(age);
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
    public boolean excluir(Agenda objeto) {
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
    
    public List<Agenda> buscar(Date dataInicial, Date dataFinal){
        try{
            session = ConexaoBD.getInstance();
            Query q = session.createQuery("SELECT a FROM Agenda a WHERE dataHora BETWEEN :dataInicial AND :dataFinal");
            System.out.println("dataInicial: " + dataInicial);
            q.setParameter("dataInicial", dataInicial);
            q.setParameter("dataFinal", dataFinal);

            List<Agenda> agendas = q.list();
  
            return agendas;
        }
        catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
        finally{
            session.close();
        }
    }
}
