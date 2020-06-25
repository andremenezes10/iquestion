package br.com.prototipo.util;

import br.com.prototipo.domain.dto.ProvaDTO;
import br.com.prototipo.exception.ErroException;

public class ListaEncadeadaProva {

	private NoProva head, tail;
	private int size = 1;

	public ListaEncadeadaProva() {
	}

	public void add(ProvaDTO element, int position) throws ErroException {

		/**
		 * CondiÃ§Ãµes para inserir na Lista: o elemento nÃ£o pode ser nulo ou vazio
		 */
		if (element != null) {

			NoProva no = new NoProva(element);

			// se a lista estiver vazia, No Ã© o primeiro elemento;
			if (head == null)
				head = tail = no;
			else {

				switch (position) {
				// adiciona no fim da lista;
				case -1:
					tail.setNext(no);
					tail = no;
					break;

				// adiciona no inÃ­cio da lista
				case 0:
					no.setNext(head);
					head = no;
					break;

				// posiÃ§Ã£o passada pelo usuÃ¡rio
				default:
					if (position > size) {
						add(element, -1);
					} else {
						NoProva previous = head;
						for (int i = 1; i < position - 1; i++) {
							previous = previous.getNext();
						}
						NoProva next = previous.getNext();
						no.setNext(next);
						previous.setNext(no);
						previous = next = null;
					}
					break;
				}
				size++;
			}
		} else {
			throw new ErroException("ERRO: Elemento Nulo!");
		}

	}

	public void remove(int position) throws ErroException {

		/**
		 * CondiÃ§Ãµes para inserir na Lista: a lista nÃ£o pode estar vazia
		 */

		if (!isEmpty()) {
			NoProva previous = head;
			switch (position) {
			// remove do final da lista
			case -1:
				while (previous.getNext() != tail) {
					previous = previous.getNext();
				}
				previous.setNext(null);
				tail = previous;
				break;

			// remmove no inÃ­cio da lista
			case 0:
				head = head.getNext();
				break;

			// remove na posiÃ§Ã£o passada pelo usuÃ¡rio
			default:
				if (position > size)
					remove(-1);
				else {
					for (int i = 1; i < position - 1; i++) {
						previous = previous.getNext();
					}
					NoProva next = previous.getNext().getNext();
					previous.setNext(next);
				}
				break;
			}
			size--;
		} else {
			throw new ErroException("ERRO: Lista Vazia!");
		}

	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	public int size() {
		return this.size;
	}

	public ProvaDTO show(int position) {
		if (!isEmpty() && position <= size) {
			NoProva temp = head;
			for (int i = 1; i <= position; i++) {
				if (i != position)
					temp = temp.getNext();
			}
			return temp.getData();

		} else if (position > size) {
			throw new ErroException("Posição invalida");
		} else
			throw new ErroException("Lista Vazia!");
	}

	public void print() {
		NoProva d = head;
		int count = 1;
		while (d != null) {
			System.out.println("Posição " + count + " - Valor: " + d.getData());
			d = d.getNext();
			count++;
		}
	}

}