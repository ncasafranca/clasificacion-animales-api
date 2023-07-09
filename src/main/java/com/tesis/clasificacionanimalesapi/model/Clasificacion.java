package com.tesis.clasificacionanimalesapi.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import org.springframework.data.annotation.Id;

@Container(containerName = "Clasificacion")
public class Clasificacion {
    @Id
    @GeneratedValue
    private String id;

    private String animal;

    private String raza;

    private String prediction;

    public Clasificacion() { }

    public Clasificacion(String animal, String raza, String prediction) {
        this.animal = animal;
        this.raza = raza;
        this.prediction = prediction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }
}
