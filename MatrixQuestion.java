interface matrix {
    public static int size = 3;
    public void addSub(matrix m1,matrix m2);//ye bhi
    public float calctrace(matrix m);//or ye bhi

    public int get(int i,int j);//this one
    public int set(int i,int j,int value);//this one
    public void displayMatrix();//this one

    
}
class MyClass implements matrix{
    private int[][] m;
    public MyClass(){
        this.m = new int[size][size];
    }
    public void displayMatrix(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(this.get(i, j)+"  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    @Override
    public int get(int i,int j){
        return this.m[i][j];
    }
    @Override
    public void addSub(matrix m1, matrix m2) {
        matrix add = new MyClass();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                int temporarySum = m1.get(i, j)+m2.get(i, j);
                add.set(i, j,temporarySum );
            }
        }
        System.out.println("Matrix Addition");
        add.displayMatrix();
        matrix sub = new MyClass();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                int temporarySum = m1.get(i, j) - m2.get(i, j);
                sub.set(i, j,temporarySum );
            }
        }
        System.out.println("Matrix Subtraction");
        sub.displayMatrix();
    }
    @Override
    public int set(int i, int j,int value) {
        this.m[i][j] = value;
        return 0;
    } 
   
    @Override
    public float calctrace(matrix m) {
        float res = 0;
        for (int i = 0; i < size; i++) {
            res+= m.get(i, i);
        }
        return res;
    }
}
public class MatrixQuestion {
    public static void main(String[] args) {

        matrix m1 = new MyClass();
        

        m1.set(0, 0, 3);
        m1.set(0, 1, 2);
        m1.set(0, 2, 5);
        m1.set(1, 0, 2);
        m1.set(1, 1, 1);
        m1.set(1, 2, 9);
        m1.set(2, 0, 3);
        m1.set(2, 1, 7);
        m1.set(2, 2, 6);
        m1.displayMatrix();

        float res1 = m1.calctrace(m1);
        System.out.println("Diagonal Sum : "+res1+"\n");
        
        matrix m2 = new MyClass();
        m2.set(0, 0, 1);
        m2.set(0, 1, 6);
        m2.set(0, 2, 3);
        m2.set(1, 0, 1);
        m2.set(1, 1, 7);
        m2.set(1, 2, 8);
        m2.set(2, 0, 2);
        m2.set(2, 1, 4);
        m2.set(2, 2, 6);
        m2.displayMatrix();

        float res2 = m2.calctrace(m2);
        System.out.println("Diagonal Sum : "+res2+"\n");

        m1.addSub(m1, m2);
        

    }
}

