package warcraft.util;

/**
 * Armazena todos os recurso de uma raça
 */

public class Recurso extends Custo {

    /**
     * Adiciona recursos
     * @param comida {int}
     * @param ouro {int}
     * @param madeira {int}
     * @param mana {int}
     */

    public void addRecursos(int comida, int ouro, int madeira, int mana) {
        this.comida += comida;
        this.ouro += ouro;
        this.madeira += madeira;
        this.mana += mana;
    }

    /**
     * Consome recursos
     * @param custo {Custo}
     */

    public void consumirRecursos(Custo custo) {
        this.comida -= custo.comida;
        this.ouro -= custo.ouro;
        this.madeira -= custo.madeira;
        this.mana -= custo.mana;
    }

    /**
     * Consome recursos
     * @param comida {int}
     * @param ouro {int}
     * @param madeira {int}
     * @param mana {int}
     */

    public void consumirRecursos(int comida, int ouro, int madeira, int mana) {
        this.comida -= comida;
        this.ouro -= ouro;
        this.madeira -= madeira;
        this.mana -= mana;
    }

    /**
     * Compara o custo de um objeto com os seus recursos de raça e verifica se é possível a criação
     * @param custo {Custo}
     * @return boolean
     */

    public boolean compararRecursos(Custo custo) {
        return this.comida >= custo.getComida() && this.ouro >= custo.getOuro() && this.madeira >= custo.getMadeira() && this.mana >= custo.getMana();
    }

    public Recurso(int comida, int ouro, int madeira, int mana) {
        super(comida, ouro, madeira, mana);
    }
}
