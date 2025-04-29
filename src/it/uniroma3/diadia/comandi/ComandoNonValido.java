package it.uniroma3.diadia.comandi;

import it.uniroma3.diadiaa.IO;
import it.uniroma3.diadiaa.Partita;

public class ComandoNonValido implements Comando{
private IO ioConsole;
	@Override
	public void esegui(Partita partita) {
			ioConsole.mostraMessaggio("Il comando non è valido riprova");
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIOConsole(IO ioconsole) {
		  this.ioConsole = ioconsole;
		
	}

}
