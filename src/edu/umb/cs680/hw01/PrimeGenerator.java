package edu.umb.cs680.hw01;

import java.util.Iterator;
import java.util.LinkedList;

public class PrimeGenerator { //class
	protected long from, to; //declare variable
	protected LinkedList<Long> primes = new LinkedList<Long>(); //declare linked list

	public PrimeGenerator(long from, long to){ //constructor
		if(from >= 1 && to > from){
			this.from = from;
			this.to = to;
		}else{
			throw new RuntimeException("Wrong input values: from=" + from + " to=" + to);
		}
	}
	
	public LinkedList<Long> getPrimes(){ //getter
		return primes;
	};  //getter
	
	protected boolean isEven(long n){
		if(n%2 == 0){ return true; }
		else{ return false; }
	}
	
	protected boolean isPrime(long n){
		// 1 or lower numbers are not prime. 
		if(n <= 1){ return false; }
		// Even numbers are not prime, except for 2.  
		if( n > 2 && isEven(n) ){ return false; }
		long i;
		// Find a number "i" that can divide "n" 
        for (i = (long) Math.sqrt(n); n%i != 0 && i >= 1; i--){}
        // If such a number "i" is found, n is not prime. Otherwise, n is prime. 
        if (i == 1){ return true; }
        else{ return false; }
	}

	public void generatePrimes(){  //add next prime number to the linked list
		for (long n = from; n <= to; n++) {
			if( isPrime(n) ){
				primes.add(n);
			}
        }
	}
	
	public static void main(String[] args) {  //main method
		PrimeGenerator gen = new PrimeGenerator(3, 15); //Create one instance

		gen.generatePrimes(); // call generate prime method and amend the linked list
		LinkedList<Long> primes = gen.getPrimes(); //get the prepared linked list

		Iterator<Long> it = primes.iterator(); //print the list and keep iterating till the last element
		while(it.hasNext()) {
			System.out.print(it.next() + ", ");
		}

		System.out.println("\n" + gen.getPrimes().size() + " primes are found.");
	}
}

