package com.prova.avaliacao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping("/")
    public String welcome() {
        return "Bem-vindo à API de Funcionários! 🚀";
    }
    @GetMapping("/dev")
    public String dev() {
        return "Desenvolvido por Moura! 🚀";
    }
}
