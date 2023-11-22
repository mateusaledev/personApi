/*
    O arquivo `Application` contém a classe principal que inicia a aplicação Spring Boot. Abaixo está uma documentação simples para a classe:

    1. **`@SpringBootApplication`:**
       - Esta anotação combina várias anotações, incluindo `@Configuration`, `@EnableAutoConfiguration`, e `@ComponentScan`.
       - `@Configuration`: Indica que a classe contém configurações para o contexto da aplicação.
       - `@EnableAutoConfiguration`: Habilita a configuração automática com base nas dependências no classpath, nas beans e nas propriedades da aplicação.
       - `@ComponentScan`: Escaneia o pacote atual e seus subpacotes em busca de componentes anotados com `@Component`, `@Service`, `@Repository`, etc.

    2. **`public static void main(String[] args) { ... }`:**
       - O método `main` é o ponto de entrada da aplicação.
       - `SpringApplication.run(Application.class, args);`: Inicia a aplicação Spring Boot. `Application.class` é a classe de configuração principal que contém a configuração da aplicação.

    Essa é a classe principal que permite iniciar a aplicação Spring Boot. O Spring Boot, por meio de convenções e configurações automáticas, simplifica o processo de configuração e execução de aplicações Java.
*/

package br.com.mktech.personapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
