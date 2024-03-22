package br.inatel.cdg;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

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
        System.out.println(chris.predio);
        assertEquals("Chris Lima", chris.getNome());
    }


}
