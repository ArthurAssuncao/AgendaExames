package com.arthurassuncao.controller;

import com.arthurassuncao.dao.UsuarioDAO;
import com.arthurassuncao.model.Usuario;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Arthur Assuncao
 */
public class UsuarioController implements IControllerDAO{
    private Usuario usuario;
    
    public UsuarioController() {
        usuario  = new Usuario();
    }
    
    public Usuario getUsuarioLogado(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        Map<String, Object> sessao = contexto.getExternalContext().getSessionMap();
        if(sessao.containsKey("usuario")){
            return ((Usuario)sessao.get("usuario"));
        }
        return null;
    }
    
    public String verificaLogin(){
        System.out.println("Fazendo login...");
        UsuarioDAO usuarioDao = new UsuarioDAO();
        FacesContext contexto = FacesContext.getCurrentInstance();
        Map<String, Object> sessao = contexto.getExternalContext().getSessionMap();
        if(usuarioDao.verificaLogin(usuario)){
            System.out.println("Login correto");
            sessao.put("usuario", usuario);
            return "login_ok";
        }
        else{
            System.out.println("Login incorreto");
            FacesMessage msg = new FacesMessage("Login incorreto");
            contexto.addMessage("form_login", msg);
            return null;
        }
    }
    
    @Override
    public boolean salvar(){
        UsuarioDAO usuarioDao = new UsuarioDAO();
        boolean loginValido = usuarioDao.verificaLogin(usuario);
        System.out.println(loginValido);
        if(!loginValido){
            return usuarioDao.salvar(usuario);
        }
        return false;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
