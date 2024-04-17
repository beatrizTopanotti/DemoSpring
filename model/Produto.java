package demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Produto extends EntityId{

    @Column(name = "nome_produto", nullable = false)
    private String nome;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "estoque")
    private Integer estoque;

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", estoque=" + estoque +
                '}';
    }
}
