package com.gezi.hdlw.vo.sys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 

* <p>Title: LwRoles</p>  

* <p>Description:角色类 </p>  

* @author lixinrong 

* @date 2019年4月2日
 */
public class LwRoles implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long roleId;

	private String roleName;

	private String roleRemark;
	/** 角色对应的菜单 */
	private List<LwMenus> lwMenuList = new ArrayList<>(10);
	/**角色对应的权限*/
	private Set<String> permsSet = new HashSet<>(16);

	/**
	 * 
	 */
	public LwRoles() {
	}

	/**
	 * @param roleId
	 */
	public LwRoles(Long roleId) {
		setRoleId(roleId);
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = (roleId == null || roleId == 0) ? null : roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	public String getRoleRemark() {
		return roleRemark;
	}

	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark == null ? null : roleRemark.trim();
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LwRoles)) {
			return false;
		}
		LwRoles castOther = (LwRoles) other;

		return ((this.getRoleId() == castOther.getRoleId()) || (this.getRoleId() != null
				&& castOther.getRoleId() != null && this.getRoleId().equals(castOther.getRoleId())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "LwRoles [roleId=" + roleId + ", roleName=" + roleName + ", roleRemark=" + roleRemark + "]";
	}

	public List<LwMenus> getLwMenuList() {
		return lwMenuList;
	}

	public void setLwMenuList(List<LwMenus> lwMenuList) {
		this.lwMenuList = lwMenuList;
	}

	public Set<String> getPermsSet() {
		return permsSet;
	}

	public void setPermsSet(Set<String> permsSet) {
		this.permsSet = permsSet;
	}

}