package Pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class prac {
	void display() {
		System.out.println("King");
	}
	public static void main(String[] args) {
		System.out.println("Avinash");
		prac ob = new prac();
		ob.display();
		String str="dwuhdw5695865dk45738!@#$%^";
		str= str.replaceAll("[^0-9]", "");
		System.out.println(str);
		for(int i= str.length(); i>0; i--) {
			System.out.print(str.charAt(i-1));
		}
		// button[contains(@id, 'u_0_5_')]
		String s[]= "i ma m ihd".split(" ");
		String ans="";
		for(int i=s.length; i>0; i--) {
			ans = ans + s[i-1]+" ";
		}
		System.out.println(ans);
		String Name="Avinash Chaubey";
		char[] arr = Name.toLowerCase().toCharArray();
		HashMap<Character, Integer> count= new HashMap<Character, Integer>();
		for(char c:arr) {
			if(count.containsKey(c)) {
				count.put(c, count.get(c)+1);
			}
			else
				count.put(c, 1);
		}
		int maxValue= Collections.max(count.values());
		for(Map.Entry<Character,Integer> entry:count.entrySet()){
			if(entry.getValue() == maxValue)
				System.out.println(entry.getKey());
			System.out.println(entry.getKey()+ "-"+entry.getValue());
		}
		
		int[] arr1 = {1,9,3,28,2873,167178,12};
		Arrays.sort(arr1);
		//int maxNum = java.util.Arrays.stream(arr1).max().getAsInt();
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]);
			System.out.print(" ");
		} 
		String s1 ="Hey Chaubey Sahab! How are you?";
		String s2[] = s1.split(" ");
		for(int i=s2.length-1; i>=0; i--) {
			System.out.print(s2[i] + " ");
		}
		String a="AvinashChaubey";
		HashMap<Character, Integer> hm=new HashMap<Character, Integer>();
		char[] c=a.toLowerCase().toCharArray();
		for(char cr:c) {
			if(hm.containsKey(cr))
				hm.put(cr, hm.get(cr)+1);
			else
				hm.put(cr,1);
		}
		for(Map.Entry<Character,Integer> entry:hm.entrySet()){
			if(entry.getValue() == maxValue)
				System.out.println(entry.getKey());
			System.out.println(entry.getKey()+ "-"+entry.getValue());
		}
		
		List<String> usernames = new ArrayList<>();
		usernames.add("admin");
		usernames.add("user1");
		usernames.add("guest");

		for (String username : usernames) {
		    System.out.println("Testing with: " + username);
		}
		
		
		
	
	}
		
		
				
		
		
	}

