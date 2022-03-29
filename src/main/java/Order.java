import java.util.List;

public class Order {
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDDate;
    private String comment;
    private Color color;

    public Order(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDDate, String comment, Color color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDDate = deliveryDDate;
        this.comment = comment;
        this.color = color;
    }

    public Order(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDDate, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDDate = deliveryDDate;
        this.comment = comment;
    }

    public Order(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRentTime() {
        return rentTime;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public String getDeliveryDDate() {
        return deliveryDDate;
    }

    public void setDeliveryDDate(String deliveryDDate) {
        this.deliveryDDate = deliveryDDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

//    public List<String> getColor() {
//        return color;
//    }

    public void setColor(Color color) {
        this.color = color;
    }
}
