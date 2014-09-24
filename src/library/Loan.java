/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author Bishal Timilsina
 */
class Loan {
    private GregorianCalendar checkoutDate;
    private GregorianCalendar returnDate;
    
    private Member borrower;
    private Copy relCopy;
    
    
    
    public Loan(Member m,Copy c){
        borrower=m;        
        relCopy=c;
        checkoutDate=new GregorianCalendar();
        returnDate=(GregorianCalendar)checkoutDate.clone();
        if(c.getPublication().getClassName()=="Book") returnDate.add((GregorianCalendar.DATE), 21);
        else    returnDate.add((GregorianCalendar.DATE), 7);
    }

    public Loan(Member m,Copy c,GregorianCalendar b,GregorianCalendar r){
        borrower=m;        
        relCopy=c;
        checkoutDate=b;
        returnDate=r;        
    }
    
    /**
     * @return the checkoutDate
     */
    public GregorianCalendar getCheckoutDate() {
        return checkoutDate;
    }

    /**
     * @param checkoutDate the checkoutDate to set
     */
    public void setCheckoutDate(GregorianCalendar checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    /**
     * @return the returnDate
     */
    public GregorianCalendar getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(GregorianCalendar returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * @return the borrower
     */
    public Member getBorrower() {
        return borrower;
    }

    /**
     * @return the relCopy
     */
    public Copy getRelCopy() {
        return relCopy;
    }
    
    public Loan returned(){
        this.setReturnDate(new GregorianCalendar());
        return this;
    }

    public Loan loan() {
        String sts=this.relCopy.getStatus();
        if(sts.trim().equals("available")){
                this.relCopy.setStatus("loaned");
                return this;
        }else 
                return null;
    }
         
    /**
     * @param relCopy the relCopy to set
     */
    public void setRelCopy(Copy relCopy) {
        this.relCopy = relCopy;
    }
}

/*            
    if(this.relCopy.getCopyNo()==ln.relCopy.getCopyNo() && this.relCopy.getPublication()==ln.relCopy.getPublication() && ln.relCopy.getStatus().equals("loaned"))
       return false;
*/