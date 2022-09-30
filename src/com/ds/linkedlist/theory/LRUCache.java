package com.ds.linkedlist.theory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class LRUCache {

	HashMap<Integer, Integer> cache;
	Queue<Integer> queue = new LinkedList<>();
	private int size = 0;

	public LRUCache(int capacity) {
		this.cache = new HashMap<>(capacity);
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			queue.remove(key);
			queue.add(key);
			return cache.get(key);
		} else
			return -1;
	}

	public void put(int key, int value) {

		if (cache.containsKey(key)) {
			cache.put(key, value);
			queue.remove(key);
			queue.add(key);
		} else {
			if (size < cache.size()) {
				cache.put(key, value);
				queue.add(key);
				size++;
			} else {
				cache.remove(queue.poll());
				cache.put(key, value);
				queue.add(key);
			}
		}

	}

}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */