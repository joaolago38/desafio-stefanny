# Spring Boot API REST

Este projeto é uma API REST desenvolvida com **Spring Boot**, configurada para múltiplos ambientes (**desenvolvimento, teste e produção**) e implantada na **AWS**.

## 📌 Pré-requisitos
Antes de começar, verifique se você possui os seguintes requisitos instalados:

- **Java 21** ([Adoptium Temurin](https://adoptium.net/))
- **Maven** ([Download](https://maven.apache.org/download.cgi))
- **Docker** (Opcional, para rodar via container) ([Download](https://www.docker.com/))
- **Git** ([Download](https://git-scm.com/))
- **AWS CLI** ([Download](https://aws.amazon.com/cli/))

---

## 🚀 Instalação e Configuração

### 1️⃣ Clonar o Repositório
```sh
git clone https://github.com/joaolago38/desafio-stefanny
cd seu-repositorio
```

### 2️⃣ Configuração do Banco de Dados
A API usa **SQLServe**. Configure seu banco conforme o ambiente desejado:

#### **Ambiente de Desenvolvimento (Local)**

1. Criar um banco de dados local (**SQLServer**):
   ```sql
   CREATE DATABASE devdb;
   ```
2. Configure o arquivo `application-dev.yml` com as credenciais:
   ```yaml
   spring:
     datasource:
       url: jdbc:sqlserver://localhost:1433;databaseName=stafanini
       username: sa
       password: root
   ```

#### **Ambiente de Teste e Produção (AWS RDS)**
- Definir variáveis de ambiente no sistema:
  ```sh
  setx DB_HOST "seu-banco-teste.amazonaws.com"
  setx DB_USER "seu-usuario"
  setx DB_PASSWORD "sua-senha"
  ```

---

## 🔥 Executando a Aplicação

### **1️⃣ Rodando localmente (Sem Docker)**
```sh
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### **2️⃣ Rodando com Docker (Recomendado para Teste/Produção)**

#### Criar e rodar o container Docker
```sh
docker build -t springboot-api .
docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=dev springboot-api
```

#### Utilizando Docker Compose
```sh
set PROFILE=dev
docker-compose up -d
```

---

## 📦 CI/CD com GitHub Actions e Deploy na AWS

A aplicação usa **GitHub Actions** para build e deploy automático na AWS.

### 1️⃣ **Configurar AWS CLI e ECR**
```sh
aws configure
aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin <aws-account-id>.dkr.ecr.us-east-1.amazonaws.com
```

### 2️⃣ **Pipeline de CI/CD (GitHub Actions)**
- Ao fazer **push** na branch `main` ou `develop`, a pipeline irá:
    1. **Buildar a aplicação**
    2. **Rodar os testes**
    3. **Criar e enviar a imagem Docker para AWS ECR**
    4. **Atualizar a aplicação no AWS ECS**

---

## 🛠️ Endpoints Principais
A API disponibiliza os seguintes endpoints:

| Método | Endpoint        | Descrição                  |
|--------|-----------------|----------------------------|
| GET    | /api/tarefa{id} | Busca uma Tarefa por id    |
| UPDATE | /api/tarefa{id} | Atualiza uma Tarefa por id |
| POST   | /api/tarefa     | Cria uma uma nova Tarefa   |
| DELETE | /api/tarefa{id} | Deleta uma   Tarefa por id |
---

## 📄 Licença
Este projeto é distribuído sob a licença **MIT**.

---

## 🤝 Contribuição
Sinta-se à vontade para contribuir! Envie um **Pull Request** com melhorias.

---

## 📞 Contato
Desenvolvido por [Seu Nome](https://github.com/seu-usuario) - Entre em contato via email: **seu@email.com**.

