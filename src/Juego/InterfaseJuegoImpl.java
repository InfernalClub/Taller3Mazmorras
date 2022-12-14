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
/**
 * Clase que representa el sistema
 */
public class InterfaseJuegoImpl implements InterfaseJuego {
    /**
     * Personaje creado
     */
    Personaje nuevoPersonaje;
    /**
     * Lista qye almacena los tipos de personajes
     */
    List<Personaje> nuevaClase = new ArrayList<>();
    /**
     * Mazmorra donde parte el personaje
     */
    int numeroMazmorra = 1;
    /**
     * Mazmorra donde se encuentra el personaje
     */
    int mazmorraActual = numeroMazmorra;
    /**
     * Funcion que determina si nuestro personaje esta explorando la mazmorra
     */
    boolean explorado = false;
    /**
     * Lista que almacena los nombres de los enemigos
     */
    List<String> nombresEnemigos = new ArrayList<>();
    /**
     * Lista que almacena las descripciones de los enemigos
     */
    List<String> descripcionesEnemigos = new ArrayList<>();
    /**
     * Lista que almacena los tipos de enemigos
     */
    List<String> tipoEnemigos = new ArrayList<>();
    /**
     * Lista que almacena al contenedor de enemigos
     */
    List<Enemigo> ListaEnemigos = new ArrayList<>();


    {
        // Metodo de la lista nombresEnemigos y se usa para agregar los nombres
        nombresEnemigos.add(0, "Silvo");
        nombresEnemigos.add(1, "Begelle");
        nombresEnemigos.add(2, "Laegon");
        nombresEnemigos.add(3, "Tand");
        nombresEnemigos.add(4, "Juvento");
        nombresEnemigos.add(5, "Tigrit");

        // Metodo de la lista descripcionesEnemigos y se usa para agregar las descripciones
        descripcionesEnemigos.add(0, "El Lider");
        descripcionesEnemigos.add(1, "El Ordenado");
        descripcionesEnemigos.add(2, "El Feliz");
        descripcionesEnemigos.add(3, "El Grande");
        descripcionesEnemigos.add(4, "El Feroz");
        descripcionesEnemigos.add(5, "El Dios");
        // Metodo de la lista tipoEnemigos y se usa para agregar los tipos de enemigos
        tipoEnemigos.add(0, "Vampiro");
        tipoEnemigos.add(1, "Hombre Lobo");
        tipoEnemigos.add(2, "Zombie");
        /**
         * Aqui se agregan a los enemigos en base a sus estadisticas y lo unico que varia seria su nombre,descripcion y habilidad, el nombre y descripcion ocupa un metodo llamado RandomizerDescripcionesYNombres que nos
         * permite seleccionar de las listas un nombre y una descripcion al azar y luego a cada enemigo se le denomina una unica habilidad
         */
        Enemigo Zombie = new Enemigo(nombresEnemigos.get(RandomizerDescripcionesYNombres()), descripcionesEnemigos.get(RandomizerDescripcionesYNombres()), 1, 110, 25, 10, 25, 100, "Normal", "Relentizar", tipoEnemigos.get(2));
        Enemigo HombreLobo = new Enemigo(nombresEnemigos.get(RandomizerDescripcionesYNombres()), descripcionesEnemigos.get(RandomizerDescripcionesYNombres()), 1, 110, 25, 10, 25, 100, "Normal", "Sangrar", tipoEnemigos.get(0));
        Enemigo Vampiro = new Enemigo(nombresEnemigos.get(RandomizerDescripcionesYNombres()), descripcionesEnemigos.get(RandomizerDescripcionesYNombres()), 1, 110, 25, 10, 25, 100, "Normal", "Araniar", tipoEnemigos.get(1));

        // Aqui se agregan los enemigos creados al contenedor ListaEnemigos
        ListaEnemigos.add(Zombie);
        ListaEnemigos.add(HombreLobo);
        ListaEnemigos.add(Vampiro);

    }

    /**
     *  Metodo que inicia el juego
     */
    @Override
    public void Iniciar()  {
        MenuPrincipal();
    }

