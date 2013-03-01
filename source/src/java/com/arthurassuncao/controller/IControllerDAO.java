package com.arthurassuncao.controller;

import javax.faces.model.ListDataModel;

/**
 *
 * @author Arthur Assuncao
 */
public interface IControllerDAO<T, E> {
    public boolean salvar();
    public boolean alterar();
    public String remover();
    public T consultar(E chave);
    public ListDataModel<T> listar();
}
