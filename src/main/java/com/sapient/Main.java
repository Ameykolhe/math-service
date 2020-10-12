package com.sapient;

import com.sapient.service.MathService;

public class Main {

	public static void main(String[] args) {
		
		MathService service = new MathService();
		
		if ( args.length > 0) {
			switch(args[0]) {
				case "isPrime":
					System.out.println(service.isPrime(Long.parseLong(args[1])));
					break;
				
				default:
					System.out.println("Invalid Input arg");
			}
		}

	}

}
