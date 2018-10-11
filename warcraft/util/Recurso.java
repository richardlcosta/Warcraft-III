package warcraft.util;

public class Recurso {

    private int comida;
    private int ouro;
    private int madeira;
    private int mana;

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

    public void addRecursos(int comida, int ouro, int madeira, int mana){
        this.comida += comida;
        this.ouro += ouro;
        this.madeira += madeira;
        this.mana += mana;
    }

    public void consumirRecursos(Recurso recurso){
        this.comida -= recurso.comida;
        this.ouro -= recurso.ouro;
        this.madeira -= recurso.madeira;
        this.mana -= recurso.mana;
    }

    public boolean compararRecursos(Recurso recurso){
        return this.comida >= recurso.getComida() && this.ouro >= recurso.getOuro() && this.madeira >= recurso.getMadeira() && this.mana >= recurso.getMana();
    }

    public Recurso(int comida, int ouro, int madeira, int mana) {
        this.comida = comida;
        this.ouro = ouro;
        this.madeira = madeira;
        this.mana = mana;
    }
}
