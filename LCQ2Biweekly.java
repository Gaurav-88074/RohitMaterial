import java.util.*;
class ElementList{
    TreeMap<Integer,Integer> map;
    ElementList(){
        map = new TreeMap<>();
    }
    public void add(int val){
        map.put(val,1 + map.getOrDefault(val, 0));
    }
    public int bisectLeft(int val){
        Map.Entry<Integer,Integer> e = map.floorEntry(val-1);
        // System.out.println(map);
        if (e==null ) {
            return -1;
        }
        return e.getKey();
    }
    public int bisectRight(int val){
        Map.Entry<Integer,Integer> e = map.ceilingEntry(val+1);
        if (e==null ) {
            return -1;
        }
        return e.getKey();
    }
    public boolean contains(int val){
        return map.containsKey(val);
    }
    public boolean isEmpty(){
        return map.size()==0;
    }
    public Set<Map.Entry<Integer, Integer>> givePairs(){
        return map.entrySet();
    }
    public int size(){
        int res = 0;
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            res+=e.getValue();
        }
        return res;
    }
    public void remove(int val){
        // System.out.println(""+val+" "+map);
        int f = map.get(val);
        
        if (f==1) {
            map.remove(val);
        }
        else{
            map.put(val, f-1);
        }
    }
    
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            for (int i = 0; i < e.getValue(); i++) {
                res.append(String.valueOf(e.getKey())+" ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
class node{
    int a;
    int b;
    public node(int a,int b){
        this.a = a;
            this.b=b;
    }
    public String toString(){
        return ""+a+":"+b+"" ;
    }
}
class SortByThis implements Comparator<node>{

    @Override
    public int compare(node o1, node o2) {
        // TODO Auto-generated method stub
        return -(o1.b - o2.b);
    }  
}
class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        var list = new ElementList();
        PriorityQueue<node> SortedDict = new PriorityQueue<node>(new SortByThis());
        for (int i = 0; i<nums.size();i++) {
            list.add(nums.get(i));
        }
        for(var x : list.givePairs()){
            SortedDict.add(new node(x.getKey(),x.getValue()));
        }
        
        var pending = new ElementList();
        while (!list.isEmpty()){
            
            node max = SortedDict.poll();
            int key = max.a;
            int val = max.b;
            
            boolean h = false;
            if(pending.contains(key)){
                pending.remove(key);
                
                val-=1;
                if(val>0){
                    SortedDict.add(new node(key,val));
                }
                h = true;
            }
            if(h){
                continue;
            }
            
            int smallerValue = list.bisectLeft(key);
            int higherValue  = list.bisectRight(key);
            if  (smallerValue!=-1 ){
                
                list.remove(smallerValue);
                list.remove(key);
                pending.add(smallerValue);
                
            }
            else if(higherValue!=-1){
                
                list.remove(higherValue);
                list.remove(key);
                pending.add(higherValue);
            }
            else{
                break;
            }
            val-=1;
            if(val>0){
                SortedDict.add(new node(key,val));
            }
            
        }
        return list.size();
    }
}