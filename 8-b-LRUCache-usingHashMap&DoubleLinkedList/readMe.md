
 https://github.com/awangdev/LintCode/blob/master/Java/146.%20LRU%20Cache.java
 https://labuladong.gitbook.io/algo-en/iv.-high-frequency-interview-problem/lru_algorithm

 Cache : HashMap<Key, Node>  : HashMap<Integer, DoublyLinkedListNode>
 
 i.e The HashMap will hold the key and the reference to the Node of the Doubly Linked List.


HashMap : put(key, value) and  get(key)  :  O(1) Contanst Time

DLL     : Add , remove , Update          :  O(1) Contanst Time 

---------------------------------------------------------------------------------

## INSERT : HashMap<Integer, DoublyLinkedListNode> : putEntry(int key, int value)

 **Case I : If KEY exist :**
 
	  - Node node = cache.get(key); 
	  - Remove NODE from DLL 
	  - Add NODE at the Front in DLL
		  
        : If KEY Do not exist 
		  - Return -1

 **Case II : If KEY do not exist :**  

    - Insert NODE at Front in DLL : This inserted item is the Most Recently used Item 
      Insert KEY and the refering Node in HashMap      : cache.put(key, NODE);
	  
    - If Capacity is Reached 
       > Remove Key from HashMap i.e refering the Node in DLL  : cache.remove(KEY);
       > Remove NODE at the end in DLL (i.e Last Item : least recently used)
       > Add NODE at the Front in DLL 
       > Insert KEY and the refering Node in HashMap      : cache.put(key, NODE);
       
---------------------------------------------------------------------------------		 

## READ	
 
   **Case I : If cache.containsKey(key)   : Cache HIT** 
   
             - Node node = cache.get(key);
             - removeNode(node);
             - addAtTop(node); 
			 
   **Case II : Cache Miss : return -1**	 
		 
