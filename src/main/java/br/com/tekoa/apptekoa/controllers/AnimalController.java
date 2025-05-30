package br.com.tekoa.apptekoa.controllers;

import br.com.tekoa.apptekoa.entities.Animal;
import br.com.tekoa.apptekoa.services.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> listar() {
        return animalService.listarAnimais();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(animalService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Animal> salvar(@RequestBody @Valid Animal animal) {
        return ResponseEntity.ok(animalService.salvar(animal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> atualizar(@PathVariable int id, @RequestBody @Valid Animal animal) {
        return ResponseEntity.ok(animalService.atualizar(id, animal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        animalService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
