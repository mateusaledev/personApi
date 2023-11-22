package br.com.mktech.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception{
    public PersonNotFoundException(Long id) {
        super(String.format("Person with ID %s not found!", id));
    }
}

/*
* A classe `PersonNotFoundException` é uma exceção personalizada que é lançada quando uma pessoa com um determinado ID não é encontrada. Abaixo está uma documentação detalhada para cada atributo e anotação presente na classe:

1. **`@ResponseStatus(HttpStatus.NOT_FOUND)`:**
   - Esta anotação do Spring MVC indica que, quando essa exceção for lançada, a resposta HTTP terá o código de status 404 (NOT FOUND). Isso é útil para indicar que a entidade procurada não foi encontrada.

2. **`public class PersonNotFoundException extends Exception {`:**
   - Declaração da classe `PersonNotFoundException` que estende a classe `Exception`.

3. **`public PersonNotFoundException(Long id) {`:**
   - Construtor da exceção que recebe o ID da pessoa que não foi encontrada.
   - `super(String.format("Person with ID %s not found!", id))`: Chama o construtor da classe `Exception` passando uma mensagem formatada indicando que a pessoa com o ID fornecido não foi encontrada.

Essa exceção pode ser lançada em situações em que você esperaria encontrar uma pessoa com um ID específico, mas ela não está presente no sistema. O uso da anotação `@ResponseStatus` permite que o Spring trate automaticamente essa exceção retornando uma resposta HTTP com o código 404.

Se houver alguma parte específica ou dúvida adicional sobre a exceção `PersonNotFoundException` que você gostaria de esclarecer, por favor, me avise!
*/