    /**
     * Menu principal del juego
     */
    @Override
    public void MenuPrincipal() {
        // Aqui se le da al usuario 2 opciones, jugar o salir
        StdOut.println("----->ZENKAI GAMES PRESENTA<-----");
        StdOut.println("");
        StdOut.println("FINAL DUNGEONS");
        StdOut.println("");
        StdOut.println("[1] INICIAR JUEGO");
        StdOut.println("[2] SALIR");
        // Dependiendo de la opcion, se analiza lo ingresado por consola si lo que ingreso el usuario es valido
        // y luego de la validacion determina que hacer
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

    /**
     * Menu para la creacion del personaje
     */
    @Override
    public void CreacionPersonaje() {
        // Aqui se ingresa por consola el nombre que quiera el usuario
        StdOut.println("----->FINAL DUNGEONS<-----");
        StdOut.println("");
        StdOut.println("[*] CREACION DE PERSONAJE [*]");
        StdOut.println("");
        StdOut.println("INGRESE UN NOMBRE: ");
        String nombrePersonaje = StdIn.readString();

        // Aqui se ingresa por consola la descripcion que quiera el usuario
        StdOut.println("----->FINAL DUNGEONS<-----");
        StdOut.println("");
        StdOut.println("[*] CREACION DE PERSONAJE [*]");
        StdOut.println("");
        StdOut.println("INGRESE UNA DESCRIPCION: ");
        String descripcionPersonaje = StdIn.readString();

        // Aqui se escribe por consola la clase que escogera el usuario para iniciar el juego
        StdOut.println("----->FINAL DUNGEONS<-----");
        StdOut.println("");
        StdOut.println("[*] CREACION DE PERSONAJE [*]");
        StdOut.println("");
        StdOut.println(" ESCOJA UNA CLASE: (Escriba la clase que desea ocupar)");
        StdOut.println("Espadachin");
        StdOut.println("Arquero");
        StdOut.println("Mago");
        String claseEscogida = StdIn.readString();

        // Si los caracteres ingresados se parecen a Espadachin obtiene la habilidad de Ataque Doble
        if (claseEscogida.equalsIgnoreCase("Espadachin")){
            nuevoPersonaje = new Personaje(nombrePersonaje,descripcionPersonaje,1,100,20,10,17,0,"Normal","Ataque Doble");
            nuevaClase.add(nuevoPersonaje);
            StdOut.println("Personaje Creado, ¡que comienze la aventura!");
            FinalDungeons();
        }
        // Si los caracteres ingresados se parecen a Arquero obtiene la habilidad de Ataque Multiple
        if (claseEscogida.equalsIgnoreCase("Arquero")){
            nuevoPersonaje = new Personaje(nombrePersonaje,descripcionPersonaje,1,100,20,10,17,0,"Normal","Ataque Multiple");
            nuevaClase.add(nuevoPersonaje);
            StdOut.println("Personaje Creado, ¡que comienze la aventura!");
            FinalDungeons();
        }
        // Si los caracteres ingresados se parecen a Mago obtiene la habilidad de Regeneracion
        if (claseEscogida.equalsIgnoreCase("Mago")){
            nuevoPersonaje = new Personaje(nombrePersonaje,descripcionPersonaje,1,100,20,10,17,0,"Normal","Regeneracion");
            nuevaClase.add(nuevoPersonaje);
            StdOut.println("Personaje Creado, ¡que comienze la aventura!");
            FinalDungeons();
        }
        // Esto ocurre si es que no se ingresa lo que se pidio por pantalla
        else
        {
            StdOut.println("Error, ingrese una opcion correcta");
            CreacionPersonaje();
        }





    }

    /**
     * Metodo donde comienza el juego
     */
    @Override
    public void FinalDungeons() {
        boolean corriendo = true;

        // Mientras la condicion de corriendo siga en true, el juego seguira ejecutandose
        // para sacar esto nuestro personaje debe morir o encontrarse con el NPC y salir de la mazmorra
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
            // Aqui se le ofrece al usuario multiples decisiones acorde a lo que quiera hacer, puede inspeccionar la mazmorra,
            // ver sus estadisticas, avanzar o retroceder en la mazmorra y salir de la mazmorra
            try {
                String opcion = StdIn.readLine();
                int decision;
                if (isNumeric(opcion)) Integer.parseInt(opcion);
                decision = Integer.parseInt(opcion);
                switch (decision) {
                    // En el caso 1 el personaje decide explorar la mazmorra, donde pueden pasar 2 cosas
                    // entra en combate o se encuentra al NPC
                    case 1:
                        if (!explorado)
                        {

                            Inspeccionar();
                        }
                        // Esto pas cuando el combate o la interaccion del NPC finalizan
                        else {System.out.println("Ya exploraste la masmorra.");}
                        FinalDungeons();

                        break;

                    case 2:
                        // Llama al metodo VerPersonaje para mostrar las estadisticas actuales del personaje
                        VerPersonaje();
                        break;

                    case 3:
                        // Aqui dependiendo de si el personaje entro en combate o esta en el menu del juego pueden pasar
                        // 2 cosas, si el personaje no a peleado o hablado con el NPC no puede avanzar
                        // Y si ya hizo una de las 2 cosas entonces ahi recien se puede mover
                        if (!explorado)
                        {
                            System.out.println("No haz explorado la masmorra actual para poder subir.");
                        }
                        else
                        {
                            numeroMazmorra++;

                            if (numeroMazmorra == mazmorraActual){explorado = false;}
                            FinalDungeons();
                        }
                        break;
                    case 4:
                        // Este metodo sirve para retroceder de mazmorra, pero con la condicion de que
                        // si el personaje se encuentra en la mazmorra 1 no puede retroceder de esta
                        if (numeroMazmorra == 1)
                        {
                            System.out.println("Ya te encuentras en la primera mazmorra, no se puede volver mas.");
                            FinalDungeons();
                        }

                        else
                        {
                            numeroMazmorra--;
                            FinalDungeons();

                        }
                        break;
                    case 5:
                        // Esta opcion sirve para salir de la mazmorra y por ende, salir del juego
                        StdOut.println("Saliendo de la mazmorra");
                        System.exit(5);
                        break;
                    // Este metodo sirve por si el usuario no ingreso lo que se pedia por pantalla
                    default:
                        StdOut.println("Ingrese una opcion de la lista: ");
                        FinalDungeons();


                }
                // Este metodo sirve por si el usuario no ingreso los caracteres requeridos por pantalla
            } catch (Exception e) {
                StdOut.println("Ingrese una opción válida.");
                FinalDungeons();


            }
        }
    }

