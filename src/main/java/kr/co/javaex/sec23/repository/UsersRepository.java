package kr.co.javaex.sec23.repository;

import kr.co.javaex.sec23.domain.Users;
import kr.co.javaex.sec23.util.AllUtil;
import java.util.List;

public class UsersRepository {
    public List<Users> show(){
        return AllUtil.readUser();
    }
    public void save(List<Users> list){
        AllUtil.printUser(list);
    }
}
