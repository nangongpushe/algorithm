package cn.itcast07;


import java.util.ArrayList;
import java.util.Iterator;

public class Code_03_SkipList {
    public static class SkipListNode{
        public Integer value;
        public ArrayList<SkipListNode> nextNodes;

        public SkipListNode(Integer value){
            this.value = value;
            nextNodes = new ArrayList<>();
        }
    }

    public static class SkipListIterator implements Iterator<Integer>{
        SkipList list;
        SkipListNode current;

        public SkipListIterator(SkipList list){
            this.list = list;
            this.current = list.getHead();
        }

        @Override
        public boolean hasNext() {
            return current.nextNodes.get(0) != null;
        }

        @Override
        public Integer next() {
            current = current.nextNodes.get(0);
            return null;
        }
    }

    public static class SkipList {
        private SkipListNode head;
        private int maxLevel;
        private int size;
        private static final double PROBABILITY = 0.5;

        public SkipList(){
            size = 0;
            maxLevel = 0;
            head = new SkipListNode(null);
            head.nextNodes.add(null);
        }

        public SkipListNode getHead(){
            return head;
        }

        public void add(Integer newValue){
            if (!contains(newValue)){
                size++;
                int level = 0;
                while (Math.random() < PROBABILITY){
                    level++;
                }
                while (level > maxLevel){
                    head.nextNodes.add(null);
                    maxLevel++;
                }
                SkipListNode newNode = new SkipListNode(newValue);
                SkipListNode current = head;
                do{
                    current = findNext(newValue, current, level);
                    newNode.nextNodes.add(0, current.nextNodes.get(level));
                    current.nextNodes.set(level, newNode);
                }while (level --> 0);
            }
        }

        public void delete(Integer deleteValue){
            if (contains(deleteValue)){
                SkipListNode deleteNode = find(deleteValue);
                size--;
                int level = maxLevel;
                SkipListNode current = head;
                do{
                    current = findNext(deleteNode.value, current, level);
                    if (deleteNode.nextNodes.size() > level){
                        current.nextNodes.set(level, deleteNode.nextNodes.get(level));
                    }
                }while (level --> 0);
            }
        }

        public boolean contains(Integer value){
            SkipListNode node = find(value);
            return node != null && node.value != null && equalTo(node.value, value);
        }

        private SkipListNode find(Integer e){
            return find(e, head, maxLevel);
        }

        public Iterator<Integer> iterator(){
            return new SkipListIterator(this);
        }

        private SkipListNode find(Integer e, SkipListNode current, int level){
            do{
                current = findNext(e, current, level);
            }while (level --> 0);
            return current;
        }

        private SkipListNode findNext(Integer e, SkipListNode current, int level){
            SkipListNode next = current.nextNodes.get(level);
            while (next != null){
                Integer value = next.value;
                if (lessThan(e, value)){
                    break;
                }
                current = next;
                next = current.nextNodes.get(level);
            }
            return current;
        }

        public int size(){
            return size;
        }

        private boolean lessThan(Integer a, Integer b){
            return a.compareTo(b) < 0;
        }

        private boolean equalTo(Integer a, Integer b){
            return a.compareTo(b) == 0;
        }
    }
}
