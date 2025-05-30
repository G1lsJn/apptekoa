package br.com.tekoa.apptekoa.controllers;

import br.com.tekoa.apptekoa.entities.CentroAtendimento;
import br.com.tekoa.apptekoa.services.CentroAtendimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/centros")
public class CentroAtendimentoController {

    @Autowired
    private CentroAtendimentoService centroAtendimentoService;

    @GetMapping
    public List<CentroAtendimento> listar() {
        return centroAtendimentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CentroAtendimento> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(centroAtendimentoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CentroAtendimento> salvar(@RequestBody @Valid CentroAtendimento centro) {
        return ResponseEntity.ok(centroAtendimentoService.salvar(centro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CentroAtendimento> atualizar(@PathVariable int id, @RequestBody @Valid CentroAtendimento centro) {
        return ResponseEntity.ok(centroAtendimentoService.atualizar(id, centro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        centroAtendimentoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
