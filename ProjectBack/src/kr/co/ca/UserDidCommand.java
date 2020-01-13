package kr.co.ca;

import java.util.Scanner;
import com.naver.UserDAO;
import com.naver.UserDTO;

public class UserDidCommand extends Command {
	

	@Override
	public void execute(Scanner sc) {
		System.out.println("유저아이디를 입력해주세요.");
		String did = sc.nextLine();
		System.out.println("검색중입니다.");
		UserDAO dao = new UserDAO();
		UserDTO list = dao.selectID(did);
		System.out.println(list);
		
	}
	
}
