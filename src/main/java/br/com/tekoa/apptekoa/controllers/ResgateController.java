package br.com.tekoa.apptekoa.controllers;

import br.com.tekoa.apptekoa.entities.CentroAtendimento;
import br.com.tekoa.apptekoa.entities.Resgate;
import br.com.tekoa.apptekoa.services.ResgateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/resgates")
public class ResgateController {

    @Autowired
    private ResgateService resgateService;

    @GetMapping
    public List<Resgate> listar() {
        return resgateService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resgate> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(resgateService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Resgate> salvar(@RequestBody @Valid Resgate resgate) {
        return ResponseEntity.ok(resgateService.salvar(resgate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        resgateService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status")
    public List<Resgate> listarPorStatus(@RequestParam String status) {
        return resgateService.listarPorStatus(status);
    }

    @PutMapping("/{id}/centro")
    public ResponseEntity<Resgate> atualizarCentroAtendimento(
            @PathVariable int id,
            @RequestBody CentroAtendimento centro) {
        return ResponseEntity.ok(resgateService.atualizarCentroAtendimento(id, centro));
    }

}
