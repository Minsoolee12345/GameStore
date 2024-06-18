package Gamestore.View;

import java.util.Scanner;

public class AdminView 
{
    public void showAdminMenu() 
    {
        System.out.println("\n관리자 메뉴:");
        System.out.println("1. 게임 추가");
        System.out.println("2. 게임 삭제");
        System.out.println("0. 종료");
        System.out.print("메뉴를 입력하세요: ");
    }

    public void showAddGamePrompt() 
    {
        System.out.println("게임 추가:");
    }

    public void showRemoveGamePrompt() 
    {
        System.out.println("게임 삭제:");
    }

    public String getAdminId(Scanner scanner) 
    {
        System.out.print("관리자 ID: ");
        return scanner.nextLine();
    }

    public String getAdminPassword(Scanner scanner) 
    {
        System.out.print("관리자 비밀번호: ");
        return scanner.nextLine();
    }
}
