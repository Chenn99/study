package study;

/**
 *二维数组的示例:JAVA中没有真正的多维数组,多维数组的表示方式是数组中的元素还是数组。
 *一起来参加程序员大赛把，有3个班级各3名学员参赛。
 *记录每个学员的成绩，并计算每个班的平均分。
 */
public class test33 {
	public static void main(String [] args) {
		//二维数组是两个[]
		int [] [] scores= {{79,98,88},{87,96,85},{67,78,89}};
		int classLen = scores.length;
		
		//外循环控制行数
		for (int i = 0; i < classLen; i++) {
			int sum = 0;
			int count = scores[i].length;
			//内循环控制列数
			for (int j = 0; j < count; j++) {
				
				sum+=scores[i][j];
			}
			int avg = sum/count;
			System.out.println("第"+(i+1)+"班的平均分成绩是： "+avg);
			
			//输出结果：
			//第1班的平均分成绩是： 88
			//第2班的平均分成绩是： 89
			//第3班的平均分成绩是： 78
		}
	}
}
/*
 * 78 98 88
 * 87 96 85
 * 67 78 89
*/
