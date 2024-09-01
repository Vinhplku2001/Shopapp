package vinh.plk.vidu.recycleview;

public class DataShop{
    private int Hinhanh;
    private String Ten;
    private int Gia;
    private int soLuong;


    public DataShop(int image,  String name, int price,int amount ){
        Hinhanh = image;
        Ten = name;
        Gia = price;
        soLuong= amount;


    }


    public int getSoluong(){
        return soLuong;
    }
    public void setSoluong(int soluong){
        soLuong = soluong;
    }


     public int getGia() {
        return Gia;
    }

     public void setGia(int gia) {Gia = gia;}

    public int getHinhanh() {
        return Hinhanh;

    }

    public void setHinhanh(int hinhanh) {
        Hinhanh = hinhanh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }
}

