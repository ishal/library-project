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
class Magazine extends Publication{
    private int issueNo;

    public Magazine(String title,int isNo) {
        super(title);
        issueNo=isNo;
    }

    /**
     * @return the issueNo
     */
    public int getIssueNo() {
        return issueNo;
    }

    @Override
    public String getClassName() {
        return "Magazine";
    }
    
    
}
