/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Bishal Timilsina
 */
public class Member extends Person{
    private int memberNo;    
    private List<Loan> loans;
    private List<Reservation> reservations;

    public Member(String firstName, String lastName, long phone, int id) {
        super(firstName, lastName, phone);    
        memberNo=id;
        loans=new ArrayList<Loan>();
        reservations=new ArrayList<Reservation>();
    }
            
    public int getMemberNo() {
        return memberNo;
    }

    void addLoan(Loan aThis) {
        getLoans().add(aThis);
    }

    void addReservation(Reservation b) {
        reservations.add(b);
    }
    
    public void reserve(){
        
    }
    
    public Loan loan(Copy copy){//, Publication pub) {
//        System.out.println("Member.loan");         
        Loan ln=new Loan(this,copy);        
        return ln.loan();
    }
    
    public Loan returnIt(Copy c){
        Loan l=c.returnIt();
//        System.out.println("Fil3"+l.getBorrower().getFirstName()+":"+l.getReturnDate().get(Calendar.DAY_OF_MONTH));        
        return l;
    }
    
    public void cancelReservation(Reservation r){
        r.setStatus("cancelled");
        r.setStatusDate(new GregorianCalendar());
        if(r.getCopy()!=null){
            if(r.getCopy().getStatus().trim().equals("hold")){                 
                r.getCopy().setStatus("available");
            }
        } else{
            System.out.println("Copy was null");
        }
    }
    
    public Loan pickupReservation(Reservation r){
        return r.pickup();
    }

    /**
     * @return the loans
     */
    public List<Loan> getLoans() {
        return loans;
    }
    
}