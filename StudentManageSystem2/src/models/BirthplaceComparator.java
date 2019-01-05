package models;

import java.util.Comparator;

/**
 * @author Mualim
 * @date ����ʱ�䣺2017-3-29 ����1:35:02
 * @version 1.0
 * @parameter
 * @return
 */
public class BirthplaceComparator implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		return arg0.getBirthplace().compareToIgnoreCase(arg1.getBirthplace());
	}

}
