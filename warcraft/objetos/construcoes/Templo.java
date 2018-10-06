package warcraft.objetos.construcoes;

import warcraft.objetos.unidades.*;
import warcraft.util.*;

import java.util.ArrayList;

public class Templo extends Construcao{

    public Sacerdote criarSacerdote(String posicao) {
        return new Sacerdote(posicao);
    }

    public Templo(String posicao) {
        super(new Posicao(posicao), "templo.jpg", new Custo("0 0 250 0"), 1, 350,0,0);
    }
}
