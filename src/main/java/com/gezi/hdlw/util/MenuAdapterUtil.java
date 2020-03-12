package com.gezi.hdlw.util;

import java.util.ArrayList;
import java.util.List;

import com.gezi.hdlw.vo.sys.LwMenus;

/**
 * 
 * <p>
 * Title: MenuAdapterUtil
 * </p>
 * 
 * <p>
 * Description:菜单适配器
 * </p>
 * 
 * @author lixinrong
 * 
 * @date 2019年4月11日
 * 
 */
public final class MenuAdapterUtil {
	public static List<LwMenus> adapterMenuList(List<LwMenus> list) {
		List<LwMenus> groupMenu = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getParentId() == 0) {
				LwMenus menu = new LwMenus();
				menu = list.get(i);
				groupMenu.add(adapterMenu(list, menu));
			}

		}
		return groupMenu;
	}

	public static LwMenus adapterMenu(List<LwMenus> list, LwMenus menu) {
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).getParentId() == menu.getMenuId()) {
				LwMenus menu2 = new LwMenus();
				menu2 = list.get(j);
				menu.getChildren().add(menu2);
				adapterMenu(list, menu2);
			}
		}
		return menu;
	}
}
