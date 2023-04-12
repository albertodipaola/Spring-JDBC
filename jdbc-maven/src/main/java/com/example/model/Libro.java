package com.example.model;

public class Libro {
    private Long id;
    private String titolo;
    private int anno;
    private float prezzo;
    private Long autore_id;

    public Libro() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public Long getAutore_id() {
        return autore_id;
    }

    public void setAutore_id(Long autore_id) {
        this.autore_id = autore_id;
    }

}
