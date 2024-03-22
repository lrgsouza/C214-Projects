package br.inatel.cdg;

import com.google.gson.JsonArray;

public class Professor {
    public String nome;
    public String horario;
    public String periodo;
    public Integer sala;
    public JsonArray predio;

    public Professor(String nome, String horario, String periodo, Integer sala, JsonArray predio) {
        this.nome = nome;
        this.horario = horario;
        this.periodo = periodo;
        this.sala = sala;
        this.predio = predio;
    }

    public String getNome() {
        return nome;
    }

    public String getHorario() {
        return horario;
    }

    public String getPeriodo() {
        return periodo;
    }

    public Integer getSala() {
        return sala;
    }

    public JsonArray getPredio() {
        return predio;
    }
}