package it.uniroma3.diadia.comandi;

import it.uniroma3.diadiaa.IO;
import it.uniroma3.diadiaa.Partita;
import it.uniroma3.diadiaa.IOConsole;

public class ComandoGuarda implements Comando {
	private IO ioconsole;

	@Override
	public void esegui(Partita partita) {
		this.ioconsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.ioconsole.mostraMessaggio(partita.getGiocatore().toString());
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public void setIOConsole(IO ioconsole) {
		 this.ioconsole = ioconsole;
	}
}
