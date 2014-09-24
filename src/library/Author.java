/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library;

import java.util.List;

/**
 *
 * @author Bishal Timilsina
 */
public class Author extends Person{
    private String credentials;
    private String shortBio;
    
    private List<Book> books;

    public Author(String firstName, String lastName, long phone,String cre,String bio) {
        super(firstName, lastName, phone);
        credentials=cre;
        shortBio=bio;
    }

    /**
     * @return the credentials
     */
    public String getCredentials() {
        return credentials;
    }

    /**
     * @return the shortBio
     */
    public String getShortBio() {
        return shortBio;
    }
}
