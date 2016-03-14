package org.xiaxiaofeng.course.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xiaxiaofeng.course.pojo.AccessToken;
import org.xiaxiaofeng.course.pojo.Button;
import org.xiaxiaofeng.course.pojo.CommonButton;
import org.xiaxiaofeng.course.pojo.ComplexButton;
import org.xiaxiaofeng.course.pojo.Menu;
import org.xiaxiaofeng.course.util.WeixinUtil;

/**
 * 菜单管理类
 * @author Administrator
 *
 */
public class MenuManager {
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);
	
	public static void main(String[] args){
		//第三方用户唯一凭证
		String appId = "wxff324b722b8e7e0b";
		//第三方用户唯一凭证密钥
		String appSecret = "6bda76e8625906df12991ec7dcdf0ad0 ";
		
		//调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
		if(null != at){
			//调用接口创建菜单
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());
			//判断菜单创建结果
			if(0 == result){
				log.info("菜单创建成功！");
			}else
				log.info("菜单创建失败，错误码：" + result);
		}
	}
	
	private static Menu getMenu(){
		CommonButton btn11 = new CommonButton();
		btn11.setName("天气预报");
		btn11.setType("click");
		btn11.setKey("11");
		
		CommonButton btn12 = new CommonButton();
		btn11.setName("公交查询");
		btn11.setType("click");
		btn11.setKey("12");
		
		CommonButton btn13 = new CommonButton();
		btn11.setName("周边搜索");
		btn11.setType("click");
		btn11.setKey("13");

		CommonButton btn14 = new CommonButton();
		btn11.setName("历史上的今天");
		btn11.setType("click");
		btn11.setKey("14");

		CommonButton btn21 = new CommonButton();
		btn11.setName("歌曲点播");
		btn11.setType("click");
		btn11.setKey("21");

		CommonButton btn22 = new CommonButton();
		btn11.setName("经典游戏");
		btn11.setType("click");
		btn11.setKey("22");

		CommonButton btn23 = new CommonButton();
		btn11.setName("美女电台");
		btn11.setType("click");
		btn11.setKey("23");

		CommonButton btn24 = new CommonButton();
		btn11.setName("人脸识别");
		btn11.setType("click");
		btn11.setKey("24");

		CommonButton btn25 = new CommonButton();
		btn11.setName("聊天唠嗑");
		btn11.setType("click");
		btn11.setKey("25");

		CommonButton btn31 = new CommonButton();
		btn11.setName("Q 友圈");
		btn11.setType("click");
		btn11.setKey("31");

		CommonButton btn32 = new CommonButton();
		btn11.setName("电影排行榜");
		btn11.setType("click");
		btn11.setKey("32");

		CommonButton btn33 = new CommonButton();
		btn11.setName("幽默笑话");
		btn11.setType("click");
		btn11.setKey("33");
		
		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("生活助手");
		mainBtn1.setSub_button(new CommonButton[]{btn11, btn12, btn13, btn14});
		
		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("休闲驿站");
		mainBtn2.setSub_button(new CommonButton[]{btn21, btn22, btn23, btn24, btn25});
		
		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("更多体验");
		mainBtn3.setSub_button(new CommonButton[]{btn31, btn32, btn33});
		
		/**
		 *  这是公众号 xiaoqrobot 目前的菜单结构，每个一级菜单都有二级菜单项
		 *  在某个一级菜单下没有二级菜单的情况，menu 该如何定义呢？
		 *  比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么 menu 应该这样定义：
		 *   menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		menu.setButton(new Button[]{mainBtn1, mainBtn2, mainBtn3});
		
		return menu;
		
	}
	
}
