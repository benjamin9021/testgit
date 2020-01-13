package kr.co.ca;

import java.util.Scanner;

import com.naver.CInfoDAO;


public class CarDeleteCommand extends Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("Id를 입력하세요.");
	      String did = sc.nextLine();
	      CInfoDAO dao = new CInfoDAO();
	      dao.delete(did);
	      System.out.println(did + "삭제 합니다");
	}
//	System.out.println("유저아이디를 입력해주세요.");
//	String did = sc.nextLine();
//	System.out.println("검색중입니다.");
//	UserDAO dao = new UserDAO();
//	UserDTO list = dao.selectID(did);
//	System.out.println(list);
//	
}
