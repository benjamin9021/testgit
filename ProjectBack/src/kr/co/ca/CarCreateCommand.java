package kr.co.ca;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.naver.CInfoDAO;
import com.naver.CInfoDTO;

public class CarCreateCommand extends Command {
	@Override
	public void execute(Scanner sc) {
		CInfoDTO dto = new CInfoDTO();
		CInfoDAO dao = new CInfoDAO();
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
			System.out.println("차번호를 입력하세요.");
			String cnum = sc.nextLine();
			Pattern ap = Pattern.compile("^[0-9]*$");
			Matcher am = ap.matcher(cnum);
			if (Integer.parseInt(cnum) < 1000 && Integer.parseInt(cnum) > 10000) {
				System.out.println("차량번호는 1000번이상부터 가능합니다.");
				continue;
			}
			if (!am.find()) {
				System.out.println("숫자만 입력해야됩니다.");
				continue;
			}
			if (cnum.trim().length() < 1) {
				System.out.println("필수 입력사항입니다.");
				continue;
			}
			CInfoDTO chk = dao.number(Integer.parseInt(cnum));
			if (chk != null) {
				System.out.println("차량번호가 중복됩니다. 다시입력해주세요.");
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
			dto.setNumber(Integer.parseInt(cnum));
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
		System.out.println("계정 생성이 완료 되었습니다.");
		dao.insert(dto);
	}
}
