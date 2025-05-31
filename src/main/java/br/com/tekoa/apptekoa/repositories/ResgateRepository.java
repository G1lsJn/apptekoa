package br.com.tekoa.apptekoa.repositories;

import br.com.tekoa.apptekoa.entities.Resgate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResgateRepository extends JpaRepository<Resgate, Integer> {

    List<Resgate> findByStatusAtual(String statusAtual);

}
