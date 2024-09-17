package study;


/**
 *   链表
 *   一种常见的基础数据结构,是一种线性表,但是并不会按线性的顺序存储数据,
 *   而是在每一个节点里存到是下一个节点的指针(pointer)。
 */
public class test71 {
	public static void main(String[] args) {
		
		NodeManager nm = new NodeManager();
		nm.add(5);
		nm.add(4);
		nm.add(3);
		nm.add(2);
		nm.add(1);
		nm.print();
	}
}

class NodeManager{
	private Node root;//根节点
	
	//添加
	public void add(int data) {
		if (root == null) {
			root = new Node(data);
		}else {
			root.addNode(data);
		}
	}
	
	public void del(int data) {
		
	}
	//打印所有
	public void print() {
		if (root != null) {
			System.out.print(root.getData()+"->");
			root.printNode();
			System.out.println();
		}
	}
	private boolean find() {
		return false;
	}
	public void updata(int oldData,int newData) {
		
	}
	public void insert(int index,int data) {
		
	}
	
	//定义成私有内部类
	private class Node{
		private int data;
		private Node next;//把当前类型作为属性
		public Node(int data) { //构造方法
			this.data = data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public int getData() {
			return data;
		}
		//添加节点
		public void addNode(int data) {
			if (this.next == null) {
				this.next = new Node(data);
			}else {
				this.next.addNode(data);
			}
		}
		//删除节点
		public void delNode(int data) {
			
		}
		//输出所有节点
		public void printNode() {
			if (this.next != null) {
				System.out.print(this.next.data+"->");
				this.next.printNode();
			}
		}
		//查找节点是否存在
		public boolean findNode(int data) {
			return false;
		}
		//修改节点
		public void updateNode(int oldData,int newData) {
			
		}
		//插入节点
		public void insert(int index,int data) {
			
		}
	}
}