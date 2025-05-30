package br.com.tekoa.apptekoa.services;

import br.com.tekoa.apptekoa.entities.Animal;
import br.com.tekoa.apptekoa.repositories.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Animal salvar(Animal animal) {
        return animalRepository.save(animal);
    }

    public List<Animal> listarAnimais() {
        return animalRepository.findAll();
    }

    public Animal buscarPorId(int id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal não encontrado"));
    }

    public void excluir(int id) {
        animalRepository.deleteById(id);
    }

    public Animal atualizar(int id, Animal atualizado) {
        Animal existente = buscarPorId(id);

        existente.setEspecie(atualizado.getEspecie());
        existente.setGrupoAnimal(atualizado.getGrupoAnimal());
        existente.setPorte(atualizado.getPorte());
        existente.setSexo(atualizado.getSexo());
        existente.setCorPredominante(atualizado.getCorPredominante());
        existente.setGravidade(atualizado.getGravidade());
        existente.setFotoUrl(atualizado.getFotoUrl());

        return animalRepository.save(existente);
    }
}
