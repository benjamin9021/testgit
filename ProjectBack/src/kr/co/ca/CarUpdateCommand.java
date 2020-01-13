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
			System.out.println("������ȣ�� �Է��ϼ���.");
			String cnum = sc.nextLine();
			if (cnum.trim().length() < 1) {
				System.out.println("�ʼ� �Է»����Դϴ�.");
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
		           System.out.println("������ȣ�� �����ϴ�. �ٽ��Է����ּ���.");
		           continue;
		        }
			if (cnumchk == false) {
				System.out.println("���ڸ� �Է��ϼ���.");
				continue;
			}
			if (Integer.parseInt(cnum) < 1000 && Integer.parseInt(cnum) > 10000) {
				System.out.println("1000���̻� 10000�����ϸ� ����� �����մϴ�.");
				continue;
			}

			dto.setNumber(Integer.parseInt(cnum));
			break;
		}

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
			System.out.println("������ �Է��ϼ���.");
			String cclr = sc.nextLine();
			if (cclr.trim().length() < 1) {
				System.out.println("�ʼ� �Է»����Դϴ�.");
				continue;
			}
			dto.setCclr(cclr);
			break;
		}
		dao.update(dto);
	}
}
