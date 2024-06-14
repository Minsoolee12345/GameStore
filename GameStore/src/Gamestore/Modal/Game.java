package Gamestore.Modal;

import java.util.ArrayList;

public class Game 
{
    private ArrayList<GameInfo> gameList;

    public Game() 
    {
        gameList = new ArrayList<>();
        gameList.add(new GameInfo("A01", "Call of Duty", "Activision", "FPS", 69900));
        gameList.add(new GameInfo("A02", "Warframe", "Digital Extremes", "MMO", 0));
        gameList.add(new GameInfo("B01", "Overwatch", "Blizzard Entertainment", "FPS", 49900));
        gameList.add(new GameInfo("B02", "Dark Souls", "FromSoftware", "Action RPG", 69900));
        gameList.add(new GameInfo("C01", "Elden Ring", "FromSoftware", "Action RPG", 69900));
        gameList.add(new GameInfo("C02", "BattleField", "Electronic Arts", "FPS", 59900));
        gameList.add(new GameInfo("D01", "Need for Speed", "Electronic Arts", "Racing", 69900));
    }

    public void gameList() 
    {
        for(GameInfo game : gameList) 
        {
            System.out.println(game.getCode() + ". " + game.getName() + " - " + game.getDeveloper() +
                               " (" + game.getGenre() + ") - " + game.getPrice() + "원");
        }
        System.out.println();
    }

    public String getGameName(String code) 
    {
        for(GameInfo game : gameList) {
            if(game.getCode().equals(code)) 
            {
                return game.getName();
            }
        }
        return "알 수 없는 게임 코드";
    }

    public int getGamePrice(String code) 
    {
        for(GameInfo game : gameList) {
            if(game.getCode().equals(code))
            {
                return game.getPrice();
            }
        }
        return 0;
    }

    public void addGame(String code, String name, String developer, String genre, int price)
    {
        gameList.add(new GameInfo(code, name, developer, genre, price));
    }

    public void removeGame(String code)
    {
        gameList.removeIf(game -> game.getCode().equals(code));
    }

    private class GameInfo 
    {
        private String code;
        private String name;
        private String developer;
        private String genre;
        private int price;

        public GameInfo(String code, String name, String developer, String genre, int price)
        {
            this.code = code;
            this.name = name;
            this.developer = developer;
            this.genre = genre;
            this.price = price;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public String getDeveloper() {
            return developer;
        }

        public String getGenre() {
            return genre;
        }

        public int getPrice() {
            return price;
        }
    }
}