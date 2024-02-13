package automation.pages.game;

import automation.base.BaseLocator;
import org.openqa.selenium.By;

public class GameLocator extends BaseLocator {

    public static GameLocator newInstance() {
        return new GameLocator();
    }

    public final By gameButton = getElementByXpath("//*[@class='box']");
    public final By scoreText = getElementByXpath("(//*[@class='resultContent']/p)[2]");

    public final By numberGameButton (String number){
        return getElementByXpath("(//*[.='" + number + "'])[2]");
    }

    public final By numberGameTimer(String number){
        return getElementByXpath("(//*[.='" + number + "'])[1]");
    }
}
