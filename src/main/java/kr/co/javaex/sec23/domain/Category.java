package kr.co.javaex.sec23.domain;

public class Category {
    public int cId; //카테고리 ID
    public Integer parentId; //상위 카테고리, null값도 삽입하기 위해서 Integer
    public String name; //카테고리명
    public int sortNumber; //대분류를 묶기 위한 변수

    public int getcId() { return this.cId; }
    public void setcId(int cId) { this.cId = cId; }

    public Integer getparentId() { return this.parentId; }
    public void setparentId(Integer parentId) { this.parentId = parentId; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public int getsortNumber() { return this.sortNumber; }
    public void setsortNumber(int sortNumber) { this.sortNumber = sortNumber; }
}

