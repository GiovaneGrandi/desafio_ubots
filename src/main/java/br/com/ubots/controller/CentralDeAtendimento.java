package br.com.ubots.controller;

import br.com.ubots.util.Validador;
import br.com.ubots.model.Atendente;
import br.com.ubots.model.Atendimento;
import br.com.ubots.model.Time;

import java.util.*;

public class CentralDeAtendimento {
    public static void main(String[] args) {
        new Time("Cartões");
        new Time("Empréstimos");
        new Time("Outros Assuntos");

        new Atendente("João", Time.buscarTimePorAssunto("Cartões"));
        new Atendente("Gabriel", Time.buscarTimePorAssunto("Cartões"));
        new Atendente("Maria", Time.buscarTimePorAssunto("Empréstimos"));
        new Atendente("Carlos", Time.buscarTimePorAssunto("Outros Assuntos"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n**********************************************");
            System.out.println("*          CENTRAL DE ATENDIMENTO           *");
            System.out.println("**********************************************\n");
            System.out.println("1 - Abrir Atendimento");
            System.out.println("2 - Visualizar Fila");
            System.out.println("3 - Finalizar Atendimento");
            System.out.println("4 - Sair");
            System.out.print("\nEscolha uma opção: ");

            int opcaoMenu = scanner.nextInt();
            scanner.nextLine();

            if (opcaoMenu == 1) {
                System.out.println("Digite o nome do cliente:");
                String cliente = scanner.nextLine();

                System.out.println("Escolha o assunto do atendimento:");
                List<Time> times = Time.getAllTimes();
                for (int i = 0; i < times.size(); i++) {
                    System.out.println((i + 1) + " - " + times.get(i).getNome());
                }
                int opcao = scanner.nextInt();
                scanner.nextLine();

                String assunto;
                Time time;

                if (opcao == 3) {
                    System.out.println("Digite a descrição do assunto:");
                    assunto = scanner.nextLine();
                    time = times.get(2);
                } else {
                    assunto = times.get(opcao - 1).getNome();
                    time = Validador.validarTime(opcao, times);
                }

                Atendimento atendimento = new Atendimento(cliente, assunto);
                time.adicionarAtendimento(atendimento);
                time.processarFilaDeEspera();

            } else if (opcaoMenu == 2) {
                List<Time> times = Time.getAllTimes();
                for (Time time : times) {
                    time.exibirStatus();
                    time.exibirFilaDeEspera();
                }
            } else if (opcaoMenu == 3) {
                System.out.println("Selecione o time para finalizar um atendimento:");
                List<Time> times = Time.getAllTimes();
                for (int i = 0; i < times.size(); i++) {
                    System.out.println((i + 1) + " - " + times.get(i).getNome());
                }
                int timeOpcao = scanner.nextInt();
                scanner.nextLine();

                if (timeOpcao >= 1 && timeOpcao <= times.size()) {
                    Time time = times.get(timeOpcao - 1);
                    time.exibirAtendimentosDetalhados();

                    System.out.println("Digite o índice do atendimento para finalizar:");
                    int atendimentoOpcao = scanner.nextInt();
                    scanner.nextLine();

                    List<Atendimento> atendimentos = new ArrayList<>();
                    for (Atendente atendente : time.getAtendentes()) {
                        atendimentos.addAll(atendente.getAtendimentos());
                    }

                    if (atendimentoOpcao >= 1 && atendimentoOpcao <= atendimentos.size()) {
                        Atendimento atendimento = atendimentos.get(atendimentoOpcao - 1);
                        atendimento.getAtendente().finalizarAtendimento(atendimento);
                    } else {
                        System.out.println("Opção de atendimento inválida. Tente novamente.");
                    }
                } else {
                    System.out.println("Opção de time inválida. Tente novamente.");
                }

            } else if (opcaoMenu == 4) {
                System.out.println("Encerrando o sistema. Até logo!");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
