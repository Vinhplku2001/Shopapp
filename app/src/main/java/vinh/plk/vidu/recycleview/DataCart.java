package vinh.plk.vidu.recycleview;

public class DataCart{
    private int Hinhanh;
    private String soluong;
    private String Gia;


    public DataCart(int image, String amount, String price ) {
        Hinhanh = image;
        soluong = amount;
        Gia = price;

        int count =1;
    }


    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {Gia = gia;}

    public int getHinhanh() {
        return Hinhanh;

    }

    public void setHinhanh(int hinhanh) {
        Hinhanh = hinhanh;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {soluong = soluong;
    }
}

