===============================
🚀 POKÉDEX FULL STACK - REACT + SPRING BOOT
===============================

📌 **Descrição**  
Este é um projeto full stack acadêmico que integra **React no frontend** com **Spring Boot no backend**, consumindo a **API pública PokéAPI**. O objetivo é listar Pokémons com busca avançada, paginação, e visualização de detalhes dinâmicos. A arquitetura segue boas práticas de separação por camadas e modularização, com foco em performance, organização e experiência do usuário.

---

🛠️ **Tecnologias Utilizadas**

**Frontend (React)**

- React 18+
- JavaScript ES6
- Axios (requisições HTTP)
- CSS3 (tema escuro responsivo)
- Jest + Testing Library (testes automatizados)

**Backend (Spring Boot)**

- Java 21
- Spring Boot 3.x
- Spring Web (REST)
- RestTemplate
- Maven (gerenciador de dependências)

---

📱 **Funcionalidades do App**

🔍 **Listagem de Pokémons**
- Busca por nome com ou sem `"*"`:
  - Ex: `char` → busca nomes **que começam com** "char"
  - Ex: `*saur` → busca nomes **que contêm** "saur" em qualquer lugar
- Exibição de **20 pokémons por página**
- **Paginação com botões no topo**
- Exibição do **número total de resultados filtrados**

🧾 **Visualização de Detalhes**
- Clique em **qualquer parte do card do Pokémon** para exibir detalhes
- Detalhes exibidos na lateral direita
- Inclui: Altura, Peso, Tipos e Habilidades

🎨 **Estilização Avançada**
- Tema escuro elegante (`#121212` de fundo, fontes claras, hover azul vibrante)
- Interface 100% responsiva
- Cards com efeito `hover`, bordas arredondadas e transições suaves

---

📂 **Estrutura do Projeto**

```
poke-fullstack/
├── frontend/             → Projeto React (VS Code)
│   ├── src/
│   │   ├── components/
│   │   │   ├── PokemonList.js
│   │   │   ├── PokemonDetails.js
│   │   │   └── Pagination.js
│   │   ├── App.js
│   │   ├── index.js
│   │   └── index.css
│   ├── public/
│   └── package.json
│
├── backend/              → Projeto Spring Boot (IntelliJ IDEA)
│   ├── src/
│   │   └── main/java/com/poke/pokeapi/
│   │       ├── controller/
│   │       │   └── PokemonController.java
│   │       ├── service/
│   │       │   └── PokemonService.java
│   │       └── dto/
│   │           └── PokemonDto.java
│   ├── pom.xml
│   └── ...
└── README.md
```

---

▶️ **Como Executar o Projeto**

### 🔧 1. Clone o repositório

```bash
git clone https://github.com/efsartorelli/fiap-gs1-soap
cd PokeProject
```

### 🖥️ 2. Rodar o Backend

Recomendado abrir com o **IntelliJ IDEA**

```bash
cd poke
mvn spring-boot:run
```

- Roda na porta `http://localhost:8080`
- Endpoints disponíveis:
  - `GET /api/pokemons` → lista paginada
  - `GET /api/pokemons/{nome}` → detalhes

### 🌐 3. Rodar o Frontend

Recomendado abrir com o **VS Code**

```bash
cd poke-frontend
npm install
npm start
```

- Roda na porta `http://localhost:3000`
- Comunicação automática com o backend local

---

🧪 **Testes Automatizados**

### Frontend

```bash
cd frontend
npm test
```

Cobertura de testes:
- Lista de Pokémons
- Comportamento da busca
- Renderização dos componentes

---

📎 **Observações Técnicas**

- O frontend **não acessa diretamente a PokéAPI**, apenas via backend (proxy)
- O backend aplica **boas práticas REST** e separação de camadas (Controller / Service / DTO)
- Os dados são cacheados em memória para reduzir requisições repetidas
- O React usa **useEffect, useState, props** e **componentes reutilizáveis**

---

🧑‍💻 **Autores**

- **Enzo Vazquez Sartorelli** — RM94618  
- **Eduardo Nistal** — RM94524

Turma: **3ESPV - Engenharia de Software — FIAP 2025**

---

📚 **Notas Finais**

- Projeto desenvolvido com fins educacionais
- Dados provenientes da [PokéAPI](https://pokeapi.co/)
- 100% funcional e responsivo
- Código aberto e modular, ideal para evolução futura

🗓️ Última atualização: **03/06/2025**
