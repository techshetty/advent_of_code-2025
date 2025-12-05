public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<long[]>rang=new ArrayList<>();
        long ct=0;
        try{
            while(true){
                String tmp[]=sc.nextLine().split("-");
                if(tmp.length==2){long l=Long.parseLong(tmp[0]),r=Long.parseLong(tmp[1]);
                rang.add(new long[]{l,r});}
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            Collections.sort(rang,(a,b)->Long.compare(a[0],b[0]));
            ArrayList<long[]>res=new ArrayList<>();
            int n=rang.size();
            long l=rang.get(0)[0],h=rang.get(0)[1];
            for(int i=0;i<n-1;i++){
                if(rang.get(i+1)[0]<=h){
                    h=Math.max(h,rang.get(i+1)[1]);
                }
                else{
                    ct+=(h-l+1);
                    l=rang.get(i+1)[0];
                    h=rang.get(i+1)[1];
                }
            }
            ct+=(h-l+1);
            System.out.println(ct);
        }
    }
}
