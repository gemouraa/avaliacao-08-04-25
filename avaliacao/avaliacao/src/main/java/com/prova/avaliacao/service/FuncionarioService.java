package com.prova.avaliacao.service;

import com.prova.avaliacao.model.Funcionario;
import com.prova.avaliacao.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    @Autowired
    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Funcionario salvar(Funcionario funcionario) {
        if (repository.existsByEmail(funcionario.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        return repository.save(funcionario);
    }

    public List<Funcionario> listar() {
        return repository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário com ID " + id + " não encontrado"));
    }

    public Funcionario atualizar(Long id, Funcionario funcionario) {
        Funcionario existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário com ID " + id + " não encontrado"));

        // Atualiza apenas os campos permitidos
        existente.setNome(funcionario.getNome());
        existente.setEmail(funcionario.getEmail());
        existente.setSalario(funcionario.getSalario());
        existente.setDataNascimento(funcionario.getDataNascimento());
        existente.setEndereco(funcionario.getEndereco());
        existente.setSexo(funcionario.getSexo());
        existente.setSetor(funcionario.getSetor());
        // Adicione mais campos se necessário

        return repository.save(existente);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Funcionário com ID " + id + " não encontrado");
        }
        repository.deleteById(id);
    }
}
