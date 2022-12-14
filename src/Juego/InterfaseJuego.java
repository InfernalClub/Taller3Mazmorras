package Juego;

import java.io.IOException;

public interface InterfaseJuego {
    void Iniciar() throws IOException;
    void MenuPrincipal();
    void CreacionPersonaje();
    void FinalDungeons();
    int Inspeccionar();


    void Batalla(int enemigos);

    void VerPersonaje();


    void InteractuarNPC(boolean NPC);

    void AtacarPersonaje();
    int AtacarEnemigo();
    void AtaqueEspecialPersonaje();
    int AtaqueEspecialEnemigo();


    int Efectos(int efecto);

    void DefensaEnemigo();
    void Salir();

}
