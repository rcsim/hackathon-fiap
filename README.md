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

### Diagrama da Arquitetura do Sistema

![image](https://github.com/rcsim/hackathon-fiap/assets/30301531/e8dfd650-7745-4a44-8558-4af23b961398)


### Banco de Dados

Configuração de produção utilizando o PostgreSQL
https://github.com/rcsim/hackathon-fiap/blob/a8d5145acff0a02d7405b32d656c3b195e09b520/src/main/resources/application-dev.properties#L1-L13

O schema do banco de dados são criados através do arquivo schema.sql:
https://github.com/rcsim/hackathon-fiap/blob/a8d5145acff0a02d7405b32d656c3b195e09b520/schema.sql#L1-L34

![image](https://github.com/rcsim/hackathon-fiap/assets/30301531/82faf466-d7a6-45e1-b9e8-19d64e9825e2)


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

### Documentação das requisições utilizadas (cURL):

Additional controller:

curl -L -X POST 'http://localhost:8080/additional/item' -H 'Content-Type: application/json' -d '{"name":"Item 1", "description":"", "price":"10"}'

curl -L -X GET 'http://localhost:8080/additional/1'

curl -L -X GET 'http://localhost:8080/additional?page=0&size=5'

curl -L -X PUT 'http://localhost:8080/additional/1' -H 'Content-Type: application/json' -d '{"name": "Item 1", "description": "", "price": 50.0}'

curl -L -X DELETE 'http://localhost:8080/additional/1'

Booking controller:

curl -L -X POST 'http://localhost:8080/book' -H 'Content-Type: application/json' -d '{"idClient": 1, "checkInDate": "2020-01-01", "checkOutDate": "2020-01-10", "rooms": [], "services": [], "totalValue": 0, "guests": 0}'

curl -L -X GET 'http://localhost:8080/book/avaliable' -H 'Content-Type: application/json' -d '{"checkInDate":"2020-01-10","checkOutDate":"2020-01-10"}'

curl -L -X GET 'http://localhost:8080/book'

curl -L -X GET 'http://localhost:8080/book/1'

curl -L -X PUT 'http://localhost:8080/book/1' -H 'Content-Type: application/json' -d '{"idClient": 1, "checkInDate": "2020-01-01", "checkOutDate": "2020-01-10", "rooms": [], "services": [], "totalValue": 0.0, "guests": 0}'

curl -L -X DELETE 'http://localhost:8080/book/1'

Building controller:

curl -L -X POST 'http://localhost:8080/building' -H 'Content-Type: application/json' -d '{"locationId": 1, "name": "Teste"}'

curl -L -X GET 'http://localhost:8080/building'

curl -L -X GET 'http://localhost:8080/building/1'

curl -L -X PUT 'http://localhost:8080/building/1' -H 'Content-Type: application/json' -d '{"locationId": 1, "name": "Teste Atualizado"}'

curl -L -X DELETE 'http://localhost:8080/building/1'

Cliente controller:

curl -L -X POST 'http://localhost:8080/client' -H 'Content-Type: application/json' --data-raw '{"country":"Teste", "cpf":"111-111-111.11", "passport":"218921928", "fullName":"Teste da Silva", "birthDate":"2020-01-10", "address":"Rua Teste", "phone":"5511912345678", "email":"teste@gmail.com"}'

curl -L -X GET 'http://localhost:8080/client'

curl -L -X GET 'http://localhost:8080/client/1'

curl -L -X PUT 'http://localhost:8080/client/1' -H 'Content-Type: application/json' --data-raw '{"country":"Teste Atualizado", "cpf":"111-111-111.12", "passport":"218921928", "fullName":"Teste da Silva", "birthDate":"2020-01-10", "address":"Rua Teste", "phone":"5511912345678", "email":"teste@gmail.com"}'

curl -L -X DELETE 'http://localhost:8080/client/1'

Location Controller:

curl -L -X POST 'http://localhost:8080/location' -H 'Content-Type: application/json' -d '{"name":"Teste", "address":"Teste", "zipCode":"0101010", "city":"Teste", "state":"Teste"}'

curl -L -X GET 'http://localhost:8080/location'

curl -L -X GET 'http://localhost:8080/location/1'

curl -L -X PUT 'http://localhost:8080/location/1' -H 'Content-Type: application/json' -d '{"name":"Teste Atualizado", "address":"Teste", "zipCode":"0101010", "city":"Teste", "state":"Teste"}'

curl -L -X DELETE 'http://localhost:8080/location/1'

Room Controller:
curl -L -X POST 'http://localhost:8080/room' -H 'Content-Type: application/json' -d '{"buildingId": "1", "locationId": "1", "type": "Padrao", "totalPeople": 0, "totalBeds": 2, "otherFurniture": "Sofa, Poltrona", "bathroom": "2", "dailyRate": 5.0}'

curl -L -X GET 'http://localhost:8080/room'

curl -L -X GET 'http://localhost:8080/room/1'

curl -L -X PUT 'http://localhost:8080/room/1' -H 'Content-Type: application/json' -d '{"buildingId": "1", "locationId": "1", "type": "Padrao 2", "totalPeople": 2, "totalBeds": 2, "otherFurniture": "Sofa, Poltrona", "bathroom": "2", "dailyRate": 5.0}'

curl -L -X DELETE 'http://localhost:8080/room/1'



#### Arquivo POSTMAN

Disponibilizamos um arquivo JSON com todas as requisições Postman para testar a API:
https://github.com/rcsim/hackathon-fiap/blob/main/src/main/resources/Postman/Hackaton.postman_collection.json




### Testes de Unidade
Utilizando as bibliotecas JUnit e JMockit, implementamos os testes de unidade, chegando a 93% de cobertura das classes do sistema:
##TODO mudar imagem
![image](https://github.com/rcsim/tech-challenge-fase4/assets/30301531/fcc79848-91b5-4e5a-a17c-2eaacaca7966)


### Casos de Testes
Caso de Teste: Cadastrar localização

Objetivo:
Criar uma nova localização

Pré-condições:

O sistema está funcionando corretamente.

Passos:

Acesse a API de localização.
Insira os dados que deseja incluir

Resultado Esperado:

O sistema deve apresentar uma mensagem com os dados cadastrados.
Se os dados estiverem inválidos, o sistema deve exibir uma mensagem de erro.

Critérios de Aceitação:
O sistema exibe uma mensagem de sucesso se os dados forem válidos.
O sistema exibe uma mensagem de erro se as credenciais forem inválidas.

Resultado do Teste:

PASS
Observações:
Json do testes:


{
    "name":"String",
    "address":"String",
    "zipCode":"String",
    "city":"String",
    "state":"String"
}

—------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Caso de Teste: Buscar todas as localizações cadastradas

Objetivo:
Listar as localizações cadastradas

Pré-condições:

O sistema está funcionando corretamente.

Passos:

Acesse a API para buscar localização.

Resultado Esperado:

O sistema deve apresentar uma mensagem com todas as localizações cadastradas.
Se os dados estiverem inválidos, o sistema deve exibir uma mensagem de erro.

Critérios de Aceitação:
O sistema exibe uma mensagem de sucesso se os dados forem válidos.
O sistema exibe uma mensagem de erro se as credenciais forem inválidas.

Resultado do Teste:

PASS
—------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Caso de Teste: Buscar uma das localizações cadastradas

Objetivo:
Listar uma localização em específico.

Pré-condições:

O sistema está funcionando corretamente.

Passos:

Acesse a API para buscar localização.
Incluir o ID da localização procurada.

Resultado Esperado:

O sistema deve apresentar uma mensagem com os dados da localização.
Se os dados estiverem inválidos, o sistema deve exibir uma mensagem de erro.

Critérios de Aceitação:
O sistema exibe uma mensagem de sucesso se os dados forem válidos.
O sistema exibe uma mensagem de erro se as credenciais forem inválidas.

Resultado do Teste:

PASS
—------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Caso de Teste: Cadastrar um prédio

Objetivo:
Criar um novo prédio.

Pré-condições:

O sistema está funcionando corretamente.
Necessário uma localização já cadastrada.

Passos:

Acesse a API de cadastro de prédio.
Inserir os dados que deseja incluir.

Resultado Esperado:

O sistema deve apresentar uma mensagem com os dados cadastrados.
Se os dados estiverem inválidos, o sistema deve exibir uma mensagem de erro.

Critérios de Aceitação:

O sistema exibe uma mensagem de sucesso se os dados forem válidos.
O sistema exibe uma mensagem de erro se as credenciais forem inválidas.

Resultado do Teste:

PASS
Observações:
Json do teste:


{
  "locationId": int,
  "name": "String"
}

—------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Caso de Teste: Buscar todas os prédios cadastrados

Objetivo:
Listar os prédios cadastrados

Pré-condições:

O sistema está funcionando corretamente.

Passos:

Acesse a API para buscar prédios.

Resultado Esperado:

O sistema deve apresentar uma mensagem com todos os prédios cadastrados.
Se os dados estiverem inválidos, o sistema deve exibir uma mensagem de erro.

Critérios de Aceitação:
O sistema exibe uma mensagem de sucesso se os dados forem válidos.
O sistema exibe uma mensagem de erro se as credenciais forem inválidas.

Resultado do Teste:

PASS
—------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Caso de Teste: Buscar um dos prédios cadastrados.

Objetivo:
Listar um prédio em específico.

Pré-condições:

O sistema está funcionando corretamente.

Passos:

Acesse a API para buscar prédios.
Incluir o ID do prédio procurado.

Resultado Esperado:

O sistema deve apresentar uma mensagem com os dados do prédio.
Se os dados estiverem inválidos, o sistema deve exibir uma mensagem de erro.

Critérios de Aceitação:
O sistema exibe uma mensagem de sucesso se os dados forem válidos.
O sistema exibe uma mensagem de erro se as credenciais forem inválidas.

Resultado do Teste:

PASS
—------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Caso de Teste: Cadastrar um quarto

Objetivo:
Cadastrar um novo quarto

Pré-condições:

O sistema está funcionando corretamente.
Necessário uma localização já cadastrada.
Necessário um prédio já cadastrado.

Passos:

Acesse a API de cadastro de prédio.
Inserir os dados que deseja incluir.

Resultado Esperado:

O sistema deve apresentar uma mensagem com os dados cadastrados.
Se os dados estiverem inválidos, o sistema deve exibir uma mensagem de erro.

Critérios de Aceitação:

O sistema exibe uma mensagem de sucesso se os dados forem válidos.
O sistema exibe uma mensagem de erro se as credenciais forem inválidas.

Resultado do Teste:

PASS
Observações:
Dados do teste:


{
    "buildingId": "String",
    "locationId": "String",
    "type": "String",
    "totalPeople": int,
    "totalBeds": int,
    "otherFurniture": "String",
    "bathroom": "String",
    "dailyRate": double
}

—------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Caso de Teste: Buscar todos os quartos cadastrados.

Objetivo:
Listar os quartos cadastrados

Pré-condições:

O sistema está funcionando corretamente.

Passos:

Acesse a API para buscar quartos.

Resultado Esperado:

O sistema deve apresentar uma mensagem com todos os quartos cadastrados.
Se os dados estiverem inválidos, o sistema deve exibir uma mensagem de erro.

Critérios de Aceitação:
O sistema exibe uma mensagem de sucesso se os dados forem válidos.
O sistema exibe uma mensagem de erro se as credenciais forem inválidas.

Resultado do Teste:

PASS
—------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Caso de Teste: Buscar um dos quartos cadastrados.

Objetivo:
Listar um quarto em específico.

Pré-condições:

O sistema está funcionando corretamente.

Passos:

Acesse a API para buscar um quarto.
Incluir o ID do quarto procurado.

Resultado Esperado:

O sistema deve apresentar uma mensagem com os dados do quarto..
Se os dados estiverem inválidos, o sistema deve exibir uma mensagem de erro.

Critérios de Aceitação:
O sistema exibe uma mensagem de sucesso se os dados forem válidos.
O sistema exibe uma mensagem de erro se as credenciais forem inválidas.

Resultado do Teste:

PASS
—------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------




