package io.sim;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import io.sim.Prova.Company;

public class TesteCompany{
    public final Company comp = new Company("data/dados.xml");

    @Test
    public void teste_lerotas(){    //Confere se tem a quantidade de 900 rotas
        assertEquals(900, comp.getRotaDisp().size());
    }
}
