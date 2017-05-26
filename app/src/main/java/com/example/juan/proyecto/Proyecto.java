/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author juan
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        API api = new API();
        System.out.println(api.register("carl", "Carlos", "1234", 25, "asdf@asdf2.com")  != null );
        
        User u = api.login("carl", "1234");
        System.out.println(u == null);
        System.out.println(u instanceof Limitado);
        System.out.println(u instanceof admin);
        System.out.println(u instanceof Contenido);
    }
    
}
