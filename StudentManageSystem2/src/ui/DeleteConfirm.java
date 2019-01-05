package ui;

import imps.ManageSystemImp;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import models.Language;
import models.Student;

/**
 * @author Mualim
 * @date 创建时间：2017-3-20 下午9:52:19
 * @version 1.0
 * @parameter
 * @return
 */
public class DeleteConfirm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7653796811736827232L;

	public DeleteConfirm(final Student st, final ManageSystemImp manageSystem,
			final QueryPage qp) {
		setLayout(null);
		setVisible(true);
		setAlwaysOnTop(true);
		setSize(300, 200);
		setTitle("Delete");
		setResizable(false);
		setLocationRelativeTo(qp);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		final DeleteConfirm thiz = this;

		//屏蔽操作
		final Component[] c = qp.getComponents();
		final MouseListener[][] mls = new MouseListener[c.length][];
		for (int i = 0; i < c.length; i++) {
			mls[i] = c[i].getMouseListeners();
			for (MouseListener ml : mls[i]) {
				c[i].removeMouseListener(ml);
			}
		}
		final JLabel jspBlocker = new JLabel();
		jspBlocker.setBounds(50, 100, 1266, 450);
		jspBlocker.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		qp.add(jspBlocker);
		
		JLabel sentence = new JLabel(Language.conDelete(Language.lang));
		sentence.setHorizontalAlignment(SwingConstants.CENTER);
		sentence.setBounds(0, 0, 300, 100);
		add(sentence);
		JButton confirm = new JButton(Language.confirm(Language.lang));
		confirm.setBounds(50, 100, 75, 50);
		add(confirm);
		JButton back = new JButton(Language.back(Language.lang));
		back.setBounds(175, 100, 75, 50);
		add(back);
		
		confirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				manageSystem.deleteStudent(st.getIdSchool());
				for (int i = 0; i < c.length; i++) {
					for (MouseListener ml : mls[i]) {
						c[i].addMouseListener(ml);
					}
				}
				qp.remove(jspBlocker);
				thiz.dispose();
				qp.getQuery().doClick();
			}
		});
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				for (int i = 0; i < c.length; i++) {
					for (MouseListener ml : mls[i]) {
						c[i].addMouseListener(ml);
					}
				}
				qp.remove(jspBlocker);
				thiz.dispose();
			}
		});
	}

}
