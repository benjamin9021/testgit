package kr.co.ca;

import java.util.Scanner;

import com.naver.UserDAO;
import com.naver.UserDTO;

import java.util.ArrayList;



public class UserAllListCommand extends Command {

	@Override
	public void execute(Scanner sc) {
		
		UserDAO cdao = new UserDAO();

		
		ArrayList<UserDTO> list = cdao.select();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}

