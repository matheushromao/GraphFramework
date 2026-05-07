package path;

import graphs.Grafo;
import graphs.Vertice;

import java.util.*;

public class BuscaEmProfundidadeRecursiva {
    private Set<String> visitados;
    private Grafo grafo;

    private List<Vertice> caminho;

    public BuscaEmProfundidadeRecursiva(Grafo grafo) {
        this.grafo = grafo;
        this.caminho = new ArrayList<>();
        this.visitados = new HashSet<>();
    }

    public void buscar(String rotulo){
        if(visitados.isEmpty()){
            visitados.add(rotulo);
        }

        caminho.add(grafo.getVertice(rotulo));

        for (var vizinho: grafo.getAdjacentes(rotulo)){
            if(!visitados.contains(vizinho.getRotulo())){
                visitados.add(vizinho.getRotulo());
                buscar(vizinho.getRotulo());
            }
        }
    }

    public List<Vertice> getCaminho(){
        return Collections.unmodifiableList(caminho);
    }
}
