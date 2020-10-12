package com.sapient.service;

import java.util.ArrayList;
import java.util.List;

import exceptions.InvalidInputException;

public class MathService {
	
	public long fibonacci(long n) {
		
		if ( n < 1 ) {
			throw new InvalidInputException(n);
		}
		
		if ( n == 1 ) {
			return 1;
		}
		
		if ( n == 2 ) {
			return 1;
		}
		
		long fibonacci = 2;
		long prev = 1;
		for ( int i = 3; i < n; i++) {
			long temp = fibonacci;
			fibonacci += prev;
			prev = temp;
		}
		
		return fibonacci;
	}
	
	
	public long facotrial(long n) {
		
		if ( n < 0 ) {
			throw new InvalidInputException(n);
		}
		
		long result = 1;
		
		for (long i = 2; i <= n; i++) {
			result *= i;
		}
		
		return result;
	}

	
	public boolean isPrime(long n) {
		if ( n < 0) {
			throw new InvalidInputException(n);
		}
		
		if ( n < 2) {
			return false;
		}
		
		for(int i = 2; i <= n/2; ++i) {
            if(n % i == 0) {
            	return false;
            }
        }
		
		return true;
	}
	
	
	public List<Long> listOfPrimeNumbers(long from, long to) {
		if (from < 0 || to < 0) {
			throw new InvalidInputException("Invalid Input value ( From / To )");
		}
		
		if (from >= to) {
			throw new InvalidInputException("From value should be less than To value");
		}
		
		ArrayList<Long> primeNumbers = new ArrayList<>();
		
		for (long i = from; i < to; i++) {
			if (isPrime(i)) {
				primeNumbers.add(i);
			}
		}
		
		return primeNumbers;
	}
	
}
