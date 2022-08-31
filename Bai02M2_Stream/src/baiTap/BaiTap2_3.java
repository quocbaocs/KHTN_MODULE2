package baiTap;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class BaiTap2_3 {

	public static void main(String[] args) {
		Student student1 = new Student("Phuong Khuat", 17, 7.0, 8.0);
		Student student2 = new Student("Hanh Nguyen", 19, 7.5, 8.5);
		Student student3 = new Student("Hoa Huynh", 18, 6.5, 7.5);
		Student student4 = new Student("Duyen Phan", 20, 7.5, 7.5);
		Student student5 = new Student("Thao Phan", 23, 8.0, 5.5);
		Student student6 = new Student("Tam Tran", 15, 9.0, 4.0);
		Student student7 = new Student("Hong Duc", 26, 5.5, 5.5);
		Student student8 = new Student("Lac Nuong", 14, 6.5, 4.5);
		Student student9 = new Student("Thuy Kieu", 19, 6.0, 6.5);
		Student student10 = new Student("Moc Lan Anh ", 14, 4.0, 7.5);
		List<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		list.add(student4);
		list.add(student5);
		list.add(student6);
		list.add(student7);
		list.add(student8);
		list.add(student9);
		list.add(student10);
		System.out.println("danh sách Student:");
		list.forEach(x -> System.out.println(x.toString()));
		
		System.out.println("danh sach bat dau bang chu H");
		list.stream().filter(x -> x.firstName.startsWith("H")).forEach(x -> System.out.println(x.toString()));
		DoubleSummaryStatistics staticStudent = list.stream().mapToDouble((x) -> (double) x.diemTB())
				.summaryStatistics();
		System.out.println("Highest Avg Mark in List:" + staticStudent.getMax());
		System.out.println("Lowest Avg Mark in List:" + staticStudent.getMin());
		System.out.println("Sum of all Avg Mark: " + staticStudent.getSum());

		List<Student> listStudentGood = list.stream().filter(x -> x.diemTB() >= 8).collect(Collectors.toList());
		listStudentGood.forEach(x -> System.out.println(x.toString()));

	}

}

class Student {
	String firstName;
	int age;
	double mark1;
	double mark2;

	public Student(String firstName, int age, double mark1, double mark2) {
		super();
		this.firstName = firstName;
		this.age = age;
		this.mark1 = mark1;
		this.mark2 = mark2;
	}

	public Student() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getMark1() {
		return mark1;
	}

	public void setMark1(double mark1) {
		this.mark1 = mark1;
	}

	public double getMark2() {
		return mark2;
	}

	public void setMark2(double mark2) {
		this.mark2 = mark2;
	}

	public void setMark2(float mark2) {
		this.mark2 = mark2;
	}

	public double diemTB() {
		return (this.mark1 + this.mark2) / 2;
	}

	@Override
	public String toString() {
		return firstName + "	 age = " + age + "	mark1=" + mark1 + " & mark2=" + mark2 + "	 avg = " + diemTB();
	}

}