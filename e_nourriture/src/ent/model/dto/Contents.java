package ent.model.dto;

import java.util.ArrayList;

public class Contents {
	private String ContentsId;			//index
	private String userId;				//writer
	private String name;				//name
	private String contents;			//����
	private String writeDate;			//�ۼ� �ð�
	private String imgURL;				//�̹��� URL
	private int contentsLikeCount; 			//���ƿ�
	private ArrayList<Communication> communication;	//���
	private ProductInfo productInfo;		//��ǰ ����
}
