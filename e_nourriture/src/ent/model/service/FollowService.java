package ent.model.service;

import java.util.ArrayList;

import ent.model.dao.FollowDAO;
import ent.model.dto.Contents;

public class FollowService {

	private FollowDAO followDAO = null;
	
	public FollowService() {
		// TODO Auto-generated constructor stub
		followDAO = new FollowDAO();
	}
	public ArrayList<Contents> usersFollowingContentsLoading(String userId) {
		System.out.println("++++++++++++++++++++++++++++++++");
		return followDAO.usersFollowingContentsLoading(followDAO.usersFollowingIdListLoading(userId));
	}
}
