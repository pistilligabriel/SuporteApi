# 📞 Suporte API

API REST desenvolvida em Java com Spring Boot para **gerenciamento de chamados de suporte técnico** dentro de uma empresa. A aplicação permite que usuários registrem, acompanhem e resolvam chamados por setor, prioridade e responsável. Inclui autenticação via JWT e documentação automática com Swagger UI.

---

## 🚀 Tecnologias Utilizadas

- Java 17  
- Spring Boot 3.3.3  
- Spring Web  
- Spring Data JPA  
- Spring Security  
- JWT (Auth0 Java JWT)  
- MySQL  
- Lombok  
- Swagger (SpringDoc OpenAPI)  
- ModelMapper  
- Maven

---

## ⚙️ Pré-requisitos

Antes de rodar o projeto, certifique-se de ter instalado:

- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)  
- [Maven 3.8+](https://maven.apache.org/)  
- [MySQL 8+](https://dev.mysql.com/downloads/mysql/)  
- Uma IDE (IntelliJ, Eclipse ou VS Code)

---

## 📥 Como Rodar o Projeto Localmente

### 1. Clone o repositório

```bash
git clone https://github.com/pistilligabriel/SuporteApi.git
cd SuporteApi
```

### 2. Crie o banco de dados no MySQL

```sql
CREATE DATABASE suporte_db;
```

### 3. Configure o `application.properties`

No arquivo `src/main/resources/application.properties`, atualize com as configurações do seu banco de dados e token JWT:

```properties
# Conexão com o banco de dados
spring.datasource.url=jdbc:mysql://localhost:3306/suporte_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# JWT
jwt.secret=chave-secreta
jwt.expiration=3600000
```

### 4. Rode a aplicação

#### Via terminal:

```bash
./mvnw spring-boot:run
```

#### Ou pela sua IDE:

Execute a classe `ApiSuporteApplication.java` no pacote principal:  
```
br.com.api_suporte
```

---

## 🔐 Autenticação

A aplicação utiliza **JWT (JSON Web Token)** para autenticação.

- Após o login bem-sucedido, um token será retornado.
- Esse token deve ser incluído no header de requisições protegidas:

```
Authorization: Bearer <seu_token>
```

---

## 📚 Documentação da API

A documentação interativa da API pode ser acessada com o projeto em execução:

- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  
ou  
- [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 📁 Estrutura Padrão do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── br/com/api_suporte/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── entity/
│   │       ├── repository/
│   │       ├── security/
│   │       ├── service/
│   │       └── ApiSuporteApplication.java
│   └── resources/
│       ├── application.properties
│       └── static/
└── test/
```

---

## ✅ Funcionalidades

- ✅ Cadastro e login de usuários  
- ✅ Criação, edição e exclusão de chamados  
- ✅ Filtragem por setor, prioridade e status  
- ✅ Autenticação JWT  
- ✅ Documentação Swagger  

---


## 📄 Licença

Este projeto está sob a licença MIT. Consulte o arquivo `LICENSE` para mais informações.

---

## 👨‍💻 Autor

Desenvolvido por [Gabriel Pistilli](https://github.com/pistilligabriel) 🚀  
Contribuições, issues e sugestões são sempre bem-vindas!
