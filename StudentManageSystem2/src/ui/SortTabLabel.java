package ui;

import imps.ManageSystemImp;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import models.Language;
import models.Student;

/**
 * @author Mualim
 * @date 创建时间：2017-3-28 上午11:16:24
 * @version 1.0
 * @parameter
 * @return
 */
public class SortTabLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 848127872316638210L;

	public SortTabLabel(final ArrayList<Student> list,
			final ManageSystemImp manageSystem, final QueryPage qp) {
		setLayout(null);
		setAutoscrolls(true);
		setVisible(true);
		setLocation(0, 0);

		JButton idSchool = new JButton(Language.idSchool(Language.lang));
		idSchool.setBounds(0, 0, 106, 40);
		idSchool.setHorizontalAlignment(SwingConstants.LEFT);
		idSchool.setVerticalAlignment(SwingConstants.CENTER);
		add(idSchool);
		JButton name = new JButton(Language.name(Language.lang));
		name.setBounds(106, 0, 106, 40);
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setVerticalAlignment(SwingConstants.CENTER);
		add(name);
		JButton gender = new JButton(Language.gender(Language.lang));
		gender.setBounds(212, 0, 106, 40);
		gender.setHorizontalAlignment(SwingConstants.LEFT);
		gender.setVerticalAlignment(SwingConstants.CENTER);
		add(gender);
		JButton age = new JButton(Language.age(Language.lang));
		age.setBounds(318, 0, 106, 40);
		age.setHorizontalAlignment(SwingConstants.LEFT);
		age.setVerticalAlignment(SwingConstants.CENTER);
		add(age);
		JButton birthday = new JButton(Language.birthday(Language.lang));
		birthday.setBounds(424, 0, 106, 40);
		birthday.setHorizontalAlignment(SwingConstants.LEFT);
		birthday.setVerticalAlignment(SwingConstants.CENTER);
		add(birthday);
		JButton birthplace = new JButton(Language.birthplace(Language.lang));
		birthplace.setBounds(530, 0, 106, 40);
		birthplace.setHorizontalAlignment(SwingConstants.LEFT);
		birthplace.setVerticalAlignment(SwingConstants.CENTER);
		add(birthplace);
		JButton hometown = new JButton(Language.hometown(Language.lang));
		hometown.setBounds(636, 0, 106, 40);
		birthplace.setHorizontalAlignment(SwingConstants.LEFT);
		hometown.setVerticalAlignment(SwingConstants.CENTER);
		add(hometown);
		JButton nation = new JButton(Language.nation(Language.lang));
		nation.setBounds(742, 0, 106, 40);
		nation.setHorizontalAlignment(SwingConstants.LEFT);
		nation.setVerticalAlignment(SwingConstants.CENTER);
		add(nation);
		JButton id = new JButton(Language.id(Language.lang));
		id.setBounds(848, 0, 106, 40);
		id.setHorizontalAlignment(SwingConstants.LEFT);
		id.setVerticalAlignment(SwingConstants.CENTER);
		add(id);
		JButton health = new JButton(Language.health(Language.lang));
		health.setBounds(954, 0, 106, 40);
		health.setHorizontalAlignment(SwingConstants.LEFT);
		health.setVerticalAlignment(SwingConstants.CENTER);
		add(health);
		JButton phoneNumber = new JButton(Language.phoneNumber(Language.lang));
		phoneNumber.setBounds(1060, 0, 106, 40);
		phoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		phoneNumber.setVerticalAlignment(SwingConstants.CENTER);
		add(phoneNumber);

		idSchool.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == (MouseEvent.BUTTON1)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(0, -1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				} else if (arg0.getButton() == (MouseEvent.BUTTON3)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(0, 1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				}
			}
		});
		name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == (MouseEvent.BUTTON1)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(1, -1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				} else if (arg0.getButton() == (MouseEvent.BUTTON3)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(1, 1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				}
			}
		});
		gender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == (MouseEvent.BUTTON1)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(2, -1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				} else if (arg0.getButton() == (MouseEvent.BUTTON3)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(2, 1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				}
			}
		});
		age.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == (MouseEvent.BUTTON1)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(3, -1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				} else if (arg0.getButton() == (MouseEvent.BUTTON3)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(3, 1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				}
			}
		});
		birthday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == (MouseEvent.BUTTON1)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(4, -1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				} else if (arg0.getButton() == (MouseEvent.BUTTON3)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(4, 1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				}
			}
		});
		birthplace.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == (MouseEvent.BUTTON1)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(5, -1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				} else if (arg0.getButton() == (MouseEvent.BUTTON3)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(5, 1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				}
			}
		});
		hometown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == (MouseEvent.BUTTON1)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(6, -1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				} else if (arg0.getButton() == (MouseEvent.BUTTON3)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(6, 1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				}
			}
		});
		nation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == (MouseEvent.BUTTON1)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(7, -1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				} else if (arg0.getButton() == (MouseEvent.BUTTON3)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(7, 1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				}
			}
		});
		id.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == (MouseEvent.BUTTON1)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(8, -1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				} else if (arg0.getButton() == (MouseEvent.BUTTON3)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(8, 1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				}
			}
		});
		health.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == (MouseEvent.BUTTON1)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(9, -1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				} else if (arg0.getButton() == (MouseEvent.BUTTON3)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(9, 1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				}
			}
		});
		phoneNumber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getButton() == (MouseEvent.BUTTON1)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(10, -1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				} else if (arg0.getButton() == (MouseEvent.BUTTON3)) {
					qp.remove(qp.getJsp());
					JScrollPane jsp = new JScrollPane(new DataLabel(
							manageSystem.pageShow(qp.getPresentPage(),
									manageSystem.sort(10, 1, list)),
							manageSystem, qp));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					qp.add(jsp);
					qp.setJsp(jsp);
					qp.revalidate();
					qp.repaint();
				}
			}
		});
	}

}
