/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade1;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {
    
private Scanner scanner;
    private Biblioteca biblioteca;

    public Aplicacao() {
        scanner = new Scanner(System.in);
        biblioteca = new Biblioteca();
    }

    public void executar() {
        int opcao = -1;

        while (opcao != 0) {
            mostrarMenu();

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        cadastrarLeitor();
                        break;
                    case 2:
                        consultarLeitor();
                        break;
                    case 3:
                        biblioteca.listarLeitores();
                        break;
                    case 4:
                        atualizarLeitor();
                        break;
                    case 5:
                        removerLeitor();
                        break;
                    case 6:
                        cadastrarLivro();
                        break;
                    case 7:
                        consultarLivro();
                        break;
                    case 8:
                        biblioteca.listarLivros();
                        break;
                    case 9:
                        atualizarLivro();
                        break;
                    case 10:
                        removerLivro();
                        break;
                    case 11:
                        registrarEmprestimo();
                        break;
                    case 12:
                        biblioteca.listarEmprestimos();
                        break;
                    case 13:
                        registrarDevolucao();
                        break;
                    case 0:
                        System.out.println("Aplicação encerrada.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1 - Cadastrar leitor");
        System.out.println("2 - Consultar leitor");
        System.out.println("3 - Listar leitores");
        System.out.println("4 - Atualizar leitor");
        System.out.println("5 - Remover leitor");
        System.out.println("6 - Cadastrar livro");
        System.out.println("7 - Consultar livro");
        System.out.println("8 - Listar livros");
        System.out.println("9 - Atualizar livro");
        System.out.println("10 - Remover livro");
        System.out.println("11 - Registrar empréstimo");
        System.out.println("12 - Listar empréstimos");
        System.out.println("13 - Registrar devolução");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
    }

    private void cadastrarLeitor() {
        System.out.print("Código: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Leitor leitor = new Leitor(codigo, nome, email);

        if (biblioteca.cadastrarLeitor(leitor)) {
            System.out.println("Leitor cadastrado.");
        } else {
            System.out.println("Não foi possível cadastrar o leitor.");
        }
    }

    private void consultarLeitor() {
        System.out.print("Código do leitor: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Leitor leitor = biblioteca.consultarLeitor(codigo);

        if (leitor == null) {
            System.out.println("Registro não encontrado.");
        } else {
            System.out.println(leitor);
        }
    }

    private void atualizarLeitor() {
        System.out.print("Código do leitor: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Leitor leitor = biblioteca.consultarLeitor(codigo);

        if (leitor == null) {
            System.out.println("Registro não encontrado.");
            return;
        }

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo email: ");
        String email = scanner.nextLine();

        leitor.atualizarDados(nome, email);
        System.out.println("Dados do leitor atualizados.");
    }

    private void removerLeitor() {
        System.out.print("Código do leitor: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Leitor leitor = biblioteca.consultarLeitor(codigo);

        if (leitor == null) {
            System.out.println("Registro não encontrado.");
        } else if (biblioteca.removerLeitor(leitor)) {
            System.out.println("Leitor removido.");
        } else {
            System.out.println("Leitor não removido. Há empréstimo aberto.");
        }
    }

    private void cadastrarLivro() {
        System.out.print("Código: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        Livro livro = new Livro(codigo, titulo, autor);

        if (biblioteca.cadastrarLivro(livro)) {
            System.out.println("Livro cadastrado.");
        } else {
            System.out.println("Não foi possível cadastrar o livro.");
        }
    }

    private void consultarLivro() {
        System.out.print("Código do livro: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Livro livro = biblioteca.consultarLivro(codigo);

        if (livro == null) {
            System.out.println("Registro não encontrado.");
        } else {
            System.out.println(livro);
        }
    }

    private void atualizarLivro() {
        System.out.print("Código do livro: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Livro livro = biblioteca.consultarLivro(codigo);

        if (livro == null) {
            System.out.println("Registro não encontrado.");
            return;
        }

        System.out.print("Novo título: ");
        String titulo = scanner.nextLine();
        System.out.print("Novo autor: ");
        String autor = scanner.nextLine();

        livro.atualizarDados(titulo, autor);
        System.out.println("Dados do livro atualizados.");
    }

    private void removerLivro() {
        System.out.print("Código do livro: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Livro livro = biblioteca.consultarLivro(codigo);

        if (livro == null) {
            System.out.println("Registro não encontrado.");
        } else if (biblioteca.removerLivro(livro)) {
            System.out.println("Livro removido.");
        } else {
            System.out.println("Livro não removido. Há empréstimo aberto.");
        }
    }

    private void registrarEmprestimo() {
        System.out.print("Código do empréstimo: ");
        int codigoEmprestimo = Integer.parseInt(scanner.nextLine());

        System.out.print("Código do leitor: ");
        int codigoLeitor = Integer.parseInt(scanner.nextLine());
        Leitor leitor = biblioteca.consultarLeitor(codigoLeitor);

        if (leitor == null) {
            System.out.println("Leitor não encontrado.");
            return;
        }

        ArrayList<Livro> livrosSelecionados = new ArrayList<Livro>();
        int codigoLivro = -1;

        System.out.println("Digite os códigos dos livros. Digite 0 para terminar.");

        while (codigoLivro != 0) {
            System.out.print("Código do livro: ");
            codigoLivro = Integer.parseInt(scanner.nextLine());

            if (codigoLivro != 0) {
                Livro livro = biblioteca.consultarLivro(codigoLivro);

                if (livro == null) {
                    System.out.println("Livro não encontrado.");
                } else if (!livro.isDisponivel()) {
                    System.out.println("Livro indisponível.");
                } else if (livrosSelecionados.contains(livro)) {
                    System.out.println("Livro já selecionado.");
                } else {
                    livrosSelecionados.add(livro);
                    System.out.println("Livro selecionado.");
                }
            }
        }

        boolean resultado = biblioteca.registrarEmprestimo(
                codigoEmprestimo, leitor, livrosSelecionados);

        if (resultado) {
            System.out.println("Empréstimo registrado.");
        } else {
            System.out.println("Não foi possível registrar o empréstimo.");
        }
    }

    private void registrarDevolucao() {
        System.out.print("Código do empréstimo: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        if (biblioteca.registrarDevolucao(codigo)) {
            System.out.println("Devolução registrada.");
        } else {
            System.out.println("Não foi possível registrar a devolução.");
        }
    }
}

