package GameStore_View;

public class Show 
{
    public static void welcome() 
    {
        String welcome = "*****************************************\n"
                + "*    Welcome to Minsoo Game Store    *\n"
                + "*****************************************";
        System.out.println(welcome);    
    }

    public void MenuList() 
    {
        System.out.println("=========메뉴 리스트=========");
        
        String[] menuList = {
                "0. 종료",
                "1. 게임 정보 보기",
                "2. 장바구니 보기",
                "3. 장바구니에 게임 추가",
                "4. 장바구니 게임 삭제",
                "5. 장바구니 비우기",
                "6. 주문하기"
        };
        
        for(String str : menuList)
        {
            System.out.println(str);
        }
        System.out.println("===========================");
    }
}
