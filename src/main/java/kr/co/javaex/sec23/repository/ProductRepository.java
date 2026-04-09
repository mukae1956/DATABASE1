package kr.co.javaex.sec23.repository;

import kr.co.javaex.sec23.domain.Products;
import kr.co.javaex.sec23.util.AllUtil;
import java.util.List;

public class ProductRepository {
    public List<Products> show(){
        return AllUtil.readProducts();
    }
    public void save(List<Products> list){
        AllUtil.printProducts(list);
    }
}
