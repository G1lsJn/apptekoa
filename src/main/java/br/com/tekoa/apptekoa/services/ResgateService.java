package br.com.tekoa.apptekoa.services;

import br.com.tekoa.apptekoa.entities.Resgate;
import br.com.tekoa.apptekoa.repositories.ResgateRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResgateService {

    @Autowired
    private ResgateRepository resgateRepository;

    public List<Resgate> listarResgates() {
        return resgateRepository.findAll();
    }

    public Resgate buscarPorId(int id) {
        return resgateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Resgate não encontrado"));
    }

    public Resgate salvar(Resgate resgate) {
        return resgateRepository.save(resgate);
    }

    public void excluir(int id) {
        resgateRepository.deleteById(id);
    }

    public Resgate atualizarStatus(int id, String novoStatus) {
        Resgate resgate = buscarPorId(id);
        resgate.setStatusAtual(novoStatus);
        return resgateRepository.save(resgate);
    }

}
