package kr.co.ca;

import java.util.ArrayList;
import java.util.Scanner;

import com.naver.UserDAO;
import com.naver.UserDTO;

public class NamereadCommand extends Command {

	@Override
	public void execute(Scanner sc) {
			System.out.println("유저이름를 입력해주세요.");
			String name = sc.nextLine();
			System.out.println("검색중입니다.");
			UserDAO dao = new UserDAO();
			ArrayList<UserDTO> list = dao.selectNAME(name);
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			
		}
	}