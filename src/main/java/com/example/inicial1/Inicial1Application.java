package com.example.inicial1;

import com.example.inicial1.entities.*;
import com.example.inicial1.repositories.AutorRepository;
import com.example.inicial1.repositories.LocalidadRepository;
import com.example.inicial1.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Inicial1Application {
	private static final Logger logger = LoggerFactory.getLogger(Inicial1Application.class);

	@Autowired
	private PersonaRepository personaRepository;
	public static void main(String[] args) {
		SpringApplication.run(Inicial1Application.class, args);
		System.out.println("funcionando");
	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository, LocalidadRepository localidadRepository, AutorRepository autorRepository) {
		return args -> {

			// Creo personas
			Persona per1 = Persona.builder().
					nombre("John").apellido("Salchichon").dni(12345678).
					build();

			Persona per2 = Persona.builder().
					nombre("Iron").apellido("Mandingo").dni(87654321).
					build();

			//Creo domicilios
			Domicilio dom1 = Domicilio.builder().
					calle("Armani").
					numero(898).build();

			Domicilio dom2 = Domicilio.builder().
					calle("9 de Julio").
					numero(1267).build();

			per1.setDomicilio(dom1);
			per2.setDomicilio(dom2);

			Localidad loc1 =Localidad.builder().denominacion("Godoy Cruz").build();
			Localidad loc2 = Localidad.builder().denominacion("Guaymallén").build();

			loc1= localidadRepository.save(loc1);
			loc2= localidadRepository.save(loc2);

			dom1.setLocalidad(loc1);
			dom2.setLocalidad(loc2);

			//Creo autores
			Autor aut1 = Autor.builder()
					.nombre("Stephen")
					.apellido("King")
					.biografia("Escritor estadounidense, eminencia de la literatura del horror y suspenso.")
					.build();

			Autor aut2 =Autor.builder()
					.nombre("Jorge")
					.apellido("Luis Borges")
					.biografia("Escritor argentino, reconocido por sus cuentos y ensayos.")
					.build();

			aut1=autorRepository.save(aut1);
			aut2=autorRepository.save(aut2);

			//Creo libros
			Libro lib1 = Libro.builder()
					.titulo("Despues")
					.fecha(1967)
					.genero("Suspenso")
					.paginas(417)
					.build();
			Libro lib2 = Libro.builder()
					.titulo("El Aleph")
					.fecha(1949)
					.genero("Ficción")
					.paginas(146)
					.build();

			lib1.getAutores().add(aut1);
			lib2.getAutores().add(aut2);

			per1.getLibros().add(lib1);
			per1.getLibros().add(lib2);

			personaRepository.save(per1);
			personaRepository.save(per2);
		};
	};

}
