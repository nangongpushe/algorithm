package cn.itcast07;

public class Code_02_MorrisTraversal {
    public static class Node{
        public int value;
        Node left;
        Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static void morrisIn(Node head){
        if (head == null){
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;
            if (cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if (cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else {
                    cur2.right = null;
                }
            }
            System.out.println(cur1.value + " ");
            cur1 = cur1.right;
        }
        System.out.println();
    }

    public static void morrisPre(Node head){
        if (head == null){
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;
            if (cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if (cur2.right == null){
                    cur2.right = cur1;
                    System.out.println(cur1.value + " ");
                    cur1 = cur1.left;
                    continue;
                }else {
                    cur2.right = null;
                }
            }else {
                System.out.println(cur1.value + " ");
            }
            cur1 = cur1.right;
        }
        System.out.println();
    }
}
