/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pkg3enraya.Jugador;
import pkg3enraya.TresEnRaya;

/**
 *
 * @author Rafa
 */
public class NewEmptyJUnitTest {

    public NewEmptyJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void devuelveTrueSiSeHaIntroducidoBien() {

        TresEnRaya tres = new TresEnRaya();
        tres.leerFichero();
        int cantidadAntes = tres.getJugadores().size();
        Jugador jugador = new Jugador("Rosendo", 45, "rosen");
        tres.añadirJugador(jugador);
        int cantidadDespues = tres.getJugadores().size();

        assertEquals(true, cantidadAntes < cantidadDespues);

    }

    @Test
    public void devuelveTrueSiYaExisteUnUsuarioConNombre() {

        TresEnRaya tres = new TresEnRaya();
        tres.leerFichero();
        Jugador jugador = new Jugador("Rafa", 45, "rosen");

        assertEquals(true, tres.comprobarExisteJugador(jugador));

    }

    @Test
    public void devuelveFalsoSiNoExisteUnUsuarioConNombre() {

        TresEnRaya tres = new TresEnRaya();
        tres.leerFichero();
        Jugador jugador = new Jugador("Joselino", 45, "rosen");

        assertEquals(false, tres.comprobarExisteJugador(jugador));

    }

    
    @Test
    public void devuelveFalseSiNoSeHaIntroducidoBien() {

        TresEnRaya tres = new TresEnRaya();
        tres.leerFichero();
        int cantidadAntes = tres.getJugadores().size();
        Jugador jugador = new Jugador("", 45, "rosen");
        tres.añadirJugador(jugador);
        int cantidadDespues = tres.getJugadores().size();


        assertEquals(false, cantidadAntes < cantidadDespues);
        

    }
    
    
}
