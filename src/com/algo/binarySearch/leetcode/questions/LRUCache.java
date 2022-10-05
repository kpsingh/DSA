package com.algo.binarySearch.leetcode.questions;

import java.util.HashMap;

class LRUCache {

	private int capacity;
	private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	private Node head = new Node(-1, -1);
	private Node tail = new Node(-1, -1);

	public LRUCache(int capacity) {
		this.capacity = capacity;
		tail.prev = head;
		head.next = tail;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		Node current = map.get(key);
		current.prev.next = current.next;
		current.next.prev = current.prev;
		moveToTail(current);

		return map.get(key).value;

	}

	public void put(int key, int value) {
		if (get(key) != -1) {
			map.get(key).value = value;
			return;
		}

		if (map.size() == capacity) {
			map.remove(head.next.key);
			head.next = head.next.next;
			head.next.prev = head;
		}

		Node insert = new Node(key, value);
		map.put(key, insert);
		moveToTail(insert);
	}

	private void moveToTail(Node node) {
		node.prev = tail.prev;
		tail.prev = node;
		node.prev.next = node;
		node.next = tail;
	}

	private class Node {
		Node prev;
		Node next;
		int key;
		int value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}

	public static void main(String[] args) {

		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		lRUCache.get(1); // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		lRUCache.get(2); // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		lRUCache.get(1); // return -1 (not found)
		lRUCache.get(3); // return 3
		lRUCache.get(4); // return 4

	}
}
