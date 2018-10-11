package warcraft.objetos.unidades;

import warcraft.objetos.Objeto;
import warcraft.racas.Raca;
import warcraft.util.*;


public class Unidade extends Objeto {
    private int ataque = 0;
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

    public Unidade(Posicao posicao, String imagem, Custo custo, boolean estado, int vida, int ataque, double velocidade, int alcance, int armadura, Raca raca) {
        super(posicao, imagem, custo, estado, vida, raca);
        this.ataque = ataque;
        this.alcance = alcance;
        this.velocidade = velocidade;
        this.armadura = armadura;
    }
}
