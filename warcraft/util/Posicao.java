package warcraft.util;

/**
 * Armazena as posições de todos os objetos criados
 */

public class Posicao {
    private double posicaoX;
    private double posicaoY;

    protected double getPosicaoX() {
        return posicaoX;
    }

    protected double getPosicaoY() {
        return posicaoY;
    }

    /**
     * Move um objeto à sua velocidade para o norte
     * @param velocidade {double}
     */

    public void moverNorte(double velocidade) {
        posicaoY += velocidade;
    }

    /**
     * Move um objeto à sua velocidade para o sul
     * @param velocidade {double}
     */

    public void moverSul(double velocidade) {
        posicaoY -= velocidade;
    }

    /**
     * Move um objeto à sua velocidade para o leste
     * @param velocidade {double}
     */

    public void moverLeste(double velocidade) {
        posicaoX += velocidade;
    }

    /**
     * Move um objeto à sua velocidade para o oeste
     * @param velocidade {double}
     */

    public void moverOeste(double velocidade) {
        posicaoX -= velocidade;
    }

    /**
     * Calcula a distancia real entre dois objetos
     * @param posicao1 {Posicao}
     * @param posicao2 {Posicao}
     * @return double
     */

    public double calculaDistancia(Posicao posicao1, Posicao posicao2) {
        double distX = Math.abs(posicao1.getPosicaoX() - posicao2.getPosicaoX());
        double distY = Math.abs(posicao1.getPosicaoY() - posicao2.getPosicaoY());

        return Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));
    }

    /**
     * Exibe na tela a posição atual de um objeto
     */

    public void mostrarPosicao() {
        System.out.println(posicaoX + " " + posicaoY);
    }

    public Posicao(String posicao) {
        this.posicaoX = Double.parseDouble(posicao.split("\\s")[0]);
        this.posicaoY = Double.parseDouble(posicao.split("\\s")[1]);
    }
}
