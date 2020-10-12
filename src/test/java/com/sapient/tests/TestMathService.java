package com.sapient.tests;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sapient.service.MathService;

import exceptions.InvalidInputException;


class TestMathService {
	
	MathService service;
	
	@BeforeEach
	void setup() {
		service = new MathService();
	}
	
	
	@AfterEach
	void cleanUp() {
		service = null;
	}
	
	
	@Test
	void testFibonacciValidNumber() {
		long actual = service.fibonacci(6);
		long expected = 8;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void testFibonacciIndexOne() {
		long actual = service.fibonacci(1);
		long expected = 1;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void testFibonacciIndexTwo() {
		long actual = service.fibonacci(2);
		long expected = 1;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void testFibonacciNegativeNumber() {
		Assertions.assertThrows(InvalidInputException.class, () -> service.fibonacci(-20));
	}
	
	@Test
	void testFactorialValidNumber() {
		long actual = service.facotrial(6);
		long expected = 720;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void testFactorialZero() {
		long actual = service.facotrial(0);
		long expected = 1;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void testFactorialOne() {
		long actual = service.facotrial(1);
		long expected = 1;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void testFactorialNegativeNumber() {
		Assertions.assertThrows(InvalidInputException.class, () -> service.facotrial(-20));
	}
	
	@Test
	void testIsPrimeValidPrimeNumber() {
		Assertions.assertTrue(service.isPrime(11));
	}
	
	@Test
	void testIsPrimeValidNonPrimeNumber() {
		Assertions.assertFalse(service.isPrime(20));
	}
	
	@Test
	void testIsPrimeOne() {
		Assertions.assertFalse(service.isPrime(1));
	}
	
	@Test
	void testIsPrimeZero() {
		Assertions.assertFalse(service.isPrime(0));
	}
	
	@Test
	void testIsPrimeNegativeNumber() {
		Assertions.assertThrows(InvalidInputException.class, () -> service.isPrime(-20));
	}
	
	@Test
	void listOfPrimeNumbersValidInput() {
		List<Long> actual = service.listOfPrimeNumbers(1, 20);
		List<Long> expected = List.of(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void listOfPrimeNumbersNegativeInput1() {
		Assertions.assertThrows(InvalidInputException.class, () -> service.listOfPrimeNumbers(-4, 100));
	}
	
	@Test
	void listOfPrimeNumbersNegativeInput2() {
		Assertions.assertThrows(InvalidInputException.class, () -> service.listOfPrimeNumbers(4, -100));
	}
	
	@Test
	void listOfPrimeNumbersFromGreaterThanTo() {
		Assertions.assertThrows(InvalidInputException.class, () -> service.listOfPrimeNumbers(100, 4));
	}
	
}
