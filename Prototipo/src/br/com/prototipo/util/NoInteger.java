package br.com.prototipo.util;

public class NoInteger {
	private Integer data;
	private NoInteger next;

	public NoInteger(int d) {
		this.data = d;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public NoInteger getNext() {
		return next;
	}

	public void setNext(NoInteger next) {
		this.next = next;
	}

	public void setData(Integer data) {
		this.data = data;
	}


}