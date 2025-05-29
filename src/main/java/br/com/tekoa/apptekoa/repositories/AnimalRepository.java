package br.com.tekoa.apptekoa.repositories;

import br.com.tekoa.apptekoa.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {


}
