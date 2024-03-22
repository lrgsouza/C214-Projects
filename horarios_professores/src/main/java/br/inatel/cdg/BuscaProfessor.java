package br.inatel.cdg;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuscaProfessor {

    ProfessorService ProfessorService;

    public BuscaProfessor(ProfessorService ProfessorService) {
        this.ProfessorService = ProfessorService;
    }

    public Professor busca(String nome){
        String profJson = ProfessorService.buscaProfessor(nome);
        JsonObject Professor = JsonParser.parseString(profJson).getAsJsonObject();

        return new Professor(
                Professor.get("nomeDoProfessor").getAsString(),
                Professor.get("horarioDeAtendimento").getAsString(),
                Professor.get("periodo").getAsString(),
                Professor.get("sala").getAsInt(),
                Professor.get("predio").getAsJsonArray());
    }
    
    

}
