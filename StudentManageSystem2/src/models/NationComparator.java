package models;

import java.util.Comparator;

/**
 * @author Mualim
 * @date 创建时间：2017-3-29 上午1:35:25
 * @version 1.0
 * @parameter
 * @return
 */
public class NationComparator implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		return arg0.getNation().compareToIgnoreCase(arg1.getNation());
	}

}
