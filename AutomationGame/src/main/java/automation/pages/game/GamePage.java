package automation.pages.game;

import automation.base.BasePage;
import automation.base.EmptyModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GamePage extends BasePage<EmptyModel, GameLocator> {

    public static GamePage newInstance(WebDriver driver, WebDriverWait driverWait) {
        return new GamePage().init(driver, driverWait);
    }

    public GamePage init(WebDriver driver, WebDriverWait driverWait) {
        initInstance(driver, driverWait);
        return this;
    }

    @Override
    public void setupController() {
        mModel = EmptyModel.newInstance();
    }

    @Override
    public void setupPathElement() {
        mLocator = new GameLocator();
    }

    public void getTextButton() {
        int getCountButton = getElement().getSize(mLocator.gameButton);
        System.out.println(getCountButton);
        int numberFinish = 50;
        for (int i = 1; i <= numberFinish; i++) {
            String getTextTimer = getElement().getText(mLocator.numberGameTimer(String.valueOf(i)));
            String getTextButton = getElement().getText(mLocator.numberGameButton(String.valueOf(i)));
            if (getTextTimer.equals(getTextButton)) {
                stepHelper.delay(500);
                getElement().click(mLocator.numberGameButton(String.valueOf(i)));
            }
        }
        stepHelper.delay(3000);
        boolean gameIsOver = getElement().verifyElementPresent(mLocator.scoreText);
        Assert.assertTrue(gameIsOver);
        String getScoreResult = getElement().getText(mLocator.scoreText);
        System.out.println("Score: " + getScoreResult);
    }
}
