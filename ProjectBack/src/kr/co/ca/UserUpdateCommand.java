package kr.co.ca;

import java.util.Scanner;

import com.naver.UserDAO;
import com.naver.UserDTO;

public class UserUpdateCommand extends Command {

   @Override
   public void execute(Scanner sc) {
      UserDTO dto = new UserDTO();
      UserDAO dao = new UserDAO();
      while (true) {
         System.out.println("���̵� �Է��ϼ���.");
         String id = sc.nextLine();
         if (id.trim().length() < 1) {
            System.out.println("�ʼ� �Է»����Դϴ�.");
            continue;
         }
         UserDTO chk = dao.selectID(id);
         if (chk == null) {
            System.out.println("���̵� �����ϴ�. �ٽ��Է����ּ���.");
            continue;
         }
         dto.setDid(id);
         break;

      }
      while (true) {
         System.out.println("������ �̸��� �Է��ϼ���.");
         String name = sc.nextLine();
         if (name.trim().length() < 1) {
            System.out.println("�ʼ� �Է»����Դϴ�.");
            continue;
         }
         dto.setName(name);
         break;
      }
      while (true) {
         System.out.println("������ ������ �Է��ϼ���.");
         String age = sc.nextLine();
         if (age.trim().length() < 1) {
            System.out.println("�ʼ� �Է»����Դϴ�.");
            continue;
         }

         boolean agechk = true;
         for (int i = 0; i < age.length(); i++) {
            char ch = age.charAt(i);
            if (ch < '0' || ch > '9') {
               agechk = false;
               break;
            }
         }
         if (agechk == false) {
            System.out.println("���ڸ� �Է��ϼ���.");
            continue;
         }
         if (Integer.parseInt(age) < 20 || Integer.parseInt(age) > 82) {

            System.out.println("20���̻� 81�����ϸ� ����� �����մϴ�.");
            continue;
         }

         dto.setAge(Integer.parseInt(age));
         break;
      }
      dao.update(dto);
   }

}
