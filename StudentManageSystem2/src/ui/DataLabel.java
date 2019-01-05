package ui;

import imps.ManageSystemImp;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;


import models.Student;

/**
 * @author Mualim
 * @date 创建时间：2017-3-20 下午1:44:31
 * @version 1.0
 * @parameter
 * @return
 */
public class DataLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5449049090504417912L;

	public DataLabel(final ArrayList<Student> list,
			final ManageSystemImp manageSystem, final QueryPage qp) {
		setLayout(null);
		setAutoscrolls(true);
		setVisible(true);
		setLocation(0, 0);

		int i = 0;
		for (; i < list.size(); i++) {
			Student st = list.get(i);
			StudentLabel studentLabel = new StudentLabel(st, manageSystem, qp);
			studentLabel.setLocation(0, 40 * i);
			add(studentLabel);
		}

		setSize(1246, (i + 1) * 40);
		setPreferredSize(new Dimension(1246, (i + 1) * 40));
	}

}
