package JavaProject.service;

import JavaProject.dao.*;
import JavaProject.test.singleton;

import java.sql.*;
import java.util.*;

public class ShoppingMallService {
	// 1.1 ����
	public static void join(Connection conn, Scanner scanner) {
		MemberDao mdao = new MemberDao(conn);

		System.out.println("--------------");
		System.out.println("ȸ������");
		System.out.println("--------------");
		System.out.print("ID: ");
		String id = scanner.next();

		System.out.print("Name: ");
		String name = scanner.next();

		System.out.print("Password: ");
		String password = scanner.next();

		System.out.print("Mobile(���ڸ� �Է�): ");
		String mobile = scanner.next();

		System.out.print("Address: ");
		String address = scanner.next();

		Member newMember = new Member(id, password, name, mobile, address);

		try {
			System.out.println(mdao.insert(newMember) + "���� ȸ���� ���ԵǾ����ϴ�.");
		} catch (SQLIntegrityConstraintViolationException e1) {
			System.out.println("�̹� �����ϴ� id�Դϴ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 1.2�α���
	public static Member login(Connection conn, Scanner scanner) {
		MemberDao mdao = new MemberDao(conn);
		System.out.println("--------");
		System.out.println("�α���");
		System.out.println("--------");

		System.out.print("ID: ");
		String id = scanner.next();

		System.out.print("Password: ");
		String password = scanner.next();

		try {
			return loginCheck(id, password, mdao);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	// �α��� ���̵�, ��й�ȣ üũ
	public static Member loginCheck(String id, String password, MemberDao mdao)
			throws IDNotFoundException, PasswordNotFoundException, SQLException {
		Member member = mdao.selectByPk(id);
		if (member == null) {
			throw new IDNotFoundException("���̵� �������� �ʽ��ϴ�.");
		} else {
			if (member.getPw().equals(password)) {
				singleton.setState(true);
				System.out.println("�α��ο� �����߽��ϴ�");
				return member;
			} else {
				throw new PasswordNotFoundException("��й�ȣ�� Ʋ���ϴ�.");
			}
		}
	}

	// 2.1.�α׾ƿ�
	public static void logout() {
		singleton.setState(false);
		System.out.println("�α׾ƿ� �Ǿ����ϴ�");
	}

	// 2.2��ǰ����
	public static void showProduct() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			ProductDao productDao = new ProductDao(conn);
			List<Product> list = productDao.selectByPage(1, 10); // �Է°� ���ľ���
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("��ǰ��ȣ\t��ǰ��\t��ǰ�ܰ�");
			System.out.println("-------------------------------------------------------------------------------");

			for (Product product : list) {
				System.out.print(product.getProduct_no() + "\t");
				System.out.print(product.getProduct_name() + "\t");
				System.out.print(product.getProduct_price() + "\t");
				System.out.println();
			}

			System.out.println("-------------------------------------------------------------------------------");

		} catch (Exception e) {

		} finally {
			conn.close();
		}
	}

	// 2.3 ��ٱ��� �ֱ�
	public static void addcart(Connection conn, Scanner scanner) {
		Cart cart = new Cart();
		CartDao cdao = new CartDao(conn);
		ProductDao pdao = new ProductDao(conn);

		cart.setMember_id(singleton.getNowMember().getId());

		try {
			System.out.print("��ǰ��ȣ> ");
			cart.setProduct_no(Integer.parseInt(scanner.next()));
			System.out.print("����> ");
			int num = Integer.parseInt(scanner.next());
			cart.setCart_amount(num);
			if (num == Integer.parseInt("0")) {
				throw new ZeroInputException("0���� ��ǰ�� ��ٱ��Ͽ� ���� �� �����ϴ�");
			}
			cdao.insert(cart);
			Product product = pdao.selectByPk(cart.getProduct_no());
			System.out.println(singleton.getNowMember().getName() + "(" + cart.getMember_id() + ")���� īƮ��  "
					+ product.getProduct_name() + " (��ǰ��ȣ: " + cart.getProduct_no() + " ) " + cart.getCart_amount()
					+ "�� �߰��Ǿ����ϴ�");
		} catch (NumberFormatException e) {
			System.out.println("������ ���ڸ� �Է� �����մϴ�");
		} catch (ZeroInputException e1) {
			System.out.println(e1.getMessage());
		} catch (SQLIntegrityConstraintViolationException e4) {
			System.out.println("��ǰ�� �����ϴ�");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
	}

	// 2.4 ��ٱ��� ����
	public static void showcart(Connection conn, String member_id) {
		CartDao cdao = new CartDao(conn);
		ProductDao pdao = new ProductDao(conn);

		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("��ǰ��ȣ    ��ǰ��      ����    ����");
		System.out.println("-------------------------------------------------------------------------------");

		int All = 0;
		Product product = new Product();

		try {
			for (Cart cart : cdao.selectByPk(member_id)) {
				product = pdao.selectByPk(cart.getProduct_no());
				System.out.print(cart.getProduct_no() + "\t");
				System.out.print(product.getProduct_name() + "\t");
				System.out.print(cart.getCart_amount() + "\t");
				System.out.println(product.getProduct_price() * cart.getCart_amount());
				All += product.getProduct_price() * cart.getCart_amount();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Cart Ŭ������ ã�� �� �����ϴ�");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL �����Դϴ�.");
		} catch (NullPointerException e) {
			System.out.println("��ٱ��Ͽ� ��ǰ�� �����ϴ�");
		} finally {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("�� �ݾ�: " + All);
		}
	}

	// 2.5 ����
	public static void order(Connection conn, Scanner scanner) throws ClassNotFoundException, SQLException {
		CartDao cdao = new CartDao(conn);
		OrderDao odao = new OrderDao(conn);
		OrderItemDao oidao = new OrderItemDao(conn);
		int no = 0;
		showcart(conn, singleton.getNowMember().getId());

		for (Cart cart : cdao.selectByPk(singleton.getNowMember().getId())) {
			no += cart.getCart_amount();
		}
		if (no == 0) {
			System.out.println("�ֹ��� ��ǰ�� �����ϴ�");
		} else {

			System.out.println("----------------------------------");
			System.out.println("1.ī��  2.������ü  3.��ǰ��  4.����� �������");
			System.out.println("----------------------------------");
			System.out.print("�������>");
			int sel = Integer.parseInt(scanner.next());

			String payment = null;
			switch (sel) {
			case 1:
				payment = "ī��";
				break;
			case 2:
				payment = "������ü";
				break;
			case 3:
				payment = "��ǰ��";
				break;
			case 4:
				payment = "����� �������";
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				return;
			}

			try {
				conn.setAutoCommit(false);
				List<Cart> list = cdao.selectByPk(singleton.getNowMember().getId());

				Order order = new Order();
				order.setPayment(payment);
				order.setId(singleton.getNowMember().getId());

				int orderno = odao.insert(order);
				OrderItem orderitem = new OrderItem();
				orderitem.setOrderno(orderno);

				for (Cart cart : list) {
					orderitem.setProductno(cart.getProduct_no());
					orderitem.setOrderproductamount(cart.getCart_amount());
					oidao.insert(orderitem);
				}
				cdao.delete(singleton.getNowMember().getId());
				System.out.println("�ֹ��� �Ϸ�Ǿ����ϴ�. (�ֹ���ȣ: " + orderno + " )");
				conn.commit();
			} catch (ClassNotFoundException e) {
				try {
					System.out.println("class �ֹ�����");
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (SQLException e) {
				try {
					System.out.println("sql �ֹ�����");
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 2.6 ��ü��������
	public static void showOrder(Connection conn, String member_id) {
		OrderDao odao = new OrderDao(conn);
		// ProductDao pdao = new ProductDao(conn);
		// OrderItemDao oidao = new OrderItemDao(conn);

		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("�ֹ���ȣ    �ֹ��� ");
		System.out.println("-------------------------------------------------------------------------------");

		List<Order> list = null;
		try {
			list = odao.selectByPk(member_id);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		for (Order order : list) {
			System.out.print(order.getNo() + "\t");
			System.out.println(order.getId() + "\t");
			// System.out.println(order.getPrice() + "\t");
		}
	}

	// 2.7 �ֹ�������
	public static void showorderitemService(Scanner scanner) {
		System.out.print("�ֹ���ȣ: ");
		int key = Integer.parseInt(scanner.next());
		showorderitem(key);
	}

	public static void showorderitem(int key) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			Product product = new Product();
			OrderDao odao = new OrderDao(conn);
			OrderItemDao orderitemDao = new OrderItemDao(conn);
			ProductDao productdao = new ProductDao(conn);
			List<OrderItem> list = orderitemDao.selectByNo(key);
	
			int All = 0;
			Order order = odao.selectByPk(key);
//			System.out.println(order.getId());
//			System.out.println(singleton.getNowMember().getId());
			
			if (singleton.getNowMember().getId().equals(order.getId())) {
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("��ǰ��ȣ\t��ǰ��\t����\t����");
				System.out.println("-------------------------------------------------------------------------------");

				for (OrderItem orderitem : list) {
					System.out.print(orderitem.getProductno() + "\t");

					product = productdao.selectByPk(orderitem.getProductno());

					System.out.print("\t" + product.getProduct_name() + "\t");
					System.out.print(orderitem.getOrderproductamount() + "\t");
					System.out.println(orderitem.getOrderproductamount() + "*" + product.getProduct_price());
					All += product.getProduct_price() * orderitem.getOrderproductamount();

				}
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("�� �ݾ�: " + All);
			}
		} catch (SQLException e) {
			System.out.println("sql����");
		} catch (ClassNotFoundException e){
			System.out.println("class ����");
		}finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

}
