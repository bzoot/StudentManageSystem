package ui;

import imps.ManageSystemImp;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import models.Language;

/**
 * @author Mualim
 * @date 创建时间：2017-3-20 下午4:26:04
 * @version 1.0
 * @parameter
 * @return
 */
public class AddWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1344144426712477380L;

	public AddWindow(final ManageSystemImp manageSystem, final QueryPage qp) {
		setLayout(null);
		setVisible(true);
		setAlwaysOnTop(true);
		setSize(300, 600);
		setTitle("Add");
		setResizable(false);
		setLocationRelativeTo(qp);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		JLabel lb = new JLabel();
		lb.setBounds(0, 0, 275, 880);
		lb.setPreferredSize(new Dimension(275, 880));
		JScrollPane jsp = new JScrollPane(lb);
		jsp.setBounds(0, 0, 300, 570);
		jsp.getVerticalScrollBar().setPreferredSize(new Dimension(20, 570));
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(jsp);
		final AddWindow thiz = this;
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		JLabel idSchool = new JLabel(Language.idSchool(Language.lang) + ":");
		idSchool.setBounds(20, 20, 80, 50);
		idSchool.setHorizontalAlignment(SwingConstants.LEFT);
		idSchool.setVerticalAlignment(SwingConstants.CENTER);
		lb.add(idSchool);
		final JTextField idSchoolF = new JTextField(12);
		idSchoolF.setBounds(100, 25, 150, 40);
		lb.add(idSchoolF);

		JLabel name = new JLabel(Language.name(Language.lang) + ":");
		name.setBounds(20, 90, 80, 50);
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setVerticalAlignment(SwingConstants.CENTER);
		lb.add(name);
		final JTextField nameF = new JTextField(12);
		nameF.setBounds(100, 95, 150, 40);
		lb.add(nameF);

		JLabel age = new JLabel(Language.age(Language.lang) + ":");
		age.setBounds(20, 160, 80, 50);
		age.setHorizontalAlignment(SwingConstants.LEFT);
		age.setVerticalAlignment(SwingConstants.CENTER);
		lb.add(age);
		final JTextField ageF = new JTextField(12);
		ageF.setBounds(100, 165, 150, 40);
		lb.add(ageF);

		JLabel gender = new JLabel(Language.gender(Language.lang) + ":");
		gender.setBounds(20, 230, 80, 50);
		gender.setHorizontalAlignment(SwingConstants.LEFT);
		gender.setVerticalAlignment(SwingConstants.CENTER);
		lb.add(gender);
		final JTextField genderF = new JTextField(12);
		genderF.setBounds(100, 235, 150, 40);
		lb.add(genderF);

		JLabel birthday = new JLabel(Language.birthday(Language.lang) + ":");
		birthday.setBounds(20, 300, 80, 50);
		birthday.setHorizontalAlignment(SwingConstants.LEFT);
		birthday.setVerticalAlignment(SwingConstants.CENTER);
		lb.add(birthday);
		final JTextField birthdayF = new JTextField(12);
		birthdayF.setBounds(100, 305, 150, 40);
		lb.add(birthdayF);

		JLabel birthplace = new JLabel(Language.birthplace(Language.lang) + ":");
		birthplace.setBounds(20, 370, 80, 50);
		birthplace.setHorizontalAlignment(SwingConstants.LEFT);
		birthplace.setVerticalAlignment(SwingConstants.CENTER);
		lb.add(birthplace);
		final JTextField birthplaceF = new JTextField(12);
		birthplaceF.setBounds(100, 375, 150, 40);
		lb.add(birthplaceF);

		JLabel hometown = new JLabel(Language.hometown(Language.lang) + ":");
		hometown.setBounds(20, 440, 80, 50);
		hometown.setHorizontalAlignment(SwingConstants.LEFT);
		hometown.setVerticalAlignment(SwingConstants.CENTER);
		lb.add(hometown);
		final JTextField hometownF = new JTextField(12);
		hometownF.setBounds(100, 445, 150, 40);
		lb.add(hometownF);

		JLabel nation = new JLabel(Language.nation(Language.lang) + ":");
		nation.setBounds(20, 510, 80, 50);
		nation.setHorizontalAlignment(SwingConstants.LEFT);
		nation.setVerticalAlignment(SwingConstants.CENTER);
		lb.add(nation);
		final JTextField nationF = new JTextField(12);
		nationF.setBounds(100, 515, 150, 40);
		lb.add(nationF);

		JLabel id = new JLabel(Language.id(Language.lang) + ":");
		id.setBounds(20, 580, 80, 50);
		id.setHorizontalAlignment(SwingConstants.LEFT);
		id.setVerticalAlignment(SwingConstants.CENTER);
		lb.add(id);
		final JTextField idF = new JTextField(12);
		idF.setBounds(100, 585, 150, 40);
		lb.add(idF);

		JLabel health = new JLabel(Language.health(Language.lang) + ":");
		health.setBounds(20, 650, 80, 50);
		health.setHorizontalAlignment(SwingConstants.LEFT);
		health.setVerticalAlignment(SwingConstants.CENTER);
		lb.add(health);
		final JTextField healthF = new JTextField(12);
		healthF.setBounds(100, 655, 150, 40);
		lb.add(healthF);

		JLabel phoneNumber = new JLabel(Language.phoneNumber(Language.lang)
				+ ":");
		phoneNumber.setBounds(20, 720, 80, 50);
		phoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		phoneNumber.setVerticalAlignment(SwingConstants.CENTER);
		lb.add(phoneNumber);
		final JTextField phoneNumberF = new JTextField(12);
		phoneNumberF.setBounds(100, 725, 150, 40);
		lb.add(phoneNumberF);

		// 初始化按钮
		JButton submit = new JButton(Language.submit(Language.lang));
		submit.setBounds(50, 790, 75, 50);
		submit.setToolTipText(Language.submit(Language.lang));
		lb.add(submit);
		JButton back = new JButton(Language.back(Language.lang));
		back.setToolTipText(Language.back(Language.lang));
		back.setBounds(175, 790, 75, 50);
		lb.add(back);

		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String idSchool = "";
				if (idSchoolF.getText().matches("[0-9]+")) {
					idSchool = idSchoolF.getText();
				} else {
					new ErrorPopFrame(thiz);
					return;
				}
				String name = nameF.getText();
				String gender = "";
				String genderO = genderF.getText();
				if (genderO.equalsIgnoreCase("male")
						|| genderO.equalsIgnoreCase("female")
						|| genderO.equals("男") || genderO.equals("女")) {
					gender = genderO;
				} else {
					new ErrorPopFrame(thiz);
					return;
				}
				String age = "";
				if (ageF.getText().matches("[0-9]+")) {
					age = ageF.getText();
				} else {
					new ErrorPopFrame(thiz);
					return;
				}
				String birthday = "";
				if (birthdayF.getText().matches(
						"[0-9][0-9][0-9][0-9]-[0-1][0-9]-[0-3][0-9]")) {
					birthday = birthdayF.getText();
				} else {
					new ErrorPopFrame(thiz);
					return;
				}
				String birthplace = birthplaceF.getText();
				String hometown = hometownF.getText();
				String nation = nationF.getText();
				String id = "";
				if (idF.getText().matches("[0-9]+")) {
					id = idF.getText();
				} else {
					new ErrorPopFrame(thiz);
					return;
				}
				String health = healthF.getText();
				String phoneNumber = "";
				if (phoneNumberF.getText().matches("[0-9]+")) {
					phoneNumber = phoneNumberF.getText();
				} else {
					new ErrorPopFrame(thiz);
					return;
				}

				try {
					if (manageSystem.addStudent(Long.parseLong(idSchool), name,
							gender, Integer.parseInt(age), sdf.parse(birthday),
							birthplace, hometown, nation, Long.parseLong(id),
							health, Long.parseLong(phoneNumber)) == 1) {
						// 成功
					} else {
						// 失败 存在学号冲突
					}
				} catch (NumberFormatException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				qp.setVisible(true);
				thiz.dispose();
				qp.getQuery().doClick();
				qp.revalidate();
				qp.repaint();
			}
		});
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				qp.setVisible(true);
				thiz.dispose();
			}
		});
	}
}
