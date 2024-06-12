package GameStore_Model;

import java.util.ArrayList;

public class Game 
{
    private ArrayList<String[]> gameList; // 게임 정보를 저장하는 리스트

    // 초기 게임 리스트
    public Game() 
    {
        gameList = new ArrayList<>();
        gameList.add(new String[]{"A01", "Call of Duty", "Activision", "FPS", "69900"});
        gameList.add(new String[]{"A02", "Warframe", "Digital Extremes", "MMO", "0"});
        gameList.add(new String[]{"B01", "Overwatch", "Blizzard Entertainment", "FPS", "49900"});
        gameList.add(new String[]{"B02", "Dark Souls", "FromSoftware", "Action RPG", "69900"});
        gameList.add(new String[]{"C01", "Elden Ring", "FromSoftware", "Action RPG", "69900"});
        gameList.add(new String[]{"C02", "BattleField", "Electronic Arts", "FPS", "59900"});
        gameList.add(new String[]{"D01", "Need for Speed", "Electronic Arts", "Racing", "69900"});
    }

    // 게임 리스트 출력 하는 함수
    public void gameList()
    {
        for(String[] game : gameList) 
        {
            System.out.println(game[0] + ". " + game[1] + " - " + game[2] + " (" + game[3] + ") - " + game[4] + "원");// 코드,게임,제작사,가격
        }
        System.out.println();
    }

    // 게임 코드를 사용하여 게임 이름을 가져오는 함수
    public String getGameName(String code)
    {
        for(String[] game : gameList) 
        {
            if(game[0].equals(code)) // 주어진 코드와 같을 때
            {
                return game[1]; // 게임 이름 리턴
            }
        }
        return "알 수 없는 게임 코드"; // 같지 않다면 메세지와 함께 리턴
    }

    // 게임 코드를 사용해서 게임 가격을 가져오는 함수
    public int getGamePrice(String code)
    {
        for(String[] game : gameList) 
        {
            if(game[0].equals(code)) // 주어진 코드와 같을 때
            {
                return Integer.parseInt(game[4]); // 게임 가격 리턴
            }
        }
        return 0; // 같지 않을 때 0 리턴
    }

    public void addGame(String code, String name, String developer, String genre, String price) 
    {
        gameList.add(new String[]{code, name, developer, genre, price});
    }

    public void removeGame(String code) 
    {
        gameList.removeIf(game -> game[0].equals(code));
    }

    public static void main(String[] args)
    {
        Game game = new Game();
        game.gameList();
    }
}
