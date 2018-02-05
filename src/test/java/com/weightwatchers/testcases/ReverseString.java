package com.weightwatchers.testcases;

import java.lang.*;
import java.util.Scanner;


public class ReverseString {
  public static void main (String args[]){
    Scanner in = new Scanner (System.in);
    String input = in.nextLine();
    System.out.println("Original String is " + input);

    StringBuilder input1= new StringBuilder();
    input1.append(input);
    input1 = input1.reverse();

    for (int i=0; i<input1.length(); i++) {
      System.out.print(input1.charAt(i));
    }

  }

}