package com.ds.queue;

public class MyQueueDemo {

	public static void main(String[] args) {

		MyQueue queue = new MyQueue();
		queue.add(15);
		queue.add(25);
		queue.add(10);
		queue.add(5);
		queue.add(65);

		queue.display_V2();
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		queue.display_V1();

		queue.add(19);
		queue.add(45);

		queue.display_V2();

	}

}
