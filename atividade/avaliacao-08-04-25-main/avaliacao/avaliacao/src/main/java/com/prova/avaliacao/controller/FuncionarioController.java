package com.prova.avaliacao.controller;

import com.prova.avaliacao.model.Funcionario;
import com.prova.avaliacao.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController //controlador REST
@RequestMapping("/funcionarios")//controlador responsável por gerenciar os funcionários
@CrossOrigin(origins = "*")// permite requisições de qualquer origem
public class FuncionarioController {

    private final FuncionarioService service;

    @Autowired //injeção de dependência
    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @PostMapping//mapeia requisições HTTP POST

    public ResponseEntity<?> criar(@Valid @RequestBody Funcionario funcionario) {
        try {
            service.salvar(funcionario);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of("mensagem", "Funcionário cadastrado com sucesso"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("erro", e.getMessage()));
        }
    }

    @GetMapping//mapeia requisições HTTP GET

    public ResponseEntity<?> listarTodos() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")//mapeia requisições HTTP GET com ID

    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("erro", e.getMessage()));
        }
    }

    @PutMapping("/{id}")//mapeia requisições HTTP PUT com ID

    public ResponseEntity<Map<String, String>> atualizar(@PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {
        service.atualizar(id, funcionario);
        return ResponseEntity.ok().body(Map.of("message", "Funcionário atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")//mapeia requisições HTTP DELETE com ID

    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.ok(Map.of("mensagem", "Funcionário deletado com sucesso"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("erro", e.getMessage()));
        }
    }
}
