import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Что сделать? save/upload");
        String whatDo = sc.nextLine();
        if(whatDo.equals("save")){
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("some.txt"))){
                Some some = new Some();
                some.result();
                oos.writeObject(some);
            }catch(Exception ex){
                ex.getMessage();
            }
        }else if(whatDo.equals("upload")){
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("some.txt"))){
                Some some1 = (Some) ois.readObject();
                System.out.println("x = "+some1.x+"\ny = "+some1.y);
            }catch (Exception ex){
                ex.getMessage();
            }
        }else{
            System.out.println("Введена неверная команда");
        }
    }
}