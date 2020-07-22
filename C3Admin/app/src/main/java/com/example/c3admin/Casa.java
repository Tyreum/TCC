package com.example.c3admin;

public class Casa {
    private String nomecasa;
    private int imagemcasa;
    private String moedascasa;

    public Casa(String nomecasa) {
        this.nomecasa = nomecasa;
        this.moedascasa = moedascasa;
        this.imagemcasa = imagemcasa;
    }

    public Casa(String ponto_do_câmbio, String s, int pontodocambio) {
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
