package br.com.tekoa.apptekoa.controllers;

import br.com.tekoa.apptekoa.entities.Responsavel;
import br.com.tekoa.apptekoa.services.ResponsavelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/responsaveis")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @GetMapping
    public List<Responsavel> listar() {
        return responsavelService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsavel> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(responsavelService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Responsavel> salvar(@RequestBody @Valid Responsavel responsavel) {
        return ResponseEntity.ok(responsavelService.salvar(responsavel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Responsavel> atualizar(@PathVariable int id, @RequestBody @Valid Responsavel responsavel) {
        return ResponseEntity.ok(responsavelService.atualizar(id, responsavel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        responsavelService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
