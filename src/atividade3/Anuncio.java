package atividade3;

public class Anuncio {
    int id;
    String empresa;
    String descricao;

    Anuncio proximo;

    Anuncio(int id, String empresa, String descricao) {
        this.id = id;
        this.empresa = empresa;
        this.descricao = descricao;
        this.proximo = null;
    }

}   