package warcraft.objetos.unidades;

import warcraft.objetos.Objeto;
import warcraft.racas.Raca;
import warcraft.util.*;


public class Unidade extends Objeto {
    private double velocidade = 0;
    private int alcance = 0;
    private int armadura = 0;

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
        } else {
            System.out.println("Uma unidade morta não pode se mover");
        }
    }

    public int getArmadura() {
        return armadura;
    }

    public Unidade(Posicao posicao, String imagem, Recurso recurso, boolean estado, int vidaMax, int ataque, double velocidade, int alcance, int armadura, Raca raca) {
        super(posicao, imagem, recurso, estado, vidaMax, ataque, raca);
        this.alcance = alcance;
        this.velocidade = velocidade;
        this.armadura = armadura;
    }
}
