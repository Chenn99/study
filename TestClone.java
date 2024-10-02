package com.vince;

public class TestClone {

	public static void main(String[] args) {
		
		Cat cat = new Cat("喵喵",2);
		try {
			Cat newCat = (Cat) cat.clone();
			
			System.out.println("cat=" +cat);
			System.out.println("newCat=" +newCat);
			System.out.println(cat==newCat);
//			cat=Cat [name=喵喵, age=2]
//			newCat=Cat [name=喵喵, age=2]
//			false

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}
}
