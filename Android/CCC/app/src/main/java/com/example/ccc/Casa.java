package com.example.ccc;

public class Casa {
    private String nomecasa;
    private int imagemcasa;
    private String moedascasa;

    public Casa(String nomecasa, String moedascasa, int imagemcasa) {
        this.nomecasa = nomecasa;
        this.moedascasa = moedascasa;
        this.imagemcasa = imagemcasa;
    }

    public String getNomecasa() {
        return nomecasa;
    }

    public void setNomecasa(String nomecasa) {
        this.nomecasa = nomecasa;
    }

    public int getImagemcasa() {
        return imagemcasa;
    }

    public void setImagemcasa(int imagemcasa) {
        this.imagemcasa = imagemcasa;
    }

    public String getMoedascasa() {
        return moedascasa;
    }

    public void setMoedascasa(String moedascasa) {
        this.moedascasa = moedascasa;
    }
}
