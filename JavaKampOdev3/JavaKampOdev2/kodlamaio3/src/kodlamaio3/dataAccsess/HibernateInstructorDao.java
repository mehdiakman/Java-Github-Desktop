package kodlamaio3.dataAccsess;

import kodlamaio3.entities.Instructor;

public class HibernateInstructorDao implements InstructorDao{

	@Override
	public void add(Instructor instructor) {
		System.out.println("Hibernate ile veritabanına eklendi");
		
	}

}
