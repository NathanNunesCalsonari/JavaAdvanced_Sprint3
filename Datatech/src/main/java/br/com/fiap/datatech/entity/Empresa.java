package br.com.fiap.datatech.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "T_TECH_EMPRESA")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMPRESA")
    private Long id;

    @Column(name = "NM_EMPRESA", nullable = false)
    private String nome;

    @Column(name = "NM_FANTASIA", nullable = true)
    private String nomeFantasia;

    @Column(name = "NR_CNPJ", nullable = false, unique = true)
    private String cnpj; 

    public Empresa(Long novoId, String nome, String nomeFantasia, String cnpj) {
        this.id = novoId;
        this.nome = nome;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

    public Empresa() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
