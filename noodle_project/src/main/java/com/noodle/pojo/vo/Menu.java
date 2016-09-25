package com.noodle.pojo.vo;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {
	//二级菜单
		private List<Menu> menus;
		//菜单id、模块id
		private String menuid;
		//图标
		private String icon;
		//菜单名称/模块名称
		private String menuname;
		//菜单链接
		private String url;
		public List<Menu> getMenus() {
			return menus;
		}
		public void setMenus(List<Menu> menus) {
			this.menus = menus;
		}
		public String getMenuid() {
			return menuid;
		}
		public void setMenuid(String menuid) {
			this.menuid = menuid;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public String getMenuname() {
			return menuname;
		}
		public void setMenuname(String menuname) {
			this.menuname = menuname;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
}
