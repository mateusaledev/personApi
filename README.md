# Person API

## Descrição
A Person API é uma aplicação Java baseada em Spring Boot que gerencia informações sobre pessoas, incluindo seus dados pessoais e números de telefone associados.

## Requisitos do Sistema
Certifique-se de ter o seguinte instalado antes de executar a aplicação:
- Java 11
- Maven
- Banco de Dados (por padrão, a aplicação utiliza o H2 Database para ambientes de desenvolvimento)

## Configuração
1. Clone o repositório.
   ```bash
   git clone https://github.com/MateusAleSilv/personApi.git
   cd person-api
   ```

2. Build da aplicação.
   ```bash
   mvn clean install
   ```

3. Execute a aplicação.
   ```bash
   mvn spring-boot:run
   ```

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints

### 1. Criar uma Pessoa
```http
POST /api/v1/people
```
Cria uma nova pessoa com base nos dados fornecidos.

#### Corpo da Requisição
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "cpf": "123.456.789-09",
  "birthDate": "1990-01-01",
  "phones": [
    {
      "type": "MOBILE",
      "number": "+1 123-456-7890"
    }
  ]
}
```

### 2. Obter uma Pessoa por ID
```http
GET /api/v1/people/{id}
```
Obtém os detalhes de uma pessoa com o ID especificado.

### 3. Listar Todas as Pessoas
```http
GET /api/v1/people
```
Obtém uma lista de todas as pessoas cadastradas.

### 4. Atualizar uma Pessoa por ID
```http
PUT /api/v1/people/{id}
```
Atualiza os detalhes de uma pessoa com o ID especificado.

#### Corpo da Requisição
```json
{
  "firstName": "Updated",
  "lastName": "Person",
  "cpf": "123.456.789-09",
  "birthDate": "1990-01-01",
  "phones": [
    {
      "type": "HOME",
      "number": "+1 987-654-3210"
    }
  ]
}
```

### 5. Excluir uma Pessoa por ID
```http
DELETE /api/v1/people/{id}
```
Exclui uma pessoa com o ID especificado.

## Tecnologias Utilizadas
- Spring Boot
- Spring Data JPA
- H2 Database (para ambiente de desenvolvimento)
- MapStruct (para mapeamento de DTOs)
- Lombok (para geração automática de código)

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.