import java.net.MalformedURLException;

public class main {
    public static void main(String[] args) {
        SeleniumTest myTest = new SeleniumTest();
        try {
            myTest.setUp();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        myTest.blazedemo1();

        myTest.tearDown();

    }
}