    /**
     * Metodo que se encarga de manera aleatoria poner o no enemigos en la mazmorra
     * @return la cantidad de enemigos que nos va a tocar en la mazmorra
     */
    @Override
    public int Inspeccionar()
    {
        int enemigos = Randomizer();
            switch (enemigos)
            {
                case 0:
                    InteractuarNPC(true);


                case 1:

                    Batalla(1);



                case 2:

                    Batalla(2);



                case 3:

                    Batalla(3);


            }
            return enemigos;

    }

    /**
     * Metodo que se encarga de mostrarnos los enemigos a combatir y las variadas opciones del personaje
     * @param enemigos cantidad de enemigos que nos otorga el sistema
     */
    @Override
    public void Batalla(int enemigos)
    {
        boolean batallando = true;

        System.out.println("¡Te haz encontrado "+enemigos+" enemigo/s, preparate!");
            while (batallando) {
                for (int i = 0; i < enemigos; i++) {
                    // Se muestra por pantalla cuantos enemigos, la vida, el nivel y el estado de el/los enemigos
                    System.out.println("*****ENEMIGO*****");
                    System.out.println("[*] Tipo: " + tipoEnemigos.get(RandomizerEnemigo()));
                    System.out.println("[*] Nivel:  " + ListaEnemigos.get(0).getNivel() + " " + nombresEnemigos.get(RandomizerDescripcionesYNombres()) + " " + descripcionesEnemigos.get(RandomizerDescripcionesYNombres()));
                    System.out.println("[*] Vida: " + ListaEnemigos.get(0).getVida());
                    System.out.println("[*] Estado:  " + ListaEnemigos.get(0).getEstado());
                    System.out.println(" ");
                    System.out.println(" ");
                }
                    // Se muestra por pantalla el nivel,vida y estado de nuestro personaje
                    System.out.println("*****TU*****");
                    System.out.println("[*] Nivel: " + nuevoPersonaje.getNivel() + " " + nuevoPersonaje.getNombre() + " " + nuevoPersonaje.getDescripcion());
                    System.out.println("[*] Vida: " + nuevoPersonaje.getVida());
                    System.out.println("[*] Estado: " + nuevoPersonaje.getEstado());
                    System.out.println(" ");
                    System.out.println(" ");

                    //Aqui se calcula dependiendo de la velocidad del enemigo y del jugador quien empieza la batalla primero
                if (nuevoPersonaje.getVelocidad() > ListaEnemigos.get(0).getVelocidad()) {
                    StdOut.println("¿Que deseas hacer?");
                    System.out.println("[1] Atacar");
                    System.out.println("[2] Usar el ataque especial");
                    System.out.println("[3] Defender");

                    int opcion = StdIn.readInt();

                    switch (opcion) {
                        case 1:
                            calculoFinal(1);

                        case 2:
                            calculoFinal(2);

                        case 3:
                            calculoFinal(3);

                        default:
                            StdOut.println("Error, ingrese una opcion correcta");
                    }


                } else {
                    // Aqui de manera aleatoria ocurren las decisiones de que hara el enemigo en el combate
                    int decisionEnemigo = RandomizerEnemigo();

                    if (decisionEnemigo == 1) {
                        AtacarEnemigo();

                    }
                    if (decisionEnemigo == 2) {
                        AtaqueEspecialEnemigo();

                    }
                    if (decisionEnemigo == 3) {
                        StdOut.println("Él enemigo a bloqueado tu ataque");

                    } else {
                        StdOut.println("");
                        FinalDungeons();
                    }
                }
                // Aqui pueden pasar 2 cosas, el enemigo muere y continua el juego o el personaje muere y se tendra que iniciar de nuevo la mazmorra
                if (ListaEnemigos.get(0).getVida()==0){
                    batallando=false;
                    StdOut.println("Haz derrotado a los enemigos, ¿que haras ahora?");
                    System.out.println(" ");
                    FinalDungeons();
                }
                else if (nuevoPersonaje.getVida()==0){
                    batallando=false;
                    StdOut.println("Te han derrotado en combate");
                    Salir();
                }

            }

    }

