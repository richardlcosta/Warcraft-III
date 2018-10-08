package warcraft.objetos.unidades;

import warcraft.objetos.construcoes.*;
import warcraft.util.*;

public class Campones extends Unidade{

    public Casa construirCasa(String posicao) {
        return new Casa(posicao);
    }
    public CentroDaCidade construirCentro(String posicao) {
        return new CentroDaCidade(posicao);
    }
    public Templo construirTempo(String posicao) {
        return new Templo(posicao);
    }
    public Quartel construirQuartel(String posicao) {
        return new Quartel(posicao);
    }
    public Torre construirTorre(String posicao) {
        return new Torre(posicao);
    }

    public Campones(String posicao) {
        super(new Posicao(posicao), "campones.jpg", new Custo(50,0,0,0), true, 50,3,2.0,0,0);
    }
}
