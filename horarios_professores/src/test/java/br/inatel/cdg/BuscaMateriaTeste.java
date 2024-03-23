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

    @Before
    public void setup(){
        this.buscaMateria = new BuscaMateria(service);
    }

    @Test
    public void testeBuscarMateria(){
        Mockito.when(service.buscaMateria("c111")).thenReturn(MateriaApiResult.C111);
        Materia c111 = buscaMateria.busca("c111");

        System.out.println(c111.getNome());

        assertEquals("Analise de dados", c111.getNome());
    }



}