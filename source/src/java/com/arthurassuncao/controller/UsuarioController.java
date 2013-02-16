package com.arthurassuncao.controller;

import com.arthurassuncao.bean.Usuario;
import com.arthurassuncao.dao.InterfaceDAO;
import com.arthurassuncao.dao.UsuarioDAO;
import java.io.Serializable;

/**
 *
 * @author Arthur Assuncao
 */
public class UsuarioController implements IControllerDAO{
    private Usuario usuario;
    
    public UsuarioController() {
        usuario  = new Usuario();
    }
    
    public boolean verificaLogin(){
        UsuarioDAO usuarioDao = new UsuarioDAO();
        return usuarioDao.verificaLogin(usuario);
    }
    
    public String salvar(){
        boolean loginValido = verificaLogin();
        System.out.println(loginValido);
        if(!loginValido){
            InterfaceDAO usuarioDao = new UsuarioDAO();
            usuarioDao.salvar(usuario);
            System.out.println("Insere usuario");
        }
        return "salvar";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
