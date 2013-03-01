/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.dao;

import com.arthurassuncao.model.Paciente;
import com.arthurassuncao.util.ConexaoBD;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Arthur Assuncao
 */
public class PacienteDAO implements InterfaceDAO<Paciente, Integer> {

    private Session session;

    @Override
    public boolean salvar(Paciente objeto) {
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
    public List<Paciente> findAll(){
        try{
            session = ConexaoBD.getInstance();
            Query q = session.createQuery("SELECT p FROM Paciente p ORDER BY nome ASC");

            List<Paciente> pacientes = q.list();
  
            return pacientes;
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
    public Paciente consultar(Integer chave) {
        session = ConexaoBD.getInstance();

        Paciente pac = null;
        try {
            pac = (Paciente)session.get(Paciente.class, chave); 
        }
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        finally{
            session.close();
        }
        return pac;
    }

    @Override
    public boolean alterar(Paciente objeto) {
        session = ConexaoBD.getInstance();
        Transaction transacao = null;

        try {
            Paciente pac = (Paciente)session.get(Paciente.class, objeto.getIdPaciente()); 
            
            pac.setNome(objeto.getNome());
            pac.setBairro(objeto.getBairro());
            pac.setCidade(objeto.getCidade());
            pac.setDataNasc(objeto.getDataNasc());
            pac.setLogradouro(objeto.getLogradouro());
            pac.setNumero(objeto.getNumero());
            pac.setUf(objeto.getUf());
            
            if(pac != null){
                transacao = session.beginTransaction();
                session.update(pac);
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
    public boolean excluir(Paciente objeto) {
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
