# Hackathon
## Repositório para o Hackathon - Grupo 30
Este repositório contém o código-fonte e a documentação para o Hackathon, desenvolvido pelo Grupo 30.

O projeto consiste em uma aplicação web para agendamento de quartos em um hotel utilizando Spring Framework, Spring Boot e Sping Data. A API permite gerenciamento de quatos, clients, serviços, opcionais e reservas.

## 1- Relatório Técnico
Tecnologias e ferramentas utilizadas

* Linguagem de programação: 

    * Java 17

* Framework:
    * Spring Boot 3.2.0

* Bibliotecas:
  * Spring Web
  * OpenAPI
  * Lombok
    
* Tests:
  * JUnit
  * JMockit
    
* Banco de dados:
  * PostgreSQL
    
* Outras ferramentas:
  * Docker 

## Configurações da solução

### Banco de Dados

Configuração de produção utilizando o PostgreSQL
https://github.com/rcsim/hackathon-fiap/blob/a8d5145acff0a02d7405b32d656c3b195e09b520/src/main/resources/application-dev.properties#L1-L13

O schema do banco de dados são criados através do arquivo schema.sql:
https://github.com/rcsim/hackathon-fiap/blob/a8d5145acff0a02d7405b32d656c3b195e09b520/schema.sql#L1-L34

### Container
Criamos um container para aplicação e outro para o banco de dados e uma rede no modo bridge para ter acesso ao containers via localhost:
https://github.com/rcsim/hackathon-fiap/blob/a8d5145acff0a02d7405b32d656c3b195e09b520/docker-compose.yml#L1-L30

Também adicionamos o arquivo Dockerfile que gerencia o processo de build da aplicação através do Maven e JDK, já inicializando a aplicação:
https://github.com/rcsim/hackathon-fiap/blob/a8d5145acff0a02d7405b32d656c3b195e09b520/docker-compose.yml#L1-L30

Para criação dos container, compilar e rodar a applicação é necessário apenas o comando:

docker-compose up -d

### Documentação das APIS 
Adicionamos a geração automática da documentação através da biblioteca SpringDoc OpenAPI, a documentação pode ser acessada enquanto a aplicação estiver rodando em http://localhost:8080/swagger-ui/index.html#/:

![image](https://github.com/rcsim/hackathon-fiap/assets/30301531/7d4528fc-5688-4207-a39b-ef1e7328c1eb)
![image](https://github.com/rcsim/hackathon-fiap/assets/30301531/303c2035-f651-4f98-b148-3da9bedf652f)
![image](https://github.com/rcsim/hackathon-fiap/assets/30301531/f36461aa-2658-469b-9e8c-695120f75221)
![image](https://github.com/rcsim/hackathon-fiap/assets/30301531/2ed6880c-9d39-467c-9567-05414b0aa280)
![image](https://github.com/rcsim/hackathon-fiap/assets/30301531/d0d45619-9434-4813-8749-a6c12eb2f49e)
![image](https://github.com/rcsim/hackathon-fiap/assets/30301531/7873c326-8df7-453f-814f-518d2c24bd06)


#### Arquivo POSTMAN

Disponibilizamos um arquivo JSON com todas as requisições Postman para testar a API:
https://github.com/rcsim/hackathon-fiap/blob/main/src/main/resources/Postman/Hackaton.postman_collection.json




### Testes de Unidade
Utilizando as bibliotecas JUnit e JMockit, implementamos os testes de unidade, chegando a 93% de cobertura das classes do sistema:
##TODO mudar imagem
![image](https://github.com/rcsim/tech-challenge-fase4/assets/30301531/fcc79848-91b5-4e5a-a17c-2eaacaca7966)







