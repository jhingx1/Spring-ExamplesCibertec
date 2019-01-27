package repository;

import model.Frases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryFrases extends JpaRepository<Frases, Integer> {

}
