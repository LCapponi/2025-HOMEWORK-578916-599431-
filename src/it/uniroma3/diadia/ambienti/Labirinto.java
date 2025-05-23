package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	public Stanza StanzaCorrente;
	public Stanza StanzaVincente;

	public Labirinto() {
		this.creaStanze();
	}

	public void creaStanze() {

		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna", 3);
		Attrezzo osso = new Attrezzo("osso", 1);
		Attrezzo spada = new Attrezzo("spada", 5);
		Attrezzo arco = new Attrezzo("arco", 3);
		Attrezzo scudo = new Attrezzo("scudo", 6);
		Attrezzo ppt = new Attrezzo("passepartout", 4);

		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");

		/* STANZE SPECIALI */
		Stanza labIA = new StanzaMagica("LabIA");
		Stanza magazzino = new StanzaBuia("magazzino");
		Stanza presidenza = new StanzaBloccata("presidenza");

		/* collega le stanze */
		laboratorio.impostaStanzaAdiacente("nord", null);
		laboratorio.impostaStanzaAdiacente("sud",   labIA  );
		laboratorio.impostaStanzaAdiacente("est",   atrio  );
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		
		atrio  .impostaStanzaAdiacente("nord",  biblioteca);
		atrio  .impostaStanzaAdiacente("sud",   magazzino  );
		atrio  .impostaStanzaAdiacente("est",   aulaN11);
		atrio  .impostaStanzaAdiacente("ovest", laboratorio);
		
		aulaN11.impostaStanzaAdiacente("nord", null);
		aulaN11.impostaStanzaAdiacente("sud",   presidenza  );
		aulaN11.impostaStanzaAdiacente("est",   laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio  );
		
		labIA  .impostaStanzaAdiacente("nord",  laboratorio);
		labIA  .impostaStanzaAdiacente("sud",   aulaN10);
		labIA   .impostaStanzaAdiacente("est",  magazzino  );
		labIA  .impostaStanzaAdiacente("ovest", presidenza  );
		
		magazzino  .impostaStanzaAdiacente("nord",  atrio  );
		magazzino  .impostaStanzaAdiacente("sud",   aulaN10);
		magazzino  .impostaStanzaAdiacente("est",   presidenza  );
		magazzino  .impostaStanzaAdiacente("ovest", labIA  );
		
		presidenza  .impostaStanzaAdiacente("nord",  aulaN11);
		presidenza  .impostaStanzaAdiacente("sud",   aulaN10);
		presidenza  .impostaStanzaAdiacente("est",   labIA  );
		presidenza  .impostaStanzaAdiacente("ovest", magazzino  );
		
		aulaN10.impostaStanzaAdiacente("nord",  magazzino  );
		aulaN10.impostaStanzaAdiacente("sud",   null);
		aulaN10.impostaStanzaAdiacente("est",   presidenza  );
		aulaN10.impostaStanzaAdiacente("ovest", labIA  );
		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		laboratorio.addAttrezzo(spada);
		aulaN11.addAttrezzo(scudo);
		biblioteca.addAttrezzo(arco);
		laboratorio.addAttrezzo(ppt);
		
		this.StanzaCorrente = atrio;
		this.StanzaVincente = biblioteca;

	}

	public void setStanzaCorrente(Stanza StanzaCorrente) {

		this.StanzaCorrente = StanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return StanzaCorrente;
	}

	public Stanza getStanzaVincente() {
		return StanzaVincente;

	}
}
