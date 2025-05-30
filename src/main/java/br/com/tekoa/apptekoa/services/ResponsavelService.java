package br.com.tekoa.apptekoa.services;

import br.com.tekoa.apptekoa.entities.Responsavel;
import br.com.tekoa.apptekoa.repositories.ResponsavelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    public List<Responsavel> listarResponsaveis() {
        return responsavelRepository.findAll();
    }

    public Responsavel buscarPorId(int id) {
        return responsavelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Responsável não encontrado"));
    }

    public Responsavel salvar(Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }

    public void excluir(int id) {
        responsavelRepository.deleteById(id);
    }

    public Responsavel atualizar(int id, Responsavel atualizado) {
        Responsavel existente = buscarPorId(id);

        existente.setNome(atualizado.getNome());
        existente.setTipo(atualizado.getTipo());
        existente.setTelefone(atualizado.getTelefone());
        existente.setEmail(atualizado.getEmail());
        existente.setOrganizacao(atualizado.getOrganizacao());

        return responsavelRepository.save(existente);
    }
}
