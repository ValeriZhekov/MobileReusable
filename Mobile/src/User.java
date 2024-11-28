public class User extends Seller{
    private final int sellerID;
    private String userName;
    private String dateJoined;
    private String password;
    private String email;
    private String birthDate;
    public int getSellerID() {
        return this.sellerID;
    }
    public User(String userName,String dateJoined,String password,String email,String birthDate)
    {
        this.sellerID=currentID;
        currentID++;
        this.userName=userName;
        this.dateJoined=dateJoined;
        this.password=password;
        this.email=email;
        this.birthDate=birthDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
