package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import utils.StringUtils;

import models.Language;

public class LanguageChose extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 242421767515660864L;

	public LanguageChose(String s, final JFrame jf, final Login lg) {
		final String[] languages = new String[] { "CN", "EN" };

		setVisible(true);
		JMenu jm = new JMenu(s);

		for (int i = 0; i < languages.length; i++) {
			final int a = i;
			JMenuItem item = new JMenuItem(languages[a]);
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Language.lang = languages[a];
					jf.remove(lg);
					jf.add(new Login(jf));
					jf.revalidate();
					jf.repaint();

					try {
						File file = new File("option.cng");
						StringBuilder sb = new StringBuilder();
						if (file.canRead()) {
							BufferedReader br = new BufferedReader(
									new InputStreamReader(new FileInputStream(
											file)));
							String temp = br.readLine();
							while (temp != null) {
								if (StringUtils.isStartWithIgnoreCase("lang",
										temp)) {
									temp = "lang=" + languages[a];
								}
								sb.append(temp + "\r\n");
								temp = br.readLine();
							}
							br.close();
						}
						if (file.canWrite()) {
							BufferedWriter bw = new BufferedWriter(
									new OutputStreamWriter(
											new FileOutputStream(file)));
							bw.write(sb.toString());
							bw.flush();
							bw.close();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});

			jm.add(item);
		}

		add(jm);
	}

}
