package com.arthurassuncao.controller;

import com.arthurassuncao.dao.UsuarioDAO;
import com.arthurassuncao.model.Usuario;
import java.io.IOException;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Arthur Assuncao
 */
public class UsuarioController implements IControllerDAO<UsuarioController, String> {

    private Usuario usuario;

    public UsuarioController() {
        usuario = new Usuario();
    }
    
    public UsuarioController(Usuario usuario){
        this.usuario = usuario;
    }

    public Usuario getUsuarioLogado() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        Map<String, Object> sessao = contexto.getExternalContext().getSessionMap();
        if (sessao.containsKey("usuario")) {
            return ((Usuario) sessao.get("usuario"));
        }
        return null;
    }
    
    public String verificaLogin(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        FacesContext contexto = FacesContext.getCurrentInstance();
        Map<String, Object> sessao = contexto.getExternalContext().getSessionMap();
        if(sessao.containsKey("usuario")){
            return null;
        }
        else if(usuario.getNome() == null || usuario.getSenha() == null){
            try{
                ExternalContext contextoExterno = contexto.getExternalContext();
                String url = contextoExterno.getRequestServletPath();
                if(url.startsWith("/user/")){
                    contextoExterno.redirect("../index.xhtml");
                }
            }
            catch(IOException e){
                System.out.println("Erro: " + e.getMessage());
            }
            return null;
        }
        else if(usuarioDAO.verificaLogin(usuario)){
            sessao.put("usuario", usuario);
            return "login_ok";
        }
        else{
            FacesMessage msg = new FacesMessage("Login incorreto");
            contexto.addMessage("form_login", msg);
            return null;
        }
    }

    @Override
    public boolean salvar() {
        System.out.println("Salvando medico");
        UsuarioDAO usuarioDao = new UsuarioDAO();
        boolean loginValido = usuarioDao.verificaLogin(usuario);
        System.out.println(loginValido);
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage msg = null;
        if (!loginValido) {
            boolean salvou = usuarioDao.salvar(usuario);
            if (salvou) {
                msg = new FacesMessage("Usuário cadastrado com sucesso");
                contexto.addMessage("form_login", msg);
                return true;
            }
        }
        msg = new FacesMessage("Não foi possível cadastrar o usuário");
        contexto.addMessage("form_login", msg);
        return false;

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean alterar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String remover() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListDataModel<UsuarioController> listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public UsuarioController consultar(String chave) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
