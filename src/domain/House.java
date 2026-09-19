package hspedu.HouseRent.src.domain;

public class House {
    private int id;
    private String name;
    private String phoneNum;
    private  String Address;
    private int mMoney;
    private String Status;

    @Override
    public String toString() {
        return   id +
                "\t\t" + name +
                "\t" + phoneNum  +
                "\t\t" + Address +
                "\t" + mMoney +
                "\t" + Status ;
    }

    public House(int id, String name, String phoneNum, String address, int mMoney, String status) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        Address = address;
        this.mMoney = mMoney;
        Status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getmMoney() {
        return mMoney;
    }

    public void setmMoney(int mMoney) {
        this.mMoney = mMoney;
    }
}
