package Juego;

import java.io.IOException;

public interface InterfaseJuego {
    void Iniciar() throws IOException;
    void MenuPrincipal();
    void CreacionPersonaje();
    void FinalDungeons();
    void Inspeccionar();


    void Batalla(int enemigos);

    void VerPersonaje();


    void InteractuarNPC(boolean NPC);

    int AtacarPersonaje();
    int AtacarEnemigo();
    int AtaqueEspecialPersonaje();
    int AtaqueEspecialEnemigo();


    int Efectos(int efecto);

    void Defender();
    void DefensaEnemigo();
    void Salir();

}
