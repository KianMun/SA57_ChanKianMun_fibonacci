package com.fib.rest.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fib.rest.model.FibRequest;
import com.fib.rest.model.FibResponse;

@CrossOrigin
@RestController
@RequestMapping("/fibonacci")
public class FibController {
	
	//For Postman
	@GetMapping
	public FibResponse generateFib(@RequestBody FibRequest request){
		//Get element from request
		int element = request.getElements();
		
		//Compute fibonacci sequence to a list
		List<Integer> fibSeq = generateFibSeq(element);
		
		//Sort fibonacci sequence
		List<Integer> sortedFibSeq = sortFibSeq(fibSeq);
		
		return new FibResponse(fibSeq, sortedFibSeq);
	}
	
	//For React
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("/api")
	public FibResponse generateFibReact(@RequestParam("elements")int element){
		
		//Compute fibonacci sequence to a list
		List<Integer> fibSeq = generateFibSeq(element);
		
		//Sort fibonacci sequence
		List<Integer> sortedFibSeq = sortFibSeq(fibSeq);
		
		return new FibResponse(fibSeq, sortedFibSeq);
	}
	
	//Generate Fibonnaci sequence
	private List<Integer> generateFibSeq(int element) {
		List<Integer> fibSeq = new ArrayList<>();
		
		//Check if element is less than 1 or greater than 100
		//if element less than 1 or greater than 100, return 0
		//if element between 1 to 100, return fibonacci sequence
		if(element < 1 || element > 100) {
			fibSeq.add(0);
			return fibSeq;
		}else {
			
			fibSeq.add(1);
			fibSeq.add(1);
			
			for(int i = 2; i < element; i++) {
				int fibNext = fibSeq.get(i-1) + fibSeq.get(i - 2);
				fibSeq.add(fibNext);
			}
			return fibSeq;
		}
		
	}
	
	//Sort Fibonacci sequence to even and odd integers
	//Even integers first, odd integers second
	//In Descending order
	private List<Integer> sortFibSeq(List<Integer> fibSeq){
		//Add odd integers from fibonacci sequence to even list
		//And sort it in descending order
		List<Integer> even = fibSeq.stream().filter(n -> n % 2 == 0).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		
		//Add even integers from fibonacci sequence to odd list
		//And sort it in descending order
		List<Integer> odd = fibSeq.stream().filter(n -> n % 2 != 0).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		
		//Combine even integers and odd integers to a List
		List<Integer> sortedFib = new ArrayList<>();
		sortedFib.addAll(even);
		sortedFib.addAll(odd);
		
		return sortedFib;
		
	}				
	
}
