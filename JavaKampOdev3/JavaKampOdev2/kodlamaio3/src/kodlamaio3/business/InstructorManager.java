package kodlamaio3.business;

public class InstructorManager {
	import kodlamaio3.corelogging.Logger;
	import kodlamaio3.dataAccsess.CategoryDao;
	import kodlamaio3.dataAccsess.InstructorDao;
	import kodlamaio3.entities.Category;
	import kodlamaio3.entities.Instructor;

	public class InstructorManager {
		private InstructorDao instructorDao;
		private Logger[] loggers;
		
		
		public InstructorManager(InstructorDao instructorDao, Logger[] loggers) {
			this.instructorDao = instructorDao;
			this.loggers = loggers;
		}
		
		public void add(Instructor instructor) {
			instructorDao.add(instructor);
			System.out.println("Egitmen eklendi");
			
			for(Logger logger:loggers) {
				logger.log(instructor.getInstructorName());
			}

		}
}
