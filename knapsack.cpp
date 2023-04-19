#include<iostream>
using namespace std;

void displayDparray(int n, int W, int** array){
    for (int i = n; i >= 0; i--)
    {
      for (int j  = 0; j<=W ; j++)
      {
        cout<<array[i][j]<<"  ";
      }
      cout<<endl;
    }

}

int subsetSum(int n , int W , int * w  , int * wt){
    // int array[n+1][W+1];
    int **array;
    array = new int *[n+1];
    for(int i = 0; i <=n; i++){

        array[i] = new int[W+1];
    }
    for (int i = 0; i <= W; i++)
    {
        array[0][i]=0;
        // array[i][0]=0;
        
    }
    for (int i = 0; i <= n; i++)
    {
        array[i][0]=0;
        // array[i][0]=0;
        
    }
    
    for (int i = 1; i <=n; i++)
    {
        for (int j = 1; j <=W; j++)
        {
           if(j<w[i-1]){
            array[i][j]=array[i-1][j];
            // cout<<array[i][j]<<" <---- if \n";
            // cout<<array[i][j]<<"  ";
           }
           else{
            array[i][j]=max(array[i-1][j],wt[i-1]+array[i-1][j-w[i-1]]);
            // cout<<array[i][j]<<" <---- esle \n";
            // cout<<array[i][j]<<"  ";
           }
        }
        // cout<<endl;
        
    }
    displayDparray(n,W, array);
    int max_credit=array[n][W];
    cout<<"Maximum credit : "<<array[n][W]<<endl;
//    int n=5;
    while (n!=0)
    {
        if(array[n][W]!=array[n-1][W]){
            cout<<n<<endl;
            W=W-w[n-1];
        }
        n--;
    }

    
    return max_credit;
    
}



int main(){
    // int W=6;
    // int w[]={2,2,3};
    // int n=3;

    int W=70;
    int w[]={40,20,30,10,30};
    int wt[]={12,8,16,9,5};
    int n=5;

    int res=subsetSum(n,W,w,wt);

    cout<<"Max value can be collected : = "<<res;
    return 0;
}