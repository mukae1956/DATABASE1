package kr.co.javaex.sec23.domain;

public class Products {
    public String pId; //상품ID
    public String pName; //상품명
    public String pExplain; //상세 설명
    public int pPrice; //가격
    public int pStock; //재고수량
    public String pStatus; //정상,판매중지

    public Products() {}

    public String getpId() { return pId; }
    public void setpId(String pId) { this.pId = pId; }

    public String getpName() { return pName; }
    public void setpName(String pName) { this.pName = pName; }

    public String getpExplain() { return pExplain; }
    public void setpExplain(String pExplain) { this.pExplain = pExplain; }

    public int getpPrice() { return pPrice; }
    public void setpPrice(int pPrice) { this.pPrice= pPrice; }

    public int getpStock() { return pStock; }
    public void setpStock(int pStock) { this.pStock = pStock; }

    public String getpStatus() { return pStatus;}
    public void setpStatus(String pStatus) {this.pStatus = pStatus;}

    @Override
    public String toString() {
        return "Products{" +
                "id='" + pId + '\'' +
                ", name='" + pName + '\'' +
                ", price=" + pPrice +
                ", stock=" + pStock +
                ", status='" + pStatus + '\'' +
                '}';
    }
}
