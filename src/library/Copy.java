/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Bishal Timilsina
 */
class Copy {
    private int copyNo;
    private String status;
    
    private List<Loan> loans;
    private Reservation reservation;
    private Publication publication;

    public Copy(int cn,Publication p,String status){
        copyNo=cn;
        publication=p; 
        this.status=status;
        loans=new ArrayList<Loan>();
    }
    
    public Copy(int cn,Publication p){
        copyNo=cn;
        publication=p; 
        status="available";
        loans=new ArrayList<Loan>();
    }
    
    /**
     * @return the copyNo
     */
    public int getCopyNo() {
        return copyNo;
    }

    /**
     * @param copyNo the copyNo to set
     */
    public void setCopyNo(int copyNo) {
        this.copyNo = copyNo;
    }

    /**
     * @return the loans
     */
    public List<Loan> getLoans() {
        return loans;
    }

    /**
     * @param loans the loans to set
     */
    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    /**
     * @return the reservation
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * @param reservation the reservation to set
     */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
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

    void addLoan(Loan aThis) {
        loans.add(aThis);
        aThis.setRelCopy(this);
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
    
    public void reserve(){
        
    }
    
    public void loan(){
        
    }
    
    public Loan returnIt(){
        Loan ln=null;
        
        for(Loan l:this.getLoans()){
//            System.out.println(l.getBorrower().getFirstName()+":"+l.getReturnDate());
            if(l.getReturnDate().compareTo(new GregorianCalendar())>=0){
//                System.out.println("Fil"+l.getBorrower().getFirstName()+":"+l.getReturnDate());
                ln=l.returned();   
//                System.out.println("Fil2"+ln.getBorrower().getFirstName()+":"+ln.getReturnDate());
                
                List<Reservation> relRes=this.getPublication().getReservations();
                List<Reservation> RelRes=new ArrayList<Reservation>();
                for(Reservation r:relRes){
                    if(r.getStatus().equals("pending"))
                        RelRes.add(r);
                }
                
                if(RelRes.size()>0){
                    // get latest reservation if history of reservation by a customer was maintained.
                    
                    Reservation rh=RelRes.get(0);
                    
                    for(Reservation r:RelRes){
                        if(rh.getStatusDate().compareTo(r.getStatusDate())>0)
                            rh=r;
                    }
                    
                    this.status="hold";
                    rh.hold(this);   
                    
                }
                else{                
                    this.status="available";                    
                }
                
                break;
            }                
        }
        
        return ln;
    }
    
    public void hold(){
        
    }
}
