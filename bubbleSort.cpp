#include<iostream>
using namespace std;
void swap(int* &array,int i,int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
void displayArray(int* &array,int size){
    for (int i = 0; i < size; i++){
        cout<<array[i]<<" ";
    }
    cout<<endl;
    
}
void bubbleSort(int* &array,int size){
    for (int i = 0; i <size-1; i++){
        cout<<endl;
        cout<<"Iteration : "<<i+1<<endl;
        for (int j = 0; j < size-i-1; j++){
            cout<<"R"<<j+1<<": ";
            if (array[j]>array[j+1]){
                swap(array,j,j+1);
            }
            displayArray(array,size);
        }
        
    }
}
int main(){
    int AR[10]={10,9,8,7,6};
    int * array = AR;
    int n=5;

    bubbleSort(array,n);
    
    return 0;
}