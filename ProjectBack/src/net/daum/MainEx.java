package net.daum;

import java.util.Scanner;

import kr.co.ca.CarCreateCommand;
import kr.co.ca.CarNumReadCommand;
import kr.co.ca.CarNumberDeleteCommand;
import kr.co.ca.CarUpdateCommand;
import kr.co.ca.CarUserListCommand;
import kr.co.ca.Command;
import kr.co.ca.UserAllListCommand;
import kr.co.ca.UserCreateCommand;
import kr.co.ca.UserDeleteCommand;
import kr.co.ca.UserDidCommand;
import kr.co.ca.UserNameCommand;
import kr.co.ca.UserUpdateCommand;

public class MainEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean ist = true;
		Command[] com = {new UserCreateCommand(),new UserDidCommand(),new UserNameCommand(),
						new UserAllListCommand(),new UserUpdateCommand(),new UserDeleteCommand(),
						new CarCreateCommand(),new CarNumReadCommand(),new CarUserListCommand(),
						new CarNumberDeleteCommand(),new CarUpdateCommand()
						};
			
				while (ist) {

					System.out.println("�޴��� �����ϼ���.");
					System.out.println("�߰�������");
					System.out.println("===============���� ����====================");
					System.out.println("0:���  1:���̵� ��ȸ  2:�̸� ��ȸ 3:��� ��ȸ  4:����  5:���� \t");
					System.out.println("===============���� ����====================");
					System.out.println("6:���  7:���� ��ȸ  8:���̵� ��ȸ 9:��� ��ȸ 10:���� 11:������� ��ȸ");
					int menu = sc.nextInt();
					sc.nextLine();
					if (menu != com.length) {
						Command c = com[menu];
						if (c != null) {
							c.execute(sc);
							
						}
					} else {
						ist = false;
					}
				}
		sc.close();
	}
	

}

