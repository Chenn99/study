import java.util.Arrays;
import java.util.Comparator;

public class Test {

	public static void main(String[] args) {

		int[] nums = {34,54,22,3,5,6,7,87,9};//根据数据的大小进行排列
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		//[3, 5, 6, 7, 9, 22, 34, 54, 87]
		
		String[] names = {"jack","tom","菲菲","粪粪"};//字符串
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		//[jack, tom, 粪粪, 菲菲]
		
		Cat[] cats = {new Cat("愤愤", 1),new Cat("菲菲", 4),new Cat("Tom", 2)};
		//自定义对象 
		Arrays.sort(cats);
		System.out.println(Arrays.toString(cats));
		//[Cat [name=愤愤, age=1], Cat [name=Tom, age=2], Cat [name=菲菲, age=4]]
		
		Dog[] dogs = {new Dog("愤愤", 1),new Dog("菲菲", 4),new Dog("Tom", 2)};
		//自定义对象 
		Arrays.sort(dogs,new DogComparator());//加上比较器
		System.out.println(Arrays.toString(dogs));
		//[Dog [name=愤愤, age=1], Dog [name=Tom, age=2], Dog [name=菲菲, age=4]]
	}

}
