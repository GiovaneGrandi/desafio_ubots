package br.com.ubots.model

import spock.lang.Specification

class TimeSpec extends Specification {

    def "Deve criar um time com limite padrão"() {
        when:
        def time = new Time("Cartões")

        then:
        time.nome == "Cartões"
        time.limite == 3
        time.atendentes.isEmpty()
        time.filaDeEspera.isEmpty()
    }

    def "Deve adicionar atendentes ao time"() {
        given:
        def time = new Time("Cartões")

        when:
        def atendente1 = new Atendente("João", time)
        def atendente2 = new Atendente("Maria", time)

        then:
        time.atendentes.size() == 2
        time.atendentes.contains(atendente1)
        time.atendentes.contains(atendente2)
    }

    def "Deve adicionar atendimento à fila de espera se limite for atingido"() {
        given:
        def time = new Time("Cartões", 1)
        def atendente = new Atendente("João", time)
        def atendimento1 = new Atendimento("Maria", "Cartões")
        def atendimento2 = new Atendimento("Carlos", "Cartões")

        when:
        time.adicionarAtendimento(atendimento1)
        time.adicionarAtendimento(atendimento2)

        then:
        time.filaDeEspera.size() == 1
        time.filaDeEspera.contains(atendimento2)
    }
}
