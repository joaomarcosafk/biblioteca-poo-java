/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade1;

/**
 *
 * @author joaom
 */
public class Leitor {
    
private int codigo;
    private String nome;
    private String email;

    public Leitor(int codigo, String nome, String email) {
        if (codigo <= 0 || nome.isEmpty() || email.isEmpty()) {
            System.out.println("Dados inválidos para leitor.");
        }

        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void atualizarDados(String nome, String email) {
        if (nome.isEmpty() || email.isEmpty()) {
            System.out.println("Nome e email não podem ser vazios.");
        }

        this.nome = nome;
        this.email = email;
    }

    public String toString() {
        return codigo + " - " + nome + " (" + email + ")";
    }
}

