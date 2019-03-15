public class Merge{
  public static void mergesort(int[]data){
    int[] temp = new int[data.length];
    for (int i = 0; i < data.length; i++){
      temp[i] = data[i];
    }
    mergesortH(data, temp, 0, data.length - 1);
  }
  private static void mergesortH(int[] data, int[] copy, int start, int end){
    int middle = data.length / 2;
    if (start == end){
      return;
    }
    //mergesortH()
    //mergesortH()
    merge(data, copy);
  }
  //Need to fix merge -  right now it only works if both halves are pre-sorted
  private static void merge(int[] data, int[] copy){
    int second = data.length / 2;
    int first = 0;
    int counter = 0;
    while (first < (data.length / 2) || second < data.length){
      if (first == (data.length / 2)){
        copy[counter] = data[second];
        second++;
      }else{
        if (second == data.length){
          copy[counter] = data[first];
          first++;
        }else{
          if (data[first] >= data[second]){
            copy[counter] = data[second];
            second++;
          }else{
            copy[counter] = data[first];
            first++;
          }
        }
      }
      counter++;
    }
  }
  public static void main(String[] args){
    int[] first = {1,123,14444,999999,2,18,90,1000000000};
    int[] copy = {0,0,0,0,0,0,0,0};
    merge(first, copy);
    for (int i : copy){
      System.out.print("" + i + " ");
    }
    System.out.println();
  }
}
