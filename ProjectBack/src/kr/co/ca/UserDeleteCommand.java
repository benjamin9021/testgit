package kr.co.ca;

import java.util.Scanner;

import com.naver.UserDAO;

public class UserDeleteCommand extends Command{
	   
	   @Override
	   public void execute(Scanner sc) {
	      // TODO Auto-generated method stub
	      System.out.println("Id를 입력하세요");
	      String did = sc.nextLine();
	      UserDAO dao = new UserDAO();
	      dao.delete(did);
	      System.out.println(did + "삭제 합니다.");
	      
	         }
}