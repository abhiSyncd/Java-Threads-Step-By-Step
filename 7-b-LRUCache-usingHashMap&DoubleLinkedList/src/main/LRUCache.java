package main;

import java.util.HashMap;

public class LRUCache {
	
   HashMap<Integer,Node> cache;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
    }

    public void addToHead(Node node){
        if(cache.size()==0){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void deleteNode(Node node){

        //if node to be deleted is the first node
        if(head==node)
            head = node.next;
        //if node to be deleted is the last node
        if(tail==node)
            tail = node.prev; 
        //boundary condition for start
        if(node.prev!=null)
            node.prev.next = node.next;
        //boundary condition for end
        if(node.next!=null)
            node.next.prev = node.prev;
    }

    public void look(int key) {

        if(cache.containsKey(key)){
            Node keyNode = cache.get(key);
            deleteNode(keyNode);
        }else{
            if(cache.size() == capacity){
                //cache is full, delete the last entry
                int tailKey = tail.key;
                deleteNode(tail); //Last Node deleted
                cache.remove(tailKey);
            }
        }
        
        // add it to cache
        Node newNode = new Node(key);
        addToHead(newNode);
        cache.put(key,newNode);
        //System.out.println("Item accessed: " + key);
        printCache();
    }

    public void printCache(){
        System.out.print("Cache : ");
        Node start = head;
        while(start!=null){
            System.out.print(start.key + " ");
            start = start.next;
        }
        System.out.println();
    }
} 
