package it.uniroma3.diadia.giocatore;

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;


	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa=new Borsa();
		
	}
	public int getCfu() {
		return this.cfu;
	}
	
    public void togliUnCfu() {
    	this.cfu--;
    }
    
    public boolean hasZeroCfu() {
    	return this.cfu <= 0;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Giocatore con " + this.cfu + " cfu");
        s.append("\n");
        s.append(borsa);
        return s.toString();
    }
}

