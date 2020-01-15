package kr.co.ca;

import java.util.Scanner;

import com.naver.CInfoDAO;

public class CarNumberDeleteCommand extends Command {
	   
	   @Override
	   public void execute(Scanner sc) {
	      // TODO Auto-generated method stub
	      System.out.println("차량번호를 입력하세요.");
	      String cnum = sc.nextLine();
	      CInfoDAO dao = new CInfoDAO();
	      dao.delete(cnum);
	      System.out.println(cnum + "삭제 합니다");
	   
	   }
	}
