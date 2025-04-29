package it.uniroma3.diadia.comandi;
import it.uniroma3.diadiaa.Partita;
import it.uniroma3.diadiaa.IO;
import it.uniroma3.diadiaa.IOConsole;
public class ComandoFine implements Comando {

	private IO ioConsole;

	@Override
	public void esegui(Partita partita ) {
		ioConsole.mostraMessaggio("Grazie per aver giocato");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIOConsole(IO ioconsole) {
		// TODO Auto-generated method stub
		
	}
}
