package ent.model.dto;

public class Communication {
	private String ContentsId;	//index;
	private String comment;		//��� ����
	private String senderId;	//�߽��� ID(�ۼ���ID)
	private String writeDate;	//�ۼ� �ð�
	
	
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
