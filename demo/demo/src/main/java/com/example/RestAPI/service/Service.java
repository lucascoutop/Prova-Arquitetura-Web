package com.example.RestAPI.service;

import com.example.RestAPI.model.UserEntity;
import com.example.RestAPI.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Service
public class Service {

    private final Repository repository;

    @Autowired
    public Service(Repository repository) {this.repository = repository;}

    private String consultarURL(String apiUrl){
        String dados = "";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){
            dados = responseEntity.getBody();
        }else{
            dados = "Falha ao obter dados, código de status:" + responseEntity.getStatusCode();
        }
        return dados;
    }

    public String consultarTudo() {
        return consultarURL("https://servicodados.ibge.gov.br/api/v3/noticias");
    }

    public String consultarNoticia() {
        return consultarURL("https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=noticia");
    }

    public String consultarRelease() {
        return consultarURL("https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=release");
    }

    public void salvarSimples(){
        UserEntity entity = new UserEntity();
        entity.setTipo(consultarTudo());
        repository.save(entity);
    }

    public String salvarNoticia() {
        String noticia = "";
        //noticias
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            noticia = responseEntity.getBody();
        } else {
            noticia = "Falha ao obter dados das noticias. Código de status: " + responseEntity.getStatusCode();
        }
        return noticia;
    }

    public String salvarRelease() {
        String release = "";
        String apiUrlR = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=release";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrlR, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            release = responseEntity.getBody();
        } else {
            release = "Falha ao obter dados das noticias e releases. Código de status: " + responseEntity.getStatusCode();
        }
        return release;
    }

}
