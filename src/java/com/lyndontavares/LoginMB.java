/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyndontavares;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Usuario1
 */
@SessionScoped
@ManagedBean
public class LoginMB {
    
    private String login;
    
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String login(){
        
        if ( ( getLogin().toUpperCase().equals( Papel.ALUNO.toString() ) && getSenha().equals("1234")) ||
              ( getLogin().toUpperCase().equals( Papel.SERVIDOR.toString() ) && getSenha().equals("abcd") )          ) {
            return "tabela";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Login Inválido!",
                    "Tente novamente!"));
            return "login";
        }
        
    }
    public boolean isServidor() {
       return Papel.SERVIDOR.toString().equals(getLogin().toUpperCase());
    }

    public boolean isAluno() {
       return Papel.ALUNO.toString().equals(getLogin().toUpperCase());
    }
    
    public String logout(){
        setLogin("");
        setSenha("");
        return "login";
    }
    
}
