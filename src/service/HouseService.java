package hspedu.HouseRent.src.service;

import hspedu.HouseRent.src.domain.House;

public class HouseService {
    private House[] houses;
    private int houseNum  = 1 ;     //房屋数量
    private int idCounter = 1 ;     //最大房屋编号

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1,"jack","112","海淀区",3000,"未出租");
    }
    public House[] list(){
        return houses;
    }
    public House findHouseById(int a){return houses[a];}
    public boolean add(House newHouse){
        if(houseNum == houses.length){
            House[] arr =new House[houses.length*2];
//            System.out.println("数组已满,不能添加");
//            return false;
            for(int i = 0 ; i < houses.length ; i++){
//                if(houses[i] == null){
//                    break;
//                }
                arr[i] = houses[i];
            }
            houses = arr;
            System.out.println("当前房屋存放空间不足,已自动扩容("+ houses.length + ")");
        }
        houses[houseNum++] = newHouse;
        newHouse.setId(++idCounter);
        return true;
    }
    public boolean del(int t){
        if(houses == null){
            System.out.println("当前没有房屋");
            return false;
        }
        for(int i = 0 ; i < houses.length ; i++){
//            if(houses[i] == null){
//                continue;
//            }
            if(houses[i] != null && houses[i].getId() == t){
                houses[i] = null;
                for(int j = i ; j < houseNum - 1 ; j++){
                    houses[j]=houses[j+1];
                }
                houses[--houseNum] =null;
                return true;
            }
        }
        System.out.println("未找到改房屋");
        return false;
    }
    public boolean find(int a){
        for(int i = 0 ; i < houseNum ; i++){
            if(houses[i] != null && houses[i].getId() == a){
                System.out.println(houses[i]);
                return true;
            }
        }
        return false;
    }

    public int update(int a){
        for(int i = 0 ; i < houseNum ; i++){
            if(houses[i] != null && houses[i].getId() == a){
                return i;
            }
        }
        return  -1;
    }

    public int getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }
}
