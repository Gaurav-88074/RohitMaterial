public class code2 {
    public static void main(String[] args) {
        
        String name = "Gaurav";
        for (int i = 0; i < 10; i++) {
            String num = String.valueOf(i);
            if(name.contains(num)){
                System.out.println("invalid");
                break;
            }
        }
    }
}
