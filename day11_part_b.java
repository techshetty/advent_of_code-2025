import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<String,ArrayList<String>>edg=new HashMap<>();
        HashSet<String>vis=new HashSet<>();
        long ct=0;
        try{
            while(true){
                String tmp[]=sc.nextLine().split(":");
                String key=tmp[0];
                String con[]=tmp[1].split(" ");
                edg.putIfAbsent(key,new ArrayList<>());
                for(String c:con){
                    if(c.length()==0)continue;
                    edg.get(key).add(c);
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
           // System.out.println(edg);
            HashMap<String,HashMap<Integer,HashMap<Integer,Long>>>dp=new HashMap<>();
            ct=helper("svr",edg,vis,0,0,dp);
            }
            System.out.println(ct);
            }
    public static long helper(String cur,HashMap<String,ArrayList<String>> edg,HashSet<String>vis,int f1,int f2,HashMap<String,HashMap<Integer,HashMap<Integer,Long>>>dp){
        if(cur.equals("out")&&f1==1&&f2==1)return 1L;
        dp.putIfAbsent(cur,new HashMap<>());
        dp.get(cur).putIfAbsent(f1,new HashMap<>());
        if(dp.get(cur).get(f1).containsKey(f2))return dp.get(cur).get(f1).get(f2);
        long cnt=0;
        vis.add(cur);
        ArrayList<String>t=edg.getOrDefault(cur,new ArrayList<>());
        int f3=f1,f4=f2;
        if(f1==0)if(cur.equals("fft"))f1=1;
        if(f2==0)if(cur.equals("dac"))f2=1;
        for(String s:t){
            if(!vis.contains(s))cnt+=helper(s,edg,vis,f1,f2,dp);
        }
        vis.remove(cur);
        // System.out.println(dp);
        dp.get(cur).get(f3).put(f4,cnt);
        return cnt;
    }
        }
