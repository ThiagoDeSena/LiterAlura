package br.com.alura.LiterAlura.Repository;

import br.com.alura.LiterAlura.Models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAutoresRepository extends JpaRepository <Autor,Long> {

    //Pesquisa pelo nome do Autor
    Optional<Autor> findByNomeContaining(String nomeAutor);
}
