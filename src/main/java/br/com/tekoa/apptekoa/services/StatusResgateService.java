package br.com.tekoa.apptekoa.services;

import br.com.tekoa.apptekoa.entities.StatusResgate;
import br.com.tekoa.apptekoa.repositories.StatusResgateRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusResgateService {

    @Autowired
    private StatusResgateRepository statusResgateRepository;

    public List<StatusResgate> listarTodos() {
        return statusResgateRepository.findAll();
    }

    public StatusResgate buscarPorId(int id) {
        return statusResgateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Status de resgate não encontrado"));
    }

    public StatusResgate salvar(StatusResgate statusResgate) {
        return statusResgateRepository.save(statusResgate);
    }

    public void excluir(int id) {
        statusResgateRepository.deleteById(id);
    }

}
