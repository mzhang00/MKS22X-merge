import java.util.Arrays;

public class Merge{
  public static void mergesort(int[] data){
    if (data.length < 27){
      insertionSort(data, 0, data.length);
    }else{
      int[] temp = new int[data.length];
      for (int i = 0; i < data.length; i++){
        temp[i] = data[i];
      }
      mergesortH(data, temp, 0, data.length - 1, 0 , data.length - 1);
    }
  }

  private static void mergesortH(int[] data, int[] copy, int start, int end, int oldstart, int oldend){
    int middle = ((end - start) / 2) + start;
    if (start == end){
      return;
    }
    mergesortH(copy, data, oldstart, middle, start, middle);
    mergesortH(copy, data, middle + 1, oldend, middle + 1, end);
    merge(copy, data, start, end);
  }

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

    //arrays are below
  /*
    int[] first = {1,2,14444,999999,2,18,90,1000000000};
    int[] copy1 = {0,0,0,0,0,0,0,0};
    int[] copy = {5,1,4,7,2,6,3};
    int[] merged = {5,1,4,7,2,6,3};
  */

    //testing merge is below
  /*
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
  */

    //testing mergesort is below
  /*
    mergesort(first);
    for (int i : first){
      System.out.print("" + i + " ");
    }
    System.out.println();
  */

    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Merge.mergesort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }

  private static void insertionSort(int[] ary, int lo, int hi){
    int temp;
    int counter;
    for (int i = lo + 1; i < hi; i++){
      temp = ary[i];
      counter = i - 1;
      while (counter >= lo && ary[counter] > temp){
        ary[counter + 1] = ary[counter];
        counter--;
      }
      ary[counter + 1] = temp;
    }
  }

  /*
  //Sort testing code
  private static final int INCREASE = 0;
  private static final int DECREASE = 1;
  private static final int STANDARD = 2;
  private static final int SMALL_RANGE = 3;
  private static String name(int i){
    if(i==INCREASE)return "Increassing";
    if(i==DECREASE)return "Decreassing";
    if(i==STANDARD)return "Normal Random";
    if(i==SMALL_RANGE)return "Random with Few Values";
    return "Error categorizing array";
  }
  private static int create(int min, int max){
    return min + (int)(Math.random()*(max-min));
  }
  private static int[]makeArray(int size,int type){
    int[]ans =new int[size];
    if(type == STANDARD){
      for(int i = 0; i < size; i++){
        ans[i]= create(-1000000,1000000);
      }
    }
    else if(type == INCREASE){
      int current = -5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current += 10;
      }
    }
    else if(type == DECREASE){
      int current = 5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current -= 10;
      }
    }
    else if(type == SMALL_RANGE){
      for(int i = 0; i < size; i++){
        ans[i]= create(-5,5);
      }
    }
    else{
      ans = new int[0];//empty is default
    }
    return ans;
  }
  public static void main(String[]args){
    if(args.length < 2)return;
    
    int size =  Integer.parseInt(args[0]);
    int type =   Integer.parseInt(args[1]);
    int [] start = makeArray(size,type);
    int [] result = Arrays.copyOf(start,start.length);
    Arrays.sort(result);
    
    long startTime = System.currentTimeMillis();
    
    quicksort(start);
    long elapsedTime = System.currentTimeMillis() - startTime;
    if(Arrays.equals(start,result)){
      System.out.println("PASS Case "+name(type)+"\t array, size:"+start.length+"\t"+elapsedTime/1000.0+"sec ");
    }else{
      System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
    }
  }*/
}
