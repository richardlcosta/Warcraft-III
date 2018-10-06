package warcraft.racas;

import warcraft.objetos.construcoes.*;
import warcraft.objetos.unidades.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Raca {
    private int comida;
    private int ouro;
    private int madeira;
    private int mana;
    private int capacidadeMax;

    List<Construcao> construcoes = new ArrayList<>();
    List<Unidade> unidades = new ArrayList<>();

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

    public List<Construcao> getConstrucoes() {
        return construcoes;
    }
    public List<Unidade> getUnidades() {
        return unidades;
    }

    public void adicionarUnidade(Unidade unidade){
        unidades.add(unidade);
    }
    public void adicionarConstrucao(Construcao construcao){
        construcoes.add(construcao);
    }

    public Raca(int comida, int ouro, int madeira, int mana) {
        this.comida = comida;
        this.ouro = ouro;
        this.madeira = madeira;
        this.mana = mana;
    }
}
