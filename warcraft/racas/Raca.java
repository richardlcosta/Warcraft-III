package warcraft.racas;

import warcraft.objetos.construcoes.*;
import warcraft.objetos.unidades.*;
import warcraft.util.*;

import java.util.ArrayList;

public abstract class Raca {
    private Recurso recursos;
    private boolean extinta = false;
    private int capacidadeMax;

    private ArrayList<Unidade> unidades = new ArrayList<>();
    private ArrayList<Construcao> construcoes = new ArrayList<>();

    public Unidade getUnidades(int index) {
        return unidades.get(index);
    }

    public Construcao getConstrucoes(int index) {
        return construcoes.get(index);
    }

    public void addUnidade(Unidade unidade) {
        unidades.add(unidade);
    }

    public void addConstrucao(Construcao construcao) {
        construcoes.add(construcao);
    }

    public void addComida() {
        this.recursos.addRecursos(1,0,0,0);
    }
    public void addOuro() {
        this.recursos.addRecursos(0,1,0,0);
    }
    public void addMadeira() {
        this.recursos.addRecursos(0,0,1,0);
    }
    public void addMana(int quant) {
        this.recursos.addRecursos(0,0,0, quant);
    }

    public Recurso getRecursos() {
        return recursos;
    }

    public void consumirMana(int quant){
        this.recursos.consumirRecursos(new Recurso(0,0,0, quant));
    }

    public void verRecursos(){
        System.out.printf("Comida:%d Ouro:%d Madeira:%d Mana:%d\n",recursos.getComida(), recursos.getOuro(), recursos.getMadeira(), recursos.getMana());
    }

    public boolean calculaPopulacaoMaxima(){
        capacidadeMax = 0;
        for(Construcao construcao : construcoes){
            if(construcao.getEstado()) {
                if (construcao instanceof Casa) {
                    capacidadeMax += 2;
                } else if (construcao instanceof CentroDaCidade) {
                    capacidadeMax += 10;
                }
            }
        }
        return unidades.size() < capacidadeMax;
    }

    public Raca(Recurso recursos) {
        this.recursos = recursos;
        construcoes.add(new CentroDaCidade("0 0", this));
        unidades.add(new Campones("0 0", this));
        unidades.add(new Campones("0 0", this));
    }
}
