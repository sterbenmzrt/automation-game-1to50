package tests.game;

import automation.pages.game.GamePage;
import base.BaseWebDriver;
import org.testng.annotations.Test;

public class GameTest extends BaseWebDriver {

    public GamePage gamePage;

    public void initInstance() {
        gamePage = GamePage.newInstance(webDriver, webDriverWait);
    }

    @Test(priority = 1)
    public void solveTheGame() {
        gamePage.getTextButton();
    }
}
