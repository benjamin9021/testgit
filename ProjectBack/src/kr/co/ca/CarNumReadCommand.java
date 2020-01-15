package kr.co.ca;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.naver.CInfoDAO;
import com.naver.CInfoDTO;

public class CarNumReadCommand extends Command {

	@Override
	public void execute(Scanner sc) {
	    CInfoDAO dao = new CInfoDAO();
	    
	    while(true) {
	       System.out.println("����ȣ�� �Է��ϼ���.");
	       String cnum = sc.nextLine();
			 Pattern ap = Pattern.compile("^[0-9]*$");
			 Matcher am = ap.matcher(cnum);
			 if (!am.find()) {
				 System.out.println("���ڸ� �Է��ؾߵ˴ϴ�.");
				 continue;
			 }
			 if(Integer.parseInt(cnum) < 1000 && Integer.parseInt(cnum) > 10000) {
				 System.out.println("������ȣ�� 1000���̻���� �����մϴ�.");
				 continue;
			 }
			 
	       if (cnum.trim().length() < 1) {
	          System.out.println("�ʼ� �Է»����Դϴ�.");
	          continue;
	       }
	       CInfoDTO chk = dao.number(Integer.parseInt(cnum));
	       if(chk==null) {
	           System.out.println("������ȣ�� �����ϴ�. �ٽ��Է����ּ���.");
	           continue;
	        }
	       CInfoDTO list = dao.number(Integer.parseInt(cnum));
	       System.out.println(list);
	       break;
	    }
		
//		System.out.println("�������̵� �Է����ּ���.");
//		String did = sc.nextLine();
//		System.out.println("�˻����Դϴ�.");
//		UserDAO dao = new UserDAO();
//		UserDTO list = dao.selectID(did);
//		System.out.println(list);
}
}
