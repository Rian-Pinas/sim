package io.sim.Prova;

/**
 * Classe na qual as rotas são separadas em um ArrayList para ser utilizada pela Company
 *
 */
public class Route {
    private String id;
    private String edge;
    private String[] edgeList;

    public Route(String ident, String routes){
        this.id = ident;
        this.edge = routes;
        edgeList = null;
    }

    public String getId(){
        return id;
    }

    public String getEdge(){
        return edge;
    }

    public Boolean isEnded(String _edge) {
        if (edgeList == null)
            edgeList = this.edge.split(" ");

        return edgeList[edgeList.length - 1].equals(_edge);

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Route other = (Route) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }

        if ((this.edge == null) ? (other.edge != null) : !this.edge.equals(other.edge)) {
            return false;
        }

        return true;
    }


}
