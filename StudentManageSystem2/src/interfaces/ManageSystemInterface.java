package interfaces;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import models.Student;

/**
 * @author Mualim
 * @date 创建时间：2017-3-20 下午7:28:23
 * @version 1.0
 * @parameter
 * @return
 */
public interface ManageSystemInterface {

	/**
	 * 
	 * @param idSchool
	 * @param name
	 * @param gender
	 * @param age
	 * @param birthday
	 * @param birthplace
	 * @param hometown
	 * @param nation
	 * @param id
	 * @param health
	 * @param phoneNumber
	 * @return
	 */
	public int addStudent(long idSchool, String name, String gender, int age,
			Date birthday, String birthplace, String hometown, String nation,
			long id, String health, long phoneNumber);

	/**
	 * 
	 * @param file
	 * @return
	 */
	public int batchAddStudents(File file);

	/**
	 * 
	 * @param idSchool
	 * @return
	 */
	public int deleteStudent(long idSchool);

	/**
	 * 
	 * @param idSchools
	 * @return
	 */
	public int deleteStudents(ArrayList<Long> idSchools);

	/**
	 * 
	 * @param idSchool
	 * @param name
	 * @param gender
	 * @param age
	 * @param birthday
	 * @param birthplace
	 * @param hometown
	 * @param nation
	 * @param idNew
	 * @param health
	 * @param phoneNumber
	 * @return
	 */
	public int updateStudent(long idSchool, long idSchoolNew, String name,
			String gender, int age, Date birthday, String birthplace,
			String hometown, String nation, long id, String health,
			long phoneNumber);

	/**
	 * 
	 * @param idSchool
	 * @param initList
	 * @return
	 */
	public ArrayList<Student> queryStudent(long idSchool, ArrayList<Student> initList);

	/**
	 * 
	 * @param name
	 * @param initList
	 * @return
	 */
	public ArrayList<Student> queryStudent(String name,
			ArrayList<Student> initList);

	/**
	 * 
	 * @param col
	 * @param order
	 * @param list
	 * @return
	 */
	public ArrayList<Student> sort(int col, int order, ArrayList<Student> list);

	/**
	 * 
	 * @param page
	 * @param list
	 * @return
	 */
	public ArrayList<Student> pageShow(int page, ArrayList<Student> list);
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public int exportStudents(ArrayList<Student> list);

}
