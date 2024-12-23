package br.com.ubots.model;

import java.util.*;
public class Atendente {
    private String nome;
    private int atendimentosAtuais;
    private br.com.ubots.model.Time time;
    private List<Atendimento> atendimentos;

    //Construtores:

    public Atendente() {}

    public Atendente(String nome, br.com.ubots.model.Time time) {
        this.nome = nome;
        this.time = time;
        this.atendimentosAtuais = 0;
        this.atendimentos = new ArrayList<>();
        time.adicionarAtendente(this);
    }

    //-------------------------------------------------------------

    //Gets e Sets:

    public String getNome() {
        return nome;
    }

    public int getAtendimentosAtuais() {
        return atendimentosAtuais;
    }

    public List<Atendimento> getAtendimentos() { // Novo método
        return atendimentos;
    }

    //-------------------------------------------------------------

    //Demais Métodos:

    public void atribuirAtendimento(Atendimento atendimento) {
        if (atendimentosAtuais < 3) {
            atendimentosAtuais++;
            atendimentos.add(atendimento);
            atendimento.setTime(time);
            atendimento.setAtendente(this);
            System.out.println("Atendimento atribuído a " + nome + " para o cliente: " + atendimento.getCliente());
        } else {
            System.out.println("O atendente " + nome + " já atingiu o limite de atendimentos simultâneos.");
        }
    }

    public void finalizarAtendimento(Atendimento atendimento) {
        if (atendimentosAtuais > 0 && atendimentos.remove(atendimento)) {
            atendimentosAtuais--;
            System.out.println("Atendimento finalizado pelo atendente: " + nome + " para o cliente: " + atendimento.getCliente());
            time.processarFilaDeEspera();
        } else {
            System.out.println("Nenhum atendimento encontrado para finalizar.");
        }
    }
}
