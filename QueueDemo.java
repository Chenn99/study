import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Queue接口：队列，是一种先进先出的线性数据结构（排队）
 * LinkedList类实现了queue接口
 * 请求队列，消息队列，任务
 * 
 * Deque接口：双端队列
 * Stack：堆栈:先进后出
 * @author Administrator
 *
 */
public class QueueDemo {

	private static void Stack() {
		Stack<String> s = new Stack<>();
		//压栈
		s.push("Bin");
		s.push("Tom");
		s.push("Lily");
		s.push("Bob");
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
	private static void queue() {
		Queue<String> queue = new LinkedList<String>();
		queue.add("小黑");
		queue.add("小白");
		queue.add("小花");
		queue.add("小蓝");
		queue.add("小李");
		
		System.out.println(queue.size());
		System.out.println(queue.peek());//移除队列头
		System.out.println(queue.size());
		System.out.println(queue.poll());//移除队列头
		System.out.println(queue.size());
		
	}
	
	private static void deque() {
		Deque<String> deque = new LinkedList<String>();
		deque.add("小黑");
		deque.add("小白");
		deque.add("小花");
		deque.add("小蓝");
		deque.add("小李");
		
		System.out.println(deque.getFirst());//小黑
		System.out.println(deque.getLast());//小李
		
	}

	public static void main(String[] args) {

		//queue();
		//deque();
		Stack();
	}

}
