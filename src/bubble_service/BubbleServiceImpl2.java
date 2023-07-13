package bubble_service;

import java.util.ArrayList;
import java.util.Scanner;

import bubble_dao.BubbleDAO;
import bubble_dto.BubbleDTO;

public class BubbleServiceImpl2 implements BubbleService {
	BubbleDAO dao;
	Scanner sc = new Scanner(System.in);
	public BubbleServiceImpl2() {
		dao = new BubbleDAO();
	}

	public void display() {
		BubbleDTO dto = new BubbleDTO();

		while (true) {
		    System.out.println("==========================================================================================================================");
		    System.out.println("(1)버블티\t(2)커피\t(3)스무디\t(4)주문내역보기 (5)메인으로 돌아가기");
			System.out.print(">>> ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				ArrayList<BubbleDTO> list1 = getList1();
				System.out.println("======== 버블티 ========");
				System.out.println("name\t\tprice");
				System.out.println("======================");
				if (list1 != null) {
					for (BubbleDTO b : list1) {
						System.out.print(b.getMenu() + "     \t");
						System.out.println(b.getPrice());
						System.out.println("-----------------------");
					}
					System.out.println("메뉴 선택 : ");
					String cho = sc.next();
					dto.setMenu(cho);
					option1(dto);
					getList();
				}

				break;
			case 2:
				ArrayList<BubbleDTO> list2 = getList2();
				System.out.println("======== 커피 ========");
				System.out.println("name\t\tprice");
				System.out.println("=====================");
				if (list2 != null) {
					for (BubbleDTO b : list2) {
						System.out.print(b.getMenu() + "     \t");
						System.out.println(b.getPrice());
						System.out.println("---------------------");
					}
					System.out.println("메뉴 선택 : ");
					String cho = sc.next();
					dto.setMenu(cho);
					option2(dto);
					getList();
				}
				break;
			case 3:
				ArrayList<BubbleDTO> list3 = getList3();
				System.out.println("======== 스무디 ========");
				System.out.println("name\t\tprice");
				System.out.println("======================");
				if (list3 != null) {
					for (BubbleDTO b : list3) {
						System.out.print(b.getMenu() + " \t\t");
						System.out.println(b.getPrice());
						System.out.println("-----------------------");
					}
					System.out.println("메뉴 선택 : ");
					String cho = sc.next();
					dto.setMenu(cho);
					option3(dto);
					getList();
				}
				break;
			case 4:
				getList();
				break;
			case 5:
				return;
			}
		}
	}
	
	public int option1(BubbleDTO dto) {
		String size, ice, pearl, addPearl;
		int sweet;

		System.out.println("컵 사이즈 선택: s / m / l");
		size = sc.next();
		dto.setSize(size);
		
		System.out.println("얼음양 선택: 적게 / 보통 / 많이");	
		ice = sc.next();
		dto.setIce(ice);
		
		System.out.println("펄 종류 선택: 타피오카 / 알로에 / 젤리 / 코코");	
		pearl = sc.next();
		dto.setPearl(pearl);

		System.out.println("펄 추가(500원): Y / N");
		addPearl = sc.next();
		dto.setAddPearl(addPearl);
		
		System.out.println("당도 선택: 0 / 20 / 50 / 70 / 100");	
		sweet = sc.nextInt();
		dto.setSweet(sweet); 
		
		return dao.insert(dto);
		
	}	

	
	public int option2(BubbleDTO dto) {
		String size, ice, pearl, addPearl;
		int sweet;

		System.out.println("컵 사이즈 선택: s / m / l");
		size = sc.next();
		dto.setSize(size);
		
		System.out.println("얼음양 선택: 적게 / 보통 / 많이");	
		ice = sc.next();
		dto.setIce(ice);
		
		dto.setPearl("선택안함");
		dto.setAddPearl("선택안함");
		dto.setSweet(0);
		return dao.insert(dto);
		
	}	
	public int option3(BubbleDTO dto) {
		String size, ice, pearl, addPearl;
		int sweet,price=0;

		System.out.println("컵 사이즈 선택: s / m / l");
		size = sc.next();
		dto.setSize(size);

		dto.setIce("선택안함");
		
		System.out.println("펄 종류 선택: 타피오카 / 알로에 / 젤리 / 코코");	
		pearl = sc.next();
		dto.setPearl(pearl);

		System.out.println("펄 추가(500원): Y / N");	
		addPearl = sc.next();
		dto.setAddPearl(addPearl);
		
   		dto.setSweet(0);

		return dao.insert(dto);

	}

    public ArrayList<BubbleDTO> getList() {
        ArrayList<BubbleDTO> orderList = dao.getList();
        System.out.println("========================================================== 주문내역 =========================================================");
        System.out.println("num\tmenu\t\tsize\t\tice\t\tpearl\t\tadd_pearl\t\tsweet\t\tprice");
        System.out.println("==========================================================================================================================");
        for (BubbleDTO b : orderList) {
           System.out.println();
           System.out.print(b.getNum()+"\t");
           System.out.print(b.getMenu() + "\t");
           System.out.print("\t"+b.getSize() + "\t");
           System.out.print("\t"+b.getIce() + "\t");
           System.out.print("\t"+b.getPearl() + "\t");
           System.out.print("\t"+b.getAddPearl() + "\t");
           System.out.print("\t"+"\t"+b.getSweet() + "\t");
           int total = totalPrice(b);
           System.out.println("\t"+ total+"\t" );
           
        }
		
		return orderList;
	}
	   int totalPrice(BubbleDTO b) {
	         int total = 0;
	         total += b.getPrice();
	         total += opt(b.getSize());
	         total += opt(b.getAddPearl());
	         return total;
	      }
	   
	      int opt(String o) {
	         int sum = 0;
	        
	         switch(o.toUpperCase()) {
	         case "S" : sum = -500;break;
	         case "M" : sum = 0; break;
	         case "L" : sum = 500; break;
	         case "Y" : sum = 500; break;
	         case "N" : sum = 0;break;
	         }
	         return sum;
	      }
  
	private ArrayList<BubbleDTO> getList1() {
		ArrayList<BubbleDTO> list1 = dao.getList1();
		dao.getList1();
		return list1;
	}

	private ArrayList<BubbleDTO> getList2() {
		ArrayList<BubbleDTO> list2 = dao.getList2();
		dao.getList2();
		return list2;
	}

	private ArrayList<BubbleDTO> getList3() {
		ArrayList<BubbleDTO> list3 = dao.getList3();
		dao.getList3();
		return list3;
	}
}
