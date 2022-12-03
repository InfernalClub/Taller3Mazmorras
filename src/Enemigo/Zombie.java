package Enemigo;

import Enemigo.Enemigo;

public class Zombie extends Enemigo {

    private String Ralentizar;


    public Zombie(String nombre, String descripcion, int nivel, int vida, int ataque, int defensa, int velocidad, int experiencia, String estado, String AtaqueEspecial) {
        super(nombre, descripcion, nivel, vida, ataque, defensa, velocidad, experiencia, estado, AtaqueEspecial);
    }

    public String getRelentizar() {
        return Ralentizar;
    }

    public void setRelentizar(String relentizar) {
        Ralentizar = relentizar;
    }


    @Override
    public void setAtaqueEspecial(String ataqueEspecial) {
        super.setAtaqueEspecial(Ralentizar);
    }
}
