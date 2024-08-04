package study;

/**
 * & 和 && 的区别
 * @author min
 *
 */
public class test7 {
	public static void main(String [] args) {
		
		boolean a = false;
		boolean b = true;
		
		boolean c = (!a) & b;
		System.out.println(c);
		//& 与运算在逻辑算术运算时分别计算表达式两边的结果,再做&与运算,在做位运算时,表示按位与
		//&& 短路与运算,先计算左边的表达式,如果结果是false,那么不用计算右边表达式,直接返回false
		//如果左边的表达式结果是true,再计算右边的表达式,如果右边的表达式为true,结果才为true,否则为false
		
		//| 或 和 || 短路或 原理同上
		//所以短路与 或 短路或的计算效率更高,建议使用。
	}
}
