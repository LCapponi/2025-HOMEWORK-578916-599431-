package it.uniroma3.diadia.comandi;
import it.uniroma3.diadiaa.IO;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadiaa.IOConsole;
import it.uniroma3.diadiaa.Partita;

public class ComandoPosa implements Comando {

	private String nomeAttrezzo;
	private IO ioConsole;
	
	

	public ComandoPosa() {
		// TODO Auto-generated constructor stub
	}

	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			ioConsole.mostraMessaggio("Quale Attrezzo vuoi posare");
			return;
			
		}
		Attrezzo attrezzo=null;
		attrezzo=partita.getGiocatore().getAttrezzo(nomeAttrezzo);
		
		if (attrezzo == null) {
	        ioConsole.mostraMessaggio("Non hai questo attrezzo nella borsa.");
	        return;
	}
		   boolean aggiunto = partita.getStanzaCorrente().addAttrezzo(attrezzo);

		    if (aggiunto) {
		        partita.getGiocatore().removeAttrezzo(attrezzo.getNome());
		        ioConsole.mostraMessaggio("Hai posato l'attrezzo: " + attrezzo.getNome());
		    } else {
		        ioConsole.mostraMessaggio("Non puoi posare l'attrezzo: stanza piena.");
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
