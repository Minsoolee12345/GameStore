package GameStore_Controller;

import java.util.Scanner;

public class Choose_Mode 
{
	// 상수로 관리자 ID와 비밀번호 설정
    private static final String ADMIN_ID = "minsoolee";
    private static final String ADMIN_PASSWORD = "12345";

    public static boolean adminLogin(Scanner in) 
    {
        System.out.print("관리자 ID: ");
        String id = in.nextLine(); // ID 입력
        System.out.print("관리자 비밀번호: ");
        String password = in.nextLine(); // 비밀번호 입력

        // 입력된 ID와 비밀번호가 일치하는지 확인하고 결과를 반환함
        return ADMIN_ID.equals(id) && ADMIN_PASSWORD.equals(password);
    }
}
