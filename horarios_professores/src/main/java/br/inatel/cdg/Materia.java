package  br.inatel.cdg;

import java.util.List;

public class Materia {

    private String nome;
    private String tipo;
    private List<Integer> salas;
    private List<Professor> professores;
    private List<String> horarios;

    public Materia(String nome, String tipo, List<Integer> salas, List<Professor> professores, List<String> horarios) {
        this.nome = nome;
        this.tipo = tipo;
        this.salas = salas;
        this.professores = professores;
        this.horarios = horarios;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public List<Integer> getSalas() {
        return salas;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<String> getHorarios() {
        return horarios;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSalas(List<Integer> salas) {
        this.salas = salas;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public void setHorarios(List<String> horarios) {
        this.horarios = horarios;
    }
}