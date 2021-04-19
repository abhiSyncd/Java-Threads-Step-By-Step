      
         why use double linked list in lru cache
         https://labuladong.gitbook.io/algo-en/iv.-high-frequency-interview-problem/lru_algorithm
	 
         https://afteracademy.com/blog/lru-cache-implementation
	 https://github.com/awangdev/LintCode/blob/master/Java/146.%20LRU%20Cache.java
	 
	 
	 easiest way is to use LinkedHashMap : https://leetcode.com/problems/lru-cache/discuss/45939/Laziest-implementation:-Java%27s-LinkedHashMap-takes-care-of-everything

	 Cache : HashMap<Key, Node>  : HashMap<Integer, DoublyLinkedListNode>

	 i.e The HashMap will hold the key and the reference to the Node of the Doubly Linked List.


	HashMap :  O(1) Contanst Time
	> put(key, value) 
	> get(key) 

	Double Linked List
	> Add x at the head, time complexity O(1)
          public void addFirst(Node x);

        > Delete node x in the linked list (x is guaranteed to exist)
          Given a node in a doubly linked list, time complexity O(1)
          public void remove(Node x);

        > Delete and return the last node in the linked list, time complexity O(1)
          public Node removeLast();

        > Return the length of the linked list, time complexity O(1)
          public int size();

---------------------------------------------------------------------------------

## INSERT : HashMap<Integer, DoublyLinkedListNode> 
 

	HashMap<Integer, Node> map;      // key associated with Node(key, val)
	DoubleList cache;               // Node(k1, v1) <-> Node(k2, v2)...
 
	void put(int key, int val) {
	    Node x = new Node(key, val);
	    if (key exists) {
		delete the old node;
		insert the new node x to the head;
	    } else {
		if (cache is full) {
		    delete the last node in the linked list;
		    delete the associated value in map;
		} 
		insert the new node x to the head;
		associate the new node x with key in map;
	    }
	}

## READ	
 
	  int get(int key) {
	    if (key does not exist) {                // Cache Miss
		return -1;
	    } 
	    else if(Key Exist) {                     // Cache Hit 
		bring (key, val) to the head;
		return val;
	    }
	}
		 
