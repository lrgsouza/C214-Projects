package br.inatel.cdg;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




@RunWith(MockitoJUnitRunner.class)
public class BuscaMateriaTeste {

    @Mock
    MateriaService service;
    BuscaMateria buscaMateria;
    ProfessorService professor;
    BuscaProfessor buscaProfessor;

    @Before
    public void setup() {
        this.buscaMateria = new BuscaMateria(service);
    }

    @Test
    public void testeBuscarMateria() {
        Mockito.when(service.buscaMateria("c111")).thenReturn(MateriaApiResult.C111);
        Materia c111 = buscaMateria.busca("c111");
        System.out.println(c111.getNome());
        assertEquals("Analise de dados", c111.getNome());
    }

    @Test
    public void testeBuscarUmHorario() {
        Mockito.when(service.buscaMateria("c111")).thenReturn(MateriaApiResult.C111);
        Materia c111 = buscaMateria.busca("c111");
        System.out.println(c111.getHorarios());
        assertEquals("19:30", c111.getHorarios().get(0).getAsString());
    }

    @Test
    public void testeBuscarTipo() {
        Mockito.when(service.buscaMateria("c214")).thenReturn(MateriaApiResult.C214);
        Materia c214 = buscaMateria.busca("c214");
        System.out.println(c214.getTipo());
        assertEquals("Lab", c214.getTipo());
    }

    @Test
    public void testeBuscarSala(){
        Map<String, List<Integer>> predio_sala = new HashMap<>();
        predio_sala.put("1", Arrays.asList(1, 2, 3, 4, 5));
        predio_sala.put("2", Arrays.asList(6, 7, 8, 9, 10));
        predio_sala.put("3", Arrays.asList(11, 12, 13, 14, 15));
        predio_sala.put("4", Arrays.asList(16, 17, 18, 19, 20));
        predio_sala.put("5", Arrays.asList(21, 22, 23, 24, 25));
        predio_sala.put("6", Arrays.asList(26, 27, 28, 29, 30));
       
        Mockito.when(service.buscaMateria("c111")).thenReturn(MateriaApiResult.C111);
        Materia C111 = buscaMateria.busca("c111");

        Integer sala = C111.getSalas().get(0).getAsInt();

        assertTrue(predio_sala.get("1").contains(sala));
    }
    // @Test
    // public void testeProfessorMateria() {
    //     Mockito.when(service.buscaMateria("c214")).thenReturn(MateriaApiResult.C214);
    //     Materia c214 = buscaMateria.busca("c214");
    //     Mockito.when(professor.buscaProfessor("Chris Lima")).thenReturn(ProfessorApiResult.CHRIS);
        
    //     Professor chris = buscaProfessor.busca("Chris Lima");
    //     List<String> salas = new ArrayList<>();

    //     for (JsonElement sala : c214.getSalas()) {
    //         salas.add(sala.getAsString());
    //     }

    //     assertTrue(salas.contains(String.valueOf(chris.getSala())));
    // }
    @Test(expected = NullPointerException.class)
    public void testeMateriaInexistente() {
        Mockito.when(service.buscaMateria("c300")).thenReturn(null);
        Materia c300 = buscaMateria.busca("c300");
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testeMateriaSemSala() {
        Mockito.when(service.buscaMateria("s204")).thenReturn(MateriaApiResult.S204);
        Materia s204 = buscaMateria.busca("s204");
        String sala = s204.getSalas().get(0).getAsString();
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testeMateriaSemHorario() {
        Mockito.when(service.buscaMateria("s204")).thenReturn(MateriaApiResult.S204);
        Materia s204 = buscaMateria.busca("s204");
        String horario = s204.getHorarios().get(0).getAsString();
    }
    @Test
    public void testeMateriaSemProfessor() {
        Mockito.when(service.buscaMateria("s204")).thenReturn(MateriaApiResult.S204);
        Materia s204 = buscaMateria.busca("s204");
        String professor = s204.getProfessor();
        assertEquals("", professor);
    }
    @Test
    public void testeMateriaQtdSalas() {
        Mockito.when(service.buscaMateria("c214")).thenReturn(MateriaApiResult.C214);
        Materia c214 = buscaMateria.busca("c214");
    
        assertEquals(3, c214.getSalas().size());
    }

}
