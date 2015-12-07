package de.htw_berlin.ai_bachelor.kbe.annotations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import static java.util.stream.Collectors.*;
import java.util.stream.Stream;


@CreationInfo (
	description = "Eine Description",
	tags = { "Tag1", "Tag3" },
	superClass = ArrayList.class,
	interfaces = {Serializable.class, Comparable.class}
)
public class Student extends ArrayList<Student> implements Serializable, Comparable<Student> {

	private static final long serialVersionUID = 1L;


	@Override
	public int compareTo(Student o) {
		return 0;
	}
	
	public static void main(String[] args) {
		CreationInfo info = Student.class.getAnnotation(CreationInfo.class);
		System.out.printf("Author: %s \n", info.author());
		System.out.printf("Description: %s \n", info.description());
		System.out.printf("Tags: %s \n", String.join(", ", info.tags()));
		
		System.out.printf("SuperClass: %s \n", info.superClass().getName());
		System.out.printf("Interfaces: %s \n", toString(info.interfaces()));
	}

	private static String toString(Class<?>[] classes) {
		return Stream
			.of(classes)
			.map(Objects::toString)
			.collect(joining(", "));
		
	}
}
