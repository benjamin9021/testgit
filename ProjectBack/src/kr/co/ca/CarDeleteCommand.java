package kr.co.ca;

import java.util.Scanner;

import com.naver.CInfoDAO;


public class CarDeleteCommand extends Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("Id�� �Է��ϼ���.");
	      String did = sc.nextLine();
	      CInfoDAO dao = new CInfoDAO();
	      dao.delete(did);
	      System.out.println(did + "���� �մϴ�");
	}
//	System.out.println("�������̵� �Է����ּ���.");
//	String did = sc.nextLine();
//	System.out.println("�˻����Դϴ�.");
//	UserDAO dao = new UserDAO();
//	UserDTO list = dao.selectID(did);
//	System.out.println(list);
//	
}
