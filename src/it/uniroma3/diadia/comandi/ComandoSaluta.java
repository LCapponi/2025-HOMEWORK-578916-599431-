package it.uniroma3.diadia.comandi;

import it.uniroma3.diadiaa.IO;
import it.uniroma3.diadiaa.Partita;

public class ComandoSaluta extends AbstractComando {

	private IO io;
	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getPersonaggio()!=null)
			io.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().saluta());
		else 
			io.mostraMessaggio("Non c'e' alcun personaggio in questa stanza!");
	}
	
	@Override
	public void setIo(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}
}