package com.prova.avaliacao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity //indica que a classe é uma entidade JPA
@Table(name = "endereco") //mapeia a classe para a tabela "endereco" no banco de dados
public class Endereco {

    @Id //indica que o campo é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera o valor automaticamente
    private Long id;

    @NotBlank(message = "Logradouro é obrigatório") //verifica se o campo não está vazio
    private String logradouro;

    @NotBlank(message = "Número é obrigatório")
    private String numero;

    private String complemento;

    @NotBlank(message = "Cidade é obrigatória")
    private String cidade;

    public Endereco() {
    }

    public Endereco(Long id, String logradouro, String numero, String complemento, String cidade) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
