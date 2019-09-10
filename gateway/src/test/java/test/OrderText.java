package test;

import java.util.Arrays;
import java.util.Random;

import com.pay.gateway.util.DealNumber;

public class OrderText {
	public static void main(String[] args) { 
		cc(3);
		
		
		
	}

	
	public static void cc(int n){
	    int[] x = new int[n];
	    for(int i = 0; i < n; i++) {
	      x[i] = i;
	    }
	    Random r = new Random();
	    for(int i = 0; i < n; i++) {
	      int in = r.nextInt(n - i) + i;
	      int t = x[in];
	      x[in] = x[i];
	      x[i] = t;
	    }
	    System.out.println(Arrays.toString(x));
	  }
}
