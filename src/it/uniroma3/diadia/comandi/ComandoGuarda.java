package it.uniroma3.diadia.comandi;

import it.uniroma3.diadiaa.IO;
import it.uniroma3.diadiaa.Partita;


public class ComandoGuarda extends AbstractComando {

    private final static String NOME = "guarda";
    private IO io;  // campo per tenere riferimento all'IO

    @Override
    public void esegui(Partita partita) {
        this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
        this.io.mostraMessaggio("Hai ancora: " + partita.getGiocatore().getCfu() + " CFU");
        this.io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
    }

    @Override
    public String getNome() {
        return NOME;
    }

    @Override
    public void setIo(IO io) {
        this.io = io;
    }

    public IO getIo() {
        return this.io;
    }
}