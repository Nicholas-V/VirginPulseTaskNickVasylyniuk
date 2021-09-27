package virgin_pulse.utilities;

import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowserUtils {
    public static void sleep(int second) {

        second*=1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

            System.out.println("something happened in the sleep method");

        }
    }

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemText = new ArrayList<>();
        for (WebElement element : list) {
            elemText.add(element.getText());
        }

        return elemText;
    }



    public static String dateFormat(){
        DateFormat df = new SimpleDateFormat("yy-mm-dd");
        DateFormat df2 = new SimpleDateFormat("dd--mm--yy hh:mm:ss");
        Date date = new Date();
        return df.format(date);
        //return df2.format(date);
    }

}
