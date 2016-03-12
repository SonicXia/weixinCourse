package org.xiaxiaofeng.course.message.resp;

public class VideoMessage extends BaseMessage{
	private String MediaId;
	private Video video;
	
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	
}
