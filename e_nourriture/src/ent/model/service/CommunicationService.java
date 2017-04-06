package ent.model.service;

import java.util.ArrayList;

import ent.model.dao.CommunicationDAO;
import ent.model.dto.Communication;

public class CommunicationService {

	private CommunicationDAO communicationDao;
	
	public CommunicationService() {
		// TODO Auto-generated constructor stub
		communicationDao = new CommunicationDAO();
	}
	
	public ArrayList<Communication> communicationList(String contentsId) {
		 return communicationDao.communicationList(contentsId);
	}
}
