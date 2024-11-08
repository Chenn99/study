
public class OneToManyDemo {

	public static void main(String[] args) {

		Teacher t1 = new Teacher("张老师", 40, "男");
		Student s1 = new Student("小王", 18);
		Student s2 = new Student("小陈", 16);
		Student s3 = new Student("小李", 17);
		
		//关联关系
		t1.getStudents().add(s1);
		t1.getStudents().add(s2);
		t1.getStudents().add(s3);
		
		s1.setTeacher(t1);
		s2.setTeacher(t1);
		s3.setTeacher(t1);
		
		print(t1);
	}
	
	private static void print(Teacher t1) {
		System.out.println(t1.getName());
		for (Student s : t1.getStudents()) {
			System.out.println(s);
//			张老师
//			Student [name=小李, age=17]
//			Student [name=小王, age=18]
//			Student [name=小陈, age=16]
		}
	}

}
