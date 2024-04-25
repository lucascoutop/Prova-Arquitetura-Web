package com.example.RestAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prova")
public class UserEntity {
    
    @Id
    private String id;
    
    private String tipo;

    public UserEntity(String id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public UserEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
