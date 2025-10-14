# Little Cats Pet Shop 🐾

**Little Cats Pet Shop** é um jogo de simulação desenvolvido em **Java**, com base em princípios de **Programação Orientada a Objetos (POO)** e na aplicação de diversos **padrões de projeto (GoF)**.  
O jogador pode criar, alimentar, brincar e cuidar de diferentes animais — gato, cachorro, coelho e hamster — cada um com comportamento e estados próprios.

---

## Visão geral

O projeto tem como principal objetivo demonstrar a integração entre **arquitetura orientada a objetos** e **padrões de projeto GoF** em um sistema interativo em console.  
Cada ação do usuário representa uma interação encapsulada em comandos e reflete mudanças reais no estado do pet.

---

## Padrões de Projeto Utilizados

### Factory Method  
Responsável pela **criação dos pets** de acordo com o tipo selecionado pelo jogador, garantindo encapsulamento e flexibilidade no processo de instanciamento.

### Command  
Encapsula ações do jogador (como alimentar, brincar, dormir, acordar, curar e aplicar acessórios) em **objetos de comando independentes**, permitindo o desacoplamento entre quem solicita a ação e quem a executa.

### State  
Modela os **estados internos dos pets** (feliz, faminto, cansado, dormindo, doente) e define como o comportamento muda dinamicamente conforme cada estado.

### Decorator  
Permite adicionar **funcionalidades visuais e comportamentais** de forma dinâmica, como banho e acessórios (laço e cachecol), sem modificar a estrutura original do objeto `Pet`.

---

## Estrutura do Projeto

src/
├── model/
│   ├── command/        # Implementações do padrão Command
│   ├── decorator/      # Implementações do padrão Decorator
│   ├── factory/        # Implementações do padrão Factory Method
│   ├── state/          # Implementações do padrão State
│   ├── Pet.java        # Classe base do pet
│   ├── Kennel.java     # Classe de baia
│   └── SimulationClock.java
├── repo/
│   ├── PetRepo.java
│   └── KennelRepo.java
├── ui/
│   ├── GameMenu.java        # Menu principal e interação do jogador
│   ├── ConsoleArtRender.java
│   └── UiScene.java
└── Main.java

---

## Funcionalidades

- Criação de pets com **Factory Method**  
- Ações de interação (alimentar, brincar, dormir, acordar, curar) via **Command Pattern**  
- Transição entre estados de humor e saúde via **State Pattern**  
- Aplicação e remoção dinâmica de acessórios e cuidados com **Decorator Pattern**  
- Repositórios persistentes em memória para pets e baias

---

## Execução

1. Compile o projeto:
   ```bash
   javac Main.java

2. Execute
   java Main
   
3. Interaja com o menu exibido no console para criar, cuidar e gerenciar seus pets.

---

## Tecnologias e Conceitos Envolvidos
- Linguagem: Java 17+
- Paradigma: Programação Orientada a Objetos
- Padrões GoF: Factory Method, Command, State e Decorator
- Arquitetura modular com repositórios e menu em console
