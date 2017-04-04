package ent.model.dto;

public class Communication {
	private String ContentsId;	//index;
	private String comment;		//댓글 내용
	private String senderId;	//발신자 ID(작성자ID)
	private String writeDate;	//작성 시간
	
	
	public Communication() {
		
	}
	public String getContentsId() {
		return ContentsId;
	}
	public void setContentsId(String contentsId) {
		ContentsId = contentsId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
	
}
