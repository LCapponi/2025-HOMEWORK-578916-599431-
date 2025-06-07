package it.uniroma3.diadia.comandi;

import it.uniroma3.diadiaa.IO;
import it.uniroma3.diadiaa.Partita;
public class ComandoAiuto extends AbstractComando {

    static final public String[] ELENCO_COMANDI = {"vai", "aiuto", "fine","prendi", "posa", "guarda","saluta","interagisci","regala"};
    
    private final static String NOME = "aiuto";
    
    private IO io;  // campo per tenere l'istanza di IO

    @Override
    public void esegui(Partita partita) {
        for(int i=0; i< ELENCO_COMANDI.length; i++) 
            this.io.mostraMessaggio(ELENCO_COMANDI[i]+" ");
        this.io.mostraMessaggio("");
    }

    @Override
    public String getNome() {
        return NOME;
    }

    @Override
    public void setIo(IO io) {
        this.io = io;
    }

    @Override
    public IO getIo() {
        return this.io;
    }
}