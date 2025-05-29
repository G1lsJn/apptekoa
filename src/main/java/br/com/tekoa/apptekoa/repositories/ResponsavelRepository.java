package br.com.tekoa.apptekoa.repositories;

import br.com.tekoa.apptekoa.entities.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Integer> {

}
