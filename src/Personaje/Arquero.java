package Personaje;

public class Arquero extends Personaje {

    private String AtaqueMultiple;

    public Arquero (String nombre, String descripcion, int nivel, int vida, int ataque, int defensa, int velocidad, int experiencia, boolean estado, String AtaqueEspecial) {
        super(nombre, descripcion, nivel, vida, ataque, defensa, velocidad, experiencia, estado, AtaqueEspecial);
    }


    public String getAtaqueMultiple() {
        return AtaqueMultiple;
    }

    public void setAtaqueMultiple(String ataqueMultiple) {
        AtaqueMultiple = ataqueMultiple;
    }

    @Override
    public void setAtaqueEspecial(String ataqueEspecial) {
        super.setAtaqueEspecial(AtaqueMultiple);
    }
}
