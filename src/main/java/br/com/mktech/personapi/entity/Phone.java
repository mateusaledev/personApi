/*
    A classe `Phone` é uma entidade JPA (Java Persistence API) que representa um telefone associado a uma entidade `Person`. Abaixo está uma documentação detalhada para cada atributo e anotação presente na classe:

    1. **`@Entity`:**
       - Esta anotação indica que a classe `Phone` é uma entidade JPA, ou seja, será mapeada para uma tabela no banco de dados.

    2. **`@Data`:**
       - Esta anotação é fornecida pelo Lombok e gera automaticamente métodos `toString`, `equals`, `hashCode`, `getter` e `setter` para todos os campos da classe.

    3. **`@Builder`:**
       - Anotação do Lombok que gera um padrão de design de construtor usando o padrão Builder. Isso facilita a criação de objetos `Phone` com uma sintaxe mais legível e concisa, especialmente quando há muitos atributos opcionais.

    4. **`@AllArgsConstructor` e `@NoArgsConstructor`:**
       - Ambas são anotações do Lombok.
       - `@AllArgsConstructor` gera um construtor com todos os atributos da classe.
       - `@NoArgsConstructor` gera um construtor sem argumentos.

    5. **`@Id` e `@GeneratedValue(strategy = GenerationType.IDENTITY)`:**
       - `@Id` indica que o atributo `id` é a chave primária da entidade.
       - `@GeneratedValue(strategy = GenerationType.IDENTITY)` especifica que o valor da chave primária será gerado automaticamente pelo banco de dados, utilizando uma estratégia de identidade.

    6. **`@Enumerated(EnumType.STRING)`:**
       - A anotação `@Enumerated` é usada para mapear a enumeração `PhoneType` para o banco de dados. O tipo de enumeração é STRING, indicando que os valores serão armazenados como strings no banco de dados.

    7. **`@Column(nullable = false)`:**
       - Indica que os campos `type` e `number` não podem ser nulos no banco de dados.

    8. **`private PhoneType type;`:**
       - Representa o tipo de telefone (por exemplo, CELULAR, RESIDENCIAL, TRABALHO). É uma enumeração do tipo `PhoneType`.

    9. **`private String number;`:**
       - Representa o número de telefone.

    Esta classe representa a estrutura da tabela `Phone` no banco de dados. A relação entre `Person` e `Phone` é mapeada através do relacionamento `@OneToMany` na classe `Person`, onde uma pessoa pode ter muitos telefones.
*/

package br.com.mktech.personapi.entity;

import br.com.mktech.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;
}
