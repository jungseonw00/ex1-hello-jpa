package designPattern.builder;

public class Main {

	public static void main(String[] args) {
		Student student = new StudentBuilder()
					.id(1000)
					.grade("4")
					.phoneNumber("010-4000-1278")
					.build();
		System.out.println("student = " + student.getName().indexOf("1"));
	}
}
