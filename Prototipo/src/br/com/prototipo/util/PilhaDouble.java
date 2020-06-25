package br.com.prototipo.util;

import br.com.prototipo.exception.ErroException;

public class PilhaDouble {

	private NoDouble head;
	private int size = 0;

	// inserir elemento sempre na cabeça
	public void push(Double element) throws ErroException {
		/**
		 * Condiçoes para inserir na Lista: o elemento nao pode ser nulo ou vazio
		 */
		if (element != null) {
			NoDouble no = new NoDouble(element);

			// adiciona elemento no inicio da Pilha
			no.setNext(head);
			head = no;
			size++;
		} else {
			throw new ErroException("ERRO: Elemento Invalido!");
		}
	}

	// remover elemento LIFO
	public void pop() throws ErroException {
		/**
		 * Condiçoes para remover item da Lista: 1. A pilha nao deve estar VAZIA
		 */
		if (!isEmpty()) {
			// remove elemento no inicio da lista
			head = head.getNext();
			size--;
		} else {
			throw new ErroException("ERRO: Pilha Vazia!");
		}

	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}
	

    public int size() {
        return size;
    }

    public Double top() throws ErroException{
        if (isEmpty())
            throw new ErroException("ERRO: Pilha Vazia!");
        return head.getData();
    }
    
    public void print(){
    	NoDouble temp = head;
        int count = 1;
        while(temp!=null){
            System.out.println("PosiÃ§Ã£o " + count + " - Valor: " + temp.getData());
            temp=temp.getNext();
            count++;
        }

    }
}
