package Users;

public class Guest {
    private String ip;
    Guest(String ip)
    {
        this.ip=ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
