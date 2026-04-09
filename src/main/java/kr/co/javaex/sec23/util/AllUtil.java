package kr.co.javaex.sec23.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.javaex.sec23.domain.Cart;
import kr.co.javaex.sec23.domain.Category;
import kr.co.javaex.sec23.domain.Order;
import kr.co.javaex.sec23.domain.Products;
import kr.co.javaex.sec23.domain.Users;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AllUtil {
    private static final ObjectMapper mapper = new ObjectMapper();
    public static final String dataPath = "data/";

    //장바구니 리스트 생성
    //장바구니로 파일 가져오기
    public static List<Cart> readCart() {
        List<Cart> list = new ArrayList<>();
        try {
            File file = new File(dataPath + "carts.json");
            if (!file.exists()) return list;
            Cart[] arr = mapper.readValue(file, Cart[].class);
            for (Cart c : arr) {
                list.add(c);
            }
        } catch (IOException e) {
            System.out.println("[오류]");
        }
        return list;
    }
    //장바구니에서 파일 내보내기
    public static void printCart(List<Cart> list) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(dataPath + "carts.json"), list);
        } catch (IOException e) {
            System.out.println("[오류]");
        }
    }
    //Category
    public static List<Category> readCategory() {
        List<Category> list = new ArrayList<>();
        try {
            File file = new File(dataPath + "categories.json");
            if (!file.exists()) return list;
            Category[] arr = mapper.readValue(file, Category[].class);
            for (Category c : arr) {
                list.add(c);
            }
        } catch (IOException e) {
            System.out.println("[오류]");
        }
        return list;
    }
    public static void printCategory(List<Category> list) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(dataPath + "categories.json"), list);
        } catch (IOException e) {
            System.out.println("[오류]");
        }
    }

    //Order
    public static List<Order> readOrder() {
        List<Order> list = new ArrayList<>();
        try {
            File file = new File(dataPath + "orders.json");
            if (!file.exists()) return list;
            Order[] arr = mapper.readValue(file, Order[].class);
            for (Order c : arr) {
                list.add(c);
            }
        } catch (IOException e) {
            System.out.println("[오류]");
        }
        return list;
    }

    public static void printOrder(List<Order> list) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(dataPath + "orders.json"), list);
        } catch (IOException e) {
            System.out.println("[오류]");
        }
    }

    //Products
    public static List<Products> readProducts() {
        List<Products> list = new ArrayList<>();
        try {
            File file = new File(dataPath + "products.json");
            if (!file.exists()) return list;
            Products[] arr = mapper.readValue(file, Products[].class);
            for (Products c : arr) {
                list.add(c);
            }
        } catch (IOException e) {
            System.out.println("[오류]");
        }
        return list;
    }

    public static void printProducts(List<Products> list) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(dataPath + "products.json"), list);
        } catch (IOException e) {
            System.out.println("[오류]");
        }
    }
    //Users
    public static List<Users> readUser() {
        List<Users> list = new ArrayList<>();
        try {
            File file = new File(dataPath + "users.json");
            if (!file.exists()) return list;
            Users[] arr = mapper.readValue(file, Users[].class);
            for (Users c : arr) {
                list.add(c);
            }
        } catch (IOException e) {
            System.out.println("[오류]");
        }
        return list;
    }

    public static void printUser(List<Users> list) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(dataPath + "users.json"), list);
        } catch (IOException e) {
            System.out.println("[오류]");
        }
    }
}
