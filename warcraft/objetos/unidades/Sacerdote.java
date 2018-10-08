package warcraft.objetos.unidades;

import warcraft.util.Custo;
import warcraft.util.Posicao;

public class Sacerdote extends Unidade{

    public Sacerdote(String posicao) {
        super(new Posicao(posicao), "sacerdote.jpg", new Custo(125,0,0,0), true, 25,0,1.0,10,2);
    }
}
