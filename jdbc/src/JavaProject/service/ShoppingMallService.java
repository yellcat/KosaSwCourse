package JavaProject.service;

import JavaProject.dao.*;
import JavaProject.test.singleton;

import java.sql.*;
import java.util.*;

public class ShoppingMallService {
	// 1.1 가입
	public static void join(Connection conn, Scanner scanner) {
		MemberDao mdao = new MemberDao(conn);

		System.out.println("--------------");
		System.out.println("회원가입");
		System.out.println("--------------");
		System.out.print("ID: ");
		String id = scanner.next();

		System.out.print("Name: ");
		String name = scanner.next();

		System.out.print("Password: ");
		String password = scanner.next();

		System.out.print("Mobile(숫자만 입력): ");
		String mobile = scanner.next();

		System.out.print("Address: ");
		String address = scanner.next();

		Member newMember = new Member(id, password, name, mobile, address);

		try {
			System.out.println(mdao.insert(newMember) + "명의 회원이 가입되었습니다.");
		} catch (SQLIntegrityConstraintViolationException e1) {
			System.out.println("이미 존재하는 id입니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 1.2로그인
	public static Member login(Connection conn, Scanner scanner) {
		MemberDao mdao = new MemberDao(conn);
		System.out.println("--------");
		System.out.println("로그인");
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

	// 로그인 아이디, 비밀번호 체크
	public static Member loginCheck(String id, String password, MemberDao mdao)
			throws IDNotFoundException, PasswordNotFoundException, SQLException {
		Member member = mdao.selectByPk(id);
		if (member == null) {
			throw new IDNotFoundException("아이디가 존재하지 않습니다.");
		} else {
			if (member.getPw().equals(password)) {
				singleton.setState(true);
				System.out.println("로그인에 성공했습니다");
				return member;
			} else {
				throw new PasswordNotFoundException("비밀번호가 틀립니다.");
			}
		}
	}

	// 2.1.로그아웃
	public static void logout() {
		singleton.setState(false);
		System.out.println("로그아웃 되었습니다");
	}

	// 2.2상품보기
	public static void showProduct() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			ProductDao productDao = new ProductDao(conn);
			List<Product> list = productDao.selectByPage(1, 10); // 입력값 고쳐야함
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("상품번호\t상품명\t상품단가");
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

	// 2.3 장바구니 넣기
	public static void addcart(Connection conn, Scanner scanner) {
		Cart cart = new Cart();
		CartDao cdao = new CartDao(conn);
		ProductDao pdao = new ProductDao(conn);

		cart.setMember_id(singleton.getNowMember().getId());

		try {
			System.out.print("상품번호> ");
			cart.setProduct_no(Integer.parseInt(scanner.next()));
			System.out.print("수량> ");
			int num = Integer.parseInt(scanner.next());
			cart.setCart_amount(num);
			if (num == Integer.parseInt("0")) {
				throw new ZeroInputException("0개의 상품은 장바구니에 넣을 수 없습니다");
			}
			cdao.insert(cart);
			Product product = pdao.selectByPk(cart.getProduct_no());
			System.out.println(singleton.getNowMember().getName() + "(" + cart.getMember_id() + ")님의 카트에  "
					+ product.getProduct_name() + " (상품번호: " + cart.getProduct_no() + " ) " + cart.getCart_amount()
					+ "개 추가되었습니다");
		} catch (NumberFormatException e) {
			System.out.println("수량은 숫자만 입력 가능합니다");
		} catch (ZeroInputException e1) {
			System.out.println(e1.getMessage());
		} catch (SQLIntegrityConstraintViolationException e4) {
			System.out.println("상품이 없습니다");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
	}

	// 2.4 장바구니 보기
	public static void showcart(Connection conn, String member_id) {
		CartDao cdao = new CartDao(conn);
		ProductDao pdao = new ProductDao(conn);

		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("상품번호    상품명      수량    가격");
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
			System.out.println("Cart 클래스를 찾을 수 없습니다");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 에러입니다.");
		} catch (NullPointerException e) {
			System.out.println("장바구니에 물품이 없습니다");
		} finally {
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("총 금액: " + All);
		}
	}

	// 2.5 오더
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
			System.out.println("주문할 상품이 없습니다");
		} else {

			System.out.println("----------------------------------");
			System.out.println("1.카드  2.계좌이체  3.상품권  4.모바일 간편결제");
			System.out.println("----------------------------------");
			System.out.print("결제방식>");
			int sel = Integer.parseInt(scanner.next());

			String payment = null;
			switch (sel) {
			case 1:
				payment = "카드";
				break;
			case 2:
				payment = "계좌이체";
				break;
			case 3:
				payment = "상품권";
				break;
			case 4:
				payment = "모바일 간편결제";
				break;
			default:
				System.out.println("잘못된 입력입니다.");
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
				System.out.println("주문이 완료되었습니다. (주문번호: " + orderno + " )");
				conn.commit();
			} catch (ClassNotFoundException e) {
				try {
					System.out.println("class 주문실패");
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (SQLException e) {
				try {
					System.out.println("sql 주문실패");
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

	// 2.6 전체오더보기
	public static void showOrder(Connection conn, String member_id) {
		OrderDao odao = new OrderDao(conn);
		// ProductDao pdao = new ProductDao(conn);
		// OrderItemDao oidao = new OrderItemDao(conn);

		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("주문번호    주문자 ");
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

	// 2.7 주문상세정보
	public static void showorderitemService(Scanner scanner) {
		System.out.print("주문번호: ");
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
				System.out.println("상품번호\t상품명\t수량\t가격");
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
				System.out.println("총 금액: " + All);
			}
		} catch (SQLException e) {
			System.out.println("sql오류");
		} catch (ClassNotFoundException e){
			System.out.println("class 오류");
		}finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

}
