/*
    A classe `PersonController` é um controlador Spring MVC responsável por lidar com requisições relacionadas a pessoas (`Person`). Abaixo está uma documentação detalhada de cada método e anotação presente na classe:

    1. **`@RestController` e `@RequestMapping("/api/v1/people")`:**
       - `@RestController` indica que esta classe é um controlador Spring que lida com solicitações HTTP, e retorna o resultado diretamente no corpo da resposta (em vez de renderizar uma visualização).
       - `@RequestMapping("/api/v1/people")` especifica o mapeamento de URL base para todos os métodos desta classe. Todas as URLs começarão com "/api/v1/people".

    2. **`public class PersonController`:**
       - Declaração da classe `PersonController`.

    3. **`private final PersonService personService;`:**
       - Declaração de uma variável final do tipo `PersonService` chamada `personService`. Essa variável é injetada por meio do construtor.

    4. **`public PersonController(PersonService personService)`:**
       - Construtor da classe `PersonController` que recebe uma instância de `PersonService` como parâmetro e a atribui à variável `personService`.

    5. **`@PostMapping` e `@ResponseStatus(HttpStatus.CREATED)`:**
       - `@PostMapping` indica que este método trata requisições HTTP do tipo POST.
       - `@ResponseStatus(HttpStatus.CREATED)` define que, se o método for executado com sucesso, a resposta HTTP terá o código de status 201 (CREATED).
       - `public MessageResponseDTO create(@RequestBody @Valid PersonDTO personDTO)`: Método que cria uma nova pessoa, recebendo um objeto `PersonDTO` no corpo da requisição. A anotação `@Valid` indica que as validações declaradas nas classes de DTO devem ser aplicadas.

    6. **`@GetMapping("/{id}")` e `@ResponseStatus(HttpStatus.OK)`:**
       - `@GetMapping("/{id}")` indica que este método trata requisições HTTP do tipo GET com um parâmetro de caminho (path variable) "id".
       - `@ResponseStatus(HttpStatus.OK)` define que, se o método for executado com sucesso, a resposta HTTP terá o código de status 200 (OK).
       - `public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException`: Método que busca e retorna os detalhes de uma pessoa pelo seu ID.

    7. **`@GetMapping` (sem anotação de status específico):**
       - `@GetMapping` indica que este método trata requisições HTTP do tipo GET.
       - `public List<PersonDTO> listAll()`: Método que retorna uma lista de todas as pessoas cadastradas.

    8. **`@PutMapping("/{id}")` e `@ResponseStatus(HttpStatus.OK)`:**
       - `@PutMapping("/{id}")` indica que este método trata requisições HTTP do tipo PUT com um parâmetro de caminho "id".
       - `@ResponseStatus(HttpStatus.OK)` define que, se o método for executado com sucesso, a resposta HTTP terá o código de status 200 (OK).
       - `public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException`: Método que atualiza os dados de uma pessoa existente com o ID fornecido.

    9. **`@DeleteMapping("/{id}")` e `@ResponseStatus(HttpStatus.NO_CONTENT)`:**
       - `@DeleteMapping("/{id}")` indica que este método trata requisições HTTP do tipo DELETE com um parâmetro de caminho "id".
       - `@ResponseStatus(HttpStatus.NO_CONTENT)` define que, se o método for executado com sucesso, a resposta HTTP terá o código de status 204 (NO CONTENT).
       - `public void delete(@PathVariable Long id) throws PersonNotFoundException`: Método que exclui uma pessoa pelo ID fornecido.

*/

package br.com.mktech.personapi.controller;

import br.com.mktech.personapi.dto.request.PersonDTO;
import br.com.mktech.personapi.dto.response.MessageResponseDTO;
import br.com.mktech.personapi.exception.PersonNotFoundException;
import br.com.mktech.personapi.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.update(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}