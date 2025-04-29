package it.uniroma3.diadia.test;
import it.uniroma3.diadiaa.IOConsole;
import it.uniroma3.diadiaa.Partita;
import it.uniroma3.diadia.comandi.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;






public class TestComandoPrendi {
	private Partita partita;
    private ComandoPrendi comandoprendi;
    private Giocatore giocatore;
    private Attrezzo attrezzo;
    private IOConsole ioconsole;
	@BeforeEach
	void SetUp() {
		this.partita=new Partita();
		this.ioconsole=new IOConsole();
		giocatore=partita.getGiocatore();
		
		this.comandoprendi= new ComandoPrendi("spada",partita);
		
		this.attrezzo=new Attrezzo("spada",1);
	    partita.getStanzaCorrente().addAttrezzo(attrezzo);
	}
	@Test
	void testEsegui() {
		comandoprendi.esegui(partita);
		
		  assertTrue(giocatore.hasAttrezzo("spada"));
	        
	        // Verifica che l'attrezzo sia stato rimosso dalla stanza
	        assertNull(partita.getStanzaCorrente().getAttrezzo("spada"));
	}
}
