package graphs;

import exception.QtdeMaximaException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
    private int qtdeMaximaVertices;
    private int qtdeAtualVertices;
    private List<Vertice> vertices;
    private MatrizAdjacencia matrizAdjacencia;
    private Map<String, Integer> rotuloEmIndice;

    public Grafo(int qtdeVertices){
        if(qtdeVertices <= 0){
            throw new IllegalArgumentException("Informe uma quantidade de vertices válida");
        }
        this.qtdeMaximaVertices = qtdeVertices;
        this.vertices = new ArrayList<>();
        this.rotuloEmIndice = new HashMap<>();
    }

    public void addVertice(String rotulo) throws Exception{
        if(qtdeAtualVertices > qtdeMaximaVertices-1){
            throw new QtdeMaximaException("Não é possível adicionar mais vertices");
        }
        var newVertice = new Vertice(rotulo);
        this.vertices.add(newVertice);
        this.rotuloEmIndice.put(rotulo, qtdeAtualVertices);
        qtdeAtualVertices++;
    }

    public void conectarVertices(String rotuloVerticeOrigem, String rotuloVerticeDestino){
        if(!isVerticeExiste(rotuloVerticeOrigem) || !isVerticeExiste(rotuloVerticeDestino)){
            throw new IllegalArgumentException("Informe um vertice válido");
        }
        var indiceOrigem = rotuloEmIndice.get(rotuloVerticeOrigem);
        var indiceDestino = rotuloEmIndice.get(rotuloVerticeDestino);
        criarMatriz();
        matrizAdjacencia.conectarVertices(indiceOrigem, indiceDestino);
    }

    public Vertice getVertice(String rotulo){
        if(!isVerticeExiste(rotulo)){
            throw new IllegalArgumentException("Informe um vertice válido");
        }
        return vertices.get(rotuloEmIndice.get(rotulo));
    }

    public List<Vertice> getAdjacentes(String rotuloVertice){
        if(!isVerticeExiste(rotuloVertice)){
            throw new IllegalArgumentException("Informe um vertice válido");
        }
        var indiceVertice = rotuloEmIndice.get(rotuloVertice);
        return matrizAdjacencia.getAdjacentes(indiceVertice);
    }

    private void criarMatriz(){
        if(matrizAdjacencia == null){
            matrizAdjacencia = new MatrizAdjacencia(vertices);
        }
    }

    private boolean isVerticeExiste(String rotuloVertice){
        return rotuloEmIndice.get(rotuloVertice) != null;
    }
}
