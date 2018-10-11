package warcraft.objetos.unidades;

import warcraft.racas.Raca;
import warcraft.util.Custo;
import warcraft.util.Posicao;

public class Arqueiro extends Unidade{

    public Arqueiro(String posicao, Raca raca) {
        super(new Posicao(posicao), "arqueiro.jpg", new Custo(40,0,20,0), true, 45,5,2.0,7,0, raca);
    }
}
