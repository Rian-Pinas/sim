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

public class Company extends Thread {
    private static ArrayList<Route> rotaDisp = new ArrayList<Route>();      //Rotas Disponíveis
    private static ArrayList<Route> rotaExe = new ArrayList<Route>();       //Rotas em Execução
    private static ArrayList<Route> rotaFim = new ArrayList<Route>();       //Rotas Finalizadas
	private static BotPayment bot;
	private static Conta conta;
    
    public Company (String caminho){    //Construtor da Company
        leRotas(caminho);
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

    //Método para execução da Thread
    public void run(){

    }


}
