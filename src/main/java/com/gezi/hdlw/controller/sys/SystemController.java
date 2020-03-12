/**
 * 
 */
package com.gezi.hdlw.controller.sys;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gezi.hdlw.service.sys.LwAdminService;
import com.gezi.hdlw.service.sys.LwMenusService;
import com.gezi.hdlw.service.sys.LwRolesMenusService;
import com.gezi.hdlw.service.sys.LwRolesService;
import com.gezi.hdlw.util.ResultBean;
import com.gezi.hdlw.util.ResultUtil;
import com.gezi.hdlw.vo.sys.LwAdmin;
import com.gezi.hdlw.vo.sys.LwMenus;
import com.gezi.hdlw.vo.sys.LwRoles;
import com.gezi.hdlw.vo.sys.LwRolesMenusKey;

/**
 * 
 * <p>
 * Title: ViewController
 * </p>
 * 
 * <p>
 * Description:系统级控制器
 * </p>
 * 
 * @author lixinrong
 * 
 * @date 2019年3月29日
 * 
 */
@Controller
@RequestMapping("/sys")
@Scope("request")
public class SystemController {
	@Resource
	private LwRolesMenusService lwRolesMenusService;
	@Resource
	private LwRolesService lwRolesService;
	@Resource
	private LwAdminService lwAdminService;
	@Resource
	private LwMenusService lwMenusService;

	/** 访问项目主页 */
	@RequestMapping("/home")
	public String goHome(HttpServletRequest req) {
		LwAdmin admin = (LwAdmin) SecurityUtils.getSubject().getPrincipal();
		if (admin != null) {
			LwRoles roles = lwRolesMenusService.getRole(new LwRolesMenusKey(admin.getRoleId()));
			req.setAttribute("menus", roles.getLwMenuList());
			return "common/home";
		}
		return "redirect:/user/login";
	}

	/** 默认欢迎页面 */
	@RequestMapping("/welcome")
	public String showWelcome(HttpServletRequest req) {
		return "common/welcome";
	}

	/** 显示菜单列表页面 */
	@RequestMapping("/menuListView")
	public String menuList() {
		return "sys/system/menuList";
	}

	/** 分页获取菜单列表 */
	@RequestMapping("/menuData")
	@RequiresPermissions("sys:menu:list")
	@ResponseBody
	public ResultUtil menuData(Integer page, Integer limit, LwMenus lwMenus) {
		return lwMenusService.listByExample(page, limit, lwMenus);
	}

	/** 显示添加菜单页面 */
	@RequestMapping("/addMenuView")
	public String addMenuView(HttpServletRequest req, Long parentId) {
		if (parentId != null && parentId != 0) {
			req.setAttribute("parentMenu", lwMenusService.getByPrimaryKey(parentId));
		}
		return "sys/system/menuform";
	}

	/** 显示编辑菜单页面 */
	@RequestMapping("/editMenuView")
	public String editMenuView(HttpServletRequest req, Long menuId) {
		if (menuId != null && menuId != 0) {
			req.setAttribute("menu", lwMenusService.getByPrimaryKey(menuId));
		}
		return "sys/system/menuform";
	}

	/** 编辑菜单操作 */
	@RequestMapping("/editMenu")
	@RequiresPermissions("sys:menu:update")
	@ResponseBody
	public ResultBean editMenu(HttpServletRequest req, LwMenus lwMenus) {
		int i = lwMenusService.saveOrUpdate(lwMenus);
		if (i > 0) {
			return new ResultBean(true, true);
		}
		return new ResultBean(false);
	}

	/** 删除菜单操作 */
	@RequestMapping("/delMenu")
	@RequiresPermissions("sys:menu:delete")
	@ResponseBody
	public ResultBean delMenu(HttpServletRequest req, Long menuId) {
		if (menuId != null) {
			int i = lwMenusService.deleteByPrimaryKey(menuId);
			if (i > 0) {
				return new ResultBean(true, true);
			}
		}
		return new ResultBean(false, "该菜单拖家带口不能全干掉");
	}

