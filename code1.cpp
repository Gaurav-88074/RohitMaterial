#include<iostream>
using namespace std;

void increment(int * a){
    *a = (*a)+1;
}
int main(){
    int * a = new int(10);
    cout<<*a<<endl;
    increment(a);
    cout<<*a<<endl;
    return 0;
}