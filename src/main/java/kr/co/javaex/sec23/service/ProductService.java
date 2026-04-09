package kr.co.javaex.sec23.service;


import kr.co.javaex.sec23.domain.Category;
import kr.co.javaex.sec23.domain.Products;
import kr.co.javaex.sec23.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;


public class ProductService {
    private ProductRepository repo = new ProductRepository();
    //상품 등록
    public boolean addProduct(String pId, String name, String explain,
                              int price, int stock) {
        List<Products> list = repo.show();
        for (Products p : list) {
            if (p.getpId().equals(pId)) {
                System.out.println("이미 있는 상품입니다.");
                return false;
            }
        }

        Products newP = new Products();
        newP.setpId(pId);
        newP.setpName(name);
        newP.setpExplain(explain);
        newP.setpPrice(price);
        newP.setpStock(stock);
        newP.setpStatus("정상");

        list.add(newP);
        repo.save(list);
        System.out.println("새로운 상품이 등록되었습니다.");
        return true;
    }

    //상품 수정
    public void updateProduct(String newId, String newName,
                              String newExplain, int newPrice, int newStock) {
        List<Products> list = repo.show();
        for (Products p : list) {
            if (p.getpId().equals(newId)) {
                p.setpName(newName);
                p.setpExplain(newExplain);
                p.setpPrice(newPrice);
                p.setpStock(newStock);
                repo.save(list);
                System.out.println("상품이 수정되었습니다.");
                return;
            }
        }
        System.out.println("상품을 찾을 수 없습니다.");
    }

    // 상품 삭제
    public void deleteProduct(String id) {
        List<Products> list = repo.show();
        boolean removed = list.removeIf(p -> p.getpId().equals(id));
        if (removed) {
            repo.save(list);
            System.out.println("상품이 삭제되었습니다.");
        } else {
            System.out.println("상품을 찾을 수 없습니다.");
        }
    }

    // 판매중지 처리
    public void stopSale(String id) {
        List<Products> list = repo.show();
        for (Products p : list) {
            if (p.getpId().equals(id)) {
                p.setpStatus("판매중지");
                repo.save(list);
                System.out.println("판매중지 처리되었습니다.");
                return;
            }
        }
        System.out.println("상품을 찾을 수 없습니다.");
    }

    // 재고 수량 업데이트
    public void updateStock(String id, int newStock) {
        List<Products> list = repo.show();
        for (Products p : list) {
            if (p.getpId().equals(id)) {
                p.setpStock(newStock);
                repo.save(list);
                System.out.println("재고가 업데이트되었습니다.");
                return;
            }
        }
        System.out.println("상품을 찾을 수 없습니다.");
    }

    //품절 처리
    public void soldOut(String id) {
        List<Products> list = repo.show();
        for (Products p : list) {
            if (p.getpId().equals(id)) {
                p.setpStock(0);
                repo.save(list);
                System.out.println("품절 처리되었습니다.");
                return;
            }
        }
        System.out.println("상품을 찾을 수 없습니다.");
    }

    //상품 목록 조회
    //데이터를 가공해서 제공
    public List<Products> productShow(){
        List<Products> result = new ArrayList<>();

        for(Products p : repo.show()){
            if(p.getpStock() != 0 && !"판매정지".equals(p.getpStatus())){
                result.add(p);
            }
            Category c = new Category();
        }
        return result;
    }
    }
