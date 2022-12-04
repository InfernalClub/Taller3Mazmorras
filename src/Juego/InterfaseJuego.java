package Juego;

import java.io.IOException;

public interface InterfaseJuego {
    void Iniciar() throws IOException;
    void MenuPrincipal();
    void CreacionPersonaje();
    void FinalDungeons();
    void Inspeccionar();
    void Batalla();
    void VerPersonaje();


    int InteractuarNPC(boolean NPC);

    int AtacarPersonaje();
    int AtacarEnemigo();
    int AtaqueEspecialPersonaje();
    int AtaqueEspecialEnemigo();


    int Efectos(int efecto);

    int Defender();
    void Salir();

}
