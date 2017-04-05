package ent.model.dto;

public class Communication {
	private String contentsId;	//index;
	private String comments;		//댓글 내용
	private String senderId;	//발신자 ID(작성자ID)
	private String receiverId;  //
	private String commentTime;	//작성 시간
	
	public Communication() {
		
	}

	public Communication( String comments, String receiverId, String commentTime) {
		super();		
		this.comments = comments;
		this.receiverId = receiverId;
		this.commentTime = commentTime;
	}

	public Communication(String contentsId, String comments, String senderId, String commentTime) {
		super();
		this.contentsId = contentsId;
		this.comments = comments;
		this.senderId = senderId;
		this.commentTime = commentTime;
	}

	public String getContentsId() {
		return contentsId;
	}

	public void setContentsId(String contentsId) {
		this.contentsId = contentsId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	
	
}
