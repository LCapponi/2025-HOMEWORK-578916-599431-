package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.*;




public class StanzaTest {

    private Stanza stanza;
    private Attrezzo attrezzo;

    @BeforeEach
    void setUp() {
        // Prima di ogni test, creiamo una nuova stanza e un attrezzo
        stanza = new Stanza("Biblioteca");
        attrezzo = new Attrezzo("Libro", 1);
    }

    @Test
    void testAddAttrezzo() {
        assertTrue(stanza.addAttrezzo(attrezzo), "L'attrezzo non è stato aggiunto correttamente");
        System.out.println("Attrezzi presenti: " + java.util.Arrays.toString(stanza.getAttrezzi())); // Debug
        assertTrue(stanza.hasAttrezzo("Libro"), "hasAttrezzo non trova l'attrezzo appena aggiunto");
    }

    @Test
    void testGetStanzaAdiacente() {
        // Test per impostare e ottenere una stanza adiacente
        Stanza stanzaVicina = new Stanza("Corridoio");
        stanza.impostaStanzaAdiacente("nord", stanzaVicina);
        
        // Verifica che la stanza adiacente sia quella corretta
        assertEquals(stanzaVicina, stanza.getStanzaAdiacente("nord"));
    }

    @Test
    void testHasAttrezzo() {
        // Test per verificare se un attrezzo è presente nella stanza
        stanza.addAttrezzo(attrezzo);
        assertTrue(stanza.hasAttrezzo("Libro"));
        assertFalse(stanza.hasAttrezzo("Chiave"));
    }
}