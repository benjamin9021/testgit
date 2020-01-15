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
			System.out.println("���̵� �Է��ϼ���.");
			String id = sc.nextLine();
			if (id.trim().length() < 1) {
				System.out.println("�ʼ� �Է»����Դϴ�.");
				continue;
			}
			dto.setDid(id);
			break;

		}
		while (true) {
			System.out.println("����ȣ�� �Է��ϼ���.");
			String cnum = sc.nextLine();
			Pattern ap = Pattern.compile("^[0-9]*$");
			Matcher am = ap.matcher(cnum);
			if (Integer.parseInt(cnum) < 1000 && Integer.parseInt(cnum) > 10000) {
				System.out.println("������ȣ�� 1000���̻���� �����մϴ�.");
				continue;
			}
			if (!am.find()) {
				System.out.println("���ڸ� �Է��ؾߵ˴ϴ�.");
				continue;
			}
			if (cnum.trim().length() < 1) {
				System.out.println("�ʼ� �Է»����Դϴ�.");
				continue;
			}
			CInfoDTO chk = dao.number(Integer.parseInt(cnum));
			if (chk != null) {
				System.out.println("������ȣ�� �ߺ��˴ϴ�. �ٽ��Է����ּ���.");
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
			System.out.println("������ �Է��ϼ���.");
			String cclr = sc.nextLine();
			if (cclr.trim().length() < 1) {
				System.out.println("�ʼ� �Է»����Դϴ�.");
				continue;
			}

			dto.setCclr(cclr);
			break;
		}
		System.out.println("���� ������ �Ϸ� �Ǿ����ϴ�.");
		dao.insert(dto);
	}
}
