package designPattern.builder;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class BuilderTest {

	@Test
	void builderTest() {
	    // given
		Student student = new StudentBuilder()
			.id(1000)
			.grade("4")
			.phoneNumber("010-4000-1278")
			.build();

		log.info("student => {}", student);

		StudentBuilder id = new StudentBuilder().id(1000);
		log.info("id => {}", id);

		Student studentBuilder = Student.builder()
											.id(1000)
											.grade("4")
											.phoneNumber("010-4000-1278")
											.build();
		log.info("studentBuilder => {}", studentBuilder);
	}
}