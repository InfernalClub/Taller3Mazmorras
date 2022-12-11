package Juego;

import Enemigo.Enemigo;
import Personaje.Personaje;
import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdIn;
import ucn.StdOut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class InterfaseJuegoImpl implements InterfaseJuego {

    Personaje nuevoPersonaje;

    List<Personaje> nuevaClase = new ArrayList<>();

    Enemigo enemigo;

    int numeroMazmorra = 1;
    int mazmorraActual = numeroMazmorra;
    boolean explorado = false;
    Enemigo Zombie, Vampiro, HombreLobo;
    ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>(3);
    ArrayList<Personaje> nuevaCLase = new ArrayList<Personaje>(100);


    @Override
    public void Iniciar() throws IOException {
        if (!cargarNombres() || !cargarDescripciones()) {
            StdOut.println("No se pudo iniciar el programa");
        }


        enemigos.add(Zombie);
        enemigos.add(Vampiro);
        enemigos.add(HombreLobo);


        MenuPrincipal();
    }

    @Override
    public void MenuPrincipal() {
        StdOut.println("----->ZENKAI GAMES PRESENTA<-----");
        StdOut.println("");
        StdOut.println("FINAL DUNGEONS");
        StdOut.println("");
        StdOut.println("[1] INICIAR JUEGO");
        StdOut.println("[2] SALIR");

        try
        {
            String opcion = StdIn.readLine();
            int decision;
            if (isNumeric(opcion)) Integer.parseInt(opcion);
            decision = Integer.parseInt(opcion);
            switch (decision)
            {
                case 1:
                    CreacionPersonaje();
                    break;

                case 2:
                    StdOut.println("Se cierra el programa");
                    StdOut.println("Gracias por jugar");
                    Salir();
                    break;

                default:
                    StdOut.println("Ingrese una opcion de la lista: ");
                    MenuPrincipal();


            }

        }
        catch (Exception e) {
            StdOut.println("Ingrese una opción válida.");
            MenuPrincipal();
        }
    }

    @Override
    public void CreacionPersonaje() {
        StdOut.println("----->FINAL DUNGEONS<-----");
        StdOut.println("");
        StdOut.println("[*] CREACION DE PERSONAJE [*]");
        StdOut.println("");
        StdOut.println("INGRESE UN NOMBRE: ");
        String nombrePersonaje = StdIn.readString();

        StdOut.println("----->FINAL DUNGEONS<-----");
        StdOut.println("");
        StdOut.println("[*] CREACION DE PERSONAJE [*]");
        StdOut.println("");
        StdOut.println("INGRESE UNA DESCRIPCION: ");
        String descripcionPersonaje = StdIn.readString();

        StdOut.println("----->FINAL DUNGEONS<-----");
        StdOut.println("");
        StdOut.println("[*] CREACION DE PERSONAJE [*]");
        StdOut.println("");
        StdOut.println(" ESCOJA UNA CLASE: ");
        StdOut.println("Espadachin");
        StdOut.println("Arquero");
        StdOut.println("Mago");
        String claseEscogida = StdIn.readString();

        if (claseEscogida.equalsIgnoreCase("Espadachin")){
            nuevoPersonaje = new Personaje(nombrePersonaje,descripcionPersonaje,1,100,20,10,17,0,"Normal","Ataque Doble");
            nuevaClase.add(nuevoPersonaje);
            StdOut.println("Personaje Creado, ¡que comienze la aventura!");
            FinalDungeons();
        }
        if (claseEscogida.equalsIgnoreCase("Arquero")){
            nuevoPersonaje = new Personaje(nombrePersonaje,descripcionPersonaje,1,100,20,10,17,0,"Normal","Ataque Multiple");
            nuevaClase.add(nuevoPersonaje);
            StdOut.println("Personaje Creado, ¡que comienze la aventura!");
            FinalDungeons();
        }
        if (claseEscogida.equalsIgnoreCase("Mago")){
            nuevoPersonaje = new Personaje(nombrePersonaje,descripcionPersonaje,1,100,20,10,17,0,"Normal","Regeneracion");
            nuevaClase.add(nuevoPersonaje);
            StdOut.println("Personaje Creado, ¡que comienze la aventura!");
            FinalDungeons();
        }else {
            StdOut.println("Error, ingrese una opcion correcta");
            CreacionPersonaje();
        }

        ;
    }

    @Override
    public void FinalDungeons() {
        boolean corriendo = true;



        while (corriendo) {
            StdOut.println("------------->FINAL DUNGEONS<-------------");
            StdOut.println("[!] Te encuentras en la mazmorra N°" + numeroMazmorra + " [!]");
            StdOut.println("");
            StdOut.println("[1] Inspeccionar");
            StdOut.println("[2] Ver Personaje");
            StdOut.println("[3] Siguiente Mazmorra");
            StdOut.println("[4] Anterior Mazmorra");
            StdOut.println("[5] Salir");
            StdOut.println("");
            StdOut.println("------------------------------------------");

            try {
                String opcion = StdIn.readLine();
                int decision;
                if (isNumeric(opcion)) Integer.parseInt(opcion);
                decision = Integer.parseInt(opcion);
                switch (decision) {
                    case 1:
                        if (!explorado)
                        {
                            explorado = true;
                            Inspeccionar();
                        }
                        else {System.out.println("Ya exploraste la masmorra.");}
                        FinalDungeons();

                        break;

                    case 2:
                        VerPersonaje();
                        break;

                    case 3:
                        if (!explorado)
                        {
                            System.out.println("No haz explorado la masmorra actual para poder subir.");
                        }
                        else
                        {
                            numeroMazmorra =+1;
                            FinalDungeons();
                        }
                        break;
                    case 4:
                        if (numeroMazmorra == 1)
                        {
                            System.out.println("Ya te encuentras en la primera mazmorra, no se puede volver mas.");
                            FinalDungeons();
                        }

                        else
                        {
                            numeroMazmorra = numeroMazmorra -1;
                            FinalDungeons();

                        }
                        break;
                    case 5:
                        StdOut.println("Saliendo de la mazmorra");
                        System.exit(5);
                        break;
                    default:
                        StdOut.println("Ingrese una opcion de la lista: ");
                        FinalDungeons();


                }

            } catch (Exception e) {
                StdOut.println("Ingrese una opción válida.");
                FinalDungeons();


            }
        }
    }

    @Override
    public void Inspeccionar()
    {
        int enemigos = Randomizer();
            switch (enemigos)
            {
                case 0:
                    InteractuarNPC(true);
                    break;

                case 1:
                    Batalla(1);
                    StdOut.println(enemigos);

                case 2:
                    Batalla(2);
                    StdOut.println(enemigos);

                case 3:
                    Batalla(3);
                    StdOut.println(enemigos);
            }


    }

    @Override
    public void Batalla(int enemigos)
    {
                
                System.out.println("Te haz encontrado a un enemigo! ");
                for (int i = 0; i <enemigos ; i++) {
                System.out.println("*****ENEMIGO*****");
                System.out.println("[*] Nivel:  "+enemigo.getNivel()+" "+enemigo.getNombre()+" "+enemigo.getDescripcion());
                System.out.println("[*] Vida: "+enemigo.getVida());
                System.out.println("[*] Estado:  "+enemigo.getEstado());
                System.out.println(" ");
                System.out.println(" ");
                }

                System.out.println("*****TU*****");
                System.out.println("[*] Nivel: "+nuevoPersonaje.getNivel()+" "+nuevoPersonaje.getNombre()+" "+nuevoPersonaje.getDescripcion());
                System.out.println("[*] Vida: "+nuevoPersonaje.getVida());
                System.out.println("[*] Estado:  "+nuevoPersonaje.getEstado());
                System.out.println(" ");
                System.out.println(" ");

                if (nuevoPersonaje.getVelocidad() > enemigo.getVelocidad()){
                    StdOut.println("¿Que deseas hacer?");
                    System.out.println("[1] Atacar");
                    System.out.println("[2] Usar el ataque especial");
                    System.out.println("[3] Defender");

                    int opcion = StdIn.readInt();

                    if (opcion==1){
                        AtacarPersonaje();
                        Batalla(enemigos);
                    }
                    if (opcion==2){
                        AtaqueEspecialPersonaje();
                        Batalla(enemigos);
                    }
                    if (opcion==3){
                        Defender();
                        Batalla(enemigos);
                    }
                    else {
                        StdOut.println("Error, ingrese una opcion correcta");
                    }
                }

                else {
                    int decisionEnemigo =RandomizerEnemigo();

                    if (decisionEnemigo==1){
                        AtacarEnemigo();
                        FinalDungeons();
                    }
                    if (decisionEnemigo==2){
                        AtaqueEspecialEnemigo();
                        FinalDungeons();
                    }
                    if (decisionEnemigo==3){
                        DefensaEnemigo();
                        FinalDungeons();
                    }
                    else {
                        StdOut.println("");
                        FinalDungeons();
                    }
                }


                if (enemigo.getVida()==0){
                    StdOut.println("Haz derrotado a los enemigos, ¿que haras ahora?");
                    System.out.println(" ");
                    FinalDungeons();
                }


    }

    public void calculoFinal(int opcion)
    {
        switch (opcion)
        {
            case 1:
            int daño = AtacarPersonaje();
            int vidaEnemigo = enemigos.get(0).getVida() - daño;
            if (vidaEnemigo <= 0)
                {
                    System.out.println("Haz derrotado al enemigo");
                    FinalDungeons();
                    break;
                }



            case 2:
                daño = AtaqueEspecialPersonaje();
                vidaEnemigo = enemigos.get(0).getVida() - daño;
                if (vidaEnemigo <= 0)
                {
                    System.out.println("Haz derrotado al enemigo");
                    FinalDungeons();
                    break;
                }

            case 3:
                Defender();
                calculoFinalEnemigo(0);
                break;
        }


    }


    public void calculoFinalEnemigo(int opcion)
    {
        switch (opcion)
        {
            case 0:
                System.out.println("El enemigo ataco pero no pudo romper tus defensas! ");
            case 1:
                int daño = AtacarEnemigo();
                int vidaJugador = nuevoPersonaje.getVida() - daño;
                if (vidaJugador <= 0)
                {
                    System.out.println("Te han derrotado!");
                    Salir();
                    break;
                }



            case 2:
                AtaqueEspecialEnemigo();
                vidaJugador = nuevoPersonaje.getVida();
                if (vidaJugador <= 0)
                {
                    System.out.println("Te han derrotado!");
                    Salir();
                    break;
                }

            case 3:
                DefensaEnemigo();
        }


    }

    @Override
    public void VerPersonaje() {
        StdOut.println("--------------->FINAL DUNGEONS<--------------");
        StdOut.println("");
        StdOut.println("");
        StdOut.println("[*] Nivel: "+nuevoPersonaje.getNivel()+" [*]");
        StdOut.println("[*] Vida: "+nuevoPersonaje.getVida()+" [*]");
        StdOut.println("[*] Ataque: "+nuevoPersonaje.getAtaque()+" [*]");
        StdOut.println("[*] Defensa: "+nuevoPersonaje.getDefensa()+" [*]");
        StdOut.println("[*] Velocidad: "+nuevoPersonaje.getVelocidad()+" [*]");
        StdOut.println("");
        StdOut.println("");
        StdOut.println("---------------------------------------------");

        StdOut.println("Presione enter para volver al menu");
        String respuesta = StdIn.readString();
        FinalDungeons();
    }

    @Override
    public int InteractuarNPC(boolean NPC)
    {
        int extraEXP = 0;

        if (NPC = true)
        {
            extraEXP = 100;
        }

        else
        {
            extraEXP = 0;
            System.out.println("No parece haber reaccion");


        }

        return extraEXP;
    }





    @Override
    public int AtacarPersonaje() {
       int vidaEnemigo=110;
       int ataqueJugador=40;

       if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Doble Ataque") && enemigos.equals("HombreLobo")){
           ataqueJugador = ataqueJugador*4;
       }
        if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Doble Ataque") && enemigos.equals("Zombie")){
            ataqueJugador = ataqueJugador*2;
        }

        if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Ataque Multiple") && enemigos.equals("Vampiro")){
            ataqueJugador = ataqueJugador*4;
        }
        if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Ataque Multiple") && enemigos.equals("HombreLobo")){
            ataqueJugador = ataqueJugador*4;
        }

        if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Regeneracion") && enemigos.equals("Zombie")){
            ataqueJugador = ataqueJugador*4;
        }
        if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Regeneracion") && enemigos.equals("Vampiro")){
            ataqueJugador = ataqueJugador*4;
        }

        vidaEnemigo = vidaEnemigo - (ataqueJugador-enemigo.getDefensa());
        enemigo.setVida(vidaEnemigo);
        return vidaEnemigo;

    }

    @Override
    public int AtacarEnemigo() {
        int vidaPersonaje = 0;
        vidaPersonaje = vidaPersonaje - (enemigo.getAtaque()-nuevoPersonaje.getDefensa());
        return vidaPersonaje;
    }

    @Override
    public int AtaqueEspecialPersonaje() {
        int ataquePersonaje=0;
        if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Doble Ataque")){
            ataquePersonaje = nuevoPersonaje.getAtaque() * 2;
        }
        if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Ataque Multiple")){
            ataquePersonaje = nuevoPersonaje.getAtaque() * 2;
        }


        return ataquePersonaje;
    }

    @Override
    public int AtaqueEspecialEnemigo() {
        String SP = enemigos.get(0).getAtaqueEspecial();
        if (SP.equalsIgnoreCase("Ralentizar"))
        {
            System.out.println("El zombie se acerca y te agarra! ");
            Efectos(2);
        }
        if (SP.equalsIgnoreCase("Sangrar"))
        {
            System.out.println("El vampiro empieza a succionar tu sangre! ");
            Efectos(3);
        }
        else
        {
            System.out.println("El hombre lobo corta tus arterias! ");
            Efectos((4));
        }
        return 0;
    }

    @Override
    public int Efectos(int efecto) {
        switch (efecto)
        {
            case 1:
                System.out.println("Estas regenerando vida");
                nuevoPersonaje.setEstado("Regenerar");
                break;

            case 2:
                System.out.println("¡Has sido ralentizado! ");
                nuevoPersonaje.setEstado("Ralentizado");
                nuevoPersonaje.setVelocidad(nuevoPersonaje.getVelocidad()/2);

            case 3:
                System.out.println("¡Te han vampirificado! ");
                nuevoPersonaje.setEstado("Vampirismo");

            case 4:
                System.out.println("¡Te han hecho sangrar! ");
                nuevoPersonaje.setEstado("Sangrando");

            case 5:
                System.out.println("Vuelves a la normalidad");
                nuevoPersonaje.setEstado("Normal");

        }

        return 0;
    }

    @Override
    public void Defender() {
        StdOut.println("Te has defendido del ataque");
    }

    @Override
    public void DefensaEnemigo() {
        StdOut.println("El enemigo a bloqueado tu ataque");
    }

    @Override
    public void Salir() {
        System.exit(2);
    }

    public void SubirDeNivel()
    {
        nuevoPersonaje.setNivel(nuevoPersonaje.getNivel()+1);
        if (nuevoPersonaje.getNivel()== 2)
        {
            nuevoPersonaje.setAtaque((int) (nuevoPersonaje.getAtaque()*1.5));
            nuevoPersonaje.setDefensa((int) (nuevoPersonaje.getDefensa()*1.5));
            nuevoPersonaje.setVida((int) (nuevoPersonaje.getVida()*1.5));
            nuevoPersonaje.setVelocidad((int) (nuevoPersonaje.getVelocidad()*1.5));
        }

        if (nuevoPersonaje.getNivel() == 3)
        {
            nuevoPersonaje.setAtaque((int) (nuevoPersonaje.getAtaque()*2));
            nuevoPersonaje.setDefensa((int) (nuevoPersonaje.getDefensa()*2));
            nuevoPersonaje.setVida((int) (nuevoPersonaje.getVida()*2));
            nuevoPersonaje.setVelocidad((int) (nuevoPersonaje.getVelocidad()*2));
        }

        if (nuevoPersonaje.getNivel() == 4)
        {
            nuevoPersonaje.setAtaque((int) (nuevoPersonaje.getAtaque()*3));
            nuevoPersonaje.setDefensa((int) (nuevoPersonaje.getDefensa()*3));
            nuevoPersonaje.setVida((int) (nuevoPersonaje.getVida()*3));
            nuevoPersonaje.setVelocidad((int) (nuevoPersonaje.getVelocidad()*3));
        }
    }



    /**
     *  Metodo que pasa un dato de String a un dato double
     * @param str String a verificar
     * @return retorna falso si el numero ingresado esta mal ingresado y true si esta correctamente ingresado
     */
    private boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static int Randomizer()
    {
        int randomNumber = ThreadLocalRandom.current().nextInt(0,   4);
        return randomNumber;
    }

    public static int RandomizerEnemigo()
    {
        int randomNumber = ThreadLocalRandom.current().nextInt(1,   4);
        return randomNumber;
    }

    public static boolean sobrevivirNPC(int randomNumber)
    {
        boolean NPC = false;
        int chanceSobrevivir = ThreadLocalRandom.current().nextInt(1,21);
        if (randomNumber == 0)
        {
            NPC = true;
        }
        if (randomNumber == 1)
            if(chanceSobrevivir >=18)
            {
                NPC = false;
            }
            else {NPC = true;}

        else if (randomNumber == 2)
        {
            if(chanceSobrevivir >= 14)
            {
                NPC = false;
            }
            else {NPC = true;}
        }

        else
        {
            if(chanceSobrevivir >= 10)
            {NPC = false;}
            else {NPC = true;}
        }

        return NPC;
    }

    public boolean cargarNombres() throws IOException {
        ArchivoEntrada archivo = new ArchivoEntrada("nombres.txt");
        int contador = 0;
        while (!archivo.isEndFile()) {
            Registro regEnt = archivo.getRegistro();
            String nombre = regEnt.getString();

            contador++;
        }
        archivo.close();
        return true;
    }

    public boolean cargarDescripciones() throws IOException {
        ArchivoEntrada archivo = new ArchivoEntrada("descripciones.txt");
        int contador = 0;
        while (!archivo.isEndFile()) {
            Registro regEnt = archivo.getRegistro();
            String descripcion = regEnt.getString();

            contador++;
        }
        archivo.close();
        return true;
    }
}
