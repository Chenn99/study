package com.vince.decorator;

/**
 * 具体的装饰者类
 * @author Administrator
 *
 */
public class SugarDecorator extends Decorator{

	public SugarDecorator(Drink drink) {
		super(drink);
	}
	
	@Override
		public float cost() {
			// TODO Auto-generated method stub
			return super.cost()+1.0f;
		}
	
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return super.description()+"+糖";
	}
}
