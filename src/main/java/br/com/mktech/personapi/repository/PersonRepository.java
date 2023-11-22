package br.com.mktech.personapi.repository;

import br.com.mktech.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

/*
     A interface `PersonRepository` é uma interface Spring Data JPA que estende `JpaRepository` para operações de acesso a dados relacionadas à entidade `Person`. Abaixo está uma documentação detalhada para cada atributo e anotação presente na interface:

    1. **`public interface PersonRepository extends JpaRepository<Person, Long> {`:**
       - `PersonRepository` é uma interface que estende `JpaRepository`.
       - `Person` é o tipo da entidade gerenciada pelo repositório.
       - `Long` é o tipo do identificador (ID) da entidade.

    2. **`JpaRepository<Person, Long>`:**
       - `JpaRepository` é uma interface do Spring Data JPA que fornece métodos CRUD (Create, Read, Update, Delete) padrão para a entidade `Person`.
       - `Person` é a entidade associada ao repositório.
       - `Long` é o tipo do identificador da entidade.

    Essa interface fornece métodos prontos para interagir com o banco de dados para realizar operações com a entidade `Person`. Alguns exemplos de métodos fornecidos por `JpaRepository` são `save`, `findById`, `findAll`, `delete`, entre outros.

    O Spring Data JPA implementará automaticamente esses métodos com base nas consultas necessárias para o banco de dados, sem a necessidade de implementação manual.
*/
