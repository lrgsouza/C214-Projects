package br.inatel.cdg;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuscaMateria {

    MateriaService MateriaService;

    public BuscaMateria(MateriaService MateriaService) {
        this.MateriaService = MateriaService;
    }

    public Materia busca(String nome) {
        String matJson = MateriaService.buscaMateria(nome);
        JsonObject Materia = JsonParser.parseString(matJson).getAsJsonObject();

        return new Materia(
            Materia.get("nome").getAsString(),
            Materia.get("tipo").getAsString(),
            Materia.get("salas").getAsJsonArray(),
            Materia.get("professor").getAsString(),
            Materia.get("horarios").getAsJsonArray());
    }

}
