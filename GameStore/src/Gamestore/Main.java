package Gamestore;

import Gamestore.Controller.Controller;
import Gamestore.Modal.Game;
import Gamestore.Modal.ShopBasket;
import Gamestore.View.AdminView;
import Gamestore.View.Show;

public class Main 
{
    public static void main(String arg[]) 
    {
        Show show = new Show();
        Game game = new Game();
        ShopBasket shop = new ShopBasket(10, game);
        AdminView adminView = new AdminView();

        Controller controller = new Controller(game, shop, show, adminView);
        controller.start();
    }
}