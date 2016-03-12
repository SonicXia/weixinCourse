package org.xiaxiaofeng.course.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.xiaxiaofeng.course.message.resp.TextMessage;
import org.xiaxiaofeng.course.util.MessageUtil;

public class CoreService {
	//第三方服务器处理微信服务器发来的请求
	public static String processRequest(HttpServletRequest request){
		String respMessage = null;
		String respContent = "请求处理异常，请稍后尝试！";
		//xml请求解析
		try {
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			//发送方账号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			//公众账号
			String toUserName = requestMap.get("ToUserName");
			//消息类型
			String msgType = requestMap.get("MsgType");
			
			//回复文本信息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			
			//文本消息
			if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)){
//				respContent = "您发送的是文本消息";
				
				
			}
			//图片消息
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)){
				respContent = "您发送的是图片消息";
			}
			//地理位置信息
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)){
				respContent = "您发送的是地理位置消息";
			}
			//链接信息
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)){
				respContent = "您发送的是链接消息";
			}
			//音频信息
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)){
				respContent = "您发送的是音频消息";
			}
			//视频信息
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)){
				respContent = "您发送的是视频消息";
			}
			//小视频信息
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_SHORTVIDEO)){
				respContent = "您发送的是小视频消息";
			}
			//事件推送
			else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)){
				//事件类型
				String eventType = requestMap.get("Event");
				//订阅
				if(eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
					respContent = "谢谢您的关注！";
				}
				//取消订阅
				else if(eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)){
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复
				}
				else if(eventType.equals(MessageUtil.EVENT_TYPE_CLICK)){
					// TODO 自定义菜单权没有开放，暂不处理该类消息
				}
				
			}
			textMessage.setContent(respContent);
//			textMessage.setContent("自行车\ue136 男人\ue138 钱袋\ue12f 情侣"
//					+ "\ue428 公共汽车\ue159");
			respMessage = MessageUtil.textMessageToXml(textMessage);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return respMessage;
		
	}
}
