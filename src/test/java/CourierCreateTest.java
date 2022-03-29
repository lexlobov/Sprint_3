import org.junit.Test;

public class CourierCreateTest {

    public String login = "LAOXi";
    public String password = "kfgkfgdgfgkdg";
    public String firstName = "Alex";

    @Test
    public void createCourierPositiveTest(){
        Courier courier = new Courier(login, password, firstName);

    }
}
