package it.uniroma3.diadia.test;

import it.uniroma3.diadiaa.IOConsole;
import it.uniroma3.diadiaa.Partita;
import it.uniroma3.diadia.comandi.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPosaTest {

	private Partita partita;
	private ComandoPosa comandoPosa;
	private Giocatore giocatore;
	private Attrezzo spada;
	private IOConsole ioconsole;

	@BeforeEach
	void SetUp() {
		this.partita = new Partita();
		this.ioconsole = new IOConsole();
		giocatore = partita.getGiocatore();
		this.spada = new Attrezzo("spada", 1);
		
		this.comandoPosa = new ComandoPosa();

		

		
	}

	@Test
	void testEsegui() {
		comandoPosa.esegui(partita);

		assertFalse(giocatore.hasAttrezzo("spada"));

		assertNotNull(partita.getStanzaCorrente().getAttrezzo("spada"));
	}
}