	/** 显示角色列表页面 */
	@RequestMapping("/roleListView")
	public String roleList() {
		return "sys/system/roleList";
	}

	/** 分页获取角色列表 */
	@RequestMapping("/getRoleList")
	@RequiresPermissions("sys:role:list")
	@ResponseBody
	public ResultUtil getRoleList(Integer page, Integer limit, LwRoles lwRoles) {
		return lwRolesService.listByExample(page, limit, lwRoles);
	}

	/** 显示编辑角色页面 */
	@RequestMapping("/editRoleView")
	public String editRoleView(HttpServletRequest req, Long roleId) {
		if (roleId != null && roleId != 0) {
			req.setAttribute("role", lwRolesMenusService.getRoleNoTree(new LwRolesMenusKey(roleId)));
		}
		List<LwMenus> list = lwMenusService.listMenu();
		req.setAttribute("menus", list);
		return "sys/system/roleform";
	}

	/** 编辑角色操作 */
	@RequestMapping("/editRole")
	@RequiresPermissions("sys:role:update")
	@ResponseBody
	public ResultBean editRole(HttpServletRequest req, @RequestBody LwRoles lwRoles) {
		int i = lwRolesService.saveOrUpdate(lwRoles);
		if (i > 0) {
			return new ResultBean(true, true);
		}
		return new ResultBean(false);
	}

	/** 删除角色操作 */
	@RequestMapping("/delRole")
	@RequiresPermissions("sys:role:delete")
	@ResponseBody
	public ResultBean delRole(HttpServletRequest req, Long roleId) {
		if (roleId != null) {
			int i = lwRolesService.deleteByPrimaryKey(roleId);
			if (i > 0) {
				return new ResultBean(true, true);
			}
		}
		return new ResultBean(false);
	}

	/** 显示管理员列表页面 */
	@RequestMapping("/adminListView")
	public String adminList() {
		return "sys/system/adminList";
	}

	/** 分页获取管理员列表数据 */
	@RequestMapping("/adminList")
	@RequiresPermissions("sys:admin:list")
	@ResponseBody
	public ResultUtil adminList(Integer page, Integer limit, LwAdmin lwAdmin) {
		if (lwAdmin.getId() == null) {
			lwAdmin = (LwAdmin) SecurityUtils.getSubject().getPrincipal();
		}
		return lwAdminService.listOrByWhere(page, limit, lwAdmin);
	}

	/** 显示编辑管理员页面 */
	@RequestMapping("/editAdminView")
	public String editAdminView(HttpServletRequest req, Long adminId) {
		if (adminId != null && adminId != 0) {
			req.setAttribute("admin", lwAdminService.getAdminByPrimaryKey(adminId));
		}
		req.setAttribute("roles", lwRolesService.list());
		return "sys/system/adminform";
	}

	/** 编辑管理员操作 */
	@RequestMapping("/editAdmin")
	@RequiresPermissions("sys:admin:update")
	@ResponseBody
	public ResultBean editAdmin(HttpServletRequest req, LwAdmin lwAdmin) {
		try {
			int i = lwAdminService.saveOrUpdate(lwAdmin);
			if (i > 0) {
				return new ResultBean(true, true);
			}
		} catch (Exception e) {
			return new ResultBean(false);
		}
		return new ResultBean(false);
	}

	/** 删除管理员操作 */
	@RequestMapping("/delAdmin")
	@RequiresPermissions("sys:admin:delete")
	@ResponseBody
	public ResultBean delAdmin(HttpServletRequest req, Long adminId) {
		if (adminId != null) {
			try {
				int i = lwAdminService.deleteByPrimaryKey(adminId);
				if (i > 0) {
					return new ResultBean(true, true);
				}
			} catch (Exception e) {
				return new ResultBean(false);
			}
		}
		return new ResultBean(false);
	}

}
