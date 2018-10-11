package warcraft.objetos.unidades;

import warcraft.objetos.construcoes.*;
import warcraft.racas.Raca;
import warcraft.util.*;

public class Campones extends Unidade {

    public void construirCasa(String posicao) {
        raca.addConstrucao(new Casa(posicao, raca));
    }

    public void construirCentro(String posicao) {
        raca.addConstrucao(new CentroDaCidade(posicao, raca));
    }

    public void construirTemplo(String posicao) {
        raca.addConstrucao(new Templo(posicao, raca));
    }

    public void construirQuartel(String posicao) {
        raca.addConstrucao(new Quartel(posicao, raca));
    }

    public void construirTorre(String posicao) {
        raca.addConstrucao(new Torre(posicao, raca));
    }

    public Campones(String posicao, Raca raca) {
        super(new Posicao(posicao), "campones.jpg", new Custo(50, 0, 0, 0), true, 50, 3, 2.0, 0, 0, raca);
    }
}
