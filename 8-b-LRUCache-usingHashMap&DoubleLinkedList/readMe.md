	 
# 1 - Data Structures Consideration

	 HashMap<Integer, DoublyLinkedListNode>
	 The HashMap will hold the key and the reference to the Node of the Doubly Linked List.
	 where

	 (a) HashMap : O(1) Contanst Time
	     > put(key, value) 
	     > get(key) 

	 (b) Double Linked List : O(1) Contanst Time
	     > Add Node at the head
	     > Delete and return the last node
	     > Delete an existing|given Node 


# 2 - Operations 

## 2-I) INSERT

	 public void put(int key, int val) {

	     Node node = new Node(key, val);

	     if (map.containsKey(key)) {
		 cache.remove(map.get(key));
		 cache.addFirst(node);
		 map.put(key, node);
	     } else {
		 if (cap == cache.size()) {
		     Node last = cache.removeLast();
		     map.remove(last.key);
		 }

		 cache.addFirst(node);
		 map.put(key, node);
	     }
 }

## 2-II) SELECT

	int get(int key) {
	    if (map.containsKey(key)) { // Cache Hit 
		Node node = map.get(key)
		int result = node.value
		deleteNode(node)
		addNodeToHead(node)
		return result
	    } else
		return -1; // Cache Miss
	}
#

Sources 

    https://labuladong.gitbook.io/algo-en/iv.-high-frequency-interview-problem/lru_algorithm 
    https://afteracademy.com/blog/lru-cache-implementation
    https://github.com/awangdev/LintCode/blob/master/Java/146.%20LRU%20Cache.java

    Easiest way is to use LinkedHashMap : https://leetcode.com/problems/lru-cache/discuss/45939/Laziest-implementation:-Java%27s-LinkedHashMap-takes-care-of-everything

