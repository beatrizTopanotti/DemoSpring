package demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Cliente extends EntityId{

    @Column(name = "nome_cliente", nullable = false)
    private
    String nome;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
