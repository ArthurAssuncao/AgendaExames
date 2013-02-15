/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.dao;

/**
 *
 * @author Arthur Assuncao
 */
public interface InterfaceDAO<T> {
    public abstract void salvar(T objeto);
    public abstract void consultar(T objeto);
    public abstract void alterar(T objeto);
    public abstract void excluir(T objeto);
}
