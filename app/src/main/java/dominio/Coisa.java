package dominio;

/**
 * Created by helio on 05/05/15.
 */
public class Coisa {

    private int id;
    private String nome;
    private String descricao;
    private String[] tags;

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
