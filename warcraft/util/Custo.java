package warcraft.util;

/**
 * Molde para todos os cursos de criação de objetos
 */

public class Custo {
    protected int comida;
    protected int ouro;
    protected int madeira;
    protected int mana;

    public int getComida() {
        return comida;
    }

    public int getOuro() {
        return ouro;
    }

    public int getMadeira() {
        return madeira;
    }

    public int getMana() {
        return mana;
    }

    public Custo(int comida, int ouro, int madeira, int mana) {
        this.comida = comida;
        this.ouro = ouro;
        this.madeira = madeira;
        this.mana = mana;
    }
}
