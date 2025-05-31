# 🐾 APP TEKOÁ

Sistema Inteligente de Resgate e Remanejamento de Fauna Silvestre em Áreas de Queimada

<br>

## 📌 Descrição do problema


Queimadas em florestas e áreas naturais causam impactos devastadores à fauna silvestre. Em situações de emergência, é comum haver:

- Falta de coordenação entre voluntários, brigadistas e centros de atendimento
- Animais resgatados sendo levados para locais inadequados ou superlotados
- Ausência de rastreamento e acompanhamento clínico dos animais

A **TEKOÁ** foi desenvolvido como uma solução integrada para **registrar, acompanhar e direcionar resgates de animais silvestres** de forma inteligente, cadastro em tempo real, integração com centros de atendimento e controle de status clínico.


<br>


## 🏗️ Visão geral da arquitetura

- **Linguagem:** Java
- **Framework:** Spring Boot
- **Banco de Dados:** H2 (em memória)
- **Camadas:** `Controller`, `Service`, `Repository`, `Entity`
- **Validações:** Jakarta Bean Validation
- **Anotações:** Lombok para simplificação de código

### 🧩 Entidades principais:
- `Animal`: características do animal resgatado
- `Resgate`: ocorrência e localização
- `Responsavel`: voluntário, brigadista ou morador que realiza o resgate
- `CentroAtendimento`: centros que recebem os animais
- `StatusResgate`: histórico de etapas do processo (aguardando, em transporte, tratamento, etc.)


<br>


## ▶️ Como executar o projeto localmente


### 1. Pré-requisitos:
- Java 17+
- Maven 3.8+

### 2. Clonar o repositório
```bash
git clone https://github.com/G1lsJn/apptekoa.git
````
### 3. Acessar a aplicação

- API ativa: http://localhost:8080
- Console H2: http://localhost:8080/h2-console

  - JDBC URL: jdbc:h2:mem:bancotekoa
  - Username: sa
  - Password: (em branco)

<br>

## 💡 Exemplos de uso da API (Postman)

<br>

### 🧑‍💼 1. Cadastrar um responsável (usuário)

**POST** `/v1/responsaveis`

```json
{
  "nome": "Mariana Costa",
  "tipo": "voluntária",
  "telefone": "11988887777",
  "email": "mariana.costa@faunaviva.org",
  "organizacao": "Fauna Viva ONG"
}
```

<br>

### 🐾 2. Cadastrar um animal

**POST** `/v1/animais`

```json
{
  "especie": "Tamanduá-bandeira",
  "grupoAnimal": "mamífero",
  "porte": "grande",
  "sexo": "macho",
  "corPredominante": "cinza e preto",
  "gravidade": "grave",
  "fotoUrl": "https://exemplo.com/imagens/tamandua.jpg"
}
```

<br>

### 🏥 3. Cadastrar um centro de atendimento

**POST** `/v1/centros`

```json
{
  "nome": "Centro Veterinário Pantanal",
  "tipoAtendimento": "mamíferos e répteis",
  "capacidadeTotal": 80,
  "capacidadeAtual": 45,
  "nivelEstrutura": "média",
  "endereco": "Av. das Árvores, 123 - Corumbá, MS",
  "latitude": -19.009344,
  "longitude": -57.651024
}
```

<br>

### 🚨 4. Registrar um resgate

**POST** `/v1/resgates`

```json
{
  "dataHora": "2025-05-30T14:00:00",
  "latitude": -19.0023,
  "longitude": -57.6200,
  "statusAtual": "Aguardando transporte",
  "observacoes": "Animal ferido próximo ao matagal",
  "animal": { "id": 1 },
  "responsavel": { "id": 1 }
}
```

<br>

### 🪪 6. Registrar um novo status para histórico

**POST** `/v1/status`

```json
{
  "resgate": { "id": 1 },
  "etapa": "Em deslocamento",
  "dataHora": "2025-05-30T14:30:00",
  "responsavelAtualizacao": "Mariana Costa"
}
```

```json
{
  "resgate": { "id": 1 },
  "etapa": "Na triagem",
  "dataHora": "2025-05-30T20:30:00",
  "responsavelAtualizacao": "Mariana Costa"
}
```

```json
{
  "resgate": { "id": 1 },
  "etapa": "Em tratamento",
  "dataHora": "2025-05-30T21:00:00",
  "responsavelAtualizacao": "Dr Carlos Silvia"
}
```

<br>

### 🏥 7. Associar um resgate a um centro de atendimento

**PUT** `/v1/resgates/1/centro`

```json
{
  "id": 3
}
```

<br>

### 🔎 8. Consultar todos os resgates com determinado status

**GET** `/v1/resgates/status?status=Em tratamento`

<br>

### 📋 9. Consultar o histórico de status de um resgate

**GET** `/v1/status/resgate/1`

<br>

### 📍 10. Consultar todos os resgates atribuídos a um centro

**GET** `/v1/resgates/centro/3`

<br>

### 📦 11. Atualizar dados de um animal (opcional)

**PUT** `/v1/animais/1`

```json
{
  "especie": "Tamanduá-bandeira",
  "grupoAnimal": "mamífero",
  "porte": "grande",
  "sexo": "macho",
  "corPredominante": "cinza escuro",
  "gravidade": "moderado",
  "fotoUrl": "https://exemplo.com/imagens/tamandua-novo.jpg"
}
```

<br>

### 👤 12. Atualizar dados de um responsável

**PUT** `/v1/responsaveis/1`

```json
{
  "nome": "Mariana Costa",
  "tipo": "gestora",
  "telefone": "11988889999",
  "email": "mariana.costa@faunaviva.org",
  "organizacao": "Fauna Viva ONG"
}
```

<br>

## 👥 Contribuidores

- Gilson Dias Ramos Junior – RM552345
- Gustavo Bezerra Assumção – RM553076
- Jefferson Gabriel De Mendonça – RM553149

