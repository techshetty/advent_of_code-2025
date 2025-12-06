import java.util.*;
// "static void main" must be defined in a public class.
public class test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long ct=0;
        try{
            while(true){
                String t[]=sc.nextLine().split(",");
                for(String cur:t){
                    if(cur.length()==0)continue;
                    String temp[]=cur.split("-");
                    long low=Long.parseLong(temp[0]);
                    long high=Long.parseLong(temp[1]);
                    for(long i=low;i<=high;i++){
                        // System.out.println(i);
                        if(isV(i+"")){ct+=i;}
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println(ct);
        }
    }
    public static boolean isV(String s){
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.setLength(0);
            for(int j=i;j<n;j++){
                sb.append(s.charAt(j));
                if(isV2(s,new StringBuilder(sb))){return true;}
            }
        }
        return false;
    }
    public static boolean isV2(String s,StringBuilder sb){
        String t=sb.toString();
        int ct=0;
        while(sb.length()<s.length()){
            ct++;
            sb.append(t);
        }
        // System.out.println(s+","+sb);
        // System.out.println(sb.toString().equals(s));
        return sb.toString().equals(s)&&ct>0;
    }
}
