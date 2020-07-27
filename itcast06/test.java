package cn.itcast06;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            System.out.println(i + ":" + (i & 1));
        }
    }
}
