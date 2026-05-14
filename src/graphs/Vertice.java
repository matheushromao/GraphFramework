package graphs;

import java.util.Objects;

public class Vertice {
    private String rotulo;
    private int grau;
    private int grauEntrada;
    private int grauSaida;

    public Vertice(String rotulo){
        this.rotulo = rotulo;
    }

    public String getRotulo() {
        return rotulo;
    }

    public int getGrau() {
        return grau;
    }

    public void addGrau(int value){
        this.grau += value;
    }

    void addGrauEntrada(int value){
        this.grauEntrada += value;
    }

    void addGrauSaida(int value){
        this.grauSaida += value;
    }

    public int getGrauSaida(){
        return grauSaida;
    }
    public int getGrauEntrada(){
        return grauEntrada;
    }


    @Override
    public String toString() {
        return "Vertice{" +
                "rotulo='" + rotulo + '\'' +
                ", grau=" + grau +
                ", grauEntrada=" + grauEntrada +
                ", grauSaida=" + grauSaida +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return grau == vertice.grau && Objects.equals(rotulo, vertice.rotulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rotulo, grau);
    }
}
