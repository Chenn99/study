package com.vince;

import java.sql.Date;

public class BinaryTree {

	private Node root;
	
	public void add(int data) {
		if (root == null) {
			root = new Node(data); //8 变成根节点
		}else {
			root.addNode(data);
		}
	}
	//输出节点
	public void print() {
		root.printNode();
	}
	
	private class Node{
		private int data;
		private Node left;
		private Node right;
		private Node (int data) {
			this.data = data;
		}
		
		
		public void addNode(int data) {
			if (this.data >data) {
				if (this.left ==null) { //传进来值要小于当前的值 就添加在左边
					this.left = new Node(data);
				}else {
					this.left.addNode(data);
				}
			}else { //传进来值要小于当前的值 就添加在右边
				if (this.right == null) {
					this.right = new Node(data);
				}else {
					this.right.addNode(data);
				}
			}
		}
		//中序遍历(先序遍历,后序遍历)
		public void printNode() {
			if (this.left != null) {
				this.left.printNode();
			}
			System.out.print(this.data +"->");
			if (this.right != null) {
				this.right.printNode();
			}
		}
	}
}
