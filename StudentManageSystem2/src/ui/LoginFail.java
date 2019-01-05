package ui;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import models.Language;


/**
 * @author Mualim
 * @date 创建时间：2017-3-21 上午12:08:01
 * @version 1.0
 * @parameter
 * @return
 */
public class LoginFail extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5283232813843796057L;

	public LoginFail(final Login lg, int res) {
		setLayout(null);
		setVisible(true);
		setAlwaysOnTop(true);
		setSize(300, 200);
		setTitle("LoginFail");
		setResizable(false);
		setLocationRelativeTo(lg);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		final LoginFail thiz = this;

		// 屏蔽操作
		final Component[] c = lg.getComponents();
		final MouseListener[][] mls = new MouseListener[c.length][];
		for (int i = 0; i < c.length; i++) {
			mls[i] = c[i].getMouseListeners();
			for (MouseListener ml : mls[i]) {
				c[i].removeMouseListener(ml);
			}
		}
		lg.getLanguageChose().setVisible(false);

		JLabel sentence = new JLabel();
		switch (res) {
		case -1:
			sentence.setText(Language.wrongPW(Language.lang));
			break;
		case -2:
			sentence.setText(Language.loginFileMiss(Language.lang));
			break;
		case 0:
			sentence.setText(Language.noUser(Language.lang));
			break;
		default:
			sentence.setText(Language.loginFail(Language.lang));
			break;
		}
		sentence.setHorizontalAlignment(SwingConstants.CENTER);
		sentence.setBounds(0, 0, 300, 100);
		add(sentence);
		JButton confirm = new JButton(Language.confirm(Language.lang));
		confirm.setBounds(75, 100, 150, 50);
		add(confirm);

		confirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				for (int i = 0; i < c.length; i++) {
					for (MouseListener ml : mls[i]) {
						c[i].addMouseListener(ml);
					}
				}
				lg.getLanguageChose().setVisible(true);
				thiz.dispose();
			}
		});
	}

}
