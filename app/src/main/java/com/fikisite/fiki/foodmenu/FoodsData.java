package com.fikisite.fiki.foodmenu;

import java.util.ArrayList;

public class FoodsData {
    public static String[][] data = new String[][]{
                    {"Tacos","70000","https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX3575877.jpg"},
                    {"Pasta","25000","https://www.bonappetour.com/assets/images/asset_pictures/1426577842-1858323.jpeg"},
                    {"Arancini","20000","https://www.bonappetour.com/assets/images/asset_pictures/1426576976-4881966.jpeg"},
                    {"Lasagne","40000","https://www.bonappetour.com/blog/wp-content/uploads/2015/03/8433819403_2de9b11f7a_k-1500x1000.jpg"},
                    {"Ribolita","60000","https://www.bonappetour.com/assets/images/asset_pictures/1426578233-7112060.jpeg"},
                    {"Saltimboca","40000","https://www.bonappetour.com/assets/images/asset_pictures/1426578956-9821121.jpeg"},
                    {"Torron","30000","https://www.bonappetour.com/assets/images/asset_pictures/1426579159-4523608.jpeg"},
                    {"Tiramisu","45000","https://www.bonappetour.com/assets/images/asset_pictures/1426579346-1465627.jpeg"}
            };
    public static ArrayList<Foods> getListData(){
        Foods foods = null;
        ArrayList<Foods> list =    new ArrayList<>();
        for (int i=0; i<data.length; i++){
            foods = new Foods();
            foods.setName(data[i][0]);
            foods.setHarga(data[i][1]);
            foods.setPhoto(data[i][2]);

            list.add(foods);
        }
        return  list;
    }
}
