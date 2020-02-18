package com.rkb.strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveVowels {

	public static void main(String[] args) {
		RemoveVowels practise = new RemoveVowels();
		String s = "aeiou12";
		System.out.println(practise.removeVowels(s));

	}
	
	public String removeVowels(String s) {
		String[] arr = s.split("");
		 List<String> list = Arrays.asList(arr);
		List<String> ans = list.stream().filter(c -> !"aeiou".contains(c.toLowerCase()))
		.collect(Collectors.toList());
		
		StringBuilder string = new StringBuilder();
		for(String s1: ans) {
			string.append( s1);
		}
		return string.toString();
	}
    
   

}
