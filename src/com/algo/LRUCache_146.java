package com.algo;

import java.util.HashMap;

public class LRUCache_146 {

	private final int capacity;

	HashMap<Integer, Node> map = new HashMap<>();

	Node head = new Node(-1, -1);
	Node tail = new Node(-1, -1);

	public LRUCache_146(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {

		// if element is not in the cache, return -1
		if (!map.containsKey(key))
			return -1;

		/*
		 * if cache has the element then move that element to the tail of the list to
		 * make more it recently used.
		 */

		Node node = map.get(key);

		// while removed, make the left and right node get connected to each other
		node.prev.next = node.next;
		node.next.prev = node.prev;

		// add the node to last of the queue to make it most recently used.
		addtoTail(node);

		return node.value;

	}

	public void put(int key, int value) {
		/*
		 * If the key already exist which we want to put :- then its same like get(key)
		 * and only value need to be updated.
		 */

		if (get(key) != -1) {
			map.get(key).value = value;
			return;
		}

		// is the element is NOT in the cache then add that to cache and make it more
		// recently used

		if (map.size() == capacity) {

			map.remove(head.next.key);
			head.next = head.next.next;
			head.next.prev = head;
		}

		Node insert = new Node(key, value);
		map.put(key, insert);
		addtoTail(insert);
	}

	private void addtoTail(Node node) {
		node.prev = tail.prev;
		tail.prev.next = node;
		node.next = tail;
		tail.prev = node;

	}

	/**
	 * 
	 * Private class to make the Double linked list implementation to have the
	 * pointer for next and previous.
	 *
	 */

	private class Node {
		int key;
		int value;
		Node next;
		Node prev;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

}
