
def compute(array):
    for i in range(len(array)):
        while(array[i]!=i+1):
            if array[array[i]-1]==array[i]:
                return array[i]

            temp = array[i]
            array[i] = array[array[i]-1]
            array[temp-1]=temp
if __name__ == '__main__':
    
    array=[1,2,3,3]
    res = compute(array)
    n = len(array)
    s = sum(array)-res
    tSum = (n*(n+1))//2

    print(res,tSum-s)