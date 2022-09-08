package chapter5.Menu;

import chapter5.object.ov.Food;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public interface SelectMenu {

    void selectAddShopMenu(BufferedReader br) throws IOException;

    void selectDashboardMenu();

    void selectOrderMenu(BufferedReader br) throws IOException;

    void selectFeedback(BufferedReader br) throws IOException;

    void close();
}
