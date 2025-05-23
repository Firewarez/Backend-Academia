# Microsserviço de academia

Projeto da faculdade de java utilizando Spring, MySQL, Docker e Insomnia para testes unitários de
api para cada tabela, sistema de simulação de criação de plano, criação de conta e inserção no banco de dados
via spring 

## Pré-requisitos

- **Java 17 ou superior** - O Spring Boot requer Java 17 ou superior.
- **Docker** - O Docker será utilizado para rodar o banco de dados MySQL em um container.
- **Docker Compose** - Usado para orquestrar os containers (Spring e MySQL).
- **Apache Maven** - Spring boot requer Maven 3.9.9 ou superior.

## Passos para rodar o projeto

### 1. **Clonar o Repositório**

```bash
git https://github.com/Firewarez/Backend-Loja
cd Backend-Loja
```

### 2. Instalar o Docker
Se você ainda não tem o Docker instalado, siga os passos de instalação para o seu sistema operacional:

- **Windows**: [Docker Desktop para Windows](https://www.docker.com/products/docker-desktop)

- **Mac**: [Docker Desktop para Mac](https://www.docker.com/products/docker-desktop)

- **Linux**: [Instalar Docker no Linux](https://docs.docker.com/engine/install/)

Depois de instalar o Docker, verifique se ele está funcionando com o comando:

```bash
docker --version
```

Dentro da pasta raiz execute:

```bash
docker-compose up -d
```

para verificar se o composer está funcionando corretamente no seu docker:
```bash
docker ps
```

### 3. Instalar o Apache Maven

- **Downloads**: [Apache Maven para todos os dispositivos](https://maven.apache.org/download.cgi)

### 4. Inicie o serviço

- Execute o arquivo LojaApiApplication.java
- Verifique se o docker está ativo