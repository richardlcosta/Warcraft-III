package warcraft.objetos.unidades;

import warcraft.util.Custo;
import warcraft.util.Posicao;

public class Cavaleiro extends Unidade{

    public Cavaleiro(String posicao) {
        super(new Posicao(posicao), "cavaleiro.jpg", new Custo("70 0 80 0"), 1, 180,12,4.0,0,3);
    }
}
