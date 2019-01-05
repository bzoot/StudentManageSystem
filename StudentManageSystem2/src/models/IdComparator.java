package models;

import java.util.Comparator;

/**
 * @author Mualim
 * @date ����ʱ�䣺2017-3-29 ����1:36:04
 * @version 1.0
 * @parameter
 * @return
 */
public class IdComparator implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		return (int) (arg0.getId() - arg1.getId());
	}

}
