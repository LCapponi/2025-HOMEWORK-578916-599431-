package it.uniroma3.diadia.comandi;
import it.uniroma3.diadiaa.Partita;
import it.uniroma3.diadiaa.IO;
import it.uniroma3.diadiaa.IOConsole;
public interface Comando {
	
	
    public void esegui(Partita partita);

    /**
     * set parametro del comando
     */
    public void setParametro(String parametro);

    /**
     * set console del comando
     */
    public void setIOConsole(IO ioconsole);
}