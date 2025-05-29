package br.com.tekoa.apptekoa.repositories;

import br.com.tekoa.apptekoa.entities.CentroAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroAtendimentoRepository extends JpaRepository<CentroAtendimento, Integer> {

}
