package br.com.prototipo.util;

public class NoDouble {
	private Double data;
	private NoDouble next;

	public NoDouble(Double d) {
		this.data = d;
		this.next = null;
	}

	public Double getData() {
		return data;
	}

	public void setData(Double data) {
		this.data = data;
	}

	public NoDouble getNext() {
		return next;
	}

	public void setNext(NoDouble next) {
		this.next = next;
	}

}