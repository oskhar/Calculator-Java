import views.ClassView;
import controllers.StringController;

// Class
public class App {

    // main Method
    public static void main(String[] args) throws Exception {

        // new ClassView();
        StringController hasil = new StringController();
        System.out.println(hasil.hitung("11+5x5+5x6+4÷7"));

    }
}
