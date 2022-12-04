package Enemigo;

import Enemigo.Enemigo;

public class Vampiro extends Enemigo {

    private String Vampirismo;


    public Vampiro(String nombre, String descripcion, int nivel, int vida, int ataque, int defensa, int velocidad, String estado, String AtaqueEspecial) {
        super(nombre, descripcion, nivel, vida, ataque, defensa, velocidad, estado, AtaqueEspecial);
    }

    public String getVampirismo() {
        return Vampirismo;
    }

    public void setVampirismo(String vampirismo) {
        Vampirismo = vampirismo;
    }
}

