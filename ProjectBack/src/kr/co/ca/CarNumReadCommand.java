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
	       System.out.println("차번호를 입력하세요.");
	       String cnum = sc.nextLine();
			 Pattern ap = Pattern.compile("^[0-9]*$");
			 Matcher am = ap.matcher(cnum);
			 if (!am.find()) {
				 System.out.println("숫자만 입력해야됩니다.");
				 continue;
			 }
			 if(Integer.parseInt(cnum) < 1000 && Integer.parseInt(cnum) > 10000) {
				 System.out.println("차량번호는 1000번이상부터 가능합니다.");
				 continue;
			 }
			 
	       if (cnum.trim().length() < 1) {
	          System.out.println("필수 입력사항입니다.");
	          continue;
	       }
	       CInfoDTO chk = dao.number(Integer.parseInt(cnum));
	       if(chk==null) {
	           System.out.println("차량번호가 없습니다. 다시입력해주세요.");
	           continue;
	        }
	       CInfoDTO list = dao.number(Integer.parseInt(cnum));
	       System.out.println(list);
	       break;
	    }
		
//		System.out.println("유저아이디를 입력해주세요.");
//		String did = sc.nextLine();
//		System.out.println("검색중입니다.");
//		UserDAO dao = new UserDAO();
//		UserDTO list = dao.selectID(did);
//		System.out.println(list);
}
}
