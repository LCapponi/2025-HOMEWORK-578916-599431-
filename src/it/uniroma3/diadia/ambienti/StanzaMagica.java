package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;


class StanzaMagica extends Stanza  {
	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;

	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if (this.contatoreAttrezziPosati >SOGLIA_MAGICA_DEFAULT)
			attrezzo = this.modificaAttrezzo(attrezzo);
		
		
		if (this.numeroAttrezzi < this.attrezzi.length) {
			this.attrezzi[this.numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			return true;

		} else
			return false;

	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		
		String nomeInvertito = new StringBuilder(attrezzo.getNome()).reverse().toString();
		int pesoRaddoppiato = attrezzo.getPeso() * 2;
		return new Attrezzo(nomeInvertito, pesoRaddoppiato);
	}
}