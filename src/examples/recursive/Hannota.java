package examples.recursive;

public class Hannota {

    public static void main(String[] args){
        hannota(3,"左","右","中");
    }

    public static void hannota(int n,String form,String to,String help){
        if (n==1){
            System.out.println("Move 1 from "+form+" to "+to);
            return;
        }else {
            hannota(n-1,form,help,to);
            System.out.println("Move "+n+" from "+form+" to "+to);
            hannota(n-1,help,to,form);
        }
    }
}
