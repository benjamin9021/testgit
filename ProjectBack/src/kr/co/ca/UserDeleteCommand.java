package kr.co.ca;

import java.util.Scanner;

import com.naver.UserDAO;

public class UserDeleteCommand extends Command{
	   
	   @Override
	   public void execute(Scanner sc) {
	      // TODO Auto-generated method stub
	      System.out.println("Id�� �Է��ϼ���");
	      String did = sc.nextLine();
	      UserDAO dao = new UserDAO();
	      dao.delete(did);
	      System.out.println(did + "���� �մϴ�.");
	      
	         }
}