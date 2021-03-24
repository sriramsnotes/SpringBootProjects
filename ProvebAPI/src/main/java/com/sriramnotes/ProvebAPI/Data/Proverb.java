package com.sriramnotes.ProvebAPI.Data;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Proverb {
    private @Id @GeneratedValue Long id;
    private String proverbString;
    private String author;

    Proverb() {}

    public Proverb(String proverbString, String author) {

        this.proverbString = proverbString;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProverbString() {
        return proverbString;
    }

    public void setProverbString(String proverbString) {
        this.proverbString = proverbString;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Proverb))
            return false;
        Proverb proverb = (Proverb) obj;
        return Objects.equals(this.id, proverb.id) && Objects.equals(this.proverbString, proverb.proverbString)
                && Objects.equals(this.author, proverb.author);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.proverbString, this.author);
    }
}
