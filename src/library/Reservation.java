/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library;

import java.util.GregorianCalendar;

/**
 *
 * @author Bishal Timilsina
 */
class Reservation {
    private GregorianCalendar statusDate;
    private String status; // either want2reserve or onHold or fulfilled or cancelled
    
    private Member member;
    private Publication publication;
    private Copy copy;
    
    public Reservation(Member m,Publication p){
        member=m;
        publication=p; 
        m.addReservation(this);
        p.addReservation(this);        
    }
    
    /**
     * @return the statusDate
     */
    public GregorianCalendar getStatusDate() {
        return statusDate;
    }

    /**
     * @param statusDate the statusDate to set
     */
    public void setStatusDate(GregorianCalendar statusDate) {
        this.statusDate = statusDate;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the member
     */
    public Member getMember() {
        return member;
    }

    /**
     * @param member the member to set
     */
    public void setMember(Member member) {
        this.member = member;
    }

    /**
     * @return the copy
     */
    public Copy getCopy() {
        return copy;
    }

    /**
     * @param copy the copy to set
     */
    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    /**
     * @return the publication
     */
    public Publication getPublication() {
        return publication;
    }

    /**
     * @param publication the publication to set
     */
    public void setPublication(Publication publication) {
        this.publication = publication;
    }
    
    public void cancel(){
        
    }
    
    public void hold(Copy c){
        this.setStatus("hold");
        this.setStatusDate(new GregorianCalendar());
        this.setCopy(c);        
    }
    
    public Loan pickup(){
        this.setStatus("fulfilled");
        this.setStatusDate(new GregorianCalendar());
        this.getCopy().setStatus("available");
        return this.getMember().loan(this.getCopy());
    }
//
//    private String findStatus(Member m, Publication p, GregorianCalendar d) {
//        String status="";
//        
//        // Check if copies of pub p are available => 'onHold'   else    =>want2Reserve
//        // 
//        
//        return status;
//    }
    
}
