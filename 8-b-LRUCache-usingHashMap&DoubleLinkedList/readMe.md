	 
# 1 - Data Structures Consideration

        HashMap<Integer, DoublyLinkedListNode>
        The HashMap will hold the key and the reference to the Node of the Doubly Linked List.
        where

	(a) HashMap :  O(1) Contanst Time
	    > put(key, value) 
	    > get(key) 

	(b) Double Linked List : O(1) Contanst Time
	    > Add Node at the head, time complexity O(1)
              public void addFirst(Node x);

            > Delete Node in the linked list (x is guaranteed to exist)
              Given a node in a doubly linked list, time complexity O(1)
              public void remove(Node x);

            > Delete and return the last node in the linked list, time complexity O(1)
              public Node removeLast();

            > Return the length of the linked list, time complexity O(1)
              public int size();


# 2 - Operations 

## 2-I) ADD : HashMap<Integer, DoublyLinkedListNode> 
 
    public void put(int key, int val) {
        
        Node x = new Node(key, val);         // Initialize new node x

        if (map.containsKey(key)) {
            
            cache.remove(map.get(key));      // Delete the old node, add to the head
            cache.addFirst(x);               // Update the corresponding record in map
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                Node last = cache.removeLast(); // Delete the last node in the linked list
                map.remove(last.key);
            }
           
            cache.addFirst(x);                // Add to the head
            map.put(key, x);
        }
    }

## 2-II) GET : HashMap<Integer, DoublyLinkedListNode>	
 
	  int get(int key) {
	    if (key does not exist) {                // Cache Miss
		return -1;
	    } 
	    else if(Key Exist) {                     // Cache Hit 
		bring (key, val) to the head;
		return val;
	    }
	}
	

#
    Sources : 
    https://labuladong.gitbook.io/algo-en/iv.-high-frequency-interview-problem/lru_algorithm 
    https://afteracademy.com/blog/lru-cache-implementation
    https://github.com/awangdev/LintCode/blob/master/Java/146.%20LRU%20Cache.java

    Easiest way is to use LinkedHashMap : https://leetcode.com/problems/lru-cache/discuss/45939/Laziest-implementation:-Java%27s-LinkedHashMap-takes-care-of-everything

