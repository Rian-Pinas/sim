package io.sim.Prova;

import java.net.Socket;

/* Classe de Alpha Bank */
//Company, Driver e Fuel Station São clientes
//Company paga os drivers por quilometro rodado
//Driver paga a Fuel Station para abastecer

public class ABank extends Service{
    

    public ABank(int port){ //Construtor do Alpha Bank
        super(port);
    }

    @Override
    public Server CreateServerThread(Socket conn){
        return new BankServer(conn);
    }

    public class BankServer extends Server {
        public BankServer(Socket conn) {
            super(conn);
        }

        @Override
        protected void ProcessMessage(String message) {
            System.out.println("[bank] received: " + message);
        }
    }
}
