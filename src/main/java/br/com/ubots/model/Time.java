package br.com.ubots.model;

import java.util.*;

public class Time {
    private static List<Time> allTimes = new ArrayList<>();
    private String nome;
    private int limite;
    private List<Atendente> atendentes;
    private Queue<Atendimento> filaDeEspera;

    //Construtores:

    public Time(String nome, int limite) {
        this.nome = nome;
        this.limite = limite;
        this.atendentes = new ArrayList<>();
        this.filaDeEspera = new LinkedList<>();
        allTimes.add(this);
    }

    public Time(String nome) {
        this(nome, 3);
    }

    //-------------------------------------------------------------

    //Gets e Sets:

    public static List<Time> getAllTimes() {
        return allTimes;
    }

    public String getNome() {
        return nome;
    }

    public List<Atendente> getAtendentes() {
        return atendentes;
    }
    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public void adicionarAtendente(Atendente atendente) {
        atendentes.add(atendente);
    }

    public Queue<Atendimento> getFilaDeEspera() {
        return filaDeEspera;
    }

    //-------------------------------------------------------------

    //Demais Métodos:

    public void adicionarAtendimento(Atendimento atendimento) {
        boolean atribuido = false;
        for (Atendente atendente : atendentes) {
            if (atendente.getAtendimentosAtuais() < limite) {
                atendente.atribuirAtendimento(atendimento);
                atribuido = true;
                break;
            }
        }
        if (!atribuido) {
            filaDeEspera.add(atendimento);
            System.out.println("Atendimento adicionado à fila de espera do time " + nome);
        }
    }

    public void processarFilaDeEspera() {
        Iterator<Atendimento> iterator = filaDeEspera.iterator();
        while (iterator.hasNext()) {
            Atendimento atendimento = iterator.next();
            boolean atribuido = false;
            for (Atendente atendente : atendentes) {
                if (atendente.getAtendimentosAtuais() < limite) {
                    atendente.atribuirAtendimento(atendimento);
                    iterator.remove();
                    atribuido = true;
                    break;
                }
            }
            if (!atribuido) {
                break;
            }
        }
    }

    public static Time buscarTimePorAssunto(String assunto) {
        for (Time time : allTimes) {
            if (time.getNome().equalsIgnoreCase(assunto)) {
                return time;
            }
        }
        return null;
    }

    public void exibirStatus() {
        System.out.println("\n--------------------------------------");
        System.out.println("Status dos atendimentos do time: " + nome);
        System.out.println("--------------------------------------");
        for (Atendente atendente : atendentes) {
            System.out.println("  " + atendente.getNome() + " - " + atendente.getAtendimentosAtuais() + "/" + limite + " atendimentos");
        }
    }

    public void exibirAtendimentosDetalhados() {
        System.out.println("Atendimentos atribuídos no time " + nome + ":");
        int index = 1;
        for (Atendente atendente : atendentes) {
            for (Atendimento atendimento : atendente.getAtendimentos()) {
                System.out.println(index + " - Cliente: " + atendimento.getCliente()
                        + " - Assunto: " + atendimento.getAssunto()
                        + " - Atendente: " + atendente.getNome());
                index++;
            }
        }
    }

    public void exibirFilaDeEspera() {
        System.out.println("\n--------------------------------------");
        System.out.println("Fila de espera do time: " + nome);
        System.out.println("--------------------------------------");
        if (filaDeEspera.isEmpty()) {
            System.out.println("  Nenhum atendimento na fila de espera.");
        } else {
            int index = 1;
            for (Atendimento atendimento : filaDeEspera) {
                System.out.println("  " + index + " - Cliente: " + atendimento.getCliente() + " - Assunto: " + atendimento.getAssunto());
                index++;
            }
        }
    }
}

