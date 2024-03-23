package br.inatel.cdg;

import com.google.gson.JsonArray;

public class Professor {
    private String nome;
    private String horario;
    private String periodo;
    private Integer sala;
    private JsonArray predio;

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