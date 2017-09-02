package pooa20171.iff.br.churrascada.controller;

/**
 * Created by filipefds on 22/07/17.
 */

public class Lista {

    private String titulo;
    private String subTitulo;
    private String preco;
    private int imagem;

    public Lista(String titulo, String subTitulo, String preco, int imagem) {
        this.titulo = titulo;
        this.subTitulo = subTitulo;
        this.preco = preco;
        this.imagem = imagem;
    }

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getSubTitulo() {return subTitulo;}
    public void setSubTitulo(String subTitulo) {this.subTitulo = subTitulo;}
    public int getImagem() {return imagem;}
    public void setImagem(int imagem) {this.imagem = imagem;}
    public String getPreco() {return preco;}
    public void setPreco(String preco) {this.preco = preco;}

}
