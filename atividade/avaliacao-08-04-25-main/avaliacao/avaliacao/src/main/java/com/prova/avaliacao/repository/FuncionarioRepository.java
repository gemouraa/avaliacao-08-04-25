package com.prova.avaliacao.repository;

import com.prova.avaliacao.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository //interface de repositório
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    boolean existsByEmail(String email);
}