package dominio;

import java.io.Serializable;

/**
 * Created by helio on 05/05/15.
 */
public class Coisa implements Serializable {

    private int id;
    private String nome;
    private String descricao;
    private String[] tags;

    public Coisa() {
    }

    public Coisa(int id, String nome, String descricao, String[] tags) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tags = tags;
    }

    public Coisa(int id, String nome, String descricao) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString(){
        return this.getNome() + " / " + this.getDescricao();
    }
}
