
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import model.AuthenEmail;
import model.MailSet;


public class TestMail {

    public static void main(String[] args) {
        MailSet ms = new MailSet("contact mail");
        String MailAddress = "int303.quizhub@gmail.com";
        String toName = "Nile";
        String messageTo = "QuizHub is the best";
        ms.setMail(toName, messageTo, MailAddress);
        //ms.sendMail();
        long t = System.currentTimeMillis();// + 60000;
        DateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        Date result = new Date(t);
        System.out.println(simple.format(result));
        Timestamp use = Timestamp.valueOf(simple.format(result));
        System.out.println(use);
        AuthenEmail ae = new AuthenEmail(1, "ABC", Long.valueOf("1000000001"), use);
        System.out.println(ae.getCreated_Time());
        System.out.println(ae.getRemove_Time());
    }

}