    /**
     * Metodo que calcular los danios que nuestro personaje le hace a los enemigos
     * @param opcion es lo que el usuario ingresa a la hora de combatir
     */
    public void calculoFinal(int opcion)
    {
        switch (opcion)
        {
            case 1:

            int danio = nuevoPersonaje.getAtaque();
            int vidaEnemigo = ListaEnemigos.get(0).getVida() - danio;
            if (vidaEnemigo <= 0)
                {
                    ListaEnemigos.get(0).setVida(vidaEnemigo);
                    System.out.println("Haz derrotado al enemigo!");
                    FinalDungeons();
                    break;
                }
            ListaEnemigos.get(0).setVida(vidaEnemigo);
            calculoFinalEnemigo(RandomizerEnemigo());



            case 2:
                danio = nuevoPersonaje.getAtaque();
                vidaEnemigo = ListaEnemigos.get(0).getVida() - danio;
                if (vidaEnemigo <= 0)
                {
                    System.out.println("Haz derrotado al enemigo");
                    FinalDungeons();
                    break;
                }
                calculoFinalEnemigo(RandomizerEnemigo());

            case 3:
                calculoFinalEnemigo(0);
                break;
        }


    }

    /**
     * Metodo que calcular los danios que el enemigo le hace al personaje
     * @param opcion es lo que hara el enemigo 
     */
    public void calculoFinalEnemigo(int opcion)
    {
        switch (opcion)
        {
            case 0:
                System.out.println("El enemigo ataco pero no pudo romper tus defensas! ");
            case 1:
                int danio = AtacarEnemigo();
                int vidaJugador = nuevoPersonaje.getVida() - danio;
                if (vidaJugador <= 0)
                {
                    System.out.println("Te han derrotado!");
                    Salir();
                    break;
                }
                Batalla(3);



            case 2:
                AtaqueEspecialEnemigo();
                vidaJugador = nuevoPersonaje.getVida();
                if (vidaJugador <= 0)
                {
                    System.out.println("Te han derrotado!");
                    Salir();
                    break;
                }
                Batalla(3);

            case 3:
                System.out.println("Él enemigo desvio tu ataque");
                Batalla(3);
        }


    }

    /**
     * VerPersonaje es el metodo que permite ver las estadisticas de nuestro personaje
     * Si el personaje sube de nivel estas estadisticas cambiaran de acuerdo a la experiencia obtenida durante el juego
     */
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

    /**
     * Este metodo determina por chance si es que nos toca el NPC en una mazmorra, el cual nos otorga
     * experiencia por encontrarlo
     * @param NPC es la variable que va dependiendo de la cantida de enemigos dentro de la mazmorra
     */
    @Override
    public void InteractuarNPC(boolean NPC)
    {
        int extraEXP = 0;
        explorado = true;

        if (NPC = true)
        {
            mazmorraActual++;

            nuevoPersonaje.setExperiencia(nuevoPersonaje.getExperiencia()+100);
            if (nuevoPersonaje.getExperiencia() >= 300 && nuevoPersonaje.getNivel() == 1){SubirDeNivel();}
            if (nuevoPersonaje.getExperiencia() >= 750 && nuevoPersonaje.getNivel() == 2){SubirDeNivel();}
            if (nuevoPersonaje.getExperiencia() >= 1250 && nuevoPersonaje.getNivel() == 3){SubirDeNivel();}
            System.out.println("Hola, no hay nadie por aca y estaba esperando a alguien");
            FinalDungeons();
        }

        else
        {

            System.out.println("No parece haber reaccion");
            mazmorraActual++;
            FinalDungeons();

        }

    }


