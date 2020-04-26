package com.rkb.strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeString {

	public static void main(String[] args) {
	String[] arr =	{"this", "is", "a", "test"};
	String and = change(arr);
	System.out.println(and);
	}
	
	public static String change(String[] arr) {
		List<String> list = Arrays.asList(arr);
		List<String> collect = list.stream().map(s -> {
			if(s.equals(arr[arr.length -1])) {
				return  s.toUpperCase();
			}else {
				return s.toUpperCase()+"-";
			}
		}).collect(Collectors.toList());
//		StringBuilder and = new StringBuilder();
//		for(String s: arr) {
//			if(arr[arr.length -1].equals(s)) {
//				and.append( s.toUpperCase());
//			}else {
//				and.append(s.toUpperCase()+"-");
//			}
//		}
//		return and.toString();
		StringBuilder and = new StringBuilder();
		for(String s : collect) {
			and.append(s);
		}
		return and.toString();
	}

}
