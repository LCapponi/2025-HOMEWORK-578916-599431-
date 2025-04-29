package it.uniroma3.diadia.test;
import it.uniroma3.diadia.giocatore.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GiocatoreTest {
	private Giocatore giocatore;
	private int CFU_INIZIALI=20;


@BeforeEach
	public void SetUp() {
	giocatore=new Giocatore();
	}
@Test
public void TestGetCFU() {
	assertEquals(CFU_INIZIALI,giocatore.getCfu());
}
}
