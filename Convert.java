import java.util.Scanner;
import java.lang.Math;

public class Convert {

    static int menu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("------------------------------");
        System.out.println("1) Convert decimal number");
        System.out.println("2) Convert binary number");
        System.out.println("3) Convert octal number");
        System.out.println("4) Convert hexadecimal number");
        System.out.println("------------------------------");
        System.out.println("5) Quit");
        return Integer.parseInt(sc.nextLine());
    }

    static String getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to convert");
        return sc.nextLine();
    }

    static String reverse(String iStr){
        String rStr=new String();
        for(int i=0;i<iStr.length();i++){
            rStr=iStr.charAt(i)+rStr;
        }
        return rStr;
    }

    static String decToBin(String dStr){
        int d=Integer.parseInt(dStr);
        String b="";//binary output in string
        while(d>0){
            b+=d%2;
            d=d/2;
        }
        return reverse(b);
    }
    static String decToOct(String dStr){
        int d=Integer.parseInt(dStr);
        String b="";//binary output in string
        while(d>0){
            b+=d%8;
            d=d/8;
        }
        return reverse(b);
    }
    static int binToDec(String bStr){
       int d =0;
       bStr=reverse(bStr);

       for(int i=0; i<bStr.length();i++){
           d+=((Integer.parseInt(String.valueOf(bStr.charAt(i)))*((int)Math.pow(2,i))));

       }
       return d;
    }


    public static void main(String[] args){
        while(true){
            int option=menu();
            if(option==5)return;
            String inp=getInput();

            switch(option){
                case 1:
                    System.out.println("Decimal: " + inp);
                    System.out.println("Binary: " + decToBin(inp));
                    System.out.println("Octal: " + decToOct(inp));
                    //System.out.println("Hexadecimal: " + decToHex(inp));
                    break;
                case 2:
                    System.out.println("Decimal: " + binToDec(inp));
                    System.out.println("Binary: " + inp);
                    System.out.println("Octal: " + decToOct(inp));
                    //System.out.println("Hexadecimal: " + decToHex(inp));
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        
        }
    }
}
