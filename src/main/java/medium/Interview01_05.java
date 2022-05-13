package medium;

public class Interview01_05 {
    public boolean oneEditAway(String first, String second) {
        int s = first.length();
        int e = second.length();
        int offset = Math.abs(s - e);
        if(offset > 1){
            return false;
        }
        if(s < e){
            String t = first;
            first = second;
            second = t;
        }
        s = -1;
        e = second.length();
        while(++s < e && first.charAt(s) == second.charAt(s));
        while(--e >= s && first.charAt(e + offset) == second.charAt(e));
        return s > e || first.length() == second.length() && e == s;
    }
}
