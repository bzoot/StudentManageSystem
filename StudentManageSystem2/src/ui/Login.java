package ui;

import imps.ManageSystemImp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import models.Language;

/**
 * @author Mualim
 * @date 创建时间：2017-3-20 下午11:33:47
 * @version 1.0
 * @parameter
 * @return
 */
public class Login extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8935952928494262263L;

	private LanguageChose languageChose;

	public Login(final JFrame jf) {
		setVisible(true);
		setSize(1366, 700);
		setLayout(null);
		final Login thiz = this;

		// 初始化页面组件
		JButton login = new JButton(Language.denglu(Language.lang));
		languageChose = new LanguageChose(Language.xuanzeyuyan(Language.lang),
				jf, thiz);
		JLabel lbUserName = new JLabel(Language.yonghuming(Language.lang));
		JLabel lbPassword = new JLabel(Language.mima(Language.lang));
		final JTextField userName = new JTextField(12);
		final JPasswordField password = new JPasswordField(12);

		// 设置位置
		login.setBounds(633, 525, 100, 50);
		languageChose.setBounds(1266, 525, 50, 50);
		lbUserName.setBounds(458, 400, 600, 50);
		lbPassword.setBounds(458, 450, 600, 50);
		userName.setBounds(66, 10, 400, 30);
		password.setBounds(66, 10, 400, 30);

		// 添加组件
		lbUserName.add(userName);
		lbPassword.add(password);
		add(login);
		add(languageChose);
		add(lbUserName);
		add(lbPassword);

		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				char[] cs = password.getPassword();
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < cs.length; i++) {
					char c = cs[i];
					sb.append(c);
				}
				int res = loginSuccess(userName.getText(), sb.toString());
				if (res == 1) {
					// 成功
					jf.remove(thiz);
					jf.add(new QueryPage(ManageSystemImp.getInstance()));
					jf.revalidate();
					jf.repaint();
				} else if (res == -1) {
					// 密码错误
					new LoginFail(thiz, res);
				} else if (res == -2) {
					// 缺少登录文件(错误)
					new LoginFail(thiz, res);
				} else if (res == 0) {
					// 没用户
					new LoginFail(thiz, res);
				} else {
					new LoginFail(thiz, res);
				}
			}
		});
	}

	public LanguageChose getLanguageChose() {
		return languageChose;
	}

	public void setLanguageChose(LanguageChose languageChose) {
		this.languageChose = languageChose;
	}

	/**
	 * 登录验证
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	private int loginSuccess(String userName, String password) {
		boolean userExist = false;
		boolean loginDataFunctional = false;
		int count = 0;
		while (count < 10) {
			try {
				File file = new File("login.cng");
				InputStreamReader isr = new InputStreamReader(
						new FileInputStream(file));
				BufferedReader br = new BufferedReader(isr);
				String temp = br.readLine();
				while (temp != null) {
					if (temp.startsWith(userName)) {
						int split = temp.indexOf(",");
						String rawUserName = temp.substring(0, split);
						String rawPassword = temp.substring(split + 1);
						if (userName.equals(rawUserName)) {
							userExist = true;
							if (password.toString().equals(rawPassword)) {
								br.close();
								return 1; // 成功
							}
						}
					}
					temp = br.readLine();
				}
				br.close();
				loginDataFunctional = true;
				break;
			} catch (IOException e) {
				e.printStackTrace();
				count++;
			}
		}
		if (!loginDataFunctional) {
			return -2; // 缺少登录文件(错误)
		} else if (userExist) {
			return -1; // 密码错误
		} else {
			return 0; // 没用户
		}
	}

}
