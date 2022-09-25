package com.ds.stack.queue;

public class MyCircularQueue {

	int front = 0;
	int back = 0;
	int size = 0;

	int[] data;

	public MyCircularQueue(int k) {
		data = new int[k];
	}

	public boolean enQueue(int value) {
		if (isFull())
			return false;

		data[back] = value;
		back = back % data.length;
		size++;

		return true;

	}

	public boolean deQueue() {
		if (isEmpty())
			return false;

		front++;
		size--;

		return true;

	}

	public int Front() {

		return data[front];

	}

	public int Rear() {
		return data[back];

	}

	public boolean isEmpty() {
		return size == 0;

	}

	public boolean isFull() {
		return size == data.length;
	}

}
