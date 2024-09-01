package vinh.plk.vidu.data;

import android.util.Log;

import java.util.ArrayList;

import vinh.plk.vidu.R;
import vinh.plk.vidu.recycleview.DataShop;

public class ListProductDataShop {
    ArrayList<DataShop> dataShops;
    ArrayList<DataShop> dataBestSeller;
    ArrayList<DataShop> dataShopingCart;
    ArrayList<DataShop> dataPopular;
    private static ListProductDataShop INSTANCE = null;

    // other instance variables can be here

    // other instance methods can follow
    String name;
    public  void cleardataCart(){
        dataShopingCart = new ArrayList<>();

    }

    public void delete (int i){
        dataShopingCart.remove(i);
//        dataShopingCart.
        Log.d("delete ", dataShopingCart.size()+"");
    }

    public static synchronized ListProductDataShop getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ListProductDataShop();
        }
        return (INSTANCE);
    }

    public ListProductDataShop() {
        if (dataShops == null) {
            dataShops = new ArrayList<>();
        }
        if (dataShopingCart == null) {
            dataShopingCart = new ArrayList<>();
        }
        if (dataBestSeller == null) {
            dataBestSeller = new ArrayList<>();
        }
        if (dataPopular == null) {
            dataPopular = new ArrayList<>();
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<DataShop> getDataShop() {
        return dataShops;
    }

    public ArrayList<DataShop> getDataPopularShop() {
        return dataPopular;
    }
    public ArrayList<DataShop> getDataBestSeller() {
        return dataBestSeller;
    }


    public void setDataShop(DataShop item) {
        this.dataShops.add(item);
    }

    public ArrayList<DataShop> getDataShopingCart() {
        return this.dataShopingCart;
    }

    public void setDataShopingCart(DataShop item) {
        this.dataShopingCart.add(item);
    }



    public ArrayList<DataShop> setDataBestSellerShop() {
        this.dataBestSeller.add(new DataShop(R.drawable.ggrapes, "Green Grapes ", 998,1));
        this.dataBestSeller.add(new DataShop(R.drawable.grapes, "Grapes", 998,1));
        this.dataBestSeller.add(new DataShop(R.drawable.melon, "Melon", 998,1));
        this.dataBestSeller.add(new DataShop(R.drawable.mango, "Mango", 998,1));
        return null;
    }

    public void  setDataPopularShop() {
        this.dataPopular.add(new DataShop(R.drawable.pineapple, "Pineapple", 955,1));
        this.dataPopular.add(new DataShop(R.drawable.banana, "Bannana", 955,1 ));
        this.dataPopular.add(new DataShop(R.drawable.banana, "Bannana", 955,1 ));
        this.dataPopular.add(new DataShop(R.drawable.banana, "Bannana", 955,1));
        this.dataPopular.add(new DataShop(R.drawable.banana, "Bannana", 955,1));
    }
}
