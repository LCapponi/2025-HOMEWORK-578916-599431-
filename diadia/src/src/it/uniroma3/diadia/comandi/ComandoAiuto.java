package it.uniroma3.diadia.comandi;
import it.uniroma3.diadiaa.Partita;
import it.uniroma3.diadiaa.IO;
import it.uniroma3.diadiaa.IOConsole;

public class ComandoAiuto implements Comando {
	
	private static final String[] elencoComandi={"Vai","prendi","posa","aiuto","fine"};

	private IO ioConsole;
	
	 @Override
public void esegui(Partita partita  ) {
		for(String coso:elencoComandi) {
			ioConsole.mostraMessaggio(""+ coso);
		}
	     ioConsole.mostraMessaggio("");
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