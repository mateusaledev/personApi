/*
    A classe `PersonService` é uma classe de serviço que contém a lógica de negócios relacionada à entidade `Person`.
      Abaixo está uma documentação detalhada para cada método e atributo presente na classe:

    1. **`@Service`:**
       - Esta anotação marca a classe como um serviço do Spring, indicando que ela deve ser gerenciada pelo contêiner de IoC (Inversão de Controle) do Spring.

    2. **`@AllArgsConstructor`:**
       - Anotação do Lombok que gera automaticamente um construtor com todos os atributos da classe.

    3. **`@Autowired`:**
       - Anotação que indica ao Spring para injetar as dependências necessárias (no caso, `PersonRepository` e `PersonMapper`) por meio do construtor.

    4. **`private final PersonRepository personRepository;` e `private final PersonMapper personMapper;`:**
       - São os atributos da classe que representam as dependências injetadas.

    5. **`public PersonService(PersonRepository personRepository, PersonMapper personMapper) { ... }`:**
       - Construtor da classe que recebe as dependências `PersonRepository` e `PersonMapper` e as atribui aos atributos correspondentes.

    6. **`public MessageResponseDTO create(PersonDTO personDTO) { ... }`:**
       - Método responsável por criar uma nova pessoa. Converte o `PersonDTO` para `Person`, salva no banco de dados usando o `personRepository` e retorna uma mensagem de sucesso.

    7. **`public PersonDTO findById(Long id) throws PersonNotFoundException { ... }`:**
       - Método que encontra uma pessoa pelo ID. Lança uma exceção `PersonNotFoundException` se a pessoa não for encontrada.

    8. **`public List<PersonDTO> listAll() { ... }`:**
       - Método que retorna uma lista de todas as pessoas no sistema.

    9. **`public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException { ... }`:**
       - Método responsável por atualizar uma pessoa. Lança uma exceção `PersonNotFoundException` se a pessoa não for encontrada.

    10. **`public void delete(Long id) throws PersonNotFoundException { ... }`:**
       - Método que exclui uma pessoa pelo ID. Lança uma exceção `PersonNotFoundException` se a pessoa não for encontrada.

    11. **`private Person verifyIfExists(Long id) throws PersonNotFoundException { ... }`:**
        - Método privado que verifica se uma pessoa com o ID fornecido existe no banco de dados. Lança uma exceção `PersonNotFoundException` se a pessoa não for encontrada.

    12. **`private MessageResponseDTO createMessageResponse(String s, Long id) { ... }`:**
        - Método privado que cria e retorna uma mensagem de resposta com base no sucesso da operação (por exemplo, criação ou atualização de uma pessoa).

    Essa classe encapsula a lógica de negócios relacionada às operações CRUD para a entidade `Person`. O uso de DTOs e Mappers ajuda a separar a camada de serviço da camada de controle, seguindo boas práticas de arquitetura.
*/

package br.com.mktech.personapi.service;

import br.com.mktech.personapi.dto.mapper.PersonMapper;
import br.com.mktech.personapi.dto.request.PersonDTO;
import br.com.mktech.personapi.dto.response.MessageResponseDTO;
import br.com.mktech.personapi.entity.Person;
import br.com.mktech.personapi.exception.PersonNotFoundException;
import br.com.mktech.personapi.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public MessageResponseDTO create(PersonDTO personDTO) {
        Person person = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(person);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully created with ID ", savedPerson.getId());

        return messageResponse;
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }

    public List<PersonDTO> listAll() {
        List<Person> people = personRepository.findAll();
        return people.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        Person updatedPerson = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(updatedPerson);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully updated with ID ", savedPerson.getId());

        return messageResponse;
    }

    public void delete(Long id) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        personRepository.deleteById(id);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(String s, Long id) {
        return MessageResponseDTO.builder()
                .message(s + id)
                .build();
    }
}
