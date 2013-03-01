/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.dao;

import java.util.List;

/**
 *
 * @author Arthur Assuncao
 */
public interface InterfaceDAO<T, E> {
    public abstract boolean salvar(T objeto);
    public abstract T consultar(E chave);
    public abstract boolean alterar(T objeto);
    public abstract boolean excluir(T objeto);
    public abstract List<T> findAll();
}
