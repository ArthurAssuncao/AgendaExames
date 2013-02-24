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
    public abstract boolean salvar(T objeto);
    public abstract T consultar(T objeto);
    public abstract boolean alterar(T objeto);
    public abstract boolean excluir(T objeto);
}
