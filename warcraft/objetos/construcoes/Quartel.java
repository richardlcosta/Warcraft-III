package warcraft.objetos.construcoes;

import warcraft.racas.*;
import warcraft.util.*;
import warcraft.objetos.unidades.*;

public class Quartel extends Construcao {

    public void criarGuerreiro(String posicao) {
        raca.addUnidade(new Guerreiro(posicao, raca));
    }

    public void criarCavaleiro(String posicao) {
        raca.addUnidade(new Cavaleiro(posicao, raca));
    }

    public void criarArqueiro(String posicao) {
        raca.addUnidade(new Arqueiro(posicao, raca));
    }

    public void criarGrifo(String posicao) {
        if (raca instanceof Orc) {
            System.out.println("Apenas humanos podem criar grifos");
        } else {
            raca.addUnidade(new Grifo(posicao, raca));
        }
    }

    public Quartel(String posicao, Raca raca) {
        super(new Posicao(posicao), "quartel.jpg", new Custo(0, 0, 125, 0), true, 350, 0, 0, raca);
    }
}
