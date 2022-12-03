package Enemigo;

import Enemigo.Enemigo;

public class Zombie extends Enemigo {

    private String Relentizar;


    public Zombie(String nombre, String descripcion, int nivel, int vida, int ataque, int defensa, int velocidad, int experiencia, boolean estado) {
        super(nombre, descripcion, nivel, vida, ataque, defensa, velocidad, experiencia, estado);
    }

    public String getRelentizar() {
        return Relentizar;
    }

    public void setRelentizar(String relentizar) {
        Relentizar = relentizar;
    }
}
