import java.math.*;
import java.util.*;
public class test2 {
    public static void main(String[] args) {
// int lc=0;
        BigInteger ct=new BigInteger("0");
        try{
            Scanner sc=new Scanner(System.in);
            while(true){
                int ind=-1,max=-1,sm=-1;
                String s=sc.nextLine();
                int n=s.length();
                String maxs=remd(s,s.length()-12);
                //helper(0,"0",12,s,maxs);
                BigInteger cur=new BigInteger(maxs);
		// System.out.println("line:"+(lc++)+" done");
                ct=ct.add(cur);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println(ct.toString());
        }
    }
    public static void helper(int i,String sum,int picks,String s,String max[]){
        if(i==s.length()||picks<=0){
            if(picks==0)max[0]=(max[0].compareTo(sum)<0)?sum:max[0];
            return;
        }
        helper(i+1,sum,picks,s,max);
        StringBuilder tmp=new StringBuilder(sum);
        tmp.append(s.charAt(i));
        helper(i+1,tmp.toString(),picks-1,s,max);
    }
public static String remd(String num, int k) {
        int n=num.length();
        char st[]=new char[n];int c=-1;
       for(int i=0;i<n;i++){
        if(c==-1)st[++c]=num.charAt(i);
        else{
            if(k<=0)st[++c]=num.charAt(i);
            else{
                while(c!=-1&&num.charAt(i)>st[c]&&k>0){c--;k--;}
                st[++c]=num.charAt(i);
            }
        }
       }
       int i=0;
       while(i<c&&st[i]=='0')i++;
        while(k-->0)c--;
        if(c-i+1<=0)return "0";
        return new String(st,i,c+1-i);
    }
}
