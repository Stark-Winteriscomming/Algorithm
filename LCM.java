import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//3
//1 45000
//6 10
//13 17
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int inputArray[] = new int[num * 2];
		Main main = new Main();
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = scanner.nextInt();
		}
		
		for (int i = 0; i < num; i++) {
//			int gcd = main.getGCD(inputArray[i*2+0],inputArray[i*2+1]);
			int gcd = main.getEuclide(inputArray[i*2+0],inputArray[i*2+1]);
			if(gcd == 0){
				System.out.println(inputArray[i*2+0] * inputArray[i*2+1]);
			}
			else{
				int arg1 = inputArray[i*2+0] / gcd;
				int arg2 = inputArray[i*2+1] / gcd;
				System.out.println(gcd * arg1 * arg2);
			}
		}
		
	}
	public static int getEuclide(int var1, int var2){
		int max;
		int divider;
		int dividend;
		int remainder;
		int quotient;
		
		if(var1 > var2){
			dividend = var1;
			divider = var2;
		}else{
			dividend = var2;
			divider = var1;
		}
		
		remainder = dividend % divider;
		if(remainder == 0) return divider;
		
		while(!(remainder == 0 || remainder == 1)){
			// if 
			dividend = divider;
			divider = remainder;
			remainder = dividend % divider;
		}
		// 계산 끝 
		if(remainder == 0){
			return divider;
		}
		else return 1;
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
		return list;
	}
}
