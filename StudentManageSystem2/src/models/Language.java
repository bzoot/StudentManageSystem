package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import utils.StringUtils;

/**
 * @author Mualim
 * @date ����ʱ�䣺2017-3-20 ����12:33:41
 * @version 1.0
 * @parameter
 * @return
 */
public abstract class Language {

	public static String lang = getLang();

	/**
	 * 
	 * @return
	 */
	private static String getLang() {
		try {
			File file = new File("option.cng");
			if (file.canRead()) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						new FileInputStream(file)));
				String temp = br.readLine();
				while (temp != null) {
					if (StringUtils.isStartWithIgnoreCase("lang", temp)) {
						br.close();
						return (temp.split("="))[1];
					}
					temp = br.readLine();
				}
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "CN";
	}

	public static String denglu(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "��¼";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Login";
		}
		return "";
	}

	public static String loginFail(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "�û������������";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Something wrong with username or password";
		}
		return "";
	}

	public static String noUser(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "û�и��û�";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "User is not exist";
		}
		return "";
	}

	public static String loginFileMiss(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "��¼�ļ���";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Login file is unreadable";
		}
		return "";
	}

	public static String wrongPW(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "�������";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Wrong password";
		}
		return "";
	}

	public static String yonghuming(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "�û���";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Username";
		}
		return "";
	}

	public static String mima(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "����";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Password";
		}
		return "";
	}

	public static String xuanzeyuyan(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "����";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Lang";
		}
		return "";
	}

	public static String confirm(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "ȷ��";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Confirm";
		}
		return "";
	}

	public static String choose(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "ѡ��";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Choose";
		}
		return "";
	}

	public static String submit(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "�ύ";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Submit";
		}
		return "";
	}

	public static String back(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "����";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Back";
		}
		return "";
	}

	public static String query(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "��ѯ";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Query";
		}
		return "";
	}

	public static String add(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "���";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Add";
		}
		return "";
	}

	public static String batchAdd(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "�������";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Import";
		}
		return "";
	}

	public static String batchExport(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "��������";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Export";
		}
		return "";
	}

	public static String delete(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "ɾ��";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Delete";
		}
		return "";
	}

	public static String update(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "�޸�";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Update";
		}
		return "";
	}

	public static String conDelete(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "ȷ��ɾ������ô��";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Confirm to delete datas?";
		}
		return "";
	}
	
	public static String exportSuccess(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "���ݵ����ɹ���";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Export Success";
		}
		return "";
	}
	
	public static String exportFail(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "���ݵ���ʧ�ܣ�";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Export Fail";
		}
		return "";
	}

	public static String legPlz(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "������Ϸ����ݣ�ѧ�ţ������֣�\n\r���䣺�����֣��Ա�male/female/��/Ů��"
					+ "\n\r�������ڣ�yyyy-MM-dd�����֤�������֣�\n\r��ϵ�绰�������֣���";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Legallize input please(IDSchool: numbers, \n\rAge:number, Gender: male/female/��/Ů"
					+ "\n\rBirthday:yyyy-MM-dd,ID: numbers, \n\rPhone: number)!";
		}
		return "";
	}

	public static String name(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "����";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Name";
		}
		return "";
	}

	public static String idSchool(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "ѧ��";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "IDSchool";
		}
		return "";
	}

	public static String gender(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "�Ա�";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Gender";
		}
		return "";
	}

	public static String birthday(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "��������";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Birthday";
		}
		return "";
	}

	public static String birthplace(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "������";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Birthplace";
		}
		return "";
	}

	public static String hometown(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "����";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Hometown";
		}
		return "";
	}

	public static String nation(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "����/����";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Nation";
		}
		return "";
	}

	public static String id(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "���֤����";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "ID";
		}
		return "";
	}

	public static String health(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "����״��";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Health";
		}
		return "";
	}

	public static String phoneNumber(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "��ϵ�绰";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Phone";
		}
		return "";
	}

	public static String age(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "����";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Age";
		}
		return "";
	}

}
