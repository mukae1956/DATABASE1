package kr.co.javaex.sec23.repository;

import kr.co.javaex.sec23.domain.Cart;
import kr.co.javaex.sec23.util.AllUtil;
import java.util.List;

public class CartRepository {
    public List<Cart> show(){
        return AllUtil.readCart();
    }
    public void save(List<Cart> list){
        AllUtil.printCart(list);
    }
}
