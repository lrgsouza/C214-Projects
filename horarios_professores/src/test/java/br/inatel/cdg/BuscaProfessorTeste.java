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
public class BuscaProfessorTeste {

    @Mock
    ProfessorService service;
    BuscaProfessor buscaProfessor;

    @Before
    public void setup(){
        this.buscaProfessor = new BuscaProfessor(service);
    }

    @Test
    public void testeBuscarProfessor(){
        Mockito.when(service.buscaProfessor("chris")).thenReturn(ProfessorApiResult.CHRIS);
        Professor chris = buscaProfessor.busca("chris");
        System.out.println(chris.getPredio());
        assertEquals("Chris Lima", chris.getNome());
    }

    @Test
    public void testeBuscarHorarioProfessor(){
        Mockito.when(service.buscaProfessor("chris")).thenReturn(ProfessorApiResult.CHRIS);
        Professor chris = buscaProfessor.busca("chris");
        assertEquals("15:30", chris.getHorario());
    }

    @Test
    public void testBuscarPredioSala(){
        Map<String, List<Integer>> predio_sala = new HashMap<>();
        predio_sala.put("1", Arrays.asList(1, 2, 3, 4, 5));
        predio_sala.put("2", Arrays.asList(6, 7, 8, 9, 10));
        predio_sala.put("3", Arrays.asList(11, 12, 13, 14, 15));
        predio_sala.put("4", Arrays.asList(16, 17, 18, 19, 20));
        predio_sala.put("5", Arrays.asList(21, 22, 23, 24, 25));
        predio_sala.put("6", Arrays.asList(26, 27, 28, 29, 30));

        Mockito.when(service.buscaProfessor("chris")).thenReturn(ProfessorApiResult.CHRIS);
        Professor chris = buscaProfessor.busca("chris");

        String predio = chris.getPredio().get(0).getAsString();

        assertTrue(predio_sala.get(predio).contains(chris.getSala()));
    }

   @Test
    public void testeBuscarPeriodo(){
        Mockito.when(service.buscaProfessor("chris")).thenReturn(ProfessorApiResult.CHRIS);
        Professor chris = buscaProfessor.busca("chris");
        assertEquals("Integral", chris.getPeriodo());
    }

    @Test(expected = NullPointerException.class)
    public void testeBuscarProfessorInexistente(){
        Mockito.when(service.buscaProfessor("john")).thenReturn(null);
        Professor john = buscaProfessor.busca("john");
    }

    @Test
    public void testeBuscarHorarioProfessorInexistente(){
        Mockito.when(service.buscaProfessor("renzo")).thenReturn(ProfessorApiResult.RENZO);
        Professor renzo = buscaProfessor.busca("renzo");
        assertEquals("", renzo.getHorario());
    }

    @Test
    public void testBuscaQtdaPredioProfessor(){
        Mockito.when(service.buscaProfessor("renzo")).thenReturn(ProfessorApiResult.RENZO);
        Professor renzo = buscaProfessor.busca("renzo");
        assertEquals(1, renzo.getPredio().size());
    }

    @Test(expected = NullPointerException.class)
    public void testeBuscarPeriodoProfessorInexistente(){
        Mockito.when(service.buscaProfessor("john")).thenReturn(null);
        Professor john = buscaProfessor.busca("john");
        assertEquals(null, john.getPeriodo());
    }

    @Test(expected = NullPointerException.class)
    public void testeBuscarProfessorComNomeNulo() {
        buscaProfessor.busca(null);
    }
}
