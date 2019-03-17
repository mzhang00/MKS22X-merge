public class Merge{
  public static void mergesort(int[]data){
    int[] temp = new int[data.length];
    for (int i = 0; i < data.length; i++){
      temp[i] = data[i];
    }
    mergesortH(data, temp, 0, data.length - 1, 0 , data.length - 1);
  }
  private static void mergesortH(int[] data, int[] copy, int start, int end, int oldstart, int oldend){
    int middle = ((end - start) / 2) + start;
    if (start == end){
      return;
    }
    mergesortH(data, copy, oldstart, middle, start, middle);
    mergesortH(data, copy, middle + 1, oldend, middle + 1, end);
    merge(data, copy, start, end);
    int[] temp = data;
    data = copy;
    copy = temp;
  }
  //Need to fix merge -  right now it only works if both halves are pre-sorted
  private static void merge(int[] data, int[] copy, int lo, int hi){
    int second = ((hi - lo) / 2) + lo + 1;
    int copyofsecond = second;
    int first = lo;
    int counter = lo;
    while (first < copyofsecond || second < hi + 1){
      if (first >= copyofsecond){
        copy[counter] = data[second];
        second++;
      }else{
        if (second >= hi + 1){
          copy[counter] = data[first];
          first++;
        }
      }
      if (first < copyofsecond && second < hi + 1){   
        if (data[first] >= data[second]){
          copy[counter] = data[second];
          second++;
        }else{
          copy[counter] = data[first];
          first++;
        }
      }
      counter++;
    }
  }
  public static void main(String[] args){
    
    int[] first = {1,2,14444,999999,2,18,90,1000000000};
    int[] copy1 = {0,0,0,0,0,0,0,0};
    int[] copy = {5,1,4,7,2,6,3};
    int[] merged = {5,1,4,7,2,6,3};

    merge(merged, copy, 0, 1);
    for (int i : copy){
      System.out.print("" + i + " ");
    }
    System.out.println();

    merge(merged, copy, 2, 3);
    for (int i : copy){
      System.out.print("" + i + " ");
    }
    System.out.println();
    
    merge(merged, copy, 4,5);
    for (int i : copy){
      System.out.print("" + i + " ");
    }
    System.out.println();
    /*
    merge(merged, copy, 6, 7);
    for (int i : copy){
      System.out.print("" + i + " ");
    }
    System.out.println();
*/
    merge(copy, merged, 0, 3);
    for (int i : merged){
      System.out.print("" + i + " ");
    }
    System.out.println();
    
    merge(copy, merged, 4, 6);
    for (int i : merged){
      System.out.print("" + i + " ");
    }
    System.out.println();

    merge(merged, copy, 0, 6);
    for (int i : copy){
      System.out.print("" + i + " ");
    }
    System.out.println();
    
    //testing merge is below

  /*
    merge(merged, copy, 0, 1);
    merge(merged, copy, 2, 3);
    merge(merged, copy, 4, 5);
    merge(merged, copy, 6, 7);
    for (int i : copy){
      System.out.print("" + i + " ");
    }
    System.out.println();

    merge(copy, merged, 0, 3);
    merge(copy, merged, 4, 7);
    for (int i : copy){
      System.out.print("" + i + " ");
    }
    System.out.println();*/
  /*
    mergesort(first);
    for (int i : copy){
      System.out.print("" + i + " ");
    }
    System.out.println();*/
  }
}
