package com.arthurassuncao.controller;

import javax.faces.model.ListDataModel;

/**
 *
 * @author Arthur Assuncao
 */
public interface IControllerDAO<T> {
    public boolean salvar();
    public boolean alterar();
    public String remover();
    public ListDataModel<T> listar();
}
