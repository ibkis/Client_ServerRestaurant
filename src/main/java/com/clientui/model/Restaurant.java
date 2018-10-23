package com.clientui.model;


import javax.persistence.*;

@Entity
@Table(name = "Restaurant")
public class Restaurant {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "Nom")
    private String Nom;
    @Column(name = "description")
    private String description;
    @Column(name = "moyen")
    private Double moyen;
    @Column(name = "qnouriture")
    private Double qnouriture;
    @Column(name = "qsalle")
    private Double qsalle;
    @Column(name = "qservice")
    private Double qservice;
    @Column(name = "imag")
    private String imag;
    public Restaurant() {
    }

    public Restaurant(int id, String nom, String description, Double moyen, Double qnouriture, Double qsalle, Double qservice, String imag) {
        this.id = id;
        Nom = nom;
        this.description = description;

        this.qnouriture = qnouriture;
        this.qsalle = qsalle;
        this.qservice = qservice;
        this.imag = imag;
    //    calculMoyen(qnouriture*2,qsalle*2,qservice*2);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMoyen() {
        return moyen;
    }
    public void calculMoyen(Double n, Double s, Double sv){
        qnouriture=(qnouriture+n)/2;
        qsalle=(qsalle+s)/2;
        qservice=(qservice+sv)/2;
       int mo=(int)(((qnouriture+qservice+qsalle)/3)*100);
       moyen=(double)(mo/100);
    }
    public void setMoyen(Double moyen) {
        this.moyen = moyen;
    }

    public Double getQnouriture() {
        return qnouriture;
    }

    public void setQnouriture(Double qnouriture) {
        this.qnouriture = qnouriture;
    }

    public Double getQsalle() {
        return qsalle;
    }

    public void setQsalle(Double qsalle) {
        this.qsalle = qsalle;
    }

    public Double getQservice() {
        return qservice;
    }

    public void setQservice(Double qservice) {
        this.qservice = qservice;
    }

    public String getImag() {
        return imag;
    }

    public void setImag(String imag) {
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", Nom='" + Nom + '\'' +
                ", description='" + description + '\'' +
                ", moeyen='" + moyen + '\'' +
                ", Qualité de nouriture=" + qnouriture +
                ", Qualité de salle=" + qsalle +
                ", Qualité de service=" + qservice +
                ", image=" + imag +
                '}';
    }


}
