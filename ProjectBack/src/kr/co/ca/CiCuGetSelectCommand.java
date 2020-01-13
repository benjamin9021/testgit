package kr.co.ca;


import java.util.ArrayList;
import java.util.Scanner;

import com.naver.CiCuserDAO;
import com.naver.CiCuserDTO;



public class CiCuGetSelectCommand extends Command {

	@Override
	public void execute(Scanner sc) {
		
		CiCuserDAO cdao = new CiCuserDAO();

		
		ArrayList<CiCuserDTO> list = cdao.select();
		System.out.println(list);
	}

}

