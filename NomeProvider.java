/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg;

/**
 *
 * @author pedro
 */
import java.io.Serializable;

public class NomeProvider implements Serializable {
    private String nome;

    public NomeProvider(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

