package models;

import java.text.SimpleDateFormat;
import java.util.Comparator;

/**
 * @author Mualim
 * @date ����ʱ�䣺2017-3-29 ����1:34:54
 * @version 1.0
 * @parameter
 * @return
 */
public class BirthdayComparator implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(arg0.getBirthday()).compareToIgnoreCase(
				sdf.format(arg1.getBirthday()));
	}

}
