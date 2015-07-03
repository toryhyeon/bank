package ams;

import java.util.Scanner;

// ��Ŭ���� �ڵ� �ڵ����� ����Ű : CTRL + SHIFT + F

public class BankMain {
	public static void main(String[] args) {
		Bank bank = new Bank(100);
		Scanner scanner = new Scanner(System.in);
		int accontNo = (int) ((Math.random() * 999999) + 111110);
		// 6�ڸ� ������ ���� ���� �߻�

		// valueOf() �� �ڹ�API �� �ִ� java.lang.String Ŭ������
		// �޼ҵ�� �������� ���ڿ��� �ٲ��ִ� ������ �Ѵ�.
		String strAccountNo = String.valueOf(accontNo);
		System.out.println("������ �̸� : ");
		String name = scanner.nextLine();
		System.out.println("��й�ȣ : ");
		String pass = scanner.nextLine();
		System.out.println("���ݾ� : ");
		int inputMoney = scanner.nextInt();

		bank.openAccount(strAccountNo, name, pass, inputMoney);
		bank.openAccount("123-963", "���̾��", "123", 5500);
		bank.openAccount("456-963", "��ũ", "123", 3300);
		bank.openAccount("999-963", "�����̴�", "123", 77);
		bank.openAccount("333-963", "��", "123", 210);
		
	//	searchByName(bank, scanner);
		
	//	searchByNumber(bank, scanner);
		
		System.out.println("=== ���� ���� ===");
		System.out.println("�����Ϸ��� ���¹�ȣ �Է� :");
		String deleteAccount = scanner.next();
		Account account = bank.searchAccountByAccountNo(deleteAccount);
		if (account != null) {
			boolean isClose = bank.closeAccount(deleteAccount);
			if (isClose) {
				System.out.println("�����Ϸ� !!");
			} else {
				System.out.println("������ �Ұ����մϴ�. �������� ���ǹٶ��ϴ�.");
			}
		} else {
			System.out.println("�����Ϸ��� ��ȸ�� ���°� �������� �ʽ��ϴ�.");
		}
		
		searchList(bank);
		 
	}

	private static void searchList(Bank bank) {
		System.out.println("=== ���¹�ȣ ��ü ��� ��� ===");
		BankBook[] list = bank.getBankBookList();
		if (list != null) {
			for (int i = 0; i < bank.getCount(); i++) {
				System.out.println(list[i].toString());
			}
		} else {
			System.out.println("���°� �ϳ��� �����ϴ�.");
		}
	}
	
	private static void searchByNumber(Bank bank, Scanner scanner) {
		System.out.println("=== ���¹�ȣ ��ȸ(��ȣ �Է�) ===");
		System.out.println("���¹�ȣ �Է� : ");
		String searchAccountNo = scanner.next();
		Account account = bank.searchAccountByAccountNo(searchAccountNo);
		if (account != null) {
			System.out.println(account.toString());
		} else {
			System.out.println("��ȸ����� �����ϴ�.");
		}
	}
	/*
	 * �޼ҵ� �����丵 ���
	 *  : ������ ���İ�Ƽ �ҽ��� ������ �ְ� �и���Ű��
	 *  �޼ҵ带 ������ �� �ֵ��� ���ȭ ��Ű�� �۾�
	 *  ����Ű : ALT + SHIFT + M
	 */
	private static void searchByName(Bank bank, Scanner scanner) {
		System.out.println("=== ���¹�ȣ ��ȸ(�̸� �Է�) ===");
		System.out.println("��ȸ�Ϸ��� �̸��� �Է� : ");
		String inputName = scanner.next();
		BankBook[] bankBooks = (BankBook[]) bank
				.searchAccountsByName(inputName); // �޼ҵ� �������� ã�ư��� ��� CTRL ����ä�� �޼ҵ� Ŭ��

		// ���ŷ : ������ ���� �� ������ ���� ����غ��鼭 ���׸� ��ư��� ��
		
		if (bankBooks != null) {
			for (int i = 0; i < bankBooks.length; i++) {
				System.out.println(bankBooks[i].toString());
			}
		} else {
			System.out.println("��ȸ�̸� ����");
		}
	}
}
