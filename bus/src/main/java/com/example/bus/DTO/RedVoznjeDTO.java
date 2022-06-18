package com.example.bus.DTO;

public class RedVoznjeDTO {

    private String cilj;
    private String distanca;
    private String start;
    private String ukupnaCena;
    private String vremeDolaska;
    private String vremePolaska;


    public String getCilj() {
        return cilj;
    }

    public void setCilj(String cilj) {
        this.cilj = cilj;
    }

    public String getDistanca() {
        return distanca;
    }

    public void setDistanca(String distanca) {
        this.distanca = distanca;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(String ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public String getVremeDolaska() {
        return vremeDolaska;
    }

    public void setVremeDolaska(String vremeDolaska) {
        this.vremeDolaska = vremeDolaska;
    }

    public String getVremePolaska() {
        return vremePolaska;
    }

    public void setVremePolaska(String vremePolaska) {
        this.vremePolaska = vremePolaska;
    }
}
