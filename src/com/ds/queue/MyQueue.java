package com.ds.queue;

/**
 * 
 * This is a circular Queue by nature
 *
 */
public class MyQueue {

	private int front = 0;
	private int back = 0;
	int size = 0;
	private static final int DEFAULT_LENGTH = 5;
	private int[] data;

	public MyQueue() {
		this(DEFAULT_LENGTH);
	}

	public MyQueue(int length) {
		this.data = new int[length];
	}

	// O(1) time
	public boolean add(int item) {
		if (this.isFull()) {
			System.out.println("Can't add as Queue is full!");
			return false;
		}

		data[back++] = item;
		back = back % data.length; // Circular Array/Q concept, this will male sure index < arr.length
		return true;
	}

	// O(1) time
	public int remove() {

		if (this.isEmpty()) {
			System.out.println("Can't remove as Queue is Empty!");
			return -1;
		}

		int removed = data[front++];
		front = front % data.length; // Circular Array/Q concept, this will male sure index < arr.length
		size--;
		return removed;

	}

	public void display_V1() {

		int temp = front;

		for (int i = 0; i < size; i++) {
			System.out.print(data[temp++] + " <- ");
			temp = temp % data.length;
		}
		System.out.println("END");
	}

	/*
	 * More beautiful code for display using do-while loop
	 */
	public void display_V2() {

		int i = front;
		do {
			System.out.print(data[i++] + " <- ");
			i = i % data.length;
		} while (i != back);

		System.out.println("END");

	}

	private boolean isFull() {

		return size == data.length;
	}

	private boolean isEmpty() {

		return size == 0;
	}

}
