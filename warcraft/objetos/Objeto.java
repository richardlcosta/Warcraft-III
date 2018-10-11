package warcraft.objetos;

import warcraft.racas.Raca;
import warcraft.util.Custo;
import warcraft.util.Posicao;

public abstract class Objeto {
    protected Posicao posicao;
    protected Raca raca;
    private Custo custo;
    private String imagem;
    private boolean estado;
    private int vida;

    public Posicao getPosicao() {
        return posicao;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Raca getRaca() {
        return raca;
    }

    public Objeto(Posicao posicao, String imagem, Custo custo, boolean estado, int vida, Raca raca) {
        this.posicao = posicao;
        this.imagem = imagem;
        this.custo = custo;
        this.estado = estado;
        this.vida = vida;
        this.raca = raca;
    }
}
