/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;
import javax.persistence.Id;

/**
 *
 * @author Arthur Assuncao
 */
@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;*/
    
    @Id @Column(nullable=false, unique=true)
    private String nome;
    
    @Column(nullable = false)
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
