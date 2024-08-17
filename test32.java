package study;

/**
 * 数组的示例:2.打印正三角形
 */
public class test32 {
	public static void main(String [] args) {
		
		char[] cs = {'A','B','C','D','E','F','G'};
		int len = cs.length;
		//外循环控制行数
		for (int i = 1; i <= len; i++) {
			
			//内循环控制列数
			for (int j = i; j < len; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i*2-1; j++) {
				System.out.print(cs[i-1]);
			}
			System.out.println();
			//输出结果
		}
	}
}