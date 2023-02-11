#include<iostream>
#include<cstdlib>
#include<time.h>
#include<fstream>
#include<chrono>
#include<vector>
using namespace std;
using namespace std::chrono;


void swap(int * &array,int a,int b){
    int temp  = array[a];
    array[a]  = array[b];
    array[b]  = temp;
}


vector<int> loumutoPartition(int *arr, int low , int high){
    
    int localCount = 0;

    int pivot=arr[high];
    int i= low-1;
    for (int j = low; j <= (high-1); j++)
    {
        if(arr[j]<pivot){
            i++;
            swap(arr,i,j);
            localCount+=1;
        }
    }
   
    swap(arr,i+1,high);
    localCount+=1;
    return  {i+1 , localCount};
}
vector<int> partitionrandom(int* &array,int start,int end){
    srand(time(NULL));
    int randompivot = start+ rand() % (start - end);
    swap(array,randompivot,end);
    return loumutoPartition(array, start, end);
}
// quick sort function
int quickSort(int* arr , int low , int high){
    if(low<high){
        vector<int> vec = loumutoPartition(arr,low,high);
        // vector<int> vec = partitionrandom(arr,low,high);
        int  p = vec[0];
        int localcount = vec[1];

        int left = quickSort(arr,low,p-1);
        int right = quickSort(arr,p+1,high);

        return left + localcount + right;
    }
    else{
        return 0;
    }
}



int main(){
    int A[]={10,20 ,30,40,50,60,70,80};
    // int A[]={5,3,8,4,2,7,1,10};
    int h=7;
    int l=0;
    
    cout<<"Raw Array : ";
    for (int i = 0; i < h; i++)
    {
        cout<<A[i]<<" ";
    }
    cout<<endl;
    
    cout<<"Array after Quick Sort : ";

    int count = quickSort(A,l,h);
    for (int i = 0; i < h; i++)
    {
        cout<<A[i]<<" ";
    }
    cout<<endl;
    cout<<"Total number of comparisons : "<<(count)<<endl;
    return 0;
    
}

