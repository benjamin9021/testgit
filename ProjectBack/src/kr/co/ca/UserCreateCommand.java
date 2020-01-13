package kr.co.ca;

import java.util.Scanner;

import com.naver.UserDAO;
import com.naver.UserDTO;

public class UserCreateCommand extends Command {

	@Override
	public void execute(Scanner sc) {
		UserDTO dto = new UserDTO();
		UserDAO dao = new UserDAO();
		
		
		while(true) {
			System.out.println("아이디를 입력하세요.");
			String id = sc.nextLine();
			if (id.trim().length() < 1) {
				System.out.println("필수 입력사항입니다.");
				continue;
			}
			UserDTO chk = dao.selectID(id);
			if(chk!=null) {
				System.out.println("아이디가 중복됩니다. 다시입력해주세요.");
				continue;
			}
			dto.setDid(id);	
			break;
			
		}
		
		
		
		while(true) {
			System.out.println("이름을 입력하세요.");
			String name = sc.nextLine();
			byte[] count = name.getBytes();
			int chkbyte = (count.length-name.length());
			
			
			
			if (name.trim().length() < 1) {
				System.out.println("필수 입력사항입니다.");
				continue;
			}
			dto.setName(name);
			break;
		}
		
		
		
		while(true) {
			System.out.println("나이을 입력하세요.");
			String age = sc.nextLine();
			if (age.trim().length() < 1) {
				System.out.println("필수 입력사항입니다.");
				continue;
			}
			
			boolean agechk = true;
			for (int i = 0; i < age.length(); i++) {
				char ch = age.charAt(i);
				if(ch<'0'||ch>'9') {
					agechk = false;
					break;
				}
			}
			if(agechk == false) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
			if (Integer.parseInt(age)<20 || Integer.parseInt(age)>82) {
				System.out.println("20세이상 81세이하만 등록이 가능합니다.");
				continue;
			}
			
			dto.setAge(Integer.parseInt(age));
			break;
			}
		
		
		System.out.println("계정 생성이 완료 되었습니다.");
		dao.insert(dto);
		}
	}


