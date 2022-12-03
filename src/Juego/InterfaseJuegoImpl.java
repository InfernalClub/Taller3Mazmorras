package Juego;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class InterfaseJuegoImpl implements InterfaseJuego {

    @Override
    public void Iniciar() {

    }

    @Override
    public void MenuPrincipal() {


    }

    @Override
    public void CreacionPersonaje() {

    }

    @Override
    public void FinalDungeons() {

    }

    @Override
    public void Inspeccionar() {

    }

    @Override
    public void Batalla() {

    }

    @Override
    public void VerPersonaje() {

    }

    @Override
    public int InteractuarNPC() {
        return 0;
    }

    @Override
    public int AtacarPersonaje() {

        //AtaqueResultante = Ataque * Efectividad;
        //return AtaqueResultante;



        return 0;
    }

    @Override
    public int AtacarEnemigo() {

        //AtaqueEnemigo;
        return 0;
    }

    @Override
    public int AtaqueEspecialPersonaje() {
        return 0;
    }

    @Override
    public int AtaqueEspecialEnemigo() {
        return 0;
    }

    @Override
    public int Efectos() {
        return 0;
    }

    @Override
    public int Defender() {
        return 0;
    }

    @Override
    public void Salir() {

    }


    public int Randomizer()
    {
        int randomNumber = ThreadLocalRandom.current().nextInt(0,   4);
        return randomNumber;
    }
}
