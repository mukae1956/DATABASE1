package kr.co.javaex.sec23.repository;

import kr.co.javaex.sec23.domain.Category;
import kr.co.javaex.sec23.util.AllUtil;
import java.util.List;

public class CategoryRepository {
    public List<Category> show(){
        return AllUtil.readCategory();
    }
    public void save(List<Category> list){
        AllUtil.printCategory(list);
    }
}
