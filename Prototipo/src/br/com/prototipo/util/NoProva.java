package br.com.prototipo.util;

import br.com.prototipo.domain.dto.ProvaDTO;

public class NoProva {
	private ProvaDTO data;
	private NoProva next;

	public NoProva(ProvaDTO d) {
		this.data = d;
		this.next = null;
	}

	public ProvaDTO getData() {
		return data;
	}

	public void setData(ProvaDTO data) {
		this.data = data;
	}

	public NoProva getNext() {
		return next;
	}

	public void setNext(NoProva next) {
		this.next = next;
	}

}