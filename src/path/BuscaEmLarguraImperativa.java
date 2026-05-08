package path;

import graphs.Grafo;
import graphs.Vertice;

import java.util.*;

public class BuscaEmLarguraImperativa {
    private Queue<Vertice> fila;
    private Set<Vertice> visitados;

    private Grafo grafo;

    public BuscaEmLarguraImperativa(Grafo grafo){
        this.grafo = grafo;
        this.fila = new LinkedList<>();
        this.visitados = new HashSet<>();
    }

    public List<Vertice> buscar(String rotulo){
        List<Vertice> caminho = new ArrayList<>();

        var origem = grafo.getVertice(rotulo);

        visitados.add(origem);
        fila.add(origem);

        while (!fila.isEmpty()){
            var atual = fila.poll();
            caminho.add(atual);

            for (var vizinho : grafo.getAdjacentes(atual.getRotulo())){
                if(!visitados.contains(vizinho)){
                    visitados.add(vizinho);
                    fila.add(vizinho);
                }
            }
        }

        return caminho;
    }
}
