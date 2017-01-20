import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Main main = new Main();
		// (3 ≤ N ≤ 100)
		int ringNum = scanner.nextInt();
		int i = 0;
		int r_array[] = new int[ringNum];
		while(i < ringNum){
			r_array[i] = scanner.nextInt();
			i++;
		}
		i = 1;
		while(i < ringNum){
			int gcd = main.getGCD(r_array[0],r_array[i]);
			if( gcd == 0)
				System.out.println(r_array[0] + "/" + r_array[i]);
			else
				System.out.println(r_array[0] / gcd + "/" + r_array[i] / gcd);
			i++;
		}
	}
	public int getGCD(int value1, int value2){
		List<Integer> value1List = getFactor(value1);
		List<Integer> value2List = getFactor(value2);
		int gcd = 0;
		for (int i = 0; i < value1List.size(); i++) {
			for (int j = 0; j < value2List.size(); j++) {
				if(value1List.get(i) == value2List.get(j)){
					gcd = value1List.get(i);
				}
			}
		}
		return gcd;
	}
	public List<Integer> getFactor(int value){
		List<Integer> list =  new ArrayList<Integer>();
		for(int i=2; i<=value; i++){
			if((value % i) == 0){
				list.add(i);
			}
		}
//		for(int result : list){
//			System.out.println(result+" ");
//		}
		return list;
	}
}
