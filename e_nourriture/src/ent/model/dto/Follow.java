package ent.model.dto;

public class Follow {
	private String userId;			//ID
	private String followerUserId;		//�ȷο� ID
	private String followingUserId;		//�ȷ��� ID
	
	public Follow() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFollowerUserId() {
		return followerUserId;
	}

	public void setFollowerUserId(String followerUserId) {
		this.followerUserId = followerUserId;
	}

	public String getFollowingUserId() {
		return followingUserId;
	}

	public void setFollowingUserId(String followingUserId) {
		this.followingUserId = followingUserId;
	}
	
	
	
}
