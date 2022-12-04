package Juego;

import java.util.LinkedList;


public class Mazmorra {
    int cantidadMazmorras;
    int cantEnemigos;
    boolean NPC;


    public Mazmorra(int cantidadMazmorras, int cantEnemigos, boolean NPC) {
        this.cantidadMazmorras = 4;
        this.cantEnemigos = 0;
        this.NPC = true;
    }

    public int getCantidadMazmorras() {
        return cantidadMazmorras;
    }

    public void setCantidadMazmorras(int cantidadMazmorras) {
        this.cantidadMazmorras = cantidadMazmorras;
    }

    public int getCantEnemigos() {
        return cantEnemigos;
    }

    public void setCantEnemigos(int cantEnemigos) {
        this.cantEnemigos = cantEnemigos;
    }

    public boolean isNPC() {
        return NPC;
    }

    public void setNPC(boolean NPC) {
        this.NPC = NPC;
    }

    LinkedList<Mazmorra> nuevaMazmorra = new LinkedList<>();

    public void agregarMazmorra () {

    }
}
