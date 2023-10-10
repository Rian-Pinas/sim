package io.sim.Prova;

/**
 * Classe na qual as rotas são separadas em um ArrayList para ser utilizada pela Company
 *
 */
public class Route {
    private String id;
    private String edge;

    public Route(String ident, String routes){
        this.id = ident;
        this.edge = routes;
    }

    

    public String getId(){
        return id;
    }

    public String getEdge(){
        return edge;
    }


}
