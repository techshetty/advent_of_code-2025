import java.util.*;
public class Main {
    static int inf =(int)1e5;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long ct=0;
        try{
            while(true){
                String tmp[]=sc.nextLine().split(" ");
                String klist=tmp[0].substring(1,tmp[0].length()-1);
                int keys[]=new int[klist.length()];
                for(int i=0;i<klist.length();i++)keys[i]=(klist.charAt(i)=='.')?0:1;
                // for(int x:keys)System.out.print(x+" ");
                // System.out.println();
                ArrayList<ArrayList<Integer>>buttons=new ArrayList<>();
                for(int i=1;i<tmp.length-1;i++){
                    String bl[]=tmp[i].substring(1,tmp[i].length()-1).split(",");
                    ArrayList<Integer>cbut=new ArrayList<>();
                    for(int j=0;j<bl.length;j++)cbut.add(Integer.parseInt(bl[j]));
                    buttons.add(cbut);
                }
                // System.out.println(buttons);
                int res=helper(0,buttons,keys,new int[keys.length]);
                // System.out.println(res);
                ct+=res;
            }
        }
        catch(Exception e){
           System.out.println(e);
        }
        finally{
            }
            System.out.println(ct);
            }
    public static int helper(int i,ArrayList<ArrayList<Integer>>buttons,int keys[],int ckey[]){
        if(i==buttons.size()){
            boolean f=true;
            for(int j=0;j<keys.length;j++)if(keys[j]!=ckey[j]){f=false;break;}
            return f?0:inf;
        }
        // System.out.println(i);
        int np=helper(i+1,buttons,keys,ckey);
        ArrayList<Integer>but=buttons.get(i);
        for(int x:but){if(x>=keys.length)continue;ckey[x]^=1;}
        int pk=1+helper(i+1,buttons,keys,ckey);
        for(int x:but){if(x>=keys.length)continue;ckey[x]^=1;}
        return Math.min(np,pk);
    }
        }
