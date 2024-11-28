public abstract class Product {
    protected String name;
    protected int id;
    protected String info;
    Product(String name,int id,String info)
    {
        this.name=name;
        this.id=id;
        this.info=info;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
