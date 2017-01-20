import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int maxArrayLength = n * 2;
		int currentMax = n;
		String queueValueArray[] = new String[maxArrayLength];
		
		for (int i = 0; i < currentMax; i++) {
			queueValueArray[i] = scanner.next();
			if(queueValueArray[i].equals("push")){
				currentMax++;
			}
		}

		Queue queue = new Queue();
		for (int i = 0; i < currentMax; i++) {
			switch(queueValueArray[i]){
				case "push": 
					queue.insert(queueValueArray[++i]);
					break;
				case "pop": 
					System.out.println(queue.delete());
					break;
				case "size": 
					System.out.println(queue.getSize());
					break;
				case "front":
					System.out.println(queue.peek());
					break;
				case "empty":
					System.out.println(queue.empty());
					break;
				case "back":
					System.out.println(queue.back());	
					break;
				default : break;
			}
		}
		scanner.close();
		
		
		
	}

}
class Queue {
	Node front;
	Node rear;
	int size;
//	push X: 정수 X를 큐에 넣는 연산이다.
//	pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//	size: 큐에 들어있는 정수의 개수를 출력한다.
//	empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//	front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//	back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public Queue() {
		// TODO Auto-generated constructor stub
		this.front = null;
		this.rear = null;
		this.size = 0;
	}
	public void insert(Object data){
		Node newNode = new Node(data);
		if(empty() == 1){
			front = newNode;
			rear = newNode;
		}else{
			rear.nextNode = newNode;
			rear = newNode;
		}
		size++;
	}
	public Object delete(){
		Object data = peek();
		if(empty() == 0){
			front = front.nextNode;
			
			if(front == null){ 
				rear = null;
			}
			size--;
			return data;
		}else{
			if(size > 0)
				size--;
			return -1;
		}
	}
	public Object peek(){
		if(empty() == 0){
			return front.getData();
		}
		else return -1;
	}
	public int empty(){
		if(this.front == null)
			return 1;
		else return 0;
	}
	public int getSize(){
		return this.size;
	}
	public Object back(){
		if(empty() == 0){
			return rear.getData();
		}
		else return -1;
	}
}
class Node{
	Object data;
	Node nextNode;
	
	public Node(Object data) {
		this.data = data;
		nextNode = null;
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
