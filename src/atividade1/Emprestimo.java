/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Emprestimo {
    
private int codigo;
    private LocalDate dataEmprestimo;
    private boolean finalizado;
    private Leitor leitor;
    private ArrayList<ItemEmprestimo> itens;

    public Emprestimo(int codigo, Leitor leitor) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("Código inválido.");
        }

        this.codigo = codigo;
        this.leitor = leitor;
        this.dataEmprestimo = LocalDate.now();
        this.finalizado = false;
        this.itens = new ArrayList<ItemEmprestimo>();
    }

    public int getCodigo() {
        return codigo;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public boolean adicionarLivro(Livro livro) {
        if (!livro.isDisponivel() || contemLivro(livro)) {
            return false;
        }

        ItemEmprestimo item = new ItemEmprestimo(livro);
        itens.add(item);
        livro.emprestar();
        return true;
    }

    public boolean contemLivro(Livro livro) {
        for (ItemEmprestimo item : itens) {
            if (item.getLivro() == livro) {
                return true;
            }
        }
        return false;
    }

    public void finalizar() {
        if (finalizado) {
            throw new IllegalStateException("Empréstimo já finalizado.");
        }

        for (ItemEmprestimo item : itens) {
            item.registrarDevolucao();
        }

        finalizado = true;
    }

    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String situacao;
        String nomesLivros = "";

        if (finalizado) {
            situacao = "finalizado";
        } else {
            situacao = "aberto";
        }

        for (int i = 0; i < itens.size(); i++) {
            nomesLivros = nomesLivros + itens.get(i).getLivro().getTitulo();

            if (i < itens.size() - 1) {
                nomesLivros = nomesLivros + ", ";
            }
        }

        return codigo + " - " + leitor.getNome() + " - "
                + dataEmprestimo.format(formato) + " - " + situacao
                + " - livros: " + nomesLivros;
    }
}
