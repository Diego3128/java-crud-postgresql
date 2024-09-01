package com.restapi.diegoperez.restapi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// decorador para la creacion de la entidad alimento
@Entity
public class Alimento {
    // Decoradores desde Spring para generar un id (auto_increment)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // atributos basicos de la entidad alimento
    private long id;
    private String nombre ;
    private double calorias ;
    private double grasa;
    private double carbohidratos;
    private double proteina;
    // metodos get y set para interactuar con la entidad
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getCalorias() {
        return calorias;
    }
    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }
    public double getGrasa() {
        return grasa;
    }
    public void setGrasa(double grasa) {
        this.grasa = grasa;
    }
    public double getCarbohidratos() {
        return carbohidratos;
    }
    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }
    public double getProteina() {
        return proteina;
    }
    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

}
