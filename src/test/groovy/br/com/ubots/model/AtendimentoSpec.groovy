package br.com.ubots.model

import spock.lang.Specification

class AtendimentoSpec extends Specification {

    def "Deve criar um atendimento com cliente e assunto válidos"() {
        when:
        def atendimento = new Atendimento("João", "Cartões")

        then:
        atendimento.cliente == "João"
        atendimento.assunto == "Cartões"
        atendimento.time == null
        atendimento.atendente == null
    }

    def "Deve associar atendimento a um time e atendente"() {
        given:
        def atendimento = new Atendimento("Maria", "Empréstimos")
        def time = new Time("Empréstimos")
        def atendente = new Atendente("Carlos", time)

        when:
        atendimento.setTime(time)
        atendimento.setAtendente(atendente)

        then:
        atendimento.time == time
        atendimento.atendente == atendente
    }
}
