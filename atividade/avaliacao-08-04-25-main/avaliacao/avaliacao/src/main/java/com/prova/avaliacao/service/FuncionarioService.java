package com.prova.avaliacao.service;

import com.prova.avaliacao.model.Funcionario;
import com.prova.avaliacao.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //anotação que indica que a classe é um serviço
public class FuncionarioService {

    private final FuncionarioRepository repository;

    @Autowired
    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    //Método para salvar um funcionário
    public Funcionario salvar(Funcionario funcionario) {
        if (repository.existsByEmail(funcionario.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        return repository.save(funcionario);
    }
    //Método para listar todos os funcionários
    public List<Funcionario> listar() {
        return repository.findAll();
    }

    //Método para buscar um funcionário por ID
    public Funcionario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário com ID " + id + " não encontrado"));
    }

    //Método para atualizar um funcionário
    public Funcionario atualizar(Long id, Funcionario funcionario) {
        Funcionario existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário com ID " + id + " não encontrado"));

        // Atualiza apenas os campos permitidos
        existente.setNome(funcionario.getNome());
        existente.setEmail(funcionario.getEmail());
        existente.setCpf(funcionario.getCpf());
        existente.setSalario(funcionario.getSalario());
        existente.setDataNascimento(funcionario.getDataNascimento());
        existente.setEndereco(funcionario.getEndereco());
        existente.setSexo(funcionario.getSexo());
        existente.setEstadoCivil(funcionario.getEstadoCivil());
        existente.setSetor(funcionario.getSetor());
        // Adicione mais campos se necessário

        return repository.save(existente);
    }
    //Método para deletar um funcionário
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Funcionário com ID " + id + " não encontrado");
        }
        repository.deleteById(id);
    }
}
