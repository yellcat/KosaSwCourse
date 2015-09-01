package JavaProject.test;

import java.sql.*;
import java.util.Scanner;

import JavaProject.dao.*;
import JavaProject.service.ShoppingMallService;

public class Init {
	public static void init() {
		singleton singleton = new singleton();
		if (singleton.isState() != true) {
			System.out.println("--------------------------");
			System.out.println("1. ȸ������ |2. �α��� |3. ����");
			System.out.println("---------------------------");
			System.out.print("����>");

		} else {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("1.�α׾ƿ� | 2.��ǰ��� | 3.��ٱ��ϳֱ� | 4.��ٱ��Ϻ��� | 5.�ֹ��ϱ� | 6.��ü�ֹ����� | 7.�ֹ������� ");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.print("����>");

		}
	}

	public static void input(Connection conn, Scanner scanner) {
		// Dao
//		MemberDao memberdao = new MemberDao(conn);// ȸ������
		if (singleton.isState() != true) {
			try {
				int sel = Integer.parseInt(scanner.next());

				switch (sel) {
				case 1: // ȸ������
					ShoppingMallService.join(conn, scanner);
					break;
				case 2: // �α���
					singleton.setNowMember(ShoppingMallService.login(conn, scanner));
					break;
				case 3:// ������
					singleton.setRun(false);
					System.out.println("����Ǿ����ϴ�");
					break;
				default:
					System.out.println("1~3 ������ ���� �Է����ּ���");
					break;
				}
			} catch (Exception e) {
				System.out.println("��ȿ���� ���� �Է��Դϴ�");
			}
		} else {
			try {
				int sel = Integer.parseInt(scanner.next());

				switch (sel) {
				case 1: // �α׾ƿ�
					ShoppingMallService.logout();
					break;
				case 2: // ��ǰ����
					ShoppingMallService.showProduct();
					break;
				case 3: // īƮ�߰�
					ShoppingMallService.addcart(conn, scanner);
					break;
				case 4: // īƮ����
					ShoppingMallService.showcart(conn, singleton.getNowMember().getId());
					break;
				case 5: // �ֹ��ϱ�
					ShoppingMallService.order(conn, scanner);
					break;
				case 6: // ��ü�ֹ�����
					ShoppingMallService.showOrder(conn, singleton.getNowMember().getId());
					break;
				case 7: // �ֹ�������
					ShoppingMallService.showorderitemService(scanner);
					break;
				default:
					System.out.println("1~7 ������ ���� �Է����ּ���");
					break;
				}
			} catch (Exception e) {
				System.out.println("��ȿ���� ���� �Է��Դϴ�");
			}
		}

	}

}
