package br.com.tekoa.apptekoa.controllers;

import br.com.tekoa.apptekoa.entities.StatusResgate;
import br.com.tekoa.apptekoa.services.StatusResgateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/status")
public class StatusResgateController {

    @Autowired
    private StatusResgateService statusResgateService;

    @GetMapping
    public List<StatusResgate> listar() {
        return statusResgateService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusResgate> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(statusResgateService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<StatusResgate> salvar(@RequestBody @Valid StatusResgate statusResgate) {
        return ResponseEntity.ok(statusResgateService.salvar(statusResgate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        statusResgateService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
