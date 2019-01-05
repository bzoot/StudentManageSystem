package models;

import java.util.Comparator;


/** 
 * @author  Mualim
 * @date ����ʱ�䣺2017-3-27 ����11:24:52 
 * @version 1.0 
 * @parameter  
 * @return  
 */
public class IdSchoolComparator implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		return (int) (arg0.getIdSchool() - arg1.getIdSchool());
	}

}
