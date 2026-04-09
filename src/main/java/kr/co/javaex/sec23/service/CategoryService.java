package kr.co.javaex.sec23.service;

import kr.co.javaex.sec23.domain.Category;
import kr.co.javaex.sec23.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    private CategoryRepository repo = new CategoryRepository();

    // 1) 카테고리 추가
    public boolean addCategory(int newId, String name, Integer parentId, int sort) {
        List<Category> list = repo.show();
        for (Category c : list) {
            if (c.getcId() == newId) {
                System.out.println("이미 존재하는 카테고리ID입니다!");
                return false;
            }
        }
        Category newCategory = new Category();
        newCategory.setcId(newId);
        newCategory.setparentId(parentId);
        newCategory.setName(name);
        newCategory.setsortNumber(sort);

        list.add(newCategory);
        repo.save(list);
        System.out.println("카테고리가 등록되었습니다.");
        return true;
    }

    // 2) 카테고리 수정
    public void updateCategory(int id, String newName, int newSortOrder) {
        List<Category> list = repo.show();
        for (Category c : list) {
            if (c.getcId() == id) {
                c.setName(newName);
                c.setsortNumber(newSortOrder);
                repo.save(list);
                System.out.println("카테고리가 수정되었습니다.");
                return;
            }
        }
        System.out.println("카테고리를 찾을 수 없습니다.");
    }

    // 3) 카테고리 삭제
    public void deleteCategory(int id) {
        List<Category> list = repo.show();
        boolean removed = list.removeIf(c -> c.getcId() == id);
        if (removed) {
            repo.save(list);
            System.out.println("카테고리가 삭제되었습니다.");
        } else {
            System.out.println("카테고리를 찾을 수 없습니다.");
        }
    }
}