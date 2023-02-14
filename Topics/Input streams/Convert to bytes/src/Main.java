import java.io.InputStream;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream input = System.in;
        byte[] bytes = new byte[50];
        int read = input.read(bytes);

        for(int i = 0;i<bytes.length; i++){
            if(bytes[i] == 10){
                break;
            }
        }
        for(int j = 0; j < bytes.length; j++){
            if(bytes[j]>0){
                System.out.print(bytes[j]);
            }
        }
        input.close();
    }
}
