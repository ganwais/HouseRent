package hspedu.HouseRent.src.view;

import hspedu.HouseRent.src.service.HouseService;
import hspedu.HouseRent.src.domain.House;
import hspedu.HouseRent.src.utils.Utility;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(2);

    public  void listHouses(){
        System.out.println("----------------房屋列表---------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(已出租/未出租)");
        House[] houses =houseService.list();
        for(int i = 0 ; i < houses.length ; i++){
            if(houses[i] == null){
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("--------------房屋列表显示完毕-------------");
    }
    public  void addHouse(){
        System.out.println("----------------添加房屋---------------");
        System.out.println("姓名:");
        String name = Utility.readString(8);
        System.out.println("电话");
        String phoneNum = Utility.readString(12);
        System.out.println("地址");
        String Address = Utility.readString(16);
        System.out.println("月租");
        int mMoney = Utility.readInt();
        System.out.println("状态(未出租/已出租)");
        String state = Utility.readString(3);
        House newhouse = new House(0,name,phoneNum,Address,mMoney,state);
        if(houseService.add(newhouse)){
            System.out.println("---------------添加房屋成功--------------");
        }else{
            System.out.println("---------------添加房屋失败--------------");
        }
    }
    public  void delHouse(){
        System.out.println("----------------删除房屋---------------");
        System.out.println("请选择待删除房屋编号(-1退出):");
        int a = Utility.readInt();
        if (a == -1) {
            return;
        }
        if (a < 1 || a > houseService.getIdCounter()){
            System.out.println("输入的编号超出范围");
            return;
        }
        char s = Utility.readConfirmSelection();
        if(s == 'N'){
            return;
        }
        if(houseService.del(a)){
            System.out.println("---------------删除房屋成功--------------");
        }else {
            System.out.println("---------------删除房屋失败--------------");
        }
    }
    public void exitHouse(){
        char s = Utility.readConfirmSelection();
        if (s == 'Y') {
            loop = false;
        }
    }
    public void findHouse(){
        System.out.println("----------------查找房屋---------------");
        System.out.println("请输入你要查找的id");
        int a = Utility.readInt();
        if( !(houseService.find(a)) ){
            System.out.println("没有找到该房屋");
        }
    }
    public void updateHouse(){
        System.out.println("----------------修改房屋---------------");
        System.out.println("请选择待修改房屋编号(-1退出):");
        int a = Utility.readInt();
        if (a == -1) {
            return;
        }
        if (a < 1 || a > houseService.getIdCounter()){
            System.out.println("输入的编号超出范围");
            return;
        }
        int b = houseService.update(a);
        if(b == -1 ){
            System.out.println("没有找到该房屋");
            return;
        }
        System.out.print("姓名(" + houseService.findHouseById(b).getName() +")");
        houseService.findHouseById(b).setName(Utility.readString(8,houseService.findHouseById(b).getName()));
        System.out.println();
        System.out.print("电话(" + houseService.findHouseById(b).getPhoneNum() + ")");
        houseService.findHouseById(b).setPhoneNum(Utility.readString(12,houseService.findHouseById(b).getPhoneNum()));
        System.out.println();
        System.out.print("地址(" + houseService.findHouseById(b).getAddress() + ")");
        houseService.findHouseById(b).setAddress(Utility.readString(16,houseService.findHouseById(b).getAddress()));
        System.out.println();
        System.out.print("月租(" + houseService.findHouseById(b).getmMoney() + ")");
        houseService.findHouseById(b).setmMoney(Utility.readInt(houseService.findHouseById(b).getmMoney()));
        System.out.println();
        System.out.print("状态(" + houseService.findHouseById(b).getStatus() + ")");
        houseService.findHouseById(b).setStatus(Utility.readString(3,houseService.findHouseById(b).getStatus()));
        System.out.println();
        System.out.println("修改完成");
    }

    public void mainMenus(){
        do{
            System.out.println("---------------房屋出租系统--------------");
            System.out.println("\t\t1 新 增 房 屋");
            System.out.println("\t\t2 查 找 房 屋");
            System.out.println("\t\t3 删 除 房 屋");
            System.out.println("\t\t4 修 改 房 屋 信 息 ");
            System.out.println("\t\t5 房 屋 列 表");
            System.out.println("\t\t6 退       出");
            System.out.println("请输入你的选择(1-6)");
            key = Utility.readChar();
            switch (key) {
                case '1' :
                    addHouse();
                    break;
                case '2' :
                    findHouse();
                    break;
                case '3' :
                    delHouse();
                    break;
                case '4' :
                    updateHouse();
                    break;
                case '5' :
                    listHouses();
                    break;
                case '6' :
                    exitHouse();
                    break;
                default:
                    System.out.println("输入有误(1-6)");
            }
        }while (loop);
    }
}
