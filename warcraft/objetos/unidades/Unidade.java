package warcraft.objetos.unidades;

import warcraft.objetos.*;
import warcraft.racas.*;
import warcraft.util.*;

/**
 * Molde para as unidades do jogo
 */

public class Unidade extends Objeto {
    private double velocidade;
    private int armadura;

    /**
     * Move um objeto para alguma direção do mapa: [Norte, Sul, Leste, Oeste]
     * @param direcao {String}
     */

    public void mover(String direcao) {
        if (getEstado()) {
            switch (direcao) {
                case "Norte":
                    posicao.moverNorte(velocidade);
                    break;
                case "Sul":
                    posicao.moverSul(velocidade);
                    break;
                case "Leste":
                    posicao.moverLeste(velocidade);
                    break;
                case "Oeste":
                    posicao.moverOeste(velocidade);
                    break;
            }
            System.out.print("Nova posição: ");
            posicao.mostrarPosicao();
        } else {
            System.out.println("Uma unidade morta não pode se mover");
        }
    }

    public int getArmadura() {
        return armadura;
    }

    public Unidade(Posicao posicao, String imagem, Custo custo, boolean estado, int vidaMax, int ataque, double velocidade, int alcance, int armadura, Raca raca) {
        super(posicao, imagem, custo, estado, vidaMax, ataque, alcance, raca);
        this.velocidade = velocidade;
        this.armadura = armadura;
    }
}
