# @lru_cache(None)
def knapsack(items,value,w,i,dp):
    if i==len(items):
        return 0
    if dp[i][w]!=None: return dp[i][w]
    take = 0
    skip = 0
    takeArray = []
    if w - items[i]>=0:
        # a,b  = knapsack(items,value,w-items[i],i + 1,dp)
        # take = value[i] + a
        # takeArray= b
        # takeArray.append(value[i])
        take = value[i]+knapsack(items,value,w-items[i],i + 1,dp)
    # c,d = knapsack(items,value,w,i + 1,dp)
    # skip = c
    # skipArray  = d
    skip = knapsack(items,value,w,i + 1,dp)

    res = max(take,skip)
    #-----------------------------------
    # resArray = []
    # if take>skip:
    #     resArray = takeArray
    # else:
    #     resArray = skipArray
    #-----------------------------------
    dp[i][w] = res
    # return [res,resArray]
    return res

weight=70;
items  =[40,20,30,10,30];
value  =[12,8,16,9,5];

dp = [[None]*(weight+1) for i in range(len(items)+1)]
# print(dp)
res = knapsack(items,value,weight,0,dp)
for i in dp:
    print(i)
print(res)
# print(resArray)
n=5
while (n!=0):
    if(dp[n][weight]!=dp[n-1][weight]):
        print(n)
        weight=weight-items[n-1]
    n-=1