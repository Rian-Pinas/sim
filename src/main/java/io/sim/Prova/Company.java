package io.sim.Prova;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.net.Proxy;

/* Classe que trata das ações da Mobility Company */

public class Company extends Service {
    private ArrayList<Route> rotaDisp = new ArrayList<Route>();      //Rotas Disponíveis
	private Conta conta = new Conta("Mobility", "mobilidade", 999999);
    private Client clientBank;
	private String caminho;

    public Company (String caminho, int port){    //Construtor da Company
        super(port);
		this.caminho = caminho;
		this.leRotas(caminho);
    }

	@Override
	public Server CreateServerThread(Socket conn){
		return new CompanyServer(conn);
	}

	@Override
	public void run(){
		leRotas(caminho);
		clientBank = new Client("127.0.0.1", 6000);
		super.run();
	}

    private void leRotas(String caminho){
        try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //Funções para
			DocumentBuilder builder = factory.newDocumentBuilder();                //Ler o documento
			Document doc = builder.parse(caminho);                                 //.xml
			NodeList nList = doc.getElementsByTagName("vehicle");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);                                        //Para cada elemento ele pega o tipo de Node
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) nNode;                                //"elem" nesse caso faz referência aos Vehicles
					Node node = elem.getElementsByTagName("route").item(0);
					Element edges = (Element) node;
                    String auxEdge = edges.getAttribute("edges");             //Obtém as edges,
                    String idVehic = elem.getAttribute("id");                 //Obtém as ids e
                    rotaDisp.add(new Route(idVehic, auxEdge));                     //Gera as rotas
                    System.out.println(idVehic + " " + auxEdge);                   //Para finalmente adicionar nas rotas disponiveis
				}
			}

			Thread.sleep(100);

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

	public Conta getConta(){
		return this.conta;
	}

	/*public ArrayList<double> getLatLong(){
		String[] rotas;
		for(int i=0;i<rotaDisp.size();i++){
			rotas = rotaDisp.get(i).getEdge().split(" ");
		}
		rotas

		return 		
	}*/

    //Método para execução da Thread

	public ArrayList<Route> getRotaDisp(){
		return this.rotaDisp;
	}

	public class CompanyServer extends Server {
        public CompanyServer(Socket conn) {
            super(conn);
        }

        @Override
        protected void ProcessMessage(String message) {
            System.out.println("[company] received: " + message);
        }
    }

}
