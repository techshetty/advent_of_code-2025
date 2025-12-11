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
            ct=helper("you",edg,vis);
            }
            System.out.println(ct);
            }
    public static long helper(String cur,HashMap<String,ArrayList<String>> edg,HashSet<String>vis){
        if(cur.equals("out"))return 1L;
        long cnt=0;
        vis.add(cur);
        ArrayList<String>t=edg.get(cur);
        for(String s:t){
            if(!vis.contains(s))cnt+=helper(s,edg,vis);
        }
        vis.remove(cur);
        return cnt;
    }
        }
