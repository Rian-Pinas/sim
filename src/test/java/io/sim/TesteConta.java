package io.sim;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import io.sim.Prova.Conta;

public class TesteConta {
    public final Conta conta = new Conta("teste", "1234", 500);

    @Test
    public void teste_saldo(){
        assertEquals(500, conta.getSaldo(), 0);
    }
}
