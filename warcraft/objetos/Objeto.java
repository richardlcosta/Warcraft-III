package warcraft.objetos;

import warcraft.util.Custo;
import warcraft.util.Posicao;

public abstract class Objeto {
    private Posicao posicao;
    private Custo custo;
    private String imagem;
    private int estado;
    private int vida;

    public Posicao getPosicao() {
        return posicao;
    }
    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

    public Objeto(Posicao posicao, String imagem, Custo custo, int estado, int vida) {
        this.posicao = posicao;
        this.imagem = imagem;
        this.custo = custo;
        this.estado = estado;
        this.vida = vida;
    }
}
