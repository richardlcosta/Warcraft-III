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

    public void moverNorte(double velocidade){
        posicaoY += velocidade;
    }
    public void moverSul(double velocidade){
        posicaoY -= velocidade;
    }
    public void moverLeste(double velocidade){
        posicaoX += velocidade;
    }
    public void moverOeste(double velocidade){
        posicaoX -= velocidade;
    }
    public void mostrarPosicao(){
        System.out.println(posicaoX + " " + posicaoY);
    }

    public Posicao(String posicao){
        this.posicaoX = Double.parseDouble(posicao.split("\\s")[0]);
        this.posicaoY = Double.parseDouble(posicao.split("\\s")[1]);
    }
}
