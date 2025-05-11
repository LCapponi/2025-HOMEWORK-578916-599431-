package it.uniroma3.diadia.comandi;

import it.uniroma3.diadiaa.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadiaa.IO;
import it.uniroma3.diadiaa.IOConsole;

public class ComandoVai implements Comando {
	private String direzione;
	private IO ioconsole;

	public ComandoVai() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		if (this.direzione == null) {
			this.ioconsole.mostraMessaggio("Dove vuoi andare? Specifica una direzione");
			return;
		}
		Stanza prossimaStanza = null;
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) {
			this.ioconsole.mostraMessaggio("Direzione inesistente");
		} else {
			partita.setStanzaCorrente(prossimaStanza);
			this.ioconsole.mostraMessaggio(prossimaStanza.getDescrizione());
			partita.getGiocatore().togliUnCfu();
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	/*
	 * impostazione della console
	 */
	@Override
	public void setIOConsole(IO ioconsole) {
		this.ioconsole = ioconsole;
	}
}