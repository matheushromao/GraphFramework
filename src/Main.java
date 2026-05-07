import graphs.Grafo;
import graphs.MatrizAdjacencia;
import graphs.Vertice;
import path.BuscaProfundidadeImperativa;

void main() {

//    List<Vertice> vertices = new ArrayList<>(
//            Arrays.asList(new Vertice("V0"),
//                    new Vertice("V1"),
//                    new Vertice("V2"),
//                    new Vertice("V3"),
//                    new Vertice("V4"))
//    );
//
//    MatrizAdjacencia matrizAdjacencia = new MatrizAdjacencia(vertices);
//    matrizAdjacencia.conectarVertices(0,4);
//    matrizAdjacencia.conectarVertices(0,3);
//    matrizAdjacencia.conectarVertices(1,3);
//    matrizAdjacencia.conectarVertices(1,4);
//    matrizAdjacencia.conectarVertices(2,2);
//    matrizAdjacencia.conectarVertices(2,3);
//    matrizAdjacencia.conectarVertices(2,3);
//    matrizAdjacencia.conectarVertices(3,4);
//
//    IO.println(vertices.get(1));
//    IO.println(matrizAdjacencia.getAdjacentes(2));
//    matrizAdjacencia.imprimir();

    try {
        Grafo grafo = new Grafo(6);
        grafo.addVertice("V1");
        grafo.addVertice("V2");
        grafo.addVertice("V3");
        grafo.addVertice("V4");
        grafo.addVertice("V5");
        grafo.addVertice("V6");

        grafo.conectarVertices("V1", "V2");
        grafo.conectarVertices("V1", "V5");
        grafo.conectarVertices("V2", "V3");
        grafo.conectarVertices("V2", "V5");
        grafo.conectarVertices("V3", "V4");
        grafo.conectarVertices("V4", "V5");
        grafo.conectarVertices("V4", "V6");


        var buscaProfundidade = new BuscaProfundidadeImperativa(grafo);
        IO.println(buscaProfundidade.buscar("V3"));
    }catch (Exception e){
        IO.println(e.getMessage());
    }

}