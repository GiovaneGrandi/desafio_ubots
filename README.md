# Central de Atendimento FlowPay

Este projeto é uma simulação de uma Central de Atendimento que organiza clientes em filas, distribui atendimentos para atendentes com base na capacidade disponível e processa filas de espera automaticamente. Foi desenvolvido como parte de um desafio técnico.

---

## Índice

1. [Descrição do Projeto](#descrição-do-projeto)
2. [Funcionalidades](#funcionalidades)
3. [Lógica do Código](#lógica-do-código)
4. [Tecnologias e Bibliotecas Utilizadas](#tecnologias-e-bibliotecas-utilizadas)
5. [Configuração do Ambiente](#configuração-do-ambiente)
6. [Como Executar o Código](#como-executar-o-código)
7. [Testes](#testes)
8. [Contribuição](#contribuição)
9. [Contato](#contato)

---

## Descrição do Projeto

A Central de Atendimento FlowPay simula o funcionamento de uma fila de suporte ao cliente em uma organização, organizando os clientes por setores (times), atribuindo atendimentos com base na capacidade dos atendentes e gerenciando automaticamente uma fila de espera. Este projeto foi desenvolvido com foco em:

- Boas práticas de programação orientada a objetos.
- Testes unitários robustos utilizando a biblioteca Spock.
- Simulação realista de processos empresariais.

---

## Funcionalidades

### Gerenciamento de Atendimentos:
- Criação de atendimentos para clientes com base em assuntos.
- Atribuição de atendimentos a atendentes disponíveis.

### Gerenciamento de Atendentes:
- Limite máximo de atendimentos simultâneos por atendente (configurável por time).
- Lista de atendimentos atuais atribuídos a cada atendente.

### Fila de Espera:
- Processamento automático da fila de espera quando um atendente libera espaço.

### Visualização:
- Exibição de status de atendimentos e fila de espera por time.

---

## Lógica do Código

### Estrutura de Classes

#### Atendimento
- Representa um atendimento de cliente.
- Contém informações sobre o cliente, assunto, time e atendente responsável.

#### Atendente
- Representa um atendente da central.
- Gerencia a atribuição e finalização de atendimentos.

#### Time
- Representa um setor (time) da central.
- Gerencia os atendentes e organiza a fila de espera.

#### Validador
- Utilitário para validar entradas do usuário (como seleção de times).

#### CentralDeAtendimento
- Classe principal para executar o programa.
- Implementa o menu e as interações do usuário.

---

## Tecnologias e Bibliotecas Utilizadas

- **Java 17**: Linguagem principal para o desenvolvimento do código.
- **Maven**: Gerenciador de dependências e build.
- **Spock Framework**: Framework para testes unitários e de integração.
- **ByteBuddy e Objenesis**: Bibliotecas auxiliares para criação de mocks em testes.

---

## Configuração do Ambiente

### Pré-requisitos:
1. **Java 17**: Certifique-se de que o JDK 17 está instalado e configurado no PATH.
2. **Maven**: Garanta que o Maven está instalado e configurado.
3. **IntelliJ IDEA** (ou outra IDE): Recomendada para edição e execução do projeto.

### Instalação das Dependências:
```bash
mvn clean install
