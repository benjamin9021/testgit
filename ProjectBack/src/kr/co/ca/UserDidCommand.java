package kr.co.ca;

import java.util.Scanner;
import com.naver.UserDAO;
import com.naver.UserDTO;

public class UserDidCommand extends Command {
	

	@Override
	public void execute(Scanner sc) {
		System.out.println("�������̵� �Է����ּ���.");
		String did = sc.nextLine();
		System.out.println("�˻����Դϴ�.");
		UserDAO dao = new UserDAO();
		UserDTO list = dao.selectID(did);
		System.out.println(list);
		
	}
	
}
