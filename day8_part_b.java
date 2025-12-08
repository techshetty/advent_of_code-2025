import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<String,Integer>hs=new HashMap<>();
        HashMap<Integer,HashSet<String>>hs1=new HashMap<>();
        int id=0,cnt=1000;
        PriorityQueue<ArrayList<long[]>>pq=new PriorityQueue<>((a,b)->{
            long p1[]=a.get(0),q1[]=a.get(1);
            long p2[]=b.get(0),q2[]=b.get(1);
            double d1=Math.sqrt(sq(p1[0]-q1[0])+sq(p1[1]-q1[1])+sq(p1[2]-q1[2]));
            double d2=Math.sqrt(sq(p2[0]-q2[0])+sq(p2[1]-q2[1])+sq(p2[2]-q2[2]));
            if(d1==d2)return 0;
            if(d1<d2)return -1;
            else return 1;
        });
        ArrayList<long[]>points=new ArrayList<>();
        long ct=0;
        try{
            while(true){
                String tmp[]=sc.nextLine().split(",");
                long pnt[]=new long[3];
                for(int i=0;i<3;i++)pnt[i]=Long.parseLong(tmp[i]);
                points.add(pnt);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            int n=points.size();
            for(int i=0;i<n;i++)for(int j=i+1;j<n;j++){
                ArrayList<long[]>tmp=new ArrayList<>();
                tmp.add(points.get(i));tmp.add(points.get(j));
                pq.offer(tmp);
            }
            while(!pq.isEmpty()){
                ArrayList<long[]>tmp=pq.poll();
                String p=key(tmp.get(0)),q=key(tmp.get(1));
                int cid1=hs.getOrDefault(p,-1);
                int cid2=hs.getOrDefault(q,-1);
                int cid=-1;boolean f=false;
                if(cid1==-1&&cid2==-1){cid=id++;f=true;}
                else if(cid1==cid2){continue;}
                else if(cid1==-1||cid2==-1){
                    cid=(cid1==-1)?cid2:cid1;f=true;
                }
                else{
                    cid=cid1;
                    HashSet<String>th=hs1.get(cid2);
                    for(String s:th){
                        hs.put(s,cid);
                    }
                    hs1.get(cid1).addAll(hs1.get(cid2));
                    hs1.remove(cid2);
                    hs.put(p,cid);hs.put(q,cid);
                }
                    if(f){hs.put(p,cid);hs.put(q,cid);
                    hs1.putIfAbsent(cid,new HashSet<>());
                    hs1.get(cid).add(p);
                    hs1.get(cid).add(q);}
                if(hs1.size()==1&&hs1.get(cid).size()==n){
                    System.out.println(tmp.get(0)[0]*tmp.get(1)[0]);
                    break;
                }
            }
            }
        }
    public static long sq(long n){return n*n;}
    public static String key(long nums[]){
        StringBuilder sb=new StringBuilder();
        for(long x:nums){
            sb.append(x);
            sb.append(',');
        }
        return sb.toString();
    }
    }
