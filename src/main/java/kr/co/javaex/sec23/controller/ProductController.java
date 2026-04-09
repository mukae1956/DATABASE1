package kr.co.javaex.sec23.controller;

import kr.co.javaex.sec23.domain.Products;
import kr.co.javaex.sec23.service.ProductService;
import kr.co.javaex.sec23.service.UserService;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    ProductService ps = new ProductService();
    UserService u = new UserService();
    Scanner s = new Scanner(System.in);

    //상품 추가 controller
    public void addRun() {
       // u.manage();
        try {
            System.out.println("등록할 상품 ID : ");
            String a = s.nextLine();
            System.out.println("등록할 상품 명 : ");
            String b = s.nextLine();
            System.out.println("등록할 상품의 상세 설명 : ");
            String c = s.nextLine();
            System.out.println("등록할 상품의 가격 : ");
            int d = s.nextInt();
            System.out.println("등록할 상품의 재고 : ");
            int e = s.nextInt();
            ps.addProduct(a, b, c, d, e);
        } catch (Exception e) {
            System.out.println("[오류!!]");
        }
    }

    //상품 수정 controller
    public void updateRun() {
        //u.manage();
        try {
            System.out.println("수정할 상품 ID : ");
            String a = s.nextLine();
            System.out.println("수정할 상품 명 : ");
            String b = s.nextLine();
            System.out.println("수정할 상품의 상세 설명 : ");
            String c = s.nextLine();
            System.out.println("수정할 상품의 가격 : ");
            int d = s.nextInt();
            System.out.println("수정할 상품의 재고 : ");
            int e = s.nextInt();
            ps.updateProduct(a, b, c, d, e);
        } catch (Exception e) {
            System.out.println("[오류!!]");
        }
    }

    //상품 삭제 controller
    public void deleteRun(){
       // u.manage();
        try {
            System.out.println("삭제할 상품 ID");
            String a = s.nextLine();
            ps.deleteProduct(a);
        } catch (Exception e) {
            System.out.println("[오류!!]");
        }
    }

    //판매 중지 controller
    public void stopRun(){
        //u.manage();
        try{
            System.out.println("판매 중지할 상품 ID");
            String a = s.nextLine();
            ps.stopSale(a);
        } catch(Exception e) {
            System.out.println("[오류!!]");
        }
    }

    //재고 수량 업데이트
    public void stockUpdateRun(){
        //u.manage();
        try{
            System.out.println("재고 수량 변경할 상품 ID");
            String a = s.nextLine();
            System.out.println("수량 입력 : ");
            int b = s.nextInt();
            ps.updateStock(a,b);
        } catch(Exception e) {
            System.out.println("[오류!!]");
        }
    }

    //품절 처리
    public void outRun(){
        //u.manage();
        try{
            System.out.println("품절 처리할 상품 ID");
            String a = s.nextLine();
            ps.soldOut(a);
        } catch(Exception e) {
            System.out.println("[오류!!]");
        }
    }

    //상품 목록 조회
    public void showRun(){
        try{
            var list = ps.productShow();

            for (var p : list) {
                // 수량이 0이거나 status가 판매정지인 상품 제외
                if (p.getpStock() == 0 || "판매중지".equals(p.getpStatus())) {
                    continue;
                }

                System.out.println(
                        "상품명 : " + p.getpName() + " | 가격 : " +
                                p.getpPrice() + "원 | 남은 수량 : " +
                                p.getpStock() + " | 상세설명 : " +
                                p.getpExplain()
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    }
