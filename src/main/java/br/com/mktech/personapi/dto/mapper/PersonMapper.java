/*
    A classe `PersonMapper` utiliza a biblioteca MapStruct para realizar o mapeamento entre objetos da classe `Person` e `PersonDTO`. Abaixo está uma documentação detalhada para cada método e anotação presente na classe:

    1. **`@Mapper(componentModel = "spring")`:**
       - A anotação `@Mapper` indica que esta interface é um mapper do MapStruct.
       - `componentModel = "spring"` especifica que o MapStruct deve gerar um bean Spring gerenciado para esta interface. Isso permite que você injete instâncias desse mapper em outros componentes Spring.

    2. **`Person toModel(PersonDTO dto)`:**
       - Método que converte um objeto `PersonDTO` em um objeto `Person`.
       - `@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")`: Especifica uma regra de mapeamento. Diz ao MapStruct para mapear o campo `birthDate` de `PersonDTO` para o campo `birthDate` de `Person`, usando o formato de data "dd-MM-yyyy".

    3. **`PersonDTO toDTO(Person dto)`:**
       - Método que converte um objeto `Person` em um objeto `PersonDTO`.

    Ambos os métodos são usados para realizar a conversão bidirecional entre `Person` e `PersonDTO`. Isso é útil para transformar objetos recebidos nas requisições em objetos que podem ser manipulados pelo serviço e vice-versa.

    A anotação `@Mapping` é usada para personalizar o mapeamento entre os campos dos objetos. No caso, a formatação da data está sendo especificada para garantir que o formato da data seja consistente ao converter entre `PersonDTO` e `Person`.

    Este mapper deve ser injetado onde for necessário converter objetos `PersonDTO` em `Person` e vice-versa. Como ele é um componente Spring (`componentModel = "spring"`), você pode injetá-lo diretamente em seus serviços ou controladores Spring.
*/

package br.com.mktech.personapi.dto.mapper;

import br.com.mktech.personapi.dto.request.PersonDTO;
import br.com.mktech.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);
}