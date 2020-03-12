package com.gezi.hdlw.vo.sys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 

* <p>Title: LwMenus</p>  

* <p>Description:菜单类 </p>  

* @author lixinrong 

* @date 2019年4月2日
 */
public class LwMenus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long menuId;

	private String title;

	private String icon;

	private String href;

	private String perms;

	private String spread;

	private Long parentId;

	private Long sorting;

	private List<LwMenus> children = new ArrayList<>(100);

	private List<LwRoles> lwRolesList = new ArrayList<LwRoles>(10);

	public LwMenus() {
	}

	public LwMenus(Long menuId) {
		setMenuId(menuId);
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = (menuId == null || menuId == 0) ? null : menuId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href == null ? null : href.trim();
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms == null ? null : perms.trim();
	}

	public String getSpread() {
		return spread;
	}

	public void setSpread(String spread) {
		this.spread = spread == null ? null : spread.trim();
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getSorting() {
		return sorting;
	}

	public void setSorting(Long sorting) {
		this.sorting = sorting;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LwMenus)) {
			return false;
		}
		LwMenus castOther = (LwMenus) other;

		return ((this.getMenuId() == castOther.getMenuId()) || (this.getMenuId() != null
				&& castOther.getMenuId() != null && this.getMenuId().equals(castOther.getMenuId())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMenuId() == null ? 0 : this.getMenuId().hashCode());
		return result;
	}

	public List<LwMenus> getChildren() {
		return children;
	}

	public void setChildren(List<LwMenus> children) {
		this.children = children;
	}

	public List<LwRoles> getLwRolesList() {
		return lwRolesList;
	}

	public void setLwRolesList(List<LwRoles> lwRolesList) {
		this.lwRolesList = lwRolesList;
	}

	@Override
	public String toString() {
		return "LwMenus [menuId=" + menuId + ", title=" + title + ", icon=" + icon + ", href=" + href + ", perms="
				+ perms + ", spread=" + spread + ", parentId=" + parentId + ", sorting=" + sorting + "]";
	}

}