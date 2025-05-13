# Projeto Java Spring com Docker e MySQL

Este é um projeto Spring Boot configurado para rodar com o banco de dados MySQL usando Docker. 

## Pré-requisitos

- **Java 17 ou superior** - O Spring Boot requer Java 17 ou superior.
- **Docker** - O Docker será utilizado para rodar o banco de dados MySQL em um container.
- **Docker Compose** - Usado para orquestrar os containers (Spring e MySQL).

## Passos para rodar o projeto

### 1. **Clonar o Repositório**

Primeiro, clone o repositório para a sua máquina local:

```bash
git clone https://github.com/Firewarez/Sistema-de-LOja
cd Sistema-de-LOja
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