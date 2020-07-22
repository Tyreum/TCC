package com.example.ccc;

public class Casa {
    private String nomecasa;
    private int imagemcasa;
    private String moedascasa;
    private String enderecocasa;
    private String contatocasa;

    public Casa(String nomecasa, String moedascasa, int imagemcasa, String contatocasa, String enderecocasa) {
        this.nomecasa = nomecasa;
        this.moedascasa = moedascasa;
        this.imagemcasa = imagemcasa;
        this.contatocasa = contatocasa;
        this.enderecocasa = enderecocasa;
    }

    //Nome da casa
    public String getNomecasa() {
        return nomecasa;
    }
    public void setNomecasa(String nomecasa) {
        this.nomecasa = nomecasa;
    }

    //Imagem da casa
    public int getImagemcasa() { return imagemcasa; }
    public void setImagemcasa(int imagemcasa) {
        this.imagemcasa = imagemcasa;
    }

    //Moeda da casa
    public String getMoedascasa() {
        return moedascasa;
    }
    public void setMoedascasa(String moedascasa) {
        this.moedascasa = moedascasa;
    }

    //Contato da casa
    public String getEnderecocasa() {
        return enderecocasa;
    }
    public void setEnderecocasa(String enderecocasa) {
        this.enderecocasa = enderecocasa;
    }

    //Endereço da casa
    public String getContatocasa() {
        return contatocasa;
    }
    public void setContatocasa(String contatocasa) {
        this.contatocasa = contatocasa;
    }
}
