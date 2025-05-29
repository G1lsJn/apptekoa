package br.com.tekoa.apptekoa.repositories;

import br.com.tekoa.apptekoa.entities.StatusResgate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusResgateRepository extends JpaRepository<StatusResgate, Integer> {
}
