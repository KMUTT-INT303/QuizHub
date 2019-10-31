
import controllers.Facultydao;
import controllers.Studentdao;
import java.util.ArrayList;
import model.Faculty;
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

    public static void main(String[] args) {
        Facultydao fdao = new Facultydao();
        ArrayList<Faculty> faculties = new ArrayList();
        faculties = fdao.getAllFaculty();
        //System.out.println(faculties);
        
        
        Studentdao sdao = new Studentdao();
        ArrayList<Student> students = sdao.getAllStudentLike("q");
        System.out.println(students);
        
        
        String fid_bid = "12-02";
        String bid = null;
        for(int i =0;i<fid_bid.length();i++){
            char j = fid_bid.charAt(i);
            if(j == '-'){
                bid = fid_bid.substring(i+1);
            }
        }
        System.out.println(bid);
    }
}
