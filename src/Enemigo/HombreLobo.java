package Enemigo;

import Enemigo.Enemigo;

public class HombreLobo extends Enemigo {

    private String Araniar;


    public HombreLobo(String nombre, String descripcion, int nivel, int vida, int ataque, int defensa, int velocidad, int experiencia, boolean estado) {
        super(nombre, descripcion, nivel, vida, ataque, defensa, velocidad, experiencia, estado);
    }

    public String getAraniar() {
        return Araniar;
    }

    public void setAraniar(String araniar) {
        Araniar = araniar;
    }
}
