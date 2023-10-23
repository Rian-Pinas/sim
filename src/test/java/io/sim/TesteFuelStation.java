package io.sim;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import io.sim.Prova.FStation;

public class TesteFuelStation {
    public final FStation fstate = new FStation();

    @Test
    public void teste_abastecer(){   //Preço do combustível. (delta = 0 // precisão total.)
        assertEquals(5.87, fstate.getFuelPrice(), 0);
    }
}
