package Personaje;

public class Mago extends Personaje {

    private String Regeneracion;

    public Mago (String nombre, String descripcion, int nivel, int vida, int ataque, int defensa, int velocidad, int experiencia, boolean estado, String AtaqueEspecial) {
        super(nombre, descripcion, nivel, vida, ataque, defensa, velocidad, experiencia, estado, AtaqueEspecial);
    }

    public String getRegeneracion() {
        return Regeneracion;
    }

    public void setRegeneracion(String regeneracion) {
        Regeneracion = regeneracion;
    }

    @Override
    public void setAtaqueEspecial(String ataqueEspecial) {
        super.setAtaqueEspecial(Regeneracion);
    }
}
