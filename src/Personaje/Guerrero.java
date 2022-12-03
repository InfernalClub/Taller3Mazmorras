package Personaje;

import Personaje.Personaje;

public class Guerrero extends Personaje {

    private String AtaqueDoble;

    public Guerrero(String nombre, String descripcion, int nivel, int vida, int ataque, int defensa, int velocidad, int experiencia, boolean estado) {
        super(nombre, descripcion, nivel, vida, ataque, defensa, velocidad, experiencia, estado);
    }

    public String getAtaqueDoble() {
        return AtaqueDoble;
    }

    public void setAtaqueDoble(String ataqueDoble) {
        AtaqueDoble = ataqueDoble;
    }
}
