/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade1;

/**
 *
 * @author joaom
 */
public class ItemEmprestimo {
    
 private Livro livro;
    private boolean devolvido;

    public ItemEmprestimo(Livro livro) {
        this.livro = livro;
        this.devolvido = false;
    }

    public Livro getLivro() {
        return livro;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void registrarDevolucao() {
        devolvido = true;
        livro.devolver();
    }
}
