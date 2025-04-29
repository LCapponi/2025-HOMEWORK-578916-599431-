package it.uniroma3.diadia.test;
import it.uniroma3.diadiaa.Partita;
import it.uniroma3.diadia.comandi.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadiaa.IOConsole;
public class ComandoAiutotest {
	private Partita partita;
    private ComandoAiuto comandoAiuto;
    private IOConsole ioconsole;
	@BeforeEach
	void SetUp() {
		this.partita=new Partita();
		this.comandoAiuto= new ComandoAiuto();
		this.ioconsole=new IOConsole();
	}
	@Test
	public void Testaiuto() {
		assertDoesNotThrow(()-> comandoAiuto.esegui(partita));
	}
	
}
