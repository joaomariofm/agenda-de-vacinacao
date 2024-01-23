# Agenda de vacinação UFG

![DER](./docs/projectDER.png)

## Executando o projeto

A explicação das configurações necessárias para executar o projeto levará em consideração como ambiente de execução o sistema operacional ubuntu na versão 22.04.3

### Configuração do banco

O projeto utiliza o framework **hibernate** para estabelecer uma conexão com um banco **mysql**. Dessa forma, para que o sistema funcione é preciso criar um novo banco de dados mysql com o nome "agendadevacinacao". Assim, ao acessar a ferramenta de linha de comando do mysql será preciso executar o seguinte comando para criar o banco.

``` msql
    CREATE DATABASE agendadevacinacao; 
```

Logo em seguida, será preciso criar um novo usuário com o nome 'ufg' e a senha 'passme' para que o sistema utilize destas credenciais para estabelecer a conexão

``` msql
    CREATE USER 'ufg'@'localhost' IDENTIFIED BY 'passme';  
```

Por fim, será necessário conceder a permissões de acesso ao novo banco criado para o novo usuário criado

``` msql
    GRANT ALL PRIVILEGES ON agendadevacinacao.* TO 'ufg'@'localhost';
```

### Compilando e executando o sistema

Para compilar e executar o sistema primeiro verique se o seu sistema já possui instalado a versão mais recente do java com o seguinte comando

```bash
    java -version
```

No caso de não ter o java instalado, faça a instalação com o seguinte comando

```bash
    sudo apt update && sudo apt install default-jre -y 
```

Depois disso execute o **build** executando o seguinte comando na raiz do projeto

```bash
    make build
```

E então para rodar, execute o seguinte comando na raiz do projeto

```bash
    make run
```
