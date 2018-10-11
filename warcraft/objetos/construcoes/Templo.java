package warcraft.objetos.construcoes;

import warcraft.objetos.unidades.*;
import warcraft.racas.Humano;
import warcraft.racas.Raca;
import warcraft.util.*;

import java.util.ArrayList;

public class Templo extends Construcao {

    public void criarSacerdote(String posicao) {
        raca.addUnidade(new Sacerdote(posicao, raca));
    }

    public void criarAndarilho(String posicao) {
        if (raca instanceof Humano) {
            System.out.println("Apenas orcs podem criar andarilhos espirituais");
        } else {
            raca.addUnidade(new Sacerdote(posicao, raca));
        }
    }

    public Templo(String posicao, Raca raca) {
        super(new Posicao(posicao), "templo.jpg", new Custo(0, 0, 250, 0), true, 350, 0, 0, raca);
    }
}
