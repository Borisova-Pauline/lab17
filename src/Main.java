import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Some some;
        System.out.println("Что сделать? save/upload");
        String whatDo = sc.nextLine();
        if(whatDo.equals("save")){
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("some.txt"))){
                some = new Some();
                some.result();
                oos.writeObject(some);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }else if(whatDo.equals("upload")){
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("some.txt"))){
                some = (Some) ois.readObject();
                System.out.println("x = "+some.x+"\ny = "+some.y);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }else{
            System.out.println("Введена неверная команда");
        }
    }
}