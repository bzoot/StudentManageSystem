package ui;

import imps.ManageSystemImp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import models.Language;
import models.Student;

/**
 * @author Mualim
 * @date 创建时间：2017-3-20 下午1:57:42
 * @version 1.0
 * @parameter
 * @return
 */
public class StudentLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8523702855820118403L;

	public StudentLabel(final Student st, final ManageSystemImp manageSystem,
			final QueryPage qp) {
		setLayout(null);
		setVisible(true);
		setSize(1246, 40);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		final JLabel idSchool = new JLabel("     " + String.valueOf(st.getIdSchool()));
		idSchool.setToolTipText(String.valueOf(st.getIdSchool()));
		idSchool.setBounds(0, 0, 106, 40);
		idSchool.setHorizontalAlignment(SwingConstants.LEFT);
		idSchool.setVerticalAlignment(SwingConstants.CENTER);
		add(idSchool);
		JLabel name = new JLabel("     " + st.getName());
		name.setToolTipText(st.getName());
		name.setBounds(106, 0, 106, 40);
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setVerticalAlignment(SwingConstants.CENTER);
		add(name);
		JLabel gender = new JLabel("     " + st.getGender());
		gender.setToolTipText(st.getGender());
		gender.setBounds(212, 0, 106, 40);
		gender.setHorizontalAlignment(SwingConstants.LEFT);
		gender.setVerticalAlignment(SwingConstants.CENTER);
		add(gender);
		JLabel age = new JLabel("     " + String.valueOf(st.getAge()));
		age.setToolTipText(String.valueOf(st.getAge()));
		age.setBounds(318, 0, 106, 40);
		age.setHorizontalAlignment(SwingConstants.LEFT);
		age.setVerticalAlignment(SwingConstants.CENTER);
		add(age);
		JLabel birthday = new JLabel("     " + sdf.format(st.getBirthday()));
		birthday.setToolTipText(sdf.format(st.getBirthday()));
		birthday.setBounds(424, 0, 106, 40);
		birthday.setHorizontalAlignment(SwingConstants.LEFT);
		birthday.setVerticalAlignment(SwingConstants.CENTER);
		add(birthday);
		JLabel birthplace = new JLabel("     " + st.getBirthplace());
		birthplace.setToolTipText(st.getBirthplace());
		birthplace.setBounds(530, 0, 106, 40);
		birthplace.setHorizontalAlignment(SwingConstants.LEFT);
		birthplace.setVerticalAlignment(SwingConstants.CENTER);
		add(birthplace);
		JLabel hometown = new JLabel("     " + st.getHometown());
		hometown.setToolTipText(st.getHometown());
		hometown.setBounds(636, 0, 106, 40);
		hometown.setHorizontalAlignment(SwingConstants.LEFT);
		hometown.setVerticalAlignment(SwingConstants.CENTER);
		add(hometown);
		JLabel nation = new JLabel("     " + st.getNation());
		nation.setToolTipText(st.getNation());
		nation.setBounds(742, 0, 106, 40);
		nation.setHorizontalAlignment(SwingConstants.LEFT);
		nation.setVerticalAlignment(SwingConstants.CENTER);
		add(nation);
		JLabel id = new JLabel("     " + String.valueOf(st.getId()));
		id.setToolTipText(String.valueOf(st.getId()));
		id.setBounds(848, 0, 106, 40);
		id.setHorizontalAlignment(SwingConstants.LEFT);
		id.setVerticalAlignment(SwingConstants.CENTER);
		add(id);
		JLabel health = new JLabel("     " + st.getHealth());
		health.setToolTipText(st.getHealth());
		health.setBounds(954, 0, 106, 40);
		health.setHorizontalAlignment(SwingConstants.LEFT);
		health.setVerticalAlignment(SwingConstants.CENTER);
		add(health);
		JLabel phoneNumber = new JLabel("     " + String.valueOf(st.getPhoneNumber()));
		phoneNumber.setToolTipText(String.valueOf(st.getPhoneNumber()));
		phoneNumber.setBounds(1060, 0, 106, 40);
		phoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		phoneNumber.setVerticalAlignment(SwingConstants.CENTER);
		add(phoneNumber);

		JButton update = new JButton(Language.update(Language.lang));
		update.setBounds(1166, 0, 40, 40);
		update.setToolTipText(Language.update(Language.lang));
		add(update);
		JButton delete = new JButton(Language.delete(Language.lang));
		delete.setBounds(1206, 0, 40, 40);
		delete.setToolTipText(Language.delete(Language.lang));
		add(delete);

		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				qp.setVisible(false);
				new UpdateWindow(manageSystem, qp, st);
			}
		});
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new DeleteConfirm(st, manageSystem, qp);
			}
		});
	}

}
