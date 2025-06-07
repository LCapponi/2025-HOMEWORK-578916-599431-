package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadiaa.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {

    private static final String MESSAGGIO_SALUTATA = "Solo perche' mi hai salutato, non ti mando in uno scantinato!";
    private static final String MESSAGGIO_NON_SALUTATA = "Sei proprio una brutta persona, vai nella stanza con meno attrezzi!";

    public Strega(String nome, String presentazione) {
        super(nome, presentazione);
    }

    @Override
    public String agisci(Partita partita) {
    	
        String msg;

        // Prendi le stanze adiacenti della stanza corrente (metodo corretto getStanzeAdiacenti())
        List<Stanza> stanzeAdiacenti = partita.getStanzaCorrente().getStanzeAdiacenti();

        // Inizializzo max e min con la prima stanza valida
        Stanza maxAttrezzi = null;
        Stanza minAttrezzi = null;

        // Trova la stanza con max e min attrezzi
        for (Stanza s : stanzeAdiacenti) {
            if (s != null) {
                if (maxAttrezzi == null || s.getAttrezzi().size() > maxAttrezzi.getAttrezzi().size()) {
                    maxAttrezzi = s;
                }
                if (minAttrezzi == null || s.getAttrezzi().size() < minAttrezzi.getAttrezzi().size()) {
                    minAttrezzi = s;
                }
            }
        }

        if (this.haSalutato()) {
            partita.setStanzaCorrente(maxAttrezzi);
            msg = MESSAGGIO_SALUTATA;
        } else {
            partita.setStanzaCorrente(minAttrezzi);
            msg = MESSAGGIO_NON_SALUTATA;
        }

        return msg;
    }

    @Override
    public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
    	  if (attrezzo == null) {
    	        return "Vuoi ingannarmi con un regalo fantasma? Sciocco mortale!";
    	    }
    	    return "AHAHAHAHAHAHHA, ti sei liberato di " + attrezzo.getNome() + ", ora è mio!";
    	}
        
    }


