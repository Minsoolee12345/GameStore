package GameStore_Controller;

import java.util.Scanner;

import GameStore_Model.Game;
import GameStore_Model.ShopBasket;
import GameStore_View.Show;

public class Main 
{
    public static void main(String arg[]) 
    {
        Scanner in = new Scanner(System.in);

        // Show, Game, ShopBasket 클래스 객체 생성
        Show show = new Show();
        Game game = new Game();
        ShopBasket shop = new ShopBasket(10, game);
        
        // 환영 메세지 출력
        show.welcome();

        // 관리자 모드 선택
        System.out.println("1. 유저 모드");
        System.out.println("2. 관리자 모드");
        System.out.print("모드를 선택하세요: ");
        int mode = in.nextInt();
        System.out.println();
         
        in.nextLine();

        if(mode == 2) 
        {
        	// 관리자 모드 진입
            if(Choose_Mode.adminLogin(in))
            {
                adminMode(in, game); //관리자 메뉴 호출
            }

            else
            {
                System.out.println("잘못된 ID 또는 비밀번호입니다. 프로그램을 종료합니다."); // 잘못된 입력을 받았을때
            }
        }

        else 
        {
        	//유저모드 진입
            userMode(in, show, game, shop);
        }
    }

    private static void adminMode(Scanner in, Game game) 
    {
        int menu;
        do {
            System.out.println("\n관리자 메뉴:");
            System.out.println("1. 게임 추가");
            System.out.println("2. 게임 삭제");
            System.out.println("0. 종료");
            System.out.print("메뉴를 입력하세요: ");
            menu = in.nextInt();
            in.nextLine();

            switch (menu) 
            {
            case 1:
                System.out.print("게임 코드: ");
                String code = in.nextLine();
                System.out.print("게임 이름: ");
                String name = in.nextLine();
                System.out.print("제작사: ");
                String developer = in.nextLine();
                System.out.print("장르: ");
                String genre = in.nextLine();
                System.out.print("가격: ");
                String price = in.nextLine();
                game.addGame(code, name, developer, genre, price);
                System.out.println("게임이 추가되었습니다.");
                break;

            case 2:
                System.out.print("삭제할 게임 코드: ");
                code = in.nextLine();
                game.removeGame(code);
                System.out.println("게임이 삭제되었습니다.");
                break;

            case 0:
                System.out.println("종료합니다.");
                break;

            default:
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                break;
            }
        } while (menu != 0);
    }

    
    public static void userMode(Scanner in, Show show, Game game, ShopBasket shop) 
    {
        int menu;

        do {
            show.MenuList();

            System.out.println();
            System.out.print("메뉴를 입력하세요: ");
            menu = in.nextInt();
            in.nextLine();
            switch (menu)
            {
            case 0:
                System.out.println("\n종료합니다.");
                break;

            case 1:
                System.out.println("\n게임 정보 보기를 선택하셨습니다.\n");
                game.gameList();
                break;

            case 2:
                System.out.println("\n장바구니 보기를 선택하셨습니다.\n");
                shop.showBasket();
                break;

            case 3:
                System.out.print("게임 고유코드를 입력하세요: ");
                String code = in.next();
                System.out.println("\n장바구니에 게임 추가를 선택하셨습니다.\n");
                shop.addToBasket(code);
                break;

            case 4:
                System.out.println("\n장바구니 게임 삭제를 선택하셨습니다.");
                System.out.print("삭제할 게임의 고유코드를 입력하세요: ");
                code = in.next();
                shop.removeFromBasket(code);
                break;

            case 5:
                System.out.println("\n장바구니 비우기를 선택하셨습니다.\n");
                shop.clearBasket();
                break;

            case 6:
                System.out.println("\n주문하기를 선택하셨습니다.");
                shop.placeOrder(in);
                break;

            default:
                System.out.print("\n잘못된 입력입니다. 다시 선택해주세요.");
                break;
            }
        } while (menu != 0);
    }
}
