package com.comtrade.Comtrade.Model;


import javax.persistence.*;

@Entity
@Table(name = "LANGUAGE_MODEL")
public class LangModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "country")
    String country;
    @Column (name = "word")
    String word;


    public LangModel(int id, String country, String word) {
        this.id = id;
        this.country = country;
        this.word = word;
    }

    public LangModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
