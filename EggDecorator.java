package com.vince.decorator;

/**
 * 具体的装饰者类
 * @author Administrator
 *
 */
public class EggDecorator extends Decorator{

	public EggDecorator(Drink drink) {
		super(drink);
	}
	
	@Override
		public float cost() {
			// TODO Auto-generated method stub
			return super.cost()+3.0f;
		}
	
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return super.description()+"+鸡蛋";
	}
}
