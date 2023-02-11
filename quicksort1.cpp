#include<iostream>
#include<cstdlib>
#include<time.h>
#include<fstream>
#include<chrono>
using namespace std;
using namespace std::chrono;

// swap function create swap function always with pass by rference to work lol!
void swap(int * &array,int a,int b,int * &count){
    int temp  = array[a];
    array[a]  = array[b];
    array[b]  = temp;
    (*count)+=1;
}

// partioning function
int loumutoPartition(int *arr, int low , int high,int * &count){
    // selcting pivot element basically that element which divide partition
    // [ less tha pivot element | pivot element | greater than pivot element ] ----> array after loumuto partition
    int pivot=arr[high];
    int i= low-1;
    for (int j = low; j <= (high-1); j++)
    {
        if(arr[j]<pivot){
            i++;
            swap(arr,i,j,count);
            
        }
    }
    //8 * 3
    //24
    swap(arr,i+1,high,count);
   
    return i+1;
    
}
int partitionrandom(int* &array,int start,int end,int * &count){
    srand(time(NULL));
    int randompivot = start+ rand() % (start - end);
    swap(array,randompivot,end,count);
    return loumutoPartition(array, start, end,count);
}
// quick sort function
void quickSort(int* arr , int low , int high,int * &count){
    if(low<high){
        // int p=loumutoPartition(arr,low,high,count);
        int p=partitionrandom(arr,low,high,count);
        quickSort(arr,low,p-1,count);
        quickSort(arr,p+1,high,count);
    }
}


int main(){
    int A[]={10,20 ,30,40,50,60,70,80};
    // int A[]={5,3,8,4,2,7,1,10};
    int h=7;
    int l=0;
    // loumutoPartition(A,0,6);
    // naivePartition(A,0,6,4);
    // hoarePartition(A,0,7);
    cout<<"Raw Array : ";
    for (int i = 0; i < h; i++)
    {
        cout<<A[i]<<" ";
    }
    cout<<endl;
    
    cout<<"Array after Quick Sort : ";
    int * count = new int(0);
    quickSort(A,l,h,count);
    for (int i = 0; i < h; i++)
    {
        cout<<A[i]<<" ";
    }
    cout<<endl;
    cout<<"Total number of comparisons : "<<(*count)<<endl;
    return 0;
    
}

