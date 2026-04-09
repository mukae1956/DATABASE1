package kr.co.javaex.sec23.controller;

import kr.co.javaex.sec23.service.CategoryService;
import kr.co.javaex.sec23.service.UserService;

import java.util.Scanner;

public class CategoryController {
    CategoryService cs = new CategoryService();
    UserService u = new UserService();
    Scanner s = new Scanner(System.in);
    //카테고리 추가 controller
        public void addRun () {
            try {
            System.out.println("추가될 카테고리ID 작성 : ");
            int a = s.nextInt();
            s.nextLine();
            System.out.println("추가할 카테고리명 작성 : ");
            String b = s.nextLine(); //추가할 카테고리명
            System.out.println("100 : 커피 | 200 : 논커피");
            System.out.println("상위 카테고리 ID 입력 (없으면 엔터): ");
            String input = s.nextLine();

            Integer c;
            if (input.isEmpty()) {
                c = null;
            } else {
                c = Integer.parseInt(input);
            }
            System.out.println("1 : 커피 | 2 : 논커피");
            System.out.println("대분류 그룹화 번호 : ");
            int d = s.nextInt();
            cs.addCategory(a, b, c, d);
            } catch (Exception e) {
            e.printStackTrace();
            }
    }
    //카테고리 수정 controller
        public void updateRun () {
            try {
                System.out.println("변경할 카테고리ID 작성 : ");
                int a = s.nextInt();
                s.nextLine();
                System.out.println("변경할 카테고리명 작성 : ");
                String b = s.nextLine(); //변경할 카테고리명
                System.out.println("1 : 커피 | 2 : 논커피");
                System.out.println("대분류 위치 : ");
                int c = s.nextInt(); //추가할 카테고리 위치
                cs.updateCategory(a, b, c);
                } catch (Exception e) {
                e.printStackTrace();
                }
    }
    //카테고리 삭제 controller
    public void deleteRun () {
        try {
            System.out.println("삭제할 카테고리ID 작성 : ");
            int a = s.nextInt();
            cs.deleteCategory(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
