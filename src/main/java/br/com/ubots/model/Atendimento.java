package br.com.ubots.model;

public class Atendimento {
    private String cliente;
    private String assunto;
    private br.com.ubots.model.Time time;
    private br.com.ubots.model.Atendente atendente;

    //Construtor:

    public Atendimento(String cliente, String assunto) {
        this.cliente = cliente;
        this.assunto = assunto;
    }

    //-------------------------------------------------------------

    //Gets e Sets:

    public String getCliente() {
        return cliente;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

    public Atendente getAtendente() { // Adicionado
        return atendente;
    }

    public void setAtendente(Atendente atendente) { // Adicionado
        this.atendente = atendente;
    }
}
