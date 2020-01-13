package kr.co.ca;

import java.util.Scanner;

import com.naver.CInfoDAO;
import com.naver.CInfoDTO;

public class CarUpdateCommand extends Command {

	@Override
	public void execute(Scanner sc) {
		CInfoDTO dto = new CInfoDTO();
		CInfoDAO dao = new CInfoDAO();

		while (true) {
			System.out.println("차량번호를 입력하세요.");
			String cnum = sc.nextLine();
			if (cnum.trim().length() < 1) {
				System.out.println("필수 입력사항입니다.");
				continue;
			}

			boolean cnumchk = true;
			for (int i = 0; i < cnum.length(); i++) {
				char ch = cnum.charAt(i);
				if (ch < '0' || ch > '9') {
					cnumchk = false;
					break;
				}
			}
			 CInfoDTO chk = dao.number(Integer.parseInt(cnum));
		       if(chk==null) {
		           System.out.println("차량번호가 없습니다. 다시입력해주세요.");
		           continue;
		        }
			if (cnumchk == false) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
			if (Integer.parseInt(cnum) < 1000 && Integer.parseInt(cnum) > 10000) {
				System.out.println("1000번이상 10000번이하만 등록이 가능합니다.");
				continue;
			}

			dto.setNumber(Integer.parseInt(cnum));
			break;
		}

		while (true) {
			System.out.println("아이디를 입력하세요.");
			String id = sc.nextLine();
			if (id.trim().length() < 1) {
				System.out.println("필수 입력사항입니다.");
				continue;
			}

			dto.setDid(id);
			break;

		}

		while (true) {
			System.out.println("색상을 입력하세요.");
			String cclr = sc.nextLine();
			if (cclr.trim().length() < 1) {
				System.out.println("필수 입력사항입니다.");
				continue;
			}
			dto.setCclr(cclr);
			break;
		}
		dao.update(dto);
	}
}
