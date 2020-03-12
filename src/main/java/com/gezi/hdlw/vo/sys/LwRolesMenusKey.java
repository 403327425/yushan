package com.gezi.hdlw.vo.sys;

import java.util.Objects;

/**
 * 
 * 
 * <p>
 * Title: LwRolesMenusKey
 * </p>
 * 
 * <p>
 * Description: 角色对应的菜单中间表
 * </p>
 * 
 * @author lixinrong
 * 
 * @date 2019年3月29日
 */
public class LwRolesMenusKey {

	private LwRoles role;
	private LwMenus menu;

	public LwRolesMenusKey() {}

	public LwRolesMenusKey(Long roleId) {
		this.role = new LwRoles(roleId);
	}

	public LwRolesMenusKey(Long roleId, Long menuId) {
		this.role = new LwRoles(roleId);
		this.menu = new LwMenus(menuId);
	}

	public LwRoles getRole() {
		return role;
	}

	public void setRole(LwRoles role) {
		this.role = role;
	}

	public LwMenus getMenu() {
		return menu;
	}

	public void setMenu(LwMenus menu) {
		this.menu = menu;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LwRolesMenusKey)) {
			return false;
		}
		LwRolesMenusKey castOther = (LwRolesMenusKey) other;

		return ((Objects.equals(this.menu.getMenuId(), castOther.menu.getMenuId())) || (this.menu.getMenuId() != null
				&& castOther.menu.getMenuId() != null && this.menu.getMenuId().equals(castOther.menu.getMenuId())))
				&& ((Objects.equals(this.role.getRoleId(), castOther.role.getRoleId()))
						|| (this.role.getRoleId() != null && castOther.role.getRoleId() != null
								&& this.role.getRoleId().equals(castOther.role.getRoleId())));
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + (this.menu.getMenuId() == null ? 0 : this.menu.getMenuId().hashCode());
		result = 37 * result + (this.role.getRoleId() == null ? 0 : this.role.getRoleId().hashCode());
		return result;
	}
}