package com.vince.decorator;

/**
 * 具体的装饰者类
 * @author Administrator
 *
 */
public class BlackBeanDecorator extends Decorator{

	public BlackBeanDecorator(Drink drink) {
		super(drink);
	}
	
	@Override
		public float cost() {
			// TODO Auto-generated method stub
			return super.cost()+2.0f;
		}
	
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return super.description()+"+黑豆";
	}
}
