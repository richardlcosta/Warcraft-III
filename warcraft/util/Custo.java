package warcraft.util;

public class Custo {

    private double comida;
    private double ouro;
    private double madeira;
    private double mana;

    public Custo(String custo){
        this.comida = Double.parseDouble(custo.split("\\s")[0]);
        this.ouro = Double.parseDouble(custo.split("\\s")[1]);
        this.madeira = Double.parseDouble(custo.split("\\s")[2]);
        this.mana = Double.parseDouble(custo.split("\\s")[3]);
    }
}
