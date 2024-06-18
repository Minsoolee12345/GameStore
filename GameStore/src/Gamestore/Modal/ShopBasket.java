package Gamestore.Modal;

import java.util.ArrayList;

public class ShopBasket 
{
    private ArrayList<String> basket;
    private int capacity;
    private Game game;

    public ShopBasket(int capacity, Game game) 
    {
        this.capacity = capacity;
        this.basket = new ArrayList<>(capacity);
        this.game = game;
    }

    public void addToBasket(String code) 
    {
        if (basket.size() < capacity) 
        {
            basket.add(code);
            System.out.println("게임이 장바구니에 추가되었습니다: " + game.getGameName(code));
        } 
        else
        {
            System.out.println("장바구니가 가득 찼습니다.");
        }
    }

    public void showBasket() 
    {
        if (basket.isEmpty()) 
        {
            System.out.println("장바구니가 비어 있습니다.");
        } 
        else 
        {
            System.out.println("장바구니 목록:");
            for (String code : basket) 
            {
                System.out.println("게임 코드: " + code + ", 이름: " + game.getGameName(code));
            }
        }
    }

    public void removeFromBasket(String code) 
    {
        if (basket.contains(code)) 
        {
            basket.remove(code);
            System.out.println("게임이 장바구니에서 제거되었습니다: " + game.getGameName(code));
        } 
        else 
        {
            System.out.println("장바구니에 해당 게임이 없습니다: " + game.getGameName(code));
        }
    }

    public void clearBasket() 
    {
        basket.clear();
        System.out.println("\n장바구니가 비워졌습니다.\n");
    }

    public void placeOrder() 
    {
        if (basket.isEmpty()) 
        {
            System.out.println("장바구니가 비어 있어 주문할 수 없습니다.");
            return;
        }

        int total = 0;
        System.out.println("\n===== 영수증 =====");
        for (String code : basket) {
            String name = game.getGameName(code);
            int price = game.getGamePrice(code);
            total += price;
            System.out.println("게임: " + name + " - " + price + "원");
        }
        System.out.println("=================");
        System.out.println("총 가격: " + total + "원");
        System.out.println("=================\n");

        basket.clear();
        System.out.println("주문이 완료되었습니다." + "\n");
    }

    public Game getGame() 
    {
        return game;
    }
}
