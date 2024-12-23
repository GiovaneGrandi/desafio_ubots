package br.com.ubots.model

import spock.lang.Specification

class AtendenteSpec extends Specification {

    def "Deve criar um atendente e associá-lo a um time"() {
        given:
        def time = new Time("Cartões")

        when:
        def atendente = new Atendente("João", time)

        then:
        atendente.nome == "João"
        atendente.time == time
        atendente.atendimentosAtuais == 0
        atendente.atendimentos.isEmpty()
    }

    def "Deve atribuir atendimento a um atendente com capacidade disponível"() {
        given:
        def time = new Time("Cartões")
        def atendente = new Atendente("João", time)
        def atendimento = new Atendimento("Maria", "Cartões")

        when:
        atendente.atribuirAtendimento(atendimento)

        then:
        atendente.atendimentosAtuais == 1
        atendente.atendimentos.contains(atendimento)
        atendimento.atendente == atendente
        atendimento.time == time
    }

    def "Não deve atribuir atendimento se o limite for atingido"() {
        given:
        def time = new Time("Cartões")
        def atendente = new Atendente("João", time)
        def atendimentos = (1..3).collect { new Atendimento("Cliente $it", "Cartões") }
        atendimentos.each { atendente.atribuirAtendimento(it) }
        def novoAtendimento = new Atendimento("Carlos", "Cartões")

        when:
        atendente.atribuirAtendimento(novoAtendimento)

        then:
        atendente.atendimentosAtuais == 3
        !atendente.atendimentos.contains(novoAtendimento)
    }
}
