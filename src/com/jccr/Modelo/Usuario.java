/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jccr.Modelo;

/**
 * Esta clase permite crear un Usuario con sus datos basicos.
 * @author Grupo 4 Plataformas de Desarrollo de Software
 * Version 1.0
 */
public class Usuario {

    //atributo que representa el id del usuario
    private int usuId;
    //atributo que representa el nombre del usuario
    private String usuNom;
    //atributo que representa la identificación del usuario
    private String usuIdent;
    //atributo que representa la clave del usuario
    private String usuClavePass;
    //atributo que representa el estado del usuario
    private int usuEstado;

    /**
     * Constructor vacio
     */
    public Usuario () {
    }

    /**
     * Crea un Usuario con sus caracteristicas fundamentales
     * @param usuId un int que representa el id del usuario
     * @param usuNom un String que representa el nombre del usuario
     * @param usuIdent un String que representa la identificación del usuario
     * @param usuClavePass un String que representa la clave de ingreso al sistema
     * @param usuEstado un int representa si el usuario esta activo 1 o 0 inactivo
     */
    public Usuario(int usuId, String usuNom, String usuIdent, String usuClavePass, int usuEstado) {
        this.usuId = usuId;
        this.usuNom = usuNom;
        this.usuIdent = usuIdent;
        this.usuClavePass = usuClavePass;
        this.usuEstado = usuEstado;
    }

    /**
     * Metodo getUsuId()
     * @return un int con el id del usuario
     */
    public int getUsuId() {
        return usuId;
    }

    /**
     * Metodo setUsuId()
     * actualiza el id del usuario
     * @param usuId int con el id del usuario
     */
    public void setUsuId(int usuId) {
        this.usuId = usuId;
    }

    /**
     * Metodo getUsuNom()
     * devuelve el nombre del usuario
     * @return un String con el nombre del usuario
     */
    public String getUsuNom() {
        return usuNom;
    }

    /**
     * Metodo setUsuNom()
     * actualiza el nombre del usuario
     * @param usuNom un String con el nombre del usuario
     */
    public void setUsuNom(String usuNom) {
        this.usuNom = usuNom;
    }

    /**
     * Metodo getUsuIdent
     * @return la identificación del usuario
     */
    public String getUsuIdent() {
        return usuIdent;
    }

    /**
     * Metodo setUsuIdent()
     * actualiza la identificación del usuario
     * @param usuIdent String con la identificación del usuario
     */
    public void setUsuIdent(String usuIdent) {
        this.usuIdent = usuIdent;
    }

    /**
     * Metodo getUsuClavePass()
     * devuelve la clave del usuario
     * @return un String con la clave del usuario.
     */
    public String getUsuClavePass() {
        return usuClavePass;
    }

    /**
     * Metodo setUsuClavePass()
     * actualiza la clave del usuario
     * @param usuClavePass un String con la clave del usuario.
     */
    public void setUsuClavePass(String usuClavePass) {
        this.usuClavePass = usuClavePass;
    }

    /**
     * Metodo getUsuEstado()
     * devuelve el estado del usuario 
     * @return un int con estado del usuario activo 1 o 0 inactivo
     */
    public int getUsuEstado() {
        return usuEstado;
    }

    /**
     * Metodo setUsuEstado()
     * actualiza si el usuario esta usuEstado
     * @param usuEstado un int con si el usuario esta usuEstado
     */
    public void setUsuEstado(int usuEstado) {
        this.usuEstado = usuEstado;
    }

    
}

