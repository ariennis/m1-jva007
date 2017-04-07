package com.luxoft.basics.part1.xtasks;

public class T1_BattleField
{
    public static void main(String[] args)
    {
//        System.out.println("  | A B C D E F G H I");
//        System.out.println("--|------------------");
//
//        System.out.println("1 | B B B B B B B B B");
//        System.out.println("2 |");
//        System.out.println("3 | B B   B B B   B B");
//        System.out.println("4 | B B   B B B   B B");
//        System.out.println("5 | B B   B B B   B B");
//        System.out.println("6 | B B B   B B     B");
//        System.out.println("7 | B B B   B B     B");
//        System.out.println("8 | B B B   B B     B");
//        System.out.println("9 | B B B T E B B   B");
        String[] field = {"B", "B", "B", " ", "B", " ", "B", " ", "B"};
//        for (int i=0; i<field.length; i+=3)
//        {
////            String[] f1={field[i],field[i+1],field[i+2]}
//            System.out.println(field[i]+" "+field[i+1]+" "+field[i+2]);
//        }

//        for (String f: field)
//        {
//            System.out.println(f);
//        }
//        for (int i1=0; i1<field.length; i1+=3)
//        {
          for (String f: field)
        {
            System.out.print(f+" ");
        }
            System.out.println();
//        }

    }
}
