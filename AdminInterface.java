package Park_HW1;

public interface AdminInterface {
	public void createCourse(String courseName, String id, int max, String prof, int section, String location);
	public void deleteCourse();
	public void editCourse(String nameOfCourse, int n, String field);
	public String courseInfo(String id);
	

}
