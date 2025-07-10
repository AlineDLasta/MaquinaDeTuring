# Simulador de Máquina de Turing 

Este projeto é uma simulação de uma Máquina de Turing, feita com backend em Java e uma interface web simples e interativa em HTML, CSS e JavaScript.

A ideia é que você possa acompanhar passo a passo a execução da máquina, vendo a fita, o estado atual, as regras aplicadas e o resultado convertido para decimal.

## Tecnologias usadas

- Java 
- Servidor HTTP nativo do Java (`com.sun.net.httpserver.HttpServer`)
- HTML, CSS e JavaScript para a interface
- JSON para comunicação entre frontend e backend

## O que o projeto faz

- Mostra a fita da máquina e o cabeçote em tempo real
- Permite avançar a simulação passo a passo, com feedback visual
- Exibe o histórico dos estados visitados
- Converte automaticamente a fita binária para número decimal quando a máquina termina
- Interface leve e responsiva, fácil de usar

## Como está organizado

```
maquina-de-turing/
├── backend/
│   ├── Model.java
│   ├── Controller.java
│   └── Server.java
├── frontend/
│   ├── index.html
│   ├── css/
│   │   └── style.css
│   ├── js/
│   │   ├── controller.js
│   │   └── view.js
│   └── assets/
│       └── AlanTuring.png

```

## Como rodar

### O que você precisa

- Java 11 ou superior instalado
- Navegador moderno (Chrome, Firefox, Edge...)

### Passos

1. Compile os arquivos Java dentro da pasta `backend`:

   ```bash
   javac Model.java Controller.java Server.java
   ```

2. Execute o servidor:

   ```bash
   java Server
   ```

3. O servidor vai rodar na porta 8000.

4. Abra o arquivo `frontend/index.html` no seu navegador para usar a interface.

## Endpoints da API

| Rota     | Método | O que faz                                         |
| -------- | ------ | ------------------------------------------------ |
| `/model` | GET    | Retorna o estado atual da máquina em JSON        |
| `/step`  | POST   | Executa um passo da máquina e retorna o novo estado |
| `/reset` | POST   | Reinicia a máquina para o estado inicial          |

## Interface da Aplicação

### Estado inicial: 
![image](https://github.com/user-attachments/assets/66afa85c-6de5-4d39-a400-d236111fa008)

### Estado após execução:
![image](https://github.com/user-attachments/assets/7b5b0d30-b751-4ec5-89b6-57b2f64652d0)

## Autor

Desenvolvido por Aline Dias Lasta

## Licença

Projeto livre para estudo, modificação e uso educacional.

## Sobre

Projeto feito para a disciplina de Linguagens Formais e Autômatos, com foco em aprender e demonstrar o funcionamento da Máquina de Turing na prática.
