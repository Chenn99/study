package com.vince.decorator;

/**
 * 具体的被装饰者类
 * 豆浆
 * @author Administrator
 *
 */
public class SoyaBeanMilk implements Drink{


	@Override
	public float cost() {
		return 10f;
	}

	@Override
	public String description() {
		return "纯豆浆";
	}

}
