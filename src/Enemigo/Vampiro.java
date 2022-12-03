package Enemigo;

import Enemigo.Enemigo;

public class Vampiro extends Enemigo {

    private String Vampirismo;


    public Vampiro(String nombre, String descripcion, int nivel, int vida, int ataque, int defensa, int velocidad, int experiencia, boolean estado, String AtaqueEspecial) {
        super(nombre, descripcion, nivel, vida, ataque, defensa, velocidad, experiencia, estado, AtaqueEspecial);
    }

    public String getVampirismo() {
        return Vampirismo;
    }

    public void setVampirismo(String vampirismo) {
        Vampirismo = vampirismo;
    }

    @Override
    public void setAtaqueEspecial(String ataqueEspecial) {
        super.setAtaqueEspecial(Vampirismo);
    }
}
