package br.com.prototipo.main;

import java.io.IOException;

import br.com.prototipo.util.ListaEncadeadaProva;
import br.com.prototipo.util.ManipuladorArquivo;
import br.com.prototipo.view.TelaDeLogin;

public class Main {

	public static void main(String[] args) throws IOException {
		TelaDeLogin login = new TelaDeLogin();
		login.setVisible(true);
	}
}
