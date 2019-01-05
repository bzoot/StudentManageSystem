package ui;

import imps.ManageSystemImp;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import models.Language;
import models.Student;

/**
 * @author Mualim
 * @date 创建时间：2017-3-20 下午12:13:13
 * @version 1.0
 * @parameter
 * @return
 */
public class QueryPage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1638555038310838964L;

	private SortTabLabel stl;
	private JScrollPane jsp;
	private JButton query;
	private ArrayList<Student> list;
	private ArrayList<Student> listShow;
	private int pageNumber;
	private int presentPage;

	public QueryPage(final ManageSystemImp manageSystemImp) {
		setLayout(null);
		setVisible(true);
		setSize(1366, 700);
		final QueryPage thiz = this;

		// 初始化按钮
		JButton add = new JButton(Language.add(Language.lang));
		add.setBounds(50, 20, 75, 50);
		add.setToolTipText(Language.add(Language.lang));
		add(add);
		query = new JButton(Language.query(Language.lang));
		query.setToolTipText(Language.query(Language.lang));
		query.setBounds(1241, 20, 75, 50);
		add(query);
		JButton batchAdd = new JButton(Language.batchAdd(Language.lang));
		batchAdd.setBounds(50, 605, 125, 50);
		batchAdd.setToolTipText(Language.batchAdd(Language.lang));
		add(batchAdd);
		JButton batchExport = new JButton(Language.batchExport(Language.lang));
		batchExport.setBounds(195, 605, 125, 50);
		batchExport.setToolTipText(Language.batchExport(Language.lang));
		add(batchExport);

		// 查询条件框
		JLabel name = new JLabel(Language.name(Language.lang) + ":");
		name.setBounds(175, 20, 50, 50);
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setVerticalAlignment(SwingConstants.CENTER);
		add(name);
		final JTextField nameF = new JTextField(12);
		nameF.setBounds(225, 25, 150, 40);
		add(nameF);
		JLabel id = new JLabel(Language.idSchool(Language.lang) + ":");
		id.setBounds(425, 20, 50, 50);
		id.setHorizontalAlignment(SwingConstants.LEFT);
		id.setVerticalAlignment(SwingConstants.CENTER);
		add(id);
		final JTextField idF = new JTextField(12);
		idF.setBounds(475, 25, 150, 40);
		add(idF);

		list = manageSystemImp.getAllData();
		listShow = manageSystemImp.pageShow(1, list);
		pageNumber = list.size() % manageSystemImp.getPageSize() == 0 ? (list
				.size() / manageSystemImp.getPageSize() == 0 ? 1 : list.size()
				/ manageSystemImp.getPageSize()) : list.size()
				/ manageSystemImp.getPageSize() + 1;
		presentPage = 1;
		stl = new SortTabLabel(list, manageSystemImp, thiz);
		stl.setBounds(50, 100, 1166, 40);
		add(stl);
		jsp = new JScrollPane(new DataLabel(listShow, manageSystemImp, thiz));
		jsp.setBounds(50, 140, 1266, 450);
		jsp.getVerticalScrollBar().setPreferredSize(new Dimension(16, 400));
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(jsp);

		JButton pre = new JButton("<");
		pre.setBounds(1066, 605, 50, 50);
		add(pre);
		JButton next = new JButton(">");
		next.setBounds(1266, 605, 50, 50);
		add(next);
		JButton go = new JButton("Go");
		go.setBounds(1216, 605, 50, 50);
		add(go);
		final JTextField page = new JTextField(4);
		page.setBounds(1166, 605, 50, 50);
		page.setHorizontalAlignment(SwingConstants.CENTER);
		add(page);
		final JLabel pageAndAllpage = new JLabel(String.valueOf(presentPage)
				+ "/" + String.valueOf(pageNumber));
		pageAndAllpage.setBounds(1116, 605, 50, 50);
		pageAndAllpage.setHorizontalAlignment(SwingConstants.CENTER);
		add(pageAndAllpage);

		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				thiz.setVisible(false);
				new AddWindow(manageSystemImp, thiz);
			}
		});
		query.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				list = new ArrayList<Student>();
				ArrayList<Student> list1 = new ArrayList<Student>();
				ArrayList<Student> list2 = new ArrayList<Student>();
				String id = "";
				String name = "";

				if (idF.getText().matches("[0-9]+")) {
					id = idF.getText();
					list1 = manageSystemImp.queryStudent(Long.parseLong(id),
							manageSystemImp.getAllData());
				} else if (idF.getText() == null || idF.getText().isEmpty()) {
					list1 = manageSystemImp.getAllData();
				} else {
					list1 = list;
				}
				if (nameF.getText() != null || !nameF.getText().isEmpty()) {
					name = nameF.getText();
					list2 = manageSystemImp.queryStudent(name, list1);
				} else {
					list2 = list1;
				}
				list = list2;
				pageNumber = list.size() % manageSystemImp.getPageSize() == 0 ? (list
						.size() / manageSystemImp.getPageSize() == 0 ? 1 : list
						.size() / manageSystemImp.getPageSize())
						: list.size() / manageSystemImp.getPageSize() + 1;
				if (presentPage > pageNumber) {
					presentPage = 1;
				}
				pageAndAllpage.setText(String.valueOf(presentPage) + "/"
						+ String.valueOf(pageNumber));
				listShow = manageSystemImp.pageShow(presentPage, list);
				thiz.remove(stl);
				thiz.remove(jsp);

				stl = new SortTabLabel(list, manageSystemImp, thiz);
				stl.setBounds(50, 100, 1166, 40);
				add(stl);
				jsp = new JScrollPane(new DataLabel(listShow, manageSystemImp,
						thiz));
				jsp.setBounds(50, 140, 1266, 450);
				jsp.getVerticalScrollBar().setPreferredSize(
						new Dimension(16, 400));
				jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				add(jsp);
				thiz.revalidate();
				thiz.repaint();
			}
		});
		batchAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				jfc.showDialog(new JLabel(), Language.choose(Language.lang));
				jfc.setMultiSelectionEnabled(false);
				File f = jfc.getSelectedFile();
				if (f.canRead()) {
					String fName = f.getName();
					String postfix = fName.substring(fName.lastIndexOf(".") + 1);
					if (postfix.equalsIgnoreCase("xls")) {
						if (manageSystemImp.batchAddStudents(f) == 1) {
							// 成功
						} else {
							// 失败
						}
						query.doClick();
					} else if (postfix.equalsIgnoreCase("txt")) {
						if (manageSystemImp.batchAddStudents(f) == 1) {
							// 成功
						} else {
							// 失败
						}
						query.doClick();
					}
				}
			}
		});
		batchExport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (manageSystemImp.exportStudents(list) == 1) {
					// 成功
					JOptionPane.showMessageDialog(new JPanel(),
							Language.exportSuccess(Language.lang), "Message",
							JOptionPane.WARNING_MESSAGE);
				} else {
					// 失败
					JOptionPane.showMessageDialog(new JPanel(),
							Language.exportFail(Language.lang), "Message",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		pre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (presentPage > 1) {
					thiz.remove(jsp);
					presentPage--;
					pageAndAllpage.setText(String.valueOf(presentPage) + "/"
							+ String.valueOf(pageNumber));
					listShow = manageSystemImp.pageShow(presentPage, list);

					jsp = new JScrollPane(new DataLabel(listShow,
							manageSystemImp, thiz));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					add(jsp);
					thiz.revalidate();
					thiz.repaint();
				}
			}
		});
		next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (presentPage < pageNumber) {
					thiz.remove(jsp);
					presentPage++;
					pageAndAllpage.setText(String.valueOf(presentPage) + "/"
							+ String.valueOf(pageNumber));
					listShow = manageSystemImp.pageShow(presentPage, list);

					jsp = new JScrollPane(new DataLabel(listShow,
							manageSystemImp, thiz));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					add(jsp);
					thiz.revalidate();
					thiz.repaint();
				}
			}
		});
		go.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String pageText = page.getText();
				if (pageText.matches("[0-9]+")) {
					presentPage = Integer.parseInt(pageText);
					if (presentPage < 1) {
						presentPage = 1;
					} else if (presentPage > pageNumber) {
						presentPage = pageNumber;
					}
					thiz.remove(jsp);
					pageAndAllpage.setText(String.valueOf(presentPage) + "/"
							+ String.valueOf(pageNumber));
					listShow = manageSystemImp.pageShow(presentPage, list);

					jsp = new JScrollPane(new DataLabel(listShow,
							manageSystemImp, thiz));
					jsp.setBounds(50, 140, 1266, 450);
					jsp.getVerticalScrollBar().setPreferredSize(
							new Dimension(16, 400));
					jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					add(jsp);
					thiz.revalidate();
					thiz.repaint();
				}
			}
		});
	}

	public JScrollPane getJsp() {
		return jsp;
	}

	public void setJsp(JScrollPane jsp) {
		this.jsp = jsp;
	}

	public JButton getQuery() {
		return query;
	}

	public void setQuery(JButton query) {
		this.query = query;
	}

	public int getPresentPage() {
		return presentPage;
	}

	public void setPresentPage(int presentPage) {
		this.presentPage = presentPage;
	}
}
