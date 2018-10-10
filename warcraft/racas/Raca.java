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
    private boolean extinta = false;
    private int capacidadeMax;

    //Arrays de Construção
    private ArrayList<Casa> casas = new ArrayList<>();
    private ArrayList<CentroDaCidade> centros = new ArrayList<>();
    private ArrayList<Quartel> quarteis = new ArrayList<>();
    private ArrayList<Templo> templos = new ArrayList<>();
    private ArrayList<Torre> torres = new ArrayList<>();

    //Arrays de Unidades
    private ArrayList<AndarilhoEspiritual> andarilhos = new ArrayList<>();
    private ArrayList<Arqueiro> arqueiros = new ArrayList<>();
    private ArrayList<Campones> camponeses = new ArrayList<>();
    private ArrayList<Cavaleiro> cavaleiros = new ArrayList<>();
    private ArrayList<Grifo> grifos = new ArrayList<>();
    private ArrayList<Guerreiro> guerreiros = new ArrayList<>();
    private ArrayList<Sacerdote> sacerdotes = new ArrayList<>();

    public CentroDaCidade getCentro(int numero) {
        return centros.get(numero - 1);
    }
    public void addCentro(CentroDaCidade centro) {
        this.centros.add(centro);
    }

    public Campones getCampones(int numero) {
        return camponeses.get(numero - 1);
    }
    public void addCampones(Campones campones) {
        this.camponeses.add(campones);
    }

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

    public Raca(int comida, int ouro, int madeira, int mana) {
        this.comida = comida;
        this.ouro = ouro;
        this.madeira = madeira;
        this.mana = mana;
    }
}
