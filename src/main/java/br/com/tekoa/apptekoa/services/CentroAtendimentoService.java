package br.com.tekoa.apptekoa.services;

import br.com.tekoa.apptekoa.entities.CentroAtendimento;
import br.com.tekoa.apptekoa.repositories.CentroAtendimentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentroAtendimentoService {

    @Autowired
    private CentroAtendimentoRepository centroAtendimentoRepository;

    public List<CentroAtendimento> listarTodos() {
        return centroAtendimentoRepository.findAll();
    }

    public CentroAtendimento buscarPorId(int id) {
        return centroAtendimentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Centro de atendimento não encontrado"));
    }

    public CentroAtendimento salvar(CentroAtendimento centro) {
        return centroAtendimentoRepository.save(centro);
    }

    public void excluir(int id) {
        centroAtendimentoRepository.deleteById(id);
    }

    public CentroAtendimento atualizar(int id, CentroAtendimento dadosAtualizados) {
        CentroAtendimento centro = buscarPorId(id);

        centro.setNome(dadosAtualizados.getNome());
        centro.setTipoAtendimento(dadosAtualizados.getTipoAtendimento());
        centro.setCapacidadeTotal(dadosAtualizados.getCapacidadeTotal());
        centro.setCapacidadeAtual(dadosAtualizados.getCapacidadeAtual());
        centro.setNivelEstrutura(dadosAtualizados.getNivelEstrutura());
        centro.setEndereco(dadosAtualizados.getEndereco());
        centro.setLatitude(dadosAtualizados.getLatitude());
        centro.setLongitude(dadosAtualizados.getLongitude());

        return centroAtendimentoRepository.save(centro);
    }

}
