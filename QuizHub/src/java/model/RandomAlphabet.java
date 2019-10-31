/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tsch
 */
public class RandomAlphabet {
    
    public String AZrandom() {
        String[] AZ = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String one = AZ[(int) (Math.random() * 26)];
        String second = AZ[(int) (Math.random() * 26)];
        String third = AZ[(int) (Math.random() * 26)];
        String fourth = AZ[(int) (Math.random() * 26)];
        String fifth = AZ[(int) (Math.random() * 26)];
        String sixth = AZ[(int) (Math.random() * 26)];
        String random = one + second + third + fourth + fifth + sixth;
        return random;
    }
    
}
