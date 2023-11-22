/*
    A classe `Person` é uma entidade JPA (Java Persistence API) que representa uma pessoa no contexto do seu sistema. Abaixo está uma documentação detalhada para cada atributo e anotação presente na classe:

    1. **`@Entity`:**
       - Esta anotação indica que a classe `Person` é uma entidade JPA, ou seja, será mapeada para uma tabela no banco de dados.

    2. **`@Data`:**
       - Esta anotação é fornecida pelo Lombok e gera automaticamente métodos `toString`, `equals`, `hashCode`, `getter` e `setter` para todos os campos da classe.

    3. **`@Builder`:**
       - Anotação do Lombok que gera um padrão de design de construtor usando o padrão Builder. Isso facilita a criação de objetos `Person` com uma sintaxe mais legível e concisa, especialmente quando há muitos atributos opcionais.

    4. **`@AllArgsConstructor` e `@NoArgsConstructor`:**
       - Ambas são anotações do Lombok.
       - `@AllArgsConstructor` gera um construtor com todos os atributos da classe.
       - `@NoArgsConstructor` gera um construtor sem argumentos.

    5. **`@Id` e `@GeneratedValue(strategy = GenerationType.IDENTITY)`:**
       - `@Id` indica que o atributo `id` é a chave primária da entidade.
       - `@GeneratedValue(strategy = GenerationType.IDENTITY)` especifica que o valor da chave primária será gerado automaticamente pelo banco de dados, utilizando uma estratégia de identidade.

    6. **`@Column(nullable = false)`:**
       - Indica que os campos `firstName`, `lastName`, e `cpf` não podem ser nulos no banco de dados.

    7. **`@Column(nullable = false, unique = true)`:**
       - Indica que o campo `cpf` é único no banco de dados, evitando que dois registros tenham o mesmo CPF.

    8. **`private LocalDate birthDate;`:**
       - Representa a data de nascimento da pessoa.

    9. **`@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})`:**
       - Indica um relacionamento de um para muitos (um `Person` pode ter muitos `Phone`) com carregamento preguiçoso (lazy loading) e as operações de persistência e remoção do cascade. Isso significa que quando um `Person` é carregado, os telefones associados a ele não serão carregados a menos que explicitamente solicitado.

    10. **`private List<Phone> phones;`:**
       - Representa a lista de telefones associados à pessoa.

    Esta classe representa a estrutura da tabela `Person` no banco de dados. Os relacionamentos, como o `@OneToMany`, indicam como os dados estão conectados entre as entidades.

*/

package br.com.mktech.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String cpf;

    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;


}
