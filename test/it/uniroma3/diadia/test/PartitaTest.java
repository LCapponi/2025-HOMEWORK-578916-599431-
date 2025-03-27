package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.Partita;


class PartitaTest {
	Partita partita;
	Stanza atrio;
	Stanza biblioteca;
    Stanza laboratorio;
    
@BeforeEach
void setUp() {
	partita=new Partita();
	atrio=this.partita.getStanzaCorrente();
	laboratorio=atrio.getStanzaAdiacente("ovest");
	biblioteca=atrio.getStanzaAdiacente("nord");
}



	@Test
	void verificaGetStanzaVincente() {
		assertEquals(biblioteca,partita.getStanzaVincente());
	}
	@Test
	void verificaGetStanzaCorrente() {
		assertEquals(atrio,partita.getStanzaCorrente());
	}
	@Test
	void verificaGetStanzaAdiacente() {
		assertEquals(atrio.getStanzaAdiacente("ovest"),laboratorio);
	}
}
