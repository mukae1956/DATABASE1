package kr.co.javaex.sec23.service;

import kr.co.javaex.sec23.domain.Users;
import kr.co.javaex.sec23.repository.UsersRepository;
import java.util.List;

public class UserService {

    private UsersRepository repo = new UsersRepository();


    // 회원가입
    public boolean register(String userId, String name, String password,
                            String phone, String email, int role) {
        List<Users> list = repo.show();
        // 이메일 중복 체크
        for (Users u : list) {
            if (u.getemail().equals(email)) {
                System.out.println("이미 사용 중인 이메일입니다.");
                return false;
            }
        }
        // 회원ID 중복 체크
        for (Users u : list) {
            if (u.getuId().equals(userId)) {
                System.out.println("이미 사용 중인 아이디입니다.");
                return false;
            }
        }

        Users newUser = new Users();
        newUser.setuId(userId);
        newUser.setuName(name);
        newUser.setpassword(password);
        newUser.setpNumber(phone);
        newUser.setemail(email);
        newUser.setrole(role); // "일반회원" or "관리자"

        list.add(newUser);
        repo.save(list);
        System.out.println("회원가입이 완료되었습니다.");
        return true;
    }

    // 로그인
    public Users login(String email, String password) {
        List<Users> list = repo.show();
        for (Users u : list) {
            if (u.getemail().equals(email) && u.getpassword().equals(password)) {
                u.uStatus = true;
                System.out.println(u.getuName() + "님 로그인 되셨습니다!");
                return u;
            }
        }
        System.out.println("이메일 또는 비밀번호가 틀렸습니다.");
        return null;
    }

    // 회원명 변경
    public void updateName(String userId, String newName) {
        List<Users> list = repo.show();
        for (Users u : list) {
            if (u.getuId().equals(userId)) {
                u.setuName(newName);
                repo.save(list);
                System.out.println("회원명이 변경되었습니다.");
                return;
            }
        }
    }

    // 휴대전화 변경
    public void updatePhone(String userId, String newPhone) {
        List<Users> list = repo.show();
        for (Users u : list) {
            if (u.getuId().equals(userId)) {
                u.setpNumber(newPhone);
                repo.save(list);
                System.out.println("휴대전화가 변경되었습니다.");
                return;
            }
        }
    }

    // 이메일 변경
    public void updateEmail(String userId, String newEmail) {
        List<Users> list = repo.show();
        // 이메일 중복 체크
        for (Users u : list) {
            if (u.getemail().equals(newEmail)) {
                System.out.println("이미 사용 중인 이메일입니다.");
                return;
            }
        }
        for (Users u : list) {
            if (u.getuId().equals(userId)) {
                u.setemail(newEmail);
                repo.save(list);
                System.out.println("이메일이 변경되었습니다.");
                return;
            }
        }
    }

    // 비밀번호 변경
    public void updatePassword(String userId, String oldPw, String newPw) {
        List<Users> list = repo.show();
        for (Users u : list) {
            if (u.getuId().equals(userId)) {
                if (!u.getpassword().equals(oldPw)) {
                    System.out.println("기존 비밀번호가 틀렸습니다.");
                    return;
                }
                u.setpassword(newPw);
                repo.save(list);
                System.out.println("비밀번호가 변경되었습니다.");
                return;
            }
        }
    }
}
