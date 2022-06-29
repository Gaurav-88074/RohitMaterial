#include<iostream>
#include<vector>
using namespace std;
void swap(vector<int> &array,int i,int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
void displayArray(vector<int> &array,int size){
    for (int i = 0; i < size; i++){
        cout<<array[i]<<" ";
    }
    cout<<endl;
    
}
void permutation(vector<int> &array,int pos){
    if (pos==array.size()){
        displayArray(array,array.size());
        return;
    }
    for (int i = pos; i < array.size(); i++){
        swap(array,pos,i);
        permutation(array,pos+1);
        swap(array,pos,i);
    }
    
    
}
int main(){
    vector<int> array = {1,2,3};
    permutation(array,0);

    return 0;
}