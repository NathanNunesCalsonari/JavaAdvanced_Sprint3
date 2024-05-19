package br.com.fiap.datatech.dto;

import jakarta.validation.constraints.NotBlank;

public class EmpresaDTO {

    private Long id;

    @NotBlank
    private String nomeEmpresa;

    @NotBlank
    private String nomeFantasia;

    @NotBlank
    private String cnpj;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getEnderecoEmpresa() {
        return nomeFantasia;
    }

    public void setEnderecoEmpresa(String enderecoEmpresa) {
        this.nomeFantasia = enderecoEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
