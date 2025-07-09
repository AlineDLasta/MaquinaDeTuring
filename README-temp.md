# Simulador de Máquina de Turing com Interface Visual

Este projeto é uma simulação de uma Máquina de Turing implementada com backend em Java e frontend interativo em HTML, CSS e JavaScript.

A aplicação permite acompanhar a execução passo a passo da máquina, visualizando a fita, o estado atual, as transições e o resultado em decimal.

## Tecnologias utilizadas

- Java 11+
- `com.sun.net.httpserver.HttpServer` (servidor HTTP nativo do Java)
- HTML5, CSS3
- JavaScript (ES6)
- JSON para comunicação entre frontend e backend

## Funcionalidades

- Visualização interativa da fita e do cabeçote
- Avanço da máquina passo a passo com feedback visual
- Histórico de estados visitados
- Conversão automática da entrada binária para número decimal
- Interface web leve e responsiva

## Estrutura do Projeto

maquina-de-turing/

├── backend/

│   ├── Model.java

│   ├── Controller.java

│   └── Server.java

│

├── frontend/

│   ├── index.html

│   ├── css/

│   │   └── style.css

│   ├── js/

│   │   ├── controller.js

│   │   └── view.js

│   └── assets/

│       └── AlanTuring.png

│

└── README.md

## Como executar o projeto

### Requisitos

- Java 11 ou superior
- Navegador moderno (Chrome, Firefox, Edge, etc.)

### Passo a passo

1. Compile os arquivos Java localizados em `backend/`:
   ```bash
   javac Model.java Controller.java Server.java

1. Execute o servidor:
    
    ```bash
    bash
    CopiarEditar
    java Server
    
    
2. O servidor iniciará na porta `8000`.
3. Acesse o frontend abrindo o arquivo `frontend/index.html` no navegador.


## Endpoints disponíveis

| Rota | Método | Descrição |
| --- | --- | --- |
| `/model` | GET | Retorna o modelo atual em JSON. Usado para carregar o estado inicial ou atual da máquina. |
| `/step` | POST | Executa um passo da máquina, avançando a simulação e retornando o novo estado. |
| `/reset` | POST | Reseta a máquina ao estado inicial, reiniciando a simulação. |


## Interface da Aplicação

### Estado inicial:

![Interface Inicial](https://chatgpt.com/frontend/assets/interface-inicial.png)


### Estado após execução:

![Interface Final](https://chatgpt.com/frontend/assets/interface-final.png)


## Possíveis melhorias

- Execução automática com controle de velocidade
- Suporte à criação de regras personalizadas via interface
- Feedback visual animado para o cabeçote
- Exportação de simulações e logs
- Integração com Maven ou Gradle

---

## Licença

Projeto de uso educacional e livre para estudo, modificação e reutilização.

---

## Autor

Desenvolvido por [Seu Nome Aqui] — projeto de aprendizado com foco em lógica, autômatos e integração frontend/backend.