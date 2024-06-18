package Gamestore.Controller;

import java.util.Scanner;

import Gamestore.Modal.Game;
import Gamestore.Modal.ShopBasket;
import Gamestore.View.AdminView;
import Gamestore.View.Show;

public class Controller
{
    private static final String ADMIN_ID = "minsoolee";
    private static final String ADMIN_PASSWORD = "12345";
    
    private Game game;
    private ShopBasket shop;
    private Show show;
    private AdminView adminView;
    private Scanner scanner;

    public Controller(Game game, ShopBasket shop, Show show, AdminView adminView)
    {
        this.game = game;
        this.shop = shop;
        this.show = show;
        this.adminView = adminView;
        this.scanner = new Scanner(System.in); // Scanner 객체를 여기서 생성
    }

    public void start() 
    {
        Show.welcome();

        System.out.println("1. 유저 모드");
        System.out.println("2. 관리자 모드");
        System.out.print("모드를 선택하세요: ");

        while (!scanner.hasNextInt()) 
        {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
            scanner.next();
        }
        int mode = scanner.nextInt();
        scanner.nextLine();

        if (mode == 2) 
        {
            if (adminLogin())
            {
                adminMode();
            } 
            else 
            {
                System.out.println("잘못된 ID 또는 비밀번호입니다. 프로그램을 종료합니다.");
            }
        } 
        else 
        {
            userMode();
        }
    }

    private boolean adminLogin() 
    {
        String id = adminView.getAdminId(scanner);
        String password = adminView.getAdminPassword(scanner);

        return ADMIN_ID.equals(id) && ADMIN_PASSWORD.equals(password);
    }

    private void adminMode() 
    {
        int menu;
        do {
            adminView.showAdminMenu();
            while (!scanner.hasNextInt())
            {
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                scanner.next();
            }
            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu)
            {
                case 1:
                    addGame();
                    break;
                case 2:
                    removeGame();
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

    private void addGame()
    {
        adminView.showAddGamePrompt();
        System.out.print("게임 코드: ");
        String code = scanner.nextLine();
        System.out.print("게임 이름: ");
        String name = scanner.nextLine();
        System.out.print("제작사: ");
        String developer = scanner.nextLine();
        System.out.print("장르: ");
        String genre = scanner.nextLine();
        System.out.print("가격: ");
        int price = scanner.nextInt();
        scanner.nextLine();

        game.addGame(code, name, developer, genre, price);
        System.out.println("게임이 추가되었습니다.");
    }

    private void removeGame() 
    {
        adminView.showRemoveGamePrompt();
        System.out.print("삭제할 게임 코드: ");
        String code = scanner.nextLine();
        game.removeGame(code);
        System.out.println("게임이 삭제되었습니다.");
    }

    private void userMode() 
    {
        int menu;
        do {
            show.menuList();
            System.out.print("메뉴를 입력하세요: ");
            while (!scanner.hasNextInt()) 
            {
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                scanner.next();
            }
            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) 
            {
                case 0:
                    System.out.println("\n종료합니다.");
                    break;
                case 1:
                    showGameInfo();
                    break;
                case 2:
                    showBasketInfo();
                    break;
                case 3:
                    showGameInfo();
                    addGameToBasket();
                    break;
                case 4:
                    removeGameFromBasket();
                    break;
                case 5:
                    clearBasket();
                    break;
                case 6:
                    placeOrder();
                    break;
                default:
                    System.out.println("\n잘못된 입력입니다. 다시 선택해주세요.");
                    break;
            }
        } while (menu != 0);
    }

    private void showGameInfo() {
        System.out.println("\n게임 정보 보기를 선택하셨습니다.\n");
        game.gameList();
    }

    private void showBasketInfo() {
        System.out.println("\n장바구니 보기를 선택하셨습니다.\n");
        shop.showBasket();
    }

    private void addGameToBasket() 
    {
        System.out.println("\n장바구니에 게임 추가를 선택하셨습니다.\n");
        System.out.print("게임 고유코드를 입력하세요: ");
        String code = scanner.next();
        scanner.nextLine();

        String gameName = game.getGameName(code);
        int gamePrice = game.getGamePrice(code);
        System.out.println("\n게임 정보:");
        System.out.println("이름: " + gameName);
        System.out.println("가격: " + gamePrice + "원");

        shop.addToBasket(code);
        System.out.println("\n현재 장바구니 내용:");
        shop.showBasket();
    }

    private void removeGameFromBasket() 
    {
        System.out.println("\n장바구니 게임 삭제를 선택하셨습니다.");
        System.out.print("삭제할 게임의 고유코드를 입력하세요: ");
        String code = scanner.next();
        shop.removeFromBasket(code);
        System.out.println("\n현재 장바구니 내용:");
        shop.showBasket();
    }

    private void clearBasket() {
        System.out.println("\n장바구니 비우기를 선택하셨습니다.\n");
        shop.clearBasket();
    }

    private void placeOrder() {
        System.out.println("\n주문하기를 선택하셨습니다.");
        shop.placeOrder();
    }
}
