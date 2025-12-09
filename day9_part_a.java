import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<long[]>points=new ArrayList<>();
        long ct=0,max=0;
        try{
            while(true){
                String tmp[]=sc.nextLine().split(",");
                long pnt[]=new long[3];
                for(int i=0;i<2;i++)pnt[i]=Long.parseLong(tmp[i]);
                points.add(pnt);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            int n=points.size();
            for(int i=0;i<n;i++)for(int j=0;j<n;j++){
                long p1[]=points.get(i),p2[]=points.get(j);
                long ar=Math.abs(p1[0]-p2[0]+1)*Math.abs(p1[1]-p2[1]+1);
                max=Math.max(max,ar);
            }
            System.out.println(max);
            }
        }
    }