    /**
     * Este metodo determina la especialidad de nuestro personaje a la hora de enfrentar a los 3 tipos de enemigos dentro de la mazmorra
     */
    @Override
    public void AtacarPersonaje() {


       if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Doble Ataque") && ListaEnemigos.equals("Hombre Lobo")){
           nuevoPersonaje.setAtaque(nuevoPersonaje.getAtaque()*4);
       }
        if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Doble Ataque") && ListaEnemigos.equals("Zombie")){
            nuevoPersonaje.setAtaque(nuevoPersonaje.getAtaque()*2);
        }

        if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Ataque Multiple") && ListaEnemigos.equals("Vampiro")){
            nuevoPersonaje.setAtaque(nuevoPersonaje.getAtaque()*4);
        }
        if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Ataque Multiple") && ListaEnemigos.equals("Hombre Lobo")){
            nuevoPersonaje.setAtaque(nuevoPersonaje.getAtaque()*2);
        }

        if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Regeneracion") && ListaEnemigos.equals("Zombie")){
            nuevoPersonaje.setAtaque(nuevoPersonaje.getAtaque()*4);
        }
        if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Regeneracion") && ListaEnemigos.equals("Vampiro")){
            nuevoPersonaje.setAtaque(nuevoPersonaje.getAtaque()*2);
        }


    }

    /**
     * Este metodo sirve para realizar el calculo que le quita vida a nuestro personaje
     * @return la vida del personaje con el danio del enemigo incluido
     */
    @Override
    public int AtacarEnemigo() {
        int vidaPersonaje = 0;
        vidaPersonaje = vidaPersonaje - (ListaEnemigos.get(0).getAtaque()-nuevoPersonaje.getDefensa());
        return vidaPersonaje;
    }

    /**
     * Este metodo sirve para ocupar la habilidad especial de nuestro personaje, dependiendo de que clase
     * escoja el usuario al momento de jugar
     */
    @Override
    public void AtaqueEspecialPersonaje() {

        if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Doble Ataque")){
            nuevoPersonaje.setAtaque(nuevoPersonaje.getAtaque()*2);
        }
        if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Ataque Multiple")){
            nuevoPersonaje.setAtaque(nuevoPersonaje.getAtaque()*2);
        }

        if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Regeneracion")){
            Efectos(1);
        }

    }

    /**
     * Aqui estan los ataques especiales del enemigo que dependen del tipo de enemigo que nos
     * enfrentemos en la mazmorra
     * @return
     */
    @Override
    public int AtaqueEspecialEnemigo() {
        String SP = ListaEnemigos.get(0).getAtaqueEspecial();
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

    /**
     * Aqui estan los efectos que pueden afectar a nuestro personaje ya sean positivos o negativos
     * @param efecto dependiendo del caso se determina que efecto se le aplicara al personaje
     * @return retorna el efecto que afectara al personaje
     */
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

        return efecto;
    }


    /**
     * Salir es un metodo que nos permite salirnos de la mazmorra
     */
    @Override
    public void Salir() {
        System.exit(2);
    }

    /**
     * Este metodo permite al personaje subir de nivel y por ende las estadisticas del personaje dependiendo del nivel
     */
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

    /**
     * Metodo que sirve para dar un numero al azar que va desde el 0 al 3
     * @return retorna un numero al azar
     */
    public static int Randomizer()
    {
        int randomNumber = ThreadLocalRandom.current().nextInt(0,   4);
        return randomNumber;
    }

    /**
     * Metodo que sirve para dar un numero al azar que va desde el 0 al 3 utilizado para invocar enemigos al azar
     * @return retorna un numero al azar
     */
    public int RandomizerEnemigo()
    {
        int randomNumber = ThreadLocalRandom.current().nextInt(1,   4);
        return randomNumber;
    }

    /**
     * Metodo que devuelve un numero
     * @return
     */
    public static int RandomizerDescripcionesYNombres()
    {
        int randomNumber = ThreadLocalRandom.current().nextInt(0,   6);
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






}
