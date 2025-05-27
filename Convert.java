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
    static String binToDec(String bStr){
       int d =0;
       bStr=reverse(bStr);

       for(int i=0; i<bStr.length();i++){
           d+=((Integer.parseInt(String.valueOf(bStr.charAt(i)))*((int)Math.pow(2,i))));

       }
       return String.valueOf(d);
    }


    static String octToDec(String oStr){
       int d =0;
       oStr=reverse(oStr);

       for(int i=0; i<oStr.length();i++){
           d+=((Integer.parseInt(String.valueOf(oStr.charAt(i)))*((int)Math.pow(8,i))));

       }
       return String.valueOf(d);
    }
    
    static String getHexDigit(int n){
        switch(n){
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                return String.valueOf(n);
        }
    }

    static String decToHex(String dStr){
        int d=Integer.parseInt(dStr);
        String h="";
        while(d>0){
            h+=getHexDigit(d%16);
            d=d/16;
        }
        return h;
    } 

    static int getDecDigitFromHex(char h){
        switch(h){
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                return h-'0';
        }
    }
    static String hexToDec(String hStr){
        int d=0;
        hStr=reverse(hStr);

        for(int i=0;i<hStr.length();i++){
           d+=getDecDigitFromHex((hStr.charAt(i)))*((int)Math.pow(16,i));
        }
        return String.valueOf(d);
    }

    public static void main(String[] args){
        while(true){
            int option=menu();
            if(option==5)return;
            String inp=getInput();

            switch(option){
                case 1://decimal input
                    System.out.println("Decimal: " + inp);
                    System.out.println("Binary: " + decToBin(inp));
                    System.out.println("Octal: " + decToOct(inp));
                    System.out.println("Hexadecimal: " + decToHex(inp));
                    break;
                case 2://binary input
                    System.out.println("Decimal: " + binToDec(inp));
                    System.out.println("Binary: " + inp);
                    System.out.println("Octal: " + decToOct(inp));
                    System.out.println("Hexadecimal: " + decToHex(binToDec(inp)));
                    break;
                case 3://octal input
                    System.out.println("Decimal: " + octToDec(inp));
                    System.out.println("Binary: " + decToBin(octToDec(inp)));
                    System.out.println("Octal: " + inp);
                    System.out.println("Hexadecimal: " + decToHex(octToDec(inp)));
                    break;
                case 4://hecadecimal input
                    System.out.println("Decimal: " + hexToDec(inp));
                    System.out.println("Binary: " + decToBin(hexToDec(inp)));
                    System.out.println("Octal: " + decToOct(hexToDec(inp)));
                    System.out.println("Hexadecimal: " + inp);
                    break;
                default://invalid option
                    System.out.println("Invalid option");
                    break;
            }
        
        }
    }
}
