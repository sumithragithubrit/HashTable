package com.day15;
import java.util.ArrayList;
import java.util.List;

	public class HashTable<K, V> {

	    int bucketSize = 6;
	    List<MyLinkedList<K, V>> myBucketArray;

	    public HashTable() {
	        this.myBucketArray = new ArrayList<>(bucketSize);
	        for (int i = 0; i < bucketSize; i++) {
	            this.myBucketArray.add(null);
	        }
	    }

	    int getIndex(K key) {
	        int index = Math.abs(key.hashCode()) % bucketSize;
	        return index;
	    }

	    public V get(K word) {
	        int index = getIndex(word);
	        MyLinkedList<K, V> myLinkedList = myBucketArray.get(index);
	        if (myLinkedList == null) {
	            return null;
	        } else {
	            MyNode<K, V> myNode = myLinkedList.search(word);
	            return myNode != null ? myNode.value : null;
	        }

	    }

	    public void add(K word, V frequency) {
	        int index = getIndex(word);
	        MyLinkedList<K, V> myLinkedList = myBucketArray.get(index);
	        if (myLinkedList == null) {
	            myLinkedList = new MyLinkedList<>();
	            myBucketArray.add(index,myLinkedList);
	            myLinkedList.append(word,frequency);
	        }else{
	            MyNode<K, V> myNode = myLinkedList.search(word);
	            if(myNode == null){
	                myLinkedList.append(word,frequency);
	            }else{
	               myNode.value = frequency;
	            }
	        }

	    }

	    @Override
	    public String toString() {
	        return "HashTable{" +
	                "myBucketArray=" + myBucketArray +
	                '}';
	    }
}
