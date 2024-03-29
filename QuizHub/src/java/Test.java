
import controllers.ChoiceResultDao;
import controllers.Choicedao;
import controllers.Facultydao;
import controllers.Questiondao;
import controllers.Quizdao;
import controllers.Resultdao;
import controllers.Studentdao;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import model.Choice;
import model.ChoiceResult;
import model.Faculty;
import model.Question;
import model.Result;
import model.Student;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tsch
 */
public class Test {

    public static void main(String[] args) throws ParseException {

        Studentdao sdao = new Studentdao();
        long sid = Long.valueOf("61130500001");
        Student s = sdao.getStudentById(sid);

        System.out.println(s.getLast_time());

        System.out.println(getDate(s.getLast_time()));

        String pattern = "dd/MM/yyyy HH:mm:ss";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(getDate(s.getLast_time()));
        System.out.println(date);

        /*Facultydao fdao = new Facultydao();
        ArrayList<Faculty> faculties = new ArrayList();
        faculties = fdao.getAllFaculty();
        //System.out.println(faculties);

        Studentdao sdao = new Studentdao();
        ArrayList<Student> students = sdao.getAllStudentLike("q");
        System.out.println(students);

        String fid_bid = "12-02";
        String bid = null;
        for (int i = 0; i < fid_bid.length(); i++) {
            char j = fid_bid.charAt(i);
            if (j == '-') {
                bid = fid_bid.substring(i + 1);
            }
        }
        System.out.println(bid);
        long sid = Long.valueOf("61130500001");
        Student tests = sdao.getStudentById(sid);
        System.out.println(tests);
        tests.setAccount_status("pending");
        tests.setPassword("123");
        sdao.editStudentInfo(tests);
        System.out.println(tests);

        String rsd = "2019-11-11T20:22:56";
        
        String x = rsd.replace("T", " ");
        
        System.out.println(Timestamp.valueOf(x));
         */
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count++;
            if (count % 3 == 0) {
                System.out.println("rounded");
            }
        }

        Quizdao dq = new Quizdao();
        //System.out.println(dq.findQuizzesByCode("HHQ123"));

        String hours = "2";
        String minutes = "00";

        String time = hours + ":" + minutes;

        System.out.println(time);

        Question q = new Question();

        /*Choice c = new Choice();
        Choicedao cdao = new Choicedao();

        if (cdao.findCorrectChoiceById(Integer.valueOf(1)).isChoiceCorrect().equals("true")) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }*/

    }

    public static String RequiredString(int n) {
        byte[] array = new byte[256];
        new Random().nextBytes(array);
        String randomString
                = new String(array, Charset.forName("UTF-8"));
        StringBuffer ra = new StringBuffer();
        for (int i = 0; i < randomString.length(); i++) {
            char ch = randomString.charAt(i);
            if (((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) && (n > 0)) {
                ra.append(ch);
                n--;
            }
        }
        return ra.toString();
    }

    public static Date getDate(Timestamp timestamp) {
        return new Date(timestamp.getTime());
    }

}
