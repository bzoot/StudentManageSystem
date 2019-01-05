package imps;

import interfaces.ManageSystemInterface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import utils.StringUtils;

import models.AgeComparator;
import models.BirthdayComparator;
import models.BirthplaceComparator;
import models.GenderComparator;
import models.HealthComparator;
import models.HometownComparator;
import models.IdComparator;
import models.IdSchoolComparator;
import models.NameComparator;
import models.NationComparator;
import models.PhoneNumberComparator;
import models.Student;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * @author Mualim
 * @date 创建时间：2017-3-20 上午10:32:30
 * @version 1.0
 * @parameter
 * @return
 */
public class ManageSystemImp implements ManageSystemInterface {

	private ArrayList<Student> allData = new ArrayList<Student>();
	private ArrayList<Long> allIdSchool = new ArrayList<Long>();
	private int pageSize;

	private static ManageSystemImp manageSystemImp = new ManageSystemImp();

	private ManageSystemImp() {
		int count = 0;
		while (count < 10) {
			try {
				loadAllData();
				loadSet();
				return;
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
				count++;
			}
		}
		System.exit(0);
	}

	public static ManageSystemImp getInstance() {
		return manageSystemImp;
	}

	// 1:success;0:fail
	/**
	 * 
	 * @param idSchool
	 * @param name
	 * @param gender
	 * @param age
	 * @param birthday
	 * @param birthplace
	 * @param hometown
	 * @param nation
	 * @param id
	 * @param health
	 * @param phoneNumber
	 * @return
	 */
	@Override
	public int addStudent(long idSchool, String name, String gender, int age,
			Date birthday, String birthplace, String hometown, String nation,
			long id, String health, long phoneNumber) {
		Student st = new Student(idSchool, name, gender, age, birthday,
				birthplace, hometown, nation, id, health, phoneNumber);
		if (!allIdSchool.contains(idSchool)) {
			allData.add(st);
			allIdSchool.add(st.getIdSchool());
			return writeToFile();
		} else {
			return 0;
		}
	}

