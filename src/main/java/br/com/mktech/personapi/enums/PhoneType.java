/*
    A classe `PhoneType` é uma enumeração que representa os tipos de telefone associados a uma entidade `Person`. Abaixo está uma documentação detalhada para cada atributo e anotação presente na classe:

    1. **`@Getter`:**
       - Esta anotação é fornecida pelo Lombok e gera automaticamente um método `getter` para o atributo `description`.

    2. **`@AllArgsConstructor`:**
       - Anotação do Lombok que gera automaticamente um construtor com todos os atributos da enumeração.

    3. **`HOME("Home"), MOBILE("Mobile"), COMMERCIAL("Commercial");`:**
       - São os valores possíveis da enumeração, representando os tipos de telefone.
       - Cada valor é associado a uma descrição correspondente, como "Home", "Mobile" e "Commercial".

    4. **`private final String description;`:**
       - O atributo `description` armazena a descrição associada a cada valor da enumeração.

    A enumeração `PhoneType` é uma forma conveniente de representar os diferentes tipos de telefone que uma pessoa pode ter. Os valores definidos na enumeração são os únicos valores válidos para o campo `type` na classe `Phone`.
*/

package br.com.mktech.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");

    private final String description;
}
