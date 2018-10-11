package warcraft.objetos.unidades;

import warcraft.objetos.*;
import warcraft.racas.*;
import warcraft.util.*;

/**
 * Molde para sacerdotes no jogo
 */

public class Sacerdote extends Unidade {

    /**
     * Realiza uma cura total em unidades não mortas
     * @param objeto {Objeto}
     */

    public void curar(Objeto objeto) {
        if (verificaDistancia(objeto)) {
            if (objeto instanceof Unidade) {
                if (this.raca.getRecursos().getMana() < 5) {
                    System.out.println("Sua raça não possui mana suficiente");
                } else if (objeto.getVida() == objeto.getVidaMax()) {
                    System.out.println("A unidade já está com a vida completa");
                } else {
                    objeto.setVida(objeto.getVidaMax());
                    this.raca.consumirMana(5);
                    System.out.println("A vida da unidade alvo foi restaurada");
                }
            } else {
                System.out.println("Não é possível curar construções");
            }
        } else {
            Erro.imprimeMensagemErro("TARGET_FAR");
        }
    }

    /**
     * Adiciona 5 de mana no total de sua raça
     */

    public void rezar() {
        this.raca.addMana(5);
    }

    public Sacerdote(String posicao, Raca raca) {
        super(new Posicao(posicao), "sacerdote.jpg", new Custo(0, 125, 0, 0), true, 25, 0, 1.0, 10, 2, raca);
    }
}
