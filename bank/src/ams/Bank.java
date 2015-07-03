package ams;

public class Bank implements BankRole{
	
	private BankBook[] bankBookList; // ������ ����Ʈ�� ���� �ϴ� �迭
	private int count; // ���� �������� ����
	
	public Bank(int count) {
		bankBookList = new BankBook[count];
		/*
		 * �迭 ���� ���
		 * �迭�� �޼ҵ�Ʒ� ���������� ����� �����
		 * int[] nums = new int[10];
		 * ������, ���� �� bankBookList �迭�� �ʵ忡
		 * ����� �ν��Ͻ� �����Դϴ�.
		 * �ν��Ͻ� ������ �����ڸ� ���� �ʱ�ȭ �Ϸ��� ���
		 * ���� ���� ó�� �մϴ�.
		 * �׸��� �迭 ������ ���ڸ� ǥ���ϴ� count ��
		 * �ݵ�� �ʵ忡 ������ �־�� �մϴ�.
		 */
	}
	// �ʵ忡 ����� �ν��Ͻ� ������ getter setter ����

	public BankBook[] getBankBookList() {
		return bankBookList;
	}

	public int getCount() {
		return count;
	}
	
	
	@Override
	public void openAccount(String accountNo, String ownerName,
			String password, int restMoney) {
		
		// ��������� Account Ŭ������ ��ü�� ���� �����ϰ� �ذ�
		Account bankBook = new BankBook(accountNo, ownerName, password, restMoney);
		
		// ĳ���� : ����(ū) ������ ��ü�� ���� ������ �������� �� ��
		// �ʿ��� ����̰� �̰��� ������� ������ ��Ŭ������ ��θ� ������.
		// �̶��� ��Ŭ���� Ŀ���� �뼭 �ڵ� �ذ��Ѵ�.
		bankBookList[count] = (BankBook) bankBook;
		count++; // ���尹���� ������Ų��.
		System.out.println(bankBook.toString() + "���� ���� ����");
		
	}

	@Override
	public Account searchAccountByAccountNo(String accountNo) {
		Account searchAccount = null;
		/*
		 * �������� ����(������)�� ���� 3������ �ֽ��ϴ�.
		 * 1. ������Ʈ ��ü�� ����Ǵ� ���� : Ŭ�������� ��) static �̶� Ű����� ����� Pay.TAX
		 * 2. Ŭ���� ���ο� ����Ǵ� ���� : �ν��Ͻ����� ��) �ʵ忡 ����� static �� ���� ����
		 * 3. �޼ҵ� ���ο� ����Ǵ� ���� : ����(����)���� ��) searchAccount
		 */
		for (int i = 0; i < getCount(); i++) {
			/*
			 * bankBookList[i] �� bankBookList �� ����ִ�
			 * ���尴ü �ϳ��� ����ŵ�ϴ�.
			 * equals() �� �ڹ�API �� �ִ� java.lang.String Ŭ������
			 * �޼ҵ�� ��Ʈ�� ���� �񱳸� �Ѵ�. ������ true �� �����Ѵ�.
			 */
			if (bankBookList[i].getAccountNo().equals(accountNo)) {
				searchAccount = bankBookList[i]; 
				/*
				 * ���� if ���� true ����� ���¹�ȣ�� �Ѿ�Դٸ�
				 * ���¹�ȣ�� �� �ϳ� ���̹Ƿ� getCount() ���ڸ��� �� ���� ����
				 * ���� �� ���׿��� ȸ���� ���߰� ���� ��ȯ�ض�.
				 */
				return searchAccount;
			}
		}
		return searchAccount;
	}

	@Override
	public Account[] searchAccountsByName(String ownerName) {
		int tempcount = searchCountByName(ownerName);
		if(tempcount == 0){ // �˻��Ϸ��� �̸����� �� ������ �ϳ��� ���� ���
			return null;
		}
		BankBook[] tempList = new BankBook[tempcount];
		tempcount = 0; // ���������� �ʱ�ȭ
		for (int i = 0; i < getCount(); i++) {
			if(bankBookList[i].getOwnerName().equals(ownerName)){
				tempList[tempcount] = bankBookList[i];
				tempcount++;
			}
		}
		return tempList;
	}
	
	private int searchCountByName(String ownerName) {
		int searchCount = 0; // ���������� ������ �ʱ�ȭ ==> �ڹٹ���
		for (int i = 0; i < getCount(); i++) {
			if(bankBookList[i].getOwnerName().equals(ownerName)){
				searchCount++;
			}
		}
		return searchCount;
	}
	
	@Override
	public boolean closeAccount(String accountNo) {
		boolean isClose = false; // boolean Ÿ���� ������ ���� false �̴�.
		// ���� boolean �� �������� �ʱ�ȭ�� false �� �Ѵ�.
		for (int i = 0; i < getCount(); i++) {
			if (bankBookList[i].getAccountNo().equals(accountNo)) {
				isClose = true;
				// �迭���� ��Ҹ� �����ϴ� for�� �����Դϴ�. �ܿ�ʽÿ�.
				for (int j = i; j < getCount()-1; j++) { // ȸ�� ī��� ���ڸ� �ϳ� ���̼���.
					/*
					 * �迭�� �ε����� �������� ������� ������ �����Դϴ�.
					 * ���� j��° ��Ҹ� j+1 ��° ��ҷ� ������ �����
					 * {1,2,3,4,5} �̷� �迭�� �ִٰ� �ϸ�
					 * [1,2,4,5] �� ����� �̰��� �ε������� 2�� 3 ��° ����� 3����
					 * ���� ���� �˴ϴ�.
					 */
					bankBookList[j] = bankBookList[j+1];
				}
				count--; // �� ������ �� ���� ������� ������ ��� ������ �پ��
			}
		}
		return isClose;
	}
	
}
