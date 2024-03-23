package  br.inatel.cdg;

import java.util.List;

import com.google.gson.JsonArray;

import com.google.gson.JsonObject;

public class Materia {

    private String nome;
    private String tipo;
    private JsonArray salas;
    private String professor;
    private JsonArray horarios;

    public Materia(String nome, String tipo, JsonArray salas, String professor, JsonArray horarios) {
        this.nome = nome;
        this.tipo = tipo;
        this.salas = salas;
        this.professor = professor;
        this.horarios = horarios;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public JsonArray getSalas() {
        return salas;
    }

    public String getProfessor() {
        return professor;
    }

    public JsonArray getHorarios() {
        return horarios;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSalas(JsonArray salas) {
        this.salas = salas;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public void setHorarios(JsonArray horarios) {
        this.horarios = horarios;
    }
}