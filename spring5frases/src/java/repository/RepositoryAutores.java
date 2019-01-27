package repository;

import model.Autores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAutores extends JpaRepository<Autores, Integer> {

}
