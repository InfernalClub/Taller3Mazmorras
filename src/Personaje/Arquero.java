package Personaje;

public class Arquero extends Personaje {

    private String AtaqueRapido;

    public Arquero (String nombre, String descripcion, int nivel, int vida, int ataque, int defensa, int velocidad, int experiencia, boolean estado) {
        super(nombre, descripcion, nivel, vida, ataque, defensa, velocidad, experiencia, estado);
    }


    public String getAtaqueRapido() {
        return AtaqueRapido;
    }

    public void setAtaqueRapido(String ataqueRapido) {
        AtaqueRapido = ataqueRapido;
    }
}
