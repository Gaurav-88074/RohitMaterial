# @lru_cache(None)
arr = []
def knapsack(items,value,w,i,dp):
    if i==len(items):
        return 0
    if dp[w][i]!=None: return dp[w][i]
    take = 0
    skip = 0
    # arr.append(value[i])
    if w - items[i]>=0:
        take = value[i]+knapsack(items,value,w-items[i],i + 1,dp)

    skip = knapsack(items,value,w,i + 1,dp)

    # arr.pop()
    # if take<skip:
    res = max(take,skip)
    dp[w][i] = res
    return res

weight=70;
items  =[40,20,30,10,30];
value  =[12,8,16,9,5];

dp = [[None]*(len(items)) for i in range(weight+1)]
# print(dp)
res = knapsack(items,value,weight,0,dp)
for i in dp:
    print(i)
print(res)
# print(arr)