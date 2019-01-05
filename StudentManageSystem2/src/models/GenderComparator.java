package models;

import java.util.Comparator;


/** 
 * @author  Mualim
 * @date 创建时间：2017-3-27 上午11:23:38 
 * @version 1.0 
 * @parameter  
 * @return  
 */
public class GenderComparator implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		return arg0.getGender().compareToIgnoreCase(arg1.getGender());
	}

}
