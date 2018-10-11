package warcraft.objetos.unidades;

import warcraft.racas.Raca;
import warcraft.util.Recurso;
import warcraft.util.Posicao;

public class Guerreiro extends Unidade {

    public Guerreiro(String posicao, Raca raca) {
        super(new Posicao(posicao), "guerreiro.jpg", new Recurso(35, 15, 0, 0), true, 160, 13, 1.8, 0, 2, raca);
    }
}
