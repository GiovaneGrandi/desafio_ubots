package br.com.ubots.util

import br.com.ubots.model.Time
import spock.lang.Specification

class ValidadorSpec extends Specification {

    def "Deve retornar o time correto para uma opção válida"() {
        given:
        def times = [
                new Time("Cartões"),
                new Time("Empréstimos"),
                new Time("Outros Assuntos")
        ]

        when:
        def time = Validador.validarTime(1, times)

        then:
        time.nome == "Cartões"
    }

    def "Deve lançar exceção para opção inválida"() {
        given:
        def times = [
                new Time("Cartões"),
                new Time("Empréstimos"),
                new Time("Outros Assuntos")
        ]

        when:
        Validador.validarTime(4, times)

        then:
        thrown(RuntimeException) // Alterar caso use uma exceção customizada
    }
}
