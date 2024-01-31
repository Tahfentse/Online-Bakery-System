/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package za.ac.Exception;

/**
 *
 * @author Train
 */
public class UserExist extends RuntimeException {

    /**
     * Creates a new instance of <code>UserExist</code> without detail message.
     */
    public UserExist() {
    }

    /**
     * Constructs an instance of <code>UserExist</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public UserExist(String msg) {
        
        super(msg);
        
    }
}
