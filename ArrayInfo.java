package Lab1_4;

import java.io.*;
import java.util.*;

public class ArrayInfo {
  public static void main(String[] args) {
    String numbers;
    List<Double>list = new ArrayList<>();

    try {
      FileReader fileReader = new FileReader(System.getProperty("user.dir") + "/src/Lab1_4/numbers.text");
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      while ((numbers = bufferedReader.readLine()) != null){
        if(!numbers.equals(""))
          list.add(Double.parseDouble(numbers));
      }

      double[] array = new double[list.size()-1];
//      for (int i = 0; i < array.length; i++) {
//        array[i] = list.get(i+1);
//
//      }

      double min = Double.MAX_VALUE, max = Double.MIN_VALUE;
      int minPosition = -1, maxPosition = -1;

      StringBuilder stringBuilder = new StringBuilder("{");
      for(int i = 0; i < array.length; i++){
        array[i] = list.get(i+1);

        if (array[i]>max){
          max = array[i];
          maxPosition = i;
        }

        if (array[i]<min){
          min = array[i];
          minPosition = i;
        }

        if (i<array.length-1)
          stringBuilder.append(array[i]).append(", ");

        else
          stringBuilder.append(array[i]).append("} contains ").append(array.length).append(" elements");
      }

      System.out.println("The array: "+stringBuilder);
      System.out.println("The first element of the array is "+array[0]);
      System.out.println("The last element of the array is "+array[array.length-1]+" and is at position "+(array.length-1));
      System.out.println("The middle element of the array is "+array[(array.length-1)/2]+" and is at position "+(array.length-1)/2);
      System.out.println("The largest element of the array is "+max+" and is at position "+maxPosition);
      System.out.println("The smallest element of the array is "+min+" and is at position "+minPosition);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
