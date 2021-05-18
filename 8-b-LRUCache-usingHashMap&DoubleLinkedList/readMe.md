	 
# 1 - Data Structures Consideration

	 HashMap<Integer, DoublyLinkedListNode>
	 The HashMap will hold the key and the reference to the Node of the Doubly Linked List.
	 where

	 (a) HashMap : O(1) Contanst Time
	     > put(key, value) 
	     > get(key) 

	 (b) Double Linked List : O(1) Contanst Time
	     > Add Node at the head             : cache.addNodeToHead(node);
	     > Delete and return the last node  : cache.deleteNodeAtEnd()
	     > Delete an existing|given Node    : cache.deleteNode(map.get(key));


# 2 - [Operations](https://github.com/abhiSyncd/Images-Repository/blob/master/LRU_Cache.png) 

## 2-I) INSERT

	 public void put(int key, int val) {

	     Node node = new Node(key, val);

	     if (map.containsKey(key)) {
		 cache.deleteNode(map.get(key));
		 cache.addNodeToHead(node);
		 map.put(key, node);
	     } else {
		 if (cap == cache.size()) {
		     Node last = cache.deleteNodeAtEnd();
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
		cache.deleteNode(node)
		cache.addNodeToHead(node)
		return result
	    } else
		return -1; // Cache Miss
	}
#

Sources 

    https://labuladong.gitbook.io/algo-en/iv.-high-frequency-interview-problem/lru_algorithm 
    https://afteracademy.com/blog/lru-cache-implementation
    https://github.com/awangdev/LintCode/blob/master/Java/146.%20LRU%20Cache.java

    Note : Easiest way is to use LinkedHashMap
    https://leetcode.com/problems/lru-cache/discuss/45939/Laziest-implementation:-Java%27s-LinkedHashMap-takes-care-of-everything

