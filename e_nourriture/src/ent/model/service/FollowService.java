package ent.model.service;

import java.util.ArrayList;

import ent.model.dao.FollowDAO;

public class FollowService {

	private FollowDAO followDAO = null;
	
	public FollowService() {
		// TODO Auto-generated constructor stub
		followDAO = new FollowDAO();
	}
	public ArrayList<String> usersContentsLoading(String userId) {
		System.out.println("++++++++++++++++++++++++++++++++");
		return followDAO.usersContentsLoading(userId);
	}
}
