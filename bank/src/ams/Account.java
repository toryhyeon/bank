package ams;
/*
 * @ Date	: 20150625
 * @ Author : 최승현
 * @ Story	: 은행 고객단 기능 정의
 */
public interface Account {
	public static final String BANK_NAME = "아이티뱅크";
	public void deposit(int money); // 예금
	public void withdraw(int money); // 출금
}
