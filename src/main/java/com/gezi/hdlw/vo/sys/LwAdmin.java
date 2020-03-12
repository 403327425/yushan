package com.gezi.hdlw.vo.sys;

import java.io.Serializable;
import java.util.Date;
/**
 * 

* <p>Title: LwAdmin</p>  

* <p>Description:管理员类 </p>  

* @author lixinrong 

* @date 2019年4月2日
 */
public class LwAdmin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String password;

	private String salt;

	private String fullname;

	private String eMail;

	private String sex;

	private Date birthday;

	private String address;

	private String phone;

	private Long roleId;

	private LwRoles lwRoles;

	/**
	 * 
	 */
	public LwAdmin() {
	}

	/**
	 * @param id
	 */
	public LwAdmin(Long id) {
		setId(id);
	}

	public LwAdmin(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = (id == null || id == 0) ? null : id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt == null ? null : salt.trim();
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname == null ? null : fullname.trim();
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail == null ? null : eMail.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public LwRoles getLwRoles() {
		return lwRoles;
	}

	public void setLwRoles(LwRoles lwRoles) {
		this.lwRoles = lwRoles;
	}

	@Override
	public String toString() {
		return "LwAdmin [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ ", fullname=" + fullname + ", eMail=" + eMail + ", sex=" + sex + ", birthday=" + birthday
				+ ", address=" + address + ", phone=" + phone + ", roleId=" + roleId + "]";
	}

}