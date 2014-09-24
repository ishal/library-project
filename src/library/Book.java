/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bishal Timilsina
 */
class Book extends Publication{
    private long ISBN;
    
    private List<Author> authors;

    public Book(String title,long isbn) {
        super(title);
        ISBN=isbn;
        authors=new ArrayList<Author>();
    }

    /**
     * @return the ISBN
     */
    public long getISBN() {
        return ISBN;
    }

    /**
     * @return the authors
     */
    public List<Author> getAuthors() {
        return authors;
    }

    /**
     * @param authors the authors to set
     */
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }       

    @Override
    public String getClassName() {
        return "Book";
    }
}
