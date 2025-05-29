package br.com.tekoa.apptekoa.services;

import br.com.tekoa.apptekoa.entities.Animal;
import br.com.tekoa.apptekoa.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Iterable<Animal> findAll(){

    }
}
