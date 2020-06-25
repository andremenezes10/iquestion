package br.com.prototipo.util;

import br.com.prototipo.exception.ErroException;

public class ListaEncadeadaDouble {

	private NoDouble head, tail;
	private int size = 1;

	public ListaEncadeadaDouble() {
	}

	public void add(Double element, int position) throws ErroException {

		/**
		 * CondiÃ§Ãµes para inserir na Lista: o elemento nÃ£o pode ser nulo ou vazio
		 */
		if (element != null) {

			NoDouble no = new NoDouble(element);

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
						NoDouble previous = head;
						for (int i = 1; i < position - 1; i++) {
							previous = previous.getNext();
						}
						NoDouble next = previous.getNext();
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
			NoDouble previous = head;
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
					NoDouble next = previous.getNext().getNext();
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

	public Double show(int position) {
		if (!isEmpty() && position < size) {
			NoDouble temp = head;
			for (int i = 1; i <= position; i++) {
				if (i != position)
					temp = temp.getNext();
			}
			return temp.getData();

		} else if (position >= size) {
			throw new ErroException("Posição invalida");
		} else
			throw new ErroException("Lista Vazia!");
	}

	public void print() {
		NoDouble d = head;
		int count = 1;
		while (d != null) {
			System.out.println("PosiÃ§Ã£o " + count + " - Valor: " + d.getData());
			d = d.getNext();
			count++;
		}
	}

}