package path;

import graphs.Grafo;
import graphs.Vertice;

import java.util.*;

public class BuscaProfundidadeImperativa {
    private Stack<Vertice> pilha;
    private Set<String> visitados;

    private Grafo grafo;

    public BuscaProfundidadeImperativa(Grafo grafo){
        this.pilha = new Stack<>();
        this.visitados = new HashSet<>();
        this.grafo = grafo;
    }

    public List<Vertice> buscar(String rotulo){
        List<Vertice> caminho = new ArrayList<>();

        var origem = grafo.getVertice(rotulo);
        pilha.push(origem);
        visitados.add(origem.getRotulo());

        while(!pilha.isEmpty()){
            var atual = pilha.pop();
            caminho.add(atual);

            for(var vizinho : grafo.getAdjacentes(atual.getRotulo())){
                if(!visitados.contains(vizinho.getRotulo())){
                    visitados.add(vizinho.getRotulo());
                    pilha.push(vizinho);
                }
            }
        }

        return caminho;
    }
}
