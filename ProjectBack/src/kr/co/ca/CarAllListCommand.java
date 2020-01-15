package kr.co.ca;

import java.util.ArrayList;
import java.util.Scanner;

import com.naver.CInfoDAO;
import com.naver.CInfoDTO;


public class CarAllListCommand extends Command {

	@Override
	public void execute(Scanner sc) {
		CInfoDAO cdao = new CInfoDAO();

		
		ArrayList<CInfoDTO> list = cdao.select();
		System.out.println(list);

	}

}
