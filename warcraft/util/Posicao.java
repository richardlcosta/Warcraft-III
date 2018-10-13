package warcraft.util;

/**
 * Armazena as posições de todos os objetos criados
 */

public class Posicao {
    private double X;
    private double Y;

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    /**
     * Move um objeto à sua velocidade para o norte
     * @param velocidade {double}
     */

    public void moverNorte(double velocidade) {
        Y += velocidade;
    }

    /**
     * Move um objeto à sua velocidade para o sul
     * @param velocidade {double}
     */

    public void moverSul(double velocidade) {
        Y -= velocidade;
    }

    /**
     * Move um objeto à sua velocidade para o leste
     * @param velocidade {double}
     */

    public void moverLeste(double velocidade) {
        X += velocidade;
    }

    /**
     * Move um objeto à sua velocidade para o oeste
     * @param velocidade {double}
     */

    public void moverOeste(double velocidade) {
        X -= velocidade;
    }

    /**
     * Calcula a distancia real entre dois objetos
     * @param posicao1 {Posicao}
     * @param posicao2 {Posicao}
     * @return double
     */

    public double calculaDistancia(Posicao posicao1, Posicao posicao2) {
        double distX = Math.abs(posicao1.getX() - posicao2.getX());
        double distY = Math.abs(posicao1.getY() - posicao2.getY());

        return Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));
    }

    /**
     * Exibe na tela a posição atual de um objeto
     */

    public void mostrarPosicao() {
        System.out.printf("Posição atual %.2f %.2f\n", X, Y);
    }

    public Posicao(String posicao) {
        this.X = Double.parseDouble(posicao.split("\\s")[0]);
        this.Y = Double.parseDouble(posicao.split("\\s")[1]);
    }
}
