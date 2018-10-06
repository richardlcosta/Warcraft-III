package warcraft.objetos.unidades;

import warcraft.objetos.Objeto;
import warcraft.util.Custo;
import warcraft.util.Posicao;


public class Unidade extends Objeto {
    private int ataque = 0;
    private double velocidade = 0;
    private int alcance = 0;
    private int armadura = 0;

    public void mover(String direcao){
        if(verificarVida()) {
            switch (direcao) {
                case "Norte":
                    setPosicao(new Posicao((getPosicao().getPosicaoX()) + " " + (getPosicao().getPosicaoY() + velocidade)));
                    break;
                case "Sul":
                    setPosicao(new Posicao((getPosicao().getPosicaoX()) + " " + (getPosicao().getPosicaoY() - velocidade)));
                    break;
                case "Leste":
                    setPosicao(new Posicao((getPosicao().getPosicaoX() + velocidade) + " " + (getPosicao().getPosicaoY())));
                    break;
                case "Oeste":
                    setPosicao(new Posicao((getPosicao().getPosicaoX() - velocidade) + " " + (getPosicao().getPosicaoY())));
                    break;
            }
        }else{
            System.out.println("Uma unidade morta não pode se mover");
        }
    }

    private boolean verificarVida(){
        return getVida() > 0;
    }

    public Unidade(Posicao posicao, String imagem, Custo custo, int estado, int vida, int ataque, double velocidade, int alcance, int armadura) {
        super(posicao, imagem, custo, estado, vida);
        this.ataque = ataque;
        this.alcance = alcance;
        this.velocidade = velocidade;
        this.armadura = armadura;
    }
}
