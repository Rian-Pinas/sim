package io.sim;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import io.sim.Prova.Company;

public class TesteCompany{
    public final Company comp = new Company("data/dados.xml",5000);

    @Test
    public void teste_lerotas(){    //Confere se tem a quantidade de 643 rotas
        assertEquals(643, comp.getRotaDisp().size());
    }
}
