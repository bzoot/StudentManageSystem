package ui;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import models.Language;


/**
 * @author Mualim
 * @date 创建时间：2017-3-20 下午10:47:39
 * @version 1.0
 * @parameter
 * @return
 */
public class ErrorPopFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5522792160411339665L;

	public ErrorPopFrame(final JFrame jf) {
		setLayout(null);
		setVisible(true);
		setAlwaysOnTop(true);
		setSize(300, 200);
		setTitle("Errors");
		setResizable(false);
		setLocationRelativeTo(jf);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		final ErrorPopFrame thiz = this;

		// 屏蔽操作
		final Component[] c = jf.getContentPane().getComponents();
		final MouseListener[][] mls = new MouseListener[c.length][];
		for (int i = 0; i < c.length; i++) {
			mls[i] = c[i].getMouseListeners();
			for (MouseListener ml : mls[i]) {
				c[i].removeMouseListener(ml);
			}
		}
		jf.setAlwaysOnTop(false);

		JTextArea sentence = new JTextArea(Language.legPlz(Language.lang));
		sentence.setOpaque(false);
		sentence.setEditable(false);
		sentence.setBounds(35, 10, 300, 70);
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
				jf.setAlwaysOnTop(true);
				thiz.dispose();
			}
		});
	}

}
