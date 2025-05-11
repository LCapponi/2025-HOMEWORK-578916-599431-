package it.uniroma3.diadia.comandi;

import java.util.Scanner;
import it.uniroma3.diadiaa.IO;
import it.uniroma3.diadiaa.IOConsole;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	private IO ioconsole;

	public FabbricaDiComandiFisarmonica() {
		this.ioconsole = new IOConsole(); // default
	}

	public FabbricaDiComandiFisarmonica(IO ioconsole2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Comando costruisciComando(String istruzione) {
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		if (istruzione != null) {
			Scanner scanner = new Scanner(istruzione);
			if (scanner.hasNext())
				nomeComando = scanner.next();
			if (scanner.hasNext())
				parametro = scanner.next();

			if (nomeComando == null)
				comando = new ComandoNonValido();

			else if (nomeComando.equals("vai"))
				comando = new ComandoVai();

			else if (nomeComando.equals("prendi"))
				comando = new ComandoPrendi();

			else if (nomeComando.equals("posa"))
				comando = new ComandoPosa();

			else if (nomeComando.equals("fine"))
				comando = new ComandoFine();

			else if (nomeComando.equals("aiuto"))
				comando = new ComandoAiuto();
			else if (nomeComando.equals("guarda"))
				comando = new ComandoGuarda();
			else
				comando = new ComandoNonValido();
		}
		comando.setParametro(parametro);
		comando.setIOConsole(ioconsole);
return comando;
	}

}
