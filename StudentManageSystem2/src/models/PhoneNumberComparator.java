package models;

import java.util.Comparator;

/** 
 * @author  Mualim
 * @date ����ʱ�䣺2017-3-29 ����1:36:23 
 * @version 1.0 
 * @parameter  
 * @return  
 */
public class PhoneNumberComparator implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		return (int) (arg0.getPhoneNumber() - arg1.getPhoneNumber());
	}

}
