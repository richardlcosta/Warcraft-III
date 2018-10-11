package warcraft.racas;

import warcraft.objetos.construcoes.*;
import warcraft.objetos.unidades.*;

import java.util.ArrayList;

public abstract class Raca {
    private int comida;
    private int ouro;
    private int madeira;
    private int mana;
    private boolean extinta = false;
    private int capacidadeMax;

    private ArrayList<Unidade> unidades = new ArrayList<>();
    private ArrayList<Construcao> construcoes = new ArrayList<>();

    public void setComida(int comida) {
        this.comida = comida;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public void setMadeira(int madeira) {
        this.madeira = madeira;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

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

    public Raca(int comida, int ouro, int madeira, int mana) {
        this.comida = comida;
        this.ouro = ouro;
        this.madeira = madeira;
        this.mana = mana;
        construcoes.add(new CentroDaCidade("0 0", this));
        unidades.add(new Campones("0 0", this));
        unidades.add(new Campones("0 0", this));
    }
}
