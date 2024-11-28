public class Dealer extends Seller{
    private final int sellerID;
    private String name;
    private String dateJoined;
    private String email;
    private String password;
    private String address;
    @Override
    public int getSellerID() {
        return this.sellerID;
    }
    Dealer(String name,String dateJoined,String email,String password,String address)
    {
        this.sellerID=currentID;
        currentID++;
        this.name=name;
        this.dateJoined=dateJoined;
        this.email=email;
        this.password=password;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