	/**
	 * @param file
	 */
	@Override
	public int batchAddStudents(File file) {
		try {
			if (file.canRead()) {
				String fName = file.getName();
				String postfix = fName.substring(fName.lastIndexOf(".") + 1);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				if (postfix.equalsIgnoreCase("xls")) {
					Workbook workBook = Workbook.getWorkbook(file);
					Sheet sheet = workBook.getSheet(0);
					for (int i = 1; i < sheet.getRows(); i++) {
						long idSchool = Long.parseLong(sheet.getCell(0, i)
								.getContents());
						String name = sheet.getCell(1, i).getContents();
						int age = Integer.parseInt(sheet.getCell(2, i)
								.getContents());
						String gender = sheet.getCell(3, i).getContents();
						Date birthday = sdf.parse(sheet.getCell(4, i)
								.getContents());
						String birthplace = sheet.getCell(5, i).getContents();
						String hometown = sheet.getCell(6, i).getContents();
						String nation = sheet.getCell(7, i).getContents();
						long id = Long.parseLong(sheet.getCell(8, i)
								.getContents());
						String health = sheet.getCell(9, i).getContents();
						long phoneNumber = Long.parseLong(sheet.getCell(10, i)
								.getContents());
						Student st = new Student(idSchool, name, gender, age,
								birthday, birthplace, hometown, nation, id,
								health, phoneNumber);
						if (!allIdSchool.contains(idSchool)) {
							allData.add(st);
							allIdSchool.add(st.getIdSchool());
						}
					}
				} else if (postfix.equalsIgnoreCase("txt")) {
					BufferedReader br = new BufferedReader(
							new InputStreamReader(new FileInputStream(file)));
					String temp = br.readLine();
					while (temp != null) {
						String[] data = temp.split(",");
						if (data[0].matches("[0-9]+")) {
							long idSchool = Long.parseLong(data[0].trim());
							String name = data[1].trim();
							int age = Integer.parseInt(data[2].trim());
							String gender = data[3].trim();
							Date birthday = sdf.parse(data[4].trim());
							String birthplace = data[5].trim();
							String hometown = data[6].trim();
							String nation = data[7].trim();
							long id = Long.parseLong(data[8].trim());
							String health = data[9].trim();
							long phoneNumber = Long.parseLong(data[10].trim());
							Student st = new Student(idSchool, name, gender,
									age, birthday, birthplace, hometown,
									nation, id, health, phoneNumber);
							if (!allIdSchool.contains(idSchool)) {
								allData.add(st);
								allIdSchool.add(st.getIdSchool());
							}
						}
						temp = br.readLine();
					}
					br.close();
				}
				return writeToFile();
			} else {
				return 0;
			}
		} catch (BiffException | IOException | ParseException
				| NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 
	 * @param idSchool
	 * @return
	 */
	@Override
	public int deleteStudent(long idSchool) {
		if (allIdSchool.contains(idSchool)) {
			for (Student st : allData) {
				if (st.getIdSchool() == idSchool) {
					allData.remove(st);
					break;
				}
			}
			setAllData(allData);
			return writeToFile();
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @param idSchools
	 * @return
	 */
	@Override
	public int deleteStudents(ArrayList<Long> idSchools) {
		for (long idSchool : idSchools) {
			int i = deleteStudent(idSchool);
			if (i == 0) {
				return 0;
			}
		}
		return 1;
	}

	/**
	 * 
	 * @param idSchool
	 * @param name
	 * @param gender
	 * @param age
	 * @param birthday
	 * @param birthplace
	 * @param hometown
	 * @param nation
	 * @param idNew
	 * @param health
	 * @param phoneNumber
	 * @return
	 */
	@Override
	public int updateStudent(long idSchool, long idSchoolNew, String name,
			String gender, int age, Date birthday, String birthplace,
			String hometown, String nation, long id, String health,
			long phoneNumber) {
		if (allIdSchool.contains(idSchool)
				&& (idSchoolNew == idSchool || !allIdSchool
						.contains(idSchoolNew))) {
			for (Student st : allData) {
				if (st.getIdSchool() == idSchool) {
					st.setIdSchool(idSchoolNew);
					st.setName(name);
					st.setGender(gender);
					st.setAge(age);
					st.setBirthday(birthday);
					st.setBirthplace(birthplace);
					st.setHometown(hometown);
					st.setNation(nation);
					st.setId(id);
					st.setHealth(health);
					st.setPhoneNumber(phoneNumber);
					break;
				}
			}
			setAllData(allData);
			return writeToFile();
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @param idSchool
	 * @return
	 */
	@Override
	public ArrayList<Student> queryStudent(long idSchool,
			ArrayList<Student> initList) {
		ArrayList<Student> list = new ArrayList<Student>();
		for (Student st : initList) {
			if (StringUtils.isStartWithIgnoreCase(String.valueOf(idSchool),
					String.valueOf(st.getIdSchool()))) {
				list.add(st);
			}
		}
		return list;
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public ArrayList<Student> queryStudent(String name,
			ArrayList<Student> initList) {
		if (name != null && !name.isEmpty()) {
			ArrayList<Student> list = new ArrayList<Student>();
			for (Student st : initList) {
				if (StringUtils.isStartWithIgnoreCase(name, st.getName())) {
					list.add(st);
				}
			}
			return list;
		} else {
			return initList;
		}
	}

	/**
	 * 
	 * @param col
	 *            0:idSchool 1:name 2:gender 3:age 4:birthday 5:birthplace
	 *            6:hometown 7:nation 8:id 9:health 10:phoneNumber
	 * @param order
	 *            -1:asc 1:desc
	 * @param list
	 * @return list
	 */
	@Override
	public ArrayList<Student> sort(int col, int order, ArrayList<Student> list) {
		if (col == 0) {
			if (order == -1) {
				Collections.sort(list, new IdSchoolComparator());
			} else if (order == 1) {
				Collections.sort(list,
						Collections.reverseOrder(new IdSchoolComparator()));
			}
		} else if (col == 1) {
			if (order == -1) {
				Collections.sort(list, new NameComparator());
			} else if (order == 1) {
				Collections.sort(list,
						Collections.reverseOrder(new NameComparator()));
			}
		} else if (col == 2) {
			if (order == -1) {
				Collections.sort(list, new GenderComparator());
			} else if (order == 1) {
				Collections.sort(list,
						Collections.reverseOrder(new GenderComparator()));
			}
		} else if (col == 3) {
			if (order == -1) {
				Collections.sort(list, new AgeComparator());
			} else if (order == 1) {
				Collections.sort(list,
						Collections.reverseOrder(new AgeComparator()));
			}
		} else if (col == 4) {
			if (order == -1) {
				Collections.sort(list, new BirthdayComparator());
			} else if (order == 1) {
				Collections.sort(list,
						Collections.reverseOrder(new BirthdayComparator()));
			}
		} else if (col == 5) {
			if (order == -1) {
				Collections.sort(list, new BirthplaceComparator());
			} else if (order == 1) {
				Collections.sort(list,
						Collections.reverseOrder(new BirthplaceComparator()));
			}
		} else if (col == 6) {
			if (order == -1) {
				Collections.sort(list, new HometownComparator());
			} else if (order == 1) {
				Collections.sort(list,
						Collections.reverseOrder(new HometownComparator()));
			}
		} else if (col == 7) {
			if (order == -1) {
				Collections.sort(list, new NationComparator());
			} else if (order == 1) {
				Collections.sort(list,
						Collections.reverseOrder(new NationComparator()));
			}
		} else if (col == 8) {
			if (order == -1) {
				Collections.sort(list, new IdComparator());
			} else if (order == 1) {
				Collections.sort(list,
						Collections.reverseOrder(new IdComparator()));
			}
		} else if (col == 9) {
			if (order == -1) {
				Collections.sort(list, new HealthComparator());
			} else if (order == 1) {
				Collections.sort(list,
						Collections.reverseOrder(new HealthComparator()));
			}
		} else if (col == 10) {
			if (order == -1) {
				Collections.sort(list, new PhoneNumberComparator());
			} else if (order == 1) {
				Collections.sort(list,
						Collections.reverseOrder(new PhoneNumberComparator()));
			}
		}

		return list;
	}

	/**
	 * 
	 * @param page
	 * @param list
	 * @return listReturn
	 */
	@Override
	public ArrayList<Student> pageShow(int page, ArrayList<Student> list) {
		ArrayList<Student> listReturn = new ArrayList<Student>();
		if (list.size() > 0) {
			if (page < 1) {
				page = 1;
			}
			if (page > (list.size() % pageSize == 0 ? list.size() / pageSize
					: list.size() / pageSize + 1)) {
				page = list.size() % pageSize == 0 ? list.size() / pageSize
						: list.size() / pageSize + 1;
			}
			List<Student> subList = list.subList((page - 1) * pageSize, page
					* pageSize > list.size() ? list.size() : page * pageSize);
			for (int i = 0; i < subList.size(); i++) {
				listReturn.add(i, subList.get(i));
			}
		}

		return listReturn;
	}

	/**
	 * 批量导出
	 * 
	 * @param list
	 * @return
	 */
	@Override
	public int exportStudents(ArrayList<Student> list) {
		File dir = new File(".\\");
		String filePre = "ExportStudentsData_";
		String[] names = dir.list();
		for (int i = 0; i < 1024; i++) {
			String filePost = String.valueOf(i + 1);
			StringBuilder sb = new StringBuilder();
			boolean exist = false;
			if (filePost.length() < 4) {
				for (int j = 0; j < 4 - filePost.length(); j++) {
					sb.append("0");
				}
			}
			sb.append(filePost);
			String fileName = filePre + sb.toString();
			for (int j = 0; j < names.length; j++) {
				if (names[j].contains(".")
						&& !names[j].startsWith(".")
						&& fileName.endsWith(names[j].substring(0,
								names[j].lastIndexOf(".")))) {
					exist = true;
					break;
				}
			}
			if (!exist) {
				File file1 = new File(fileName + ".xls");
				File file2 = new File(fileName + ".txt");

				try {
					WritableWorkbook workBook = Workbook.createWorkbook(file1);
					WritableSheet sheet = workBook.createSheet("Sheet1", 0);
					for (int j = 0; j < 11; j++) {
						sheet.setColumnView(j, 20);
					}
					BufferedWriter bw2 = new BufferedWriter(
							new OutputStreamWriter(new FileOutputStream(file2,
									true)));

					for (int j = 0; j < list.size(); j++) {
						String data = list.get(j).toString();
						String[] maps = data.split(",");
						for (int k = 0; k < maps.length; k++) {
							sheet.addCell(new Label(k, j + 1, maps[k]
									.split("=")[1]));
							bw2.write(maps[k].split("=")[1] + ", ");
						}
						bw2.write("\r\n");
					}

					workBook.write();
					workBook.close();
					bw2.flush();
					bw2.close();
					return 1;
				} catch (IOException | WriteException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;
	}

	/**
	 * 将allData写入文件
	 */
	private int writeToFile() {

		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("StudentsData.dat"));
			oos.writeObject(allData);
			oos.flush();
			oos.close();
			return 1;
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 载入数据
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	private void loadAllData() throws IOException, ClassNotFoundException {
		File file = new File("StudentsData.dat");
		if (file.canRead()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					file));
			setAllData((ArrayList<Student>) ois.readObject());
			ois.close();
		}
	}

	/**
	 * 载入配置
	 * 
	 * @throws IOException
	 */
	private void loadSet() throws IOException {
		pageSize = 10;
		File file = new File("option.cng"); // 配置文件
		if (file.canRead()) {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));
			String temp = br.readLine();
			while (temp != null) {
				if (StringUtils.isStartWithIgnoreCase("pageSize", temp)) {
					pageSize = Integer.parseInt((temp.split("="))[1]);
				}
				temp = br.readLine();
			}
			br.close();
		}
	}

	public ArrayList<Student> getAllData() {
		return allData;
	}

	private void setAllData(ArrayList<Student> allData) {
		this.allData = allData;
		setAllIdSchool();
	}

	public ArrayList<Long> getAllIdSchool() {
		return allIdSchool;
	}

	private void setAllIdSchool() {
		ArrayList<Long> allIdSchool = new ArrayList<Long>();
		for (Student st : allData) {
			allIdSchool.add(st.getIdSchool());
		}
		this.allIdSchool = allIdSchool;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
