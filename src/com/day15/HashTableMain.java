package com.day15;

public class HashTableMain {
	
	 public static void main(String[] args) {
	        String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
	        String[] paraArray = paragraph.split(" ");
	        HashTable<String,Integer> hashTable = new HashTable<>();
	        for (String word:paraArray) {
	            Integer currentFrequency = hashTable.get(word);
	            if(currentFrequency == null){
	                hashTable.add(word,1);
	            }else{
	                currentFrequency+=1;
	                hashTable.add(word,currentFrequency);
	            }

	        }
	        System.out.println(hashTable);
	    }

}
