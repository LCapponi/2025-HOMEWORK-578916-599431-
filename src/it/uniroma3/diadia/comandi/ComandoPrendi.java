package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadiaa.Partita;
import it.uniroma3.diadiaa.IO;
import it.uniroma3.diadiaa.IOConsole;

public class ComandoPrendi implements Comando {

	private String nomeAttrezzo;
	private IO ioConsole;

	public ComandoPrendi(String nomeAttrezzo, Partita partita) {
		this.nomeAttrezzo = nomeAttrezzo;
	
	}

	public ComandoPrendi() {
		// TODO Auto-generated constructor stub
	}

	public void esegui(Partita partita) {
		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);

		if (attrezzo != null) {
			if (partita.getGiocatore().addAttrezzo(attrezzo)) {
				partita.getStanzaCorrente().removeAttrezzo(attrezzo);
				ioConsole.mostraMessaggio("Hai preso l'attrezzo: " + nomeAttrezzo);
			} else {
				ioConsole.mostraMessaggio("La borsa è piena, non puoi prendere l'attrezzo.");
			}
		} else if (nomeAttrezzo != null) {
			ioConsole.mostraMessaggio("Non c'è nessun attrezzo con il nome " + nomeAttrezzo + " nella stanza.");
		} else {
			ioConsole.mostraMessaggio("Seleziona un attrezzo!");
		}
	}

	@Override
	public void setParametro(String parametro) {
	    this.nomeAttrezzo = parametro;

	}

	@Override
	public void setIOConsole(IO ioconsole) {
	    this.ioConsole = ioconsole;
	}

}
