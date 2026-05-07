package graphs;


import java.util.ArrayList;
import java.util.List;

public class MatrizAdjacencia {
    private int[][] matriz;
    private int qtdeVertices;
    private List<Vertice> vertices;

    public MatrizAdjacencia(List<Vertice> vertices){
        this.vertices = vertices;
        this.qtdeVertices = vertices.size();
        this.matriz = new int[qtdeVertices][qtdeVertices];
    }

    public void conectarVertices(int indiceVerticeOrigem, int indiceVerticeDestino){
        var verticeOrigem = vertices.get(indiceVerticeOrigem);
        var verticeDestino = vertices.get(indiceVerticeDestino);
        if(indiceVerticeOrigem == indiceVerticeDestino){
            matriz[indiceVerticeOrigem][indiceVerticeDestino] += 1;
            verticeOrigem.addGrau(2);
        }else{
            matriz[indiceVerticeOrigem][indiceVerticeDestino]+=1;
            verticeOrigem.addGrau(1);
            matriz[indiceVerticeDestino][indiceVerticeOrigem]+=1;
            verticeDestino.addGrau(1);
        }
    }

    public List<Vertice> getAdjacentes(int indiceVertice){
        List<Vertice> adjacentes = new ArrayList<>();
        int linha = indiceVertice;
        for(int j = 0; j < qtdeVertices; j++){
            if(matriz[linha][j] != 0){
                var tempVertice = vertices.get(j);
                adjacentes.add(tempVertice);
            }
        }
        return adjacentes;
    }

    public void imprimir(){
        for(int i = 0; i < qtdeVertices; i++){
            for(int j = 0; j < qtdeVertices; j++){
                IO.print(matriz[i][j] + "\t");
            }
            IO.println();
        }
    }
}
