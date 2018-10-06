package warcraft.util;

public class Posicao {
    private double posicaoX;
    private double posicaoY;

    public double getPosicaoX() {
        return posicaoX;
    }
    public double getPosicaoY() {
        return posicaoY;
    }

    public Posicao(String posicao){
        this.posicaoX = Double.parseDouble(posicao.split("\\s")[0]);
        this.posicaoY = Double.parseDouble(posicao.split("\\s")[1]);
    }
}
