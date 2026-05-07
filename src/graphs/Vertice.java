package graphs;

import java.util.Objects;

public class Vertice {
    private String rotulo;
    private int grau;

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

    @Override
    public String toString() {
        return "Vertice{" +
                "rotulo='" + rotulo + '\'' +
                ", grau=" + grau +
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
