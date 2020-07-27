package cn.itcast06;

public class Code_09_IsRotation {
    public static boolean isRotation(String a, String b){
        if (a == null || b == null || a.length() != b.length()){
            return false;
        }
        String b2 = b + b;
        return getIndexOf(b2, a) != -1;
    }

    public static int getIndexOf(String s, String m){
        if (s.length() < m.length()){
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while (si < ss.length && mi < ms.length){
            if (ss[si] == ms[si]){
                si++;
                mi++;
            }
        }
        return -1;
    }

    public static int[] getNextArray(char[] ms){
        if (ms.length == 1){
            return new int[]{ -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length){
            if (ms[pos - 1] == ms[cn]){
                next[pos++] = ++cn;
            }else if (cn > 0){
                cn = next[cn];
            }else {
                next[pos++] = 0;
            }
        }
        return next;
    }


}
