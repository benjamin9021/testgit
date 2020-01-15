package kr.co.ca;

import java.util.ArrayList;
import java.util.Scanner;

import com.naver.CInfoDAO;
import com.naver.CInfoDTO;

public class CarUserListCommand extends Command {

	@Override
	public void execute(Scanner sc) {
		CInfoDAO dao = new CInfoDAO();
		
		
		ArrayList<CInfoDTO> list = dao.select();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
