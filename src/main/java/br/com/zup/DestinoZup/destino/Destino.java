package br.com.zup.DestinoZup.destino;

import br.com.zup.DestinoZup.categoria.Categoria;
import br.com.zup.DestinoZup.regiao.Regiao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "destinos")
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @ManyToOne
    private Regiao regiao;
    @ManyToMany
    private List<Categoria> categoria;

    public Destino() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }
}
