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
abstract class Publication {
    private String title;
    
    private List<Copy> copies;
    private List<Reservation> reservations;

    public Publication(String title){
        this.title=title;
        copies=new ArrayList<Copy>();
        reservations=new ArrayList<Reservation>();
    }
    
    public void addCopy(Copy c){
        copies.add(c);        
    }
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the copies
     */
    public List<Copy> getCopies() {
        return copies;
    }

    /**
     * @param copies the copies to set
     */
    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }

    /**
     * @return the reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * @param reservations the reservations to set
     */
    public void setReservation(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public abstract String getClassName();
    
}
