package Pattern;
import java.util.*;

public class maxWaterContainer {
	public static void main(String args[]) {
		int[] h= {1,8,6,2,5,4,8,3,7};
		
		int max=0;
		for(int i=0; i<h.length-1; i++) {
			for(int j=i+1; j<h.length; j++) {
				 {
					int t= (j-i)*min(h[i],h[j]);
					if(t>max) {
						max=max+t;
					}
				}
			}
		}
		System.out.println(max);
	}

	
}
