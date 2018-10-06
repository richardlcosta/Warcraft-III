package warcraft.objetos.construcoes;

import warcraft.util.*;

public class Torre extends Construcao{

    public Torre(String posicao) {
        super(new Posicao(posicao), "torre.jpg", new Custo("0 0 70 0"), 1, 200,20,7);
    }
}
