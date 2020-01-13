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

					System.out.println("메뉴를 선택하세요.");
					System.out.println("추가수정본");
					System.out.println("===============유저 정보====================");
					System.out.println("0:등록  1:아이디 조회  2:이름 조회 3:모두 조회  4:수정  5:삭제 \t");
					System.out.println("===============차량 정보====================");
					System.out.println("6:등록  7:차번 조회  8:아이디 조회 9:모두 조회 10:삭제 11:모든정보 조회");
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

