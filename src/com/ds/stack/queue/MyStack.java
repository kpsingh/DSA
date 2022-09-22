package com.ds.stack.queue;

public class MyStack {

	// Internally stack is using the arrays to store the data
	private int[] elementData;

	// pointer to know the current status of array
	int index = -1;

	// If no size provide during creation then use the default size
	private final static int DEFAULT_SIZE = 5;

	// no arg constructor
	public MyStack() {
		this(DEFAULT_SIZE);
	}

	// size constructor
	public MyStack(int size) {
		this.elementData = new int[size];
	}

	public boolean push(int element) throws Exception {

		if (isFull()) {
			throw new Exception("Stack is full!");
		}

		index++;
		elementData[index] = element;
		return true;
	}

	public Integer pop() throws Exception {

		if (isEmpty()) {
			throw new Exception("Stack is empty!");
		}

		return elementData[index--];
	}

	public Integer peek() throws Exception {

		if (isEmpty()) {
			throw new Exception("Stack is empty!");
		}

		return elementData[index];
	}

	private boolean isFull() {

		return index == elementData.length - 1;
	}

	private boolean isEmpty() {
		return index == -1;
	}

}
