
import controllers.Facultydao;
import java.util.ArrayList;
import model.Faculty;

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
        System.out.println(faculties);
    }
}
