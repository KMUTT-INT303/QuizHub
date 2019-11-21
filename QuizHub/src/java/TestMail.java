
import java.util.Random;
import model.MailSet;


public class TestMail {

    public static void main(String[] args) {
        MailSet ms = new MailSet("contact mail");
        String MailAddress = "int303.quizhub@gmail.com";
        String toName = "Nile";
        String messageTo = "QuizHub is the best";
        ms.setMail(toName, messageTo, MailAddress);
        //ms.sendMail();
        
        
    }

}
