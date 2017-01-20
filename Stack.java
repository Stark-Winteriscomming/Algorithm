import java.util.Scanner;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
		
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int maxArrayLength = n * 2;
		int currentMax = n;
		String stackValueArray[] = new String[maxArrayLength];
		
		for (int i = 0; i < currentMax; i++) {
			stackValueArray[i] = scanner.next();
			if(stackValueArray[i].equals("push")){
				currentMax++;
			}
		}
		Stack stack = new Stack();
		
		for (int i = 0; i < currentMax; i++) {
			switch(stackValueArray[i]){
				case "push": 
					stack.push(stackValueArray[++i]);
					break;
				case "pop": 
					System.out.println(stack.pop());
					break;
				case "size": 
					System.out.println(stack.size());
					break;
				case "top":
					System.out.println(stack.getTopItem());
					break;
				case "empty":
					System.out.println(stack.empty());
					break;
				default : break;
			}
		}
		scanner.close();
	}
	
}
class Stack{
	private Node top;
	private int size;
	
	public Stack() {
		this.top = null;
		this.size = 0;
	}
	public void setTop(Node top) {
		this.top = top;
	}
	public int empty(){
		if(top == null)
			return 1;
		else 
			return 0;
	}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void push(Object item){
		Node newNode = new Node(item);
		
		if(this.top != null)
			newNode.setNextNode(top);
		
		this.setTop(newNode);
		this.setSize(++size);
		
	}
	
	public int size(){
		return this.getSize();
	}
//	pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public Object pop(){
		if(empty() == 0){
			this.setSize(--size);
			Object data = this.top.getData(); 
			this.setTop(top.getNextNode());
			return data;
			
		}
		return -1;
	}
	public Object getTopItem(){
		if(empty() == 0){
			return this.top.getData();
		}
		else 
			return -1;
	}
}

class Node{
	private Object data;
	private Node nextNode;
	
	public Node(Object data) {
		this.data = data;
		this.nextNode = null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
}



