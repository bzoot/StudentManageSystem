package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import utils.StringUtils;

/**
 * @author Mualim
 * @date 创建时间：2017-3-20 下午12:33:41
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
			return "登录";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Login";
		}
		return "";
	}

	public static String loginFail(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "用户名或密码错误";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Something wrong with username or password";
		}
		return "";
	}

	public static String noUser(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "没有该用户";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "User is not exist";
		}
		return "";
	}

	public static String loginFileMiss(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "登录文件损坏";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Login file is unreadable";
		}
		return "";
	}

	public static String wrongPW(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "密码错误";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Wrong password";
		}
		return "";
	}

	public static String yonghuming(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "用户名";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Username";
		}
		return "";
	}

	public static String mima(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "密码";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Password";
		}
		return "";
	}

	public static String xuanzeyuyan(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "语言";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Lang";
		}
		return "";
	}

	public static String confirm(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "确认";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Confirm";
		}
		return "";
	}

	public static String choose(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "选择";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Choose";
		}
		return "";
	}

	public static String submit(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "提交";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Submit";
		}
		return "";
	}

	public static String back(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "返回";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Back";
		}
		return "";
	}

	public static String query(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "查询";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Query";
		}
		return "";
	}

	public static String add(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "添加";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Add";
		}
		return "";
	}

	public static String batchAdd(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "批量添加";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Import";
		}
		return "";
	}

	public static String batchExport(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "批量导出";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Export";
		}
		return "";
	}

	public static String delete(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "删除";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Delete";
		}
		return "";
	}

	public static String update(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "修改";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Update";
		}
		return "";
	}

	public static String conDelete(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "确认删除数据么？";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Confirm to delete datas?";
		}
		return "";
	}
	
	public static String exportSuccess(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "数据导出成功！";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Export Success";
		}
		return "";
	}
	
	public static String exportFail(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "数据导出失败！";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Export Fail";
		}
		return "";
	}

	public static String legPlz(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "请填入合法数据（学号：纯数字，\n\r年龄：纯数字，性别：male/female/男/女，"
					+ "\n\r出生日期：yyyy-MM-dd，身份证：纯数字，\n\r联系电话：纯数字）！";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Legallize input please(IDSchool: numbers, \n\rAge:number, Gender: male/female/男/女"
					+ "\n\rBirthday:yyyy-MM-dd,ID: numbers, \n\rPhone: number)!";
		}
		return "";
	}

	public static String name(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "姓名";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Name";
		}
		return "";
	}

	public static String idSchool(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "学号";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "IDSchool";
		}
		return "";
	}

	public static String gender(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "性别";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Gender";
		}
		return "";
	}

	public static String birthday(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "出生日期";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Birthday";
		}
		return "";
	}

	public static String birthplace(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "出生地";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Birthplace";
		}
		return "";
	}

	public static String hometown(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "籍贯";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Hometown";
		}
		return "";
	}

	public static String nation(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "国籍/地区";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Nation";
		}
		return "";
	}

	public static String id(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "身份证件号";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "ID";
		}
		return "";
	}

	public static String health(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "健康状况";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Health";
		}
		return "";
	}

	public static String phoneNumber(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "联系电话";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Phone";
		}
		return "";
	}

	public static String age(String lang) {
		if (lang.equalsIgnoreCase("CN")) {
			return "年龄";
		} else if (lang.equalsIgnoreCase("EN")) {
			return "Age";
		}
		return "";
	}

}
