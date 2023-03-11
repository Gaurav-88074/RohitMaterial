import java.util.*;
public class fuelTank{
    public static void main(String[] args) {
        
        Stack<Integer> stack  = new Stack<>();
        
        int dest  = 25;
        int stationCount = 0;
        
        int p = 0;
        //p          0 1 2
        int[] arr = {4,7,11,13,18,20,23};
        
        int d = 6;
        int fuelLeft = d;
        
        //0 1 2 3 4 5 6 
        //0
        int i = 0;
        while(i<dest){
            //i = 5
            if(p<arr.length && arr[p]  <= i ){
                stack.add(p);
                // System.out.println(pq);
                // System.out.println(Arrays.toString(arr));
                // System.out.println(arr[p]+ " ko rakhliya");
                // System.out.println("--------------------------------");
                p+=1;
            }
            
            
            if (fuelLeft==0) {
                if (stack.size()==0){
                    System.out.println("Pahuchna namukin hai ");
                    break;
                }
                else{
                    int recentStationIndex = stack.pop();
                    System.out.println("hum "+i+" pe khali hogye");
                    i = arr[recentStationIndex];
                    System.out.println("hame vapis "+i+" pe aagye");


                    if (i+fuelLeft>=dest) {
                        System.out.println("hn hn pachuch gye bhai");
                        break;
                    }

                    stationCount+=1;
                    fuelLeft = d;
                    continue;
                    
                }
            }
                 
            else{
                i++;
            }
            //---------------------
            fuelLeft-=1;
            //---------------------
        }
        System.out.println("we have used "+stationCount+" so far");
    }
}

// import java.util.*;
// public class fuelTank{
//     public static void main(String[] args) {
        
//         PriorityQueue<Integer> pq  = new PriorityQueue<>(Collections.reverseOrder());
        
//         int dest  = 25;
//         int stationCount = 0;
        
//         int p = 0;
//         //p          0 1 2
//         int[] arr = {4,7,11,13,18,20,23};
        
//         int d = 6;
//         int fuelLeft = d;
        
//         //0 1 2 3 4 5 6 
//         //0
//         int i = 0;
//         while(i<dest){
//             //i = 5
//             if(p<arr.length && arr[p]  <= i ){
//                 pq.add(p);
//                 // System.out.println(pq);
//                 // System.out.println(Arrays.toString(arr));
//                 // System.out.println(arr[p]+ " ko rakhliya");
//                 // System.out.println("--------------------------------");
//                 p+=1;
//             }
            
            
//             if (fuelLeft==0) {
//                 if (pq.size()==0){
//                     System.out.println("Pahuchna namukin hai ");
//                     break;
//                 }
//                 else{
//                     int recentStationIndex = pq.poll();
//                     System.out.println("hum "+i+" pe khali hogye");
//                     i = arr[recentStationIndex];
//                     System.out.println("hame vapis "+i+" pe aagye");


//                     if (i+fuelLeft>=dest) {
//                         System.out.println("hn hn pachuch gye bhai");
//                         break;
//                     }

//                     stationCount+=1;
//                     fuelLeft = d;
//                     continue;
                    
//                 }
//             }
                 
//             else{
//                 i++;
//             }
//             //---------------------
//             fuelLeft-=1;
//             //---------------------
//         }
//         System.out.println("we have used "+stationCount+" so far");
//     }
// }