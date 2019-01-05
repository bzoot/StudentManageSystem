package models;

import java.util.Comparator;

/**
 * @author Mualim
 * @date 创建时间：2017-3-29 上午1:36:12
 * @version 1.0
 * @parameter
 * @return
 */
public class HealthComparator implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		return arg0.getHealth().compareToIgnoreCase(arg1.getHealth());
	}

}
