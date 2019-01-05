package models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mualim
 * @date 创建时间：2017-3-20 上午10:31:54
 * @version 1.0
 * @parameter
 * @return
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 2351302242390595677L;

	private long idSchool; // 学号
	private String name; // 姓名
	private String gender; // 性别
	private int age; // 年龄
	private Date birthday; // 出生日期
	private String birthplace; // 出生地
	private String hometown; // 籍贯
	private String nation; // 国籍/地区
	private long id; // 身份证件号
	private String health; // 健康状况
	private long phoneNumber; // 联系电话

	public Student(long idSchool, String name, String gender, int age,
			Date birthday, String birthplace, String hometown, String nation,
			long id, String health, long phoneNumber) {
		super();
		this.idSchool = idSchool;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.birthday = birthday;
		this.birthplace = birthplace;
		this.hometown = hometown;
		this.nation = nation;
		this.id = id;
		this.health = health;
		this.phoneNumber = phoneNumber;
	}

	public Student() {
	}

	public long getIdSchool() {
		return idSchool;
	}

	public void setIdSchool(long idSchool) {
		this.idSchool = idSchool;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (int) (idSchool ^ (idSchool >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (idSchool != other.idSchool)
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "idSchool=" + idSchool + ",name=" + name + ",gender=" + gender
				+ ",age=" + age + ",birthday=" + sdf.format(birthday)
				+ ",birthplace=" + birthplace + ",hometown=" + hometown
				+ ",nation=" + nation + ",id=" + id + ",health=" + health
				+ ",phoneNumber=" + phoneNumber;
	}

}
