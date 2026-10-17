/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade1;

import java.util.ArrayList;

public class Biblioteca {
    
 private ArrayList<Leitor> leitores;
    private ArrayList<Livro> livros;
    private ArrayList<Emprestimo> emprestimos;

    public Biblioteca() {
        leitores = new ArrayList<Leitor>();
        livros = new ArrayList<Livro>();
        emprestimos = new ArrayList<Emprestimo>();
    }

    public boolean cadastrarLeitor(Leitor leitor) {
        if (leitor == null || consultarLeitor(leitor.getCodigo()) != null) {
            return false;
        }

        leitores.add(leitor);
        return true;
    }

    public Leitor consultarLeitor(int codigo) {
        for (Leitor leitor : leitores) {
            if (leitor.getCodigo() == codigo) {
                return leitor;
            }
        }
        return null;
    }

    public void listarLeitores() {
        if (leitores.isEmpty()) {
            System.out.println("Nenhum leitor cadastrado.");
        } else {
            for (Leitor leitor : leitores) {
                System.out.println(leitor);
            }
        }
    }

    public boolean removerLeitor(Leitor leitor) {
        for (Emprestimo emprestimo : emprestimos) {
            if (!emprestimo.isFinalizado()
                    && emprestimo.getLeitor() == leitor) {
                return false;
            }
        }

        return leitores.remove(leitor);
    }

    public boolean cadastrarLivro(Livro livro) {
        if (livro == null || consultarLivro(livro.getCodigo()) != null) {
            return false;
        }

        livros.add(livro);
        return true;
    }

    public Livro consultarLivro(int codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo() == codigo) {
                return livro;
            }
        }
        return null;
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    public boolean removerLivro(Livro livro) {
        for (Emprestimo emprestimo : emprestimos) {
            if (!emprestimo.isFinalizado()
                    && emprestimo.contemLivro(livro)) {
                return false;
            }
        }

        return livros.remove(livro);
    }

    public boolean registrarEmprestimo(int codigo, Leitor leitor,
            ArrayList<Livro> livrosSelecionados) {

        if (codigo <= 0 || leitor == null || livrosSelecionados == null) {
            return false;
        }

        if (consultarEmprestimo(codigo) != null) {
            return false;
        }

        if (consultarLeitor(leitor.getCodigo()) == null) {
            return false;
        }

        if (livrosSelecionados.isEmpty()) {
            return false;
        }

        for (Livro livro : livrosSelecionados) {
            if (livro == null || consultarLivro(livro.getCodigo()) == null
                    || !livro.isDisponivel()) {
                return false;
            }
        }

        Emprestimo emprestimo = new Emprestimo(codigo, leitor);

        for (Livro livro : livrosSelecionados) {
            if (!emprestimo.adicionarLivro(livro)) {
                return false;
            }
        }

        emprestimos.add(emprestimo);
        return true;
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
        } else {
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println(emprestimo);
            }
        }
    }

    public boolean registrarDevolucao(int codigo) {
        Emprestimo emprestimo = consultarEmprestimo(codigo);

        if (emprestimo == null || emprestimo.isFinalizado()) {
            return false;
        }

        emprestimo.finalizar();
        return true;
    }

    private Emprestimo consultarEmprestimo(int codigo) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getCodigo() == codigo) {
                return emprestimo;
            }
        }
        return null;
    }
}
