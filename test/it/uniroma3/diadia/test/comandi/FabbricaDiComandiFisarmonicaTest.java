package it.uniroma3.diadia.test.comandi;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadiaa.IO;
import it.uniroma3.diadiaa.IOConsole;

public class FabbricaDiComandiFisarmonicaTest {
    FabbricaDiComandi fab;

    @BeforeEach
    private void setup() {
        IO ioconsole = new IOConsole();
        this.fab = new FabbricaDiComandiFisarmonica(ioconsole);
    }

    @Test
    private void crea_un_comando() {
        Comando com = fab.costruisciComando("abc def ghi");
        assertNotNull(com, "non sono riuscito a creare un comando con la fabbrica");
    }
}