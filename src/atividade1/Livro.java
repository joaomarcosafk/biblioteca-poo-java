/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade1;

/**
 *
 * @author joaom
 */
public class Livro {
    
private int codigo;
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(int codigo, String titulo, String autor) {
        if (codigo <= 0 || titulo.isEmpty() || autor.isEmpty()) {
            System.out.println("Dados inválidos para livro.");
        }

        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void atualizarDados(String titulo, String autor) {
        if (titulo.isEmpty() || autor.isEmpty()) {
            System.out.println("Título e autor não podem ser vazios.");
        }

        this.titulo = titulo;
        this.autor = autor;
    }

    public void emprestar() {
        disponivel = false;
    }

    public void devolver() {
        disponivel = true;
    }

    public String toString() {
        String situacao;

        if (disponivel) {
            situacao = "disponível";
        } else {
            situacao = "indisponível";
        }

        return codigo + " - " + titulo + " (" + autor + ") - " + situacao;
    }
}

