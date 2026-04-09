package kr.co.javaex.sec23.repository;

import kr.co.javaex.sec23.domain.Order;
import kr.co.javaex.sec23.util.AllUtil;
import java.util.List;

public class OrderRepository {
    public List<Order> show(){
        return AllUtil.readOrder();
    }
    public void save(List<Order> list){
        AllUtil.printOrder(list);
    }
}
