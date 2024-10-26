package Pattern;

public class pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welecome to my Heart Buddy");
		int a=0;
		for(int i=0; i<5; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(a);
				System.out.print("  ");
				a++;
			}
			System.out.println(" ");
			
		}
		a--;
		for(int i=0; i<5; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(a);
				System.out.print("  ");
				a++;
			}
			System.out.println(" ");
			
		}

	}

}
