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
  private static void merge(int[] data, int[] copy){
    int middle = data.length / 2;

  }
}
