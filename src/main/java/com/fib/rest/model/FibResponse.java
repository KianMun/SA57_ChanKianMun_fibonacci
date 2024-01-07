package com.fib.rest.model;

import java.util.List;

public class FibResponse {
	
	private List<Integer> fib;
	private List<Integer> fibSort;
	
	
	public FibResponse(List<Integer> fib, List<Integer>fibSort) {
		this.fib = fib;
		this.fibSort = fibSort;
	}
	
	public List<Integer> getFib() {
		return fib;
	}
	public void setFib(List<Integer> fib) {
		this.fib = fib;
	}
	
	public List<Integer> getFibSort() {
		return fibSort;
	}
	public void setFibSort(List<Integer> fibSort) {
		this.fibSort = fibSort;
	}
	
	public static String error() {
		return "Please input a value between 1 to 100";
	}

}
