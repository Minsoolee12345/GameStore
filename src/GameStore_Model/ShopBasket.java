package GameStore_Model;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopBasket 
{
    private ArrayList<String> basket; // 장바구니에 게임 코드를 저장하는 리스트
    private int capacity; // 장바구니에 추가할 수 있는 최대 게임 수
    private Game game; // 게임 세부 정보를 위한 인스턴스

    // 주어진 최대 게임 수와 게임 인스턴스로 장바구니를 초기화하는 생성자
    public ShopBasket(int capacity, Game game) 
    {
        this.capacity = capacity; // 장바구니 용량 설정
        this.basket = new ArrayList<>(capacity); // 주어진 용량으로 장바구니 초기화
        this.game = game; // 인스턴스 초기화
    }

    // 게임 코드를 받아 게임을 추가하는 함수
    public void addToBasket(String code) 
    {
        if(basket.size() < capacity)  // 장바구니가 가득 찼는지 확인
        {
            basket.add(code); // 장바구니에 게임 추가
            System.out.println("게임이 장바구니에 추가되었습니다: " + game.getGameName(code)); // 추가되었다고 메세지 출력
        } 
        else 
        {
            System.out.println("장바구니가 가득 찼습니다."); // 장바구니가 가득 찼다고 메세지 출력
        }
    }
    
    // 장바구니 내용을 표시하는 함수
    public void showBasket() 
    {
        if(basket.isEmpty()) // 장바구니가 비어있는지 확인
        {
            System.out.println("장바구니가 비어 있습니다."); // 비었으면 메세지 출력
        } 
        else 
        {
            System.out.println("장바구니 목록:"); // 장바구니 목록 출력
            for(String code : basket)
            {
                System.out.println("게임 코드: " + code + ", 이름: " + game.getGameName(code)); // 출력 메세지
            }
        }
    }
    
    // 장바구니에서 코드를 이용하여 게임을 제거하는 함수
    public void removeFromBasket(String code)
    {
        if(basket.contains(code)) // 장바구니에 게임 코드가 있는지 확인
        {
            basket.remove(code); // 게임 제거
            System.out.println("게임이 장바구니에서 제거되었습니다: " + game.getGameName(code)); // 게임 이름과 함께 메세지 출력
        } 
        else 
        {
            System.out.println("장바구니에 해당 게임이 없습니다: " + game.getGameName(code)); // 장바구에 해당 게임이 없으면 출력
        }
    }

    
    // 장바구니에 있는 게임을 주문하는 함수
    public void clearBasket() 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("장바구니를 비우려면 'yes' 를 입력하세요: ");
        String input = in.nextLine(); // 사용자에게 입력을 받아서
        
        if("yes".equalsIgnoreCase(input))  // 입력이 'yes' 일 시 
        {
            basket.clear(); // 장바구니 clear
            System.out.println("\n장바구니가 비워졌습니다.\n"); // 비운 후 메세지 출력
        } 
        else 
        {
            System.out.println("장바구니 비우기가 취소되었습니다."); // 아니면 비우기 취소되었다고 메세지 출력
        }
    }

    // 장바구니에 있는 게임을 주문하는 함수
    public void placeOrder(Scanner in)
    {
        if(basket.isEmpty()) // 장바구니가 비어 있는지 확인
        {
            System.out.println("장바구니가 비어 있어 주문할 수 없습니다."); // 장바구니가 비어있어서 주문을 못하는 메세지 출력
            return;
        }

        System.out.print("주문 하시겠습니까? (yes/no): "); // 주문 확인 메세지
        String input = in.nextLine(); // 사용자 입력 yes || no

        if("yes".equals(input)) // 입력이 'yes'라면
        {
            int total = 0; // 총 가격
            System.out.println("\n===== 영수증 =====");
            for(String code : basket) 
            {
                String name = game.getGameName(code); // 게임 이름 가져오기
                int price = game.getGamePrice(code); // 게임 가격 가져오기
                total += price; // 총 가격에 게임 가격 누적
                System.out.println("게임: " + name + " - " + price + "원"); // 게임 이름과 가격 출력
            }
            System.out.println("=================");
            System.out.println("총 가격: " + total + "원"); // 총 가격 출력
            System.out.println("=================\n");

            basket.clear();
            System.out.println("주문이 완료되었습니다." +"\n"); // 주문 완료 메세지
        } 
        else // 'yes'가 아니라면
        {   
            System.out.println("주문이 취소되었습니다." + "\n"); // 주문 취소 메세지 출력
        }
    }
}
