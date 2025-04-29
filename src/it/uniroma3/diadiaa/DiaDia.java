package it.uniroma3.diadiaa;

import it.uniroma3.diadiaa.IO;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadiaa.IOConsole;
import java.util.Scanner;
import it.uniroma3.diadia.giocatore.*;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author docente di POO (da un'idea di Michael Kolling and David J. Barnes)
 * 
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""
			+ "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
			+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
			+ "I locali sono popolati da strani personaggi, " + "alcuni amici, altri... chissa!\n"
			+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
			+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
			+ "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
			+ "Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = { "vai", "prendi", "posa", "aiuto", "fine", "guarda" };

	private Partita partita;
	private IO ioconsole;
	private FabbricaDiComandi fabbrica;
	private int cfu;

	public DiaDia(IO ioconsole) {
		this.partita = new Partita();
		this.fabbrica = new FabbricaDiComandiFisarmonica();
		this.ioconsole = ioconsole;
	}

	public void gioca() {
		String istruzione;

		this.ioconsole.mostraMessaggio(MESSAGGIO_BENVENUTO);
		this.stampa_stato_partita();
		do
			istruzione = this.ioconsole.leggiRiga();
		while (!processaIstruzione(istruzione));
	}

	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false
	 *         altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandodaeseguire = fabbrica.costruisciComando(istruzione);
		comandodaeseguire.setIOConsole(ioconsole);
		comandodaeseguire.esegui(partita);

		if (partita.isFinita()) {
			if (partita.vinta())
				ioconsole.mostraMessaggio("Hai vinto");
			if (partita.getCfu() == 0)
				ioconsole.mostraMessaggio("Hai perso,finiti i cfu ");
			this.ioconsole.mostraMessaggio("Grazie di aver giocato!");
			return true;
		}
		
		return false;

	}

	private void stampa_stato_partita() {
		this.ioconsole.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
		this.ioconsole.mostraMessaggio(this.partita.getGiocatore().toString());

	}

	public static void main(String[] argc) {
		IO ioconsole = new IOConsole();
		DiaDia gioco = new DiaDia(ioconsole);
		gioco.gioca();
	}

}