import java.io.Serializable;
import java.util.Scanner;

public class Some implements Serializable {
    double x;
    double y;

    public Some() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите x:");
        this.x = sc.nextDouble();
    }
    public void result(){
        this.y=this.x - Math.sin(this.x);
    }
}
