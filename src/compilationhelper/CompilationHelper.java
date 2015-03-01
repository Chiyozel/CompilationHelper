/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilationhelper;

import java.util.Scanner;
import utils.TaikoReader;

/**
 *
 * @author Gezochan
 */
public class CompilationHelper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(
                "What do you want to do?\n"
                + "1.\tCreate a marathon\n"
                + "2.\tModify a Taiko map\n"
                + "Other choice:\tExit"
        );

        int choix = sc.nextInt();

        switch (choix) {
            case 1:
                MarathonHelper noteChart = new MarathonHelper();
                break;
            case 2:
                TaikoReader taikoReader = new TaikoReader();
                break;
            default:
                System.exit(0);
        }

    }

}
