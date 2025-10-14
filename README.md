# Little Cats Pet Shop 🐾

O **Little Cats Pet Shop** é um jogo em Java onde você cuida de animaizinhos virtuais — gatos, cachorros, coelhos e hamsters.  
Você pode alimentar, brincar, colocar acessórios e acompanhar o humor e a saúde de cada pet.

Mais do que um joguinho de console, o projeto foi feito para **demonstrar o uso de Padrões de Projeto (GoF)** de um jeito prático e divertido.

---

## Padrões de Projeto usados

- **Factory Method** → cria automaticamente os pets de acordo com o tipo escolhido.  
- **Command** → encapsula cada ação do jogador (alimentar, brincar, dormir, curar...).  
- **State** → controla o humor e os estados dos pets (feliz, cansado, faminto, doente...).  
- **Decorator** → adiciona acessórios e efeitos visuais (laço, cachecol, banho) sem alterar a classe original.  

---

## O que você pode fazer

- Criar e nomear seu pet  
- Alimentar, brincar, curar e colocar pra dormir  
- Dar banho e adicionar acessórios  
- Ver o status e trocar entre pets  
- Passar horas no jogo (simulação de tempo)  
- Tudo isso com feedback visual no console

---

## Estrutura do projeto

```
src/
├── model/
│   ├── command/        # Ações do jogador
│   ├── decorator/      # Acessórios e banho
│   ├── factory/        # Criação de pets
│   ├── state/          # Estados do pet
│   ├── Pet.java
│   └── SimulationClock.java
├── repo/
│   ├── PetRepo.java
│   └── KennelRepo.java
├── ui/
│   ├── GameMenu.java
│   ├── ConsoleArtRender.java
│   └── UiScene.java
└── Main.java
```

---

## ▶️ Como jogar

1. Compile o projeto:
   ```bash
   javac Main.java

2. Execute:
   ```bash
   java Main

3. Escolha seu pet e comece a cuidar dele.
Alimente, brinque, cure, decore e veja como ele reage a cada ação.

---

## Tecnologias e conceitos

- Java 17+
- Programação Orientada a Objetos
- Padrões de Projeto GoF (Factory, Command, State, Decorator)
- Simulação de tempo (SimulationClock)
- Interface por console (GameMenu + ConsoleArtRender)

---
Desenvolvido por Anna Quezia dos Santos
Projeto voltado ao estudo e prática de padrões de projeto aplicados a sistemas interativos em Java.
