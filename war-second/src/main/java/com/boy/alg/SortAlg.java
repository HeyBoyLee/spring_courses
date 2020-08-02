package com.boy.alg;

/**
 * Created by heyboy on 2020-08-01.
 */
public class SortAlg {
  public static void quickSort(int[] n, int start, int end){
    if(start >= end)
      return;
    int left = start;
    int right = end;
    int i = start;
    int x = n[start];

    while(start < end){
      while(start < end && x < n[end]) end--;
      if(start < end && x > n[end]){
        n[i] = n[end];
        i = end;
      }
      while(start < end && x > n[start]) start++;
      if(start < end && x < n[start]){
        n[i] = n[start];
        i = start;
      }
    }
    n[i] = x;
    quickSort(n, left, i-1);
    quickSort(n, i+1, right);
  }

  public static void heapSort(int[] n){
    int len = n.length;
    for(int j=len; j>0; j--){  //堆顶和堆尾互换
      for(int i = j/2-1;i>=0;i--){  // 构建最大堆
        int largest = i;
        if(n[2*i] > n[largest] && 2*i<j) largest = 2*i;
        if(n[2*i+1] > n[largest] && (2*i+1)<j) largest = 2*i+1;
        if(i != largest)
          swap(n, i, largest);
      }
      swap(n, 0, j-1);
    }
  }

  public static void heapify(int[] n, int len){
    for(int i = len-1;i>=0;i--){
      int largest = i;
      if(n[2*i] > n[largest]) largest = 2*i;
      if(n[2*i+1] > n[largest]) largest = 2*i+1;
      if(i != largest)
        swap(n, i, largest);
    }
  }

  public static void swap(int[] n, int i, int j){
    int x = n[i];
    n[i] = n[j];
    n[j] = x;
  }

  public static void printArray(int[] n){
    for(int i=0; i< n.length; i++){
      System.out.print(n[i]+",");
    }
    System.out.println();
  }

  public static void shellSort(int n[]){
    for(int gap=n.length/2;gap>0;gap /=2){    //分组
      for(int i=gap;i<n.length;i++){          //每个组
        for(int j=i;j<n.length;j+= gap){      //每个组每个元素对比插入
          int x = n[j];
          int k = j;
          while(k-gap >=0 && n[k-gap] > n[k]){
            n[k] = n[k-gap];
            k -= gap;
          }
          n[k] = x;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] n = {2,5,3,9,8,1,6,12,10};
    printArray(n);
//    quickSort(n, 0, n.length-1);
//    heapSort(n);
    shellSort(n);
    printArray(n);
  }
}
