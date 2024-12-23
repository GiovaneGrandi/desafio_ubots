package br.com.ubots.util;

import br.com.ubots.model.Time;

import java.util.*;

public class Validador {

    public static Time validarTime(int opcao, List<Time> times) {
        if (opcao >= 1 && opcao <= times.size()) {
            return times.get(opcao - 1);
        } else {
            System.out.println("Opção inválida. Encerrando o programa.");
            System.exit(0);
        }
        return null;
    }
}
