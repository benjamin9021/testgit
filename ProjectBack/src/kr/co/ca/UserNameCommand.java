package kr.co.ca;

import java.util.ArrayList;
import java.util.Scanner;

import com.naver.UserDAO;
import com.naver.UserDTO;

public class UserNameCommand extends Command {

	@Override
	public void execute(Scanner sc) {
			System.out.println("�����̸��� �Է����ּ���.");
			String name = sc.nextLine();
			System.out.println("�˻����Դϴ�.");
			UserDAO dao = new UserDAO();
			ArrayList<UserDTO> list = dao.selectNAME(name);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			
		}
	}