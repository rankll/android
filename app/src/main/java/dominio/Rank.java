package dominio;

import java.util.Date;

/**
 * Created by helio on 04/05/15.
 */
public class Rank {

    private int id;
    private String descricao;
    private int nota;
    private String latitude;
    private String longitude;
    private Coisa coisa;
    private Date dataInclusao;

    public Rank(){}

    public Rank(String descricao, int nota){
        this.descricao = descricao;
        this.nota = nota;
    }

    public Rank(int id, String descricao, int nota){
        this.id = id;
        this.descricao = descricao;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
