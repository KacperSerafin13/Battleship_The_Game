import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int numberOfDimensions;
        Scanner scanner = new Scanner(System.in);
        numberOfDimensions = scanner.nextInt();
        boolean result = true;

        int[][] matrix = new int[numberOfDimensions][numberOfDimensions];

        for(int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[col][row] = scanner.nextInt();
            }
        }

        for(int i = 0; i < matrix.length;i++){
            for(int j = 0;j < matrix[i].length; j++){
                if(matrix[i][j] != matrix[j][i]){
                    result = false;
                }
            }
        }
        if(result){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
}