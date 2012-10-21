/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crm;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author kexital
 */
public class Intresting_code_achivemetnets {
    
    
    
    
     class dateUtil {
        Calendar calll = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat();

        private void del() {
            sdf.set2DigitYearStart(null);
    
        }
    //TODO to Notes and delete now();
    //<editor-fold defaultstate="collapsed" desc="to Notes. Nice method to get integer date year or smth defined by pattern providet to method">
        public Integer now(String dateFormat) {
        Calendar cal1 = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat(dateFormat);
        String str = sdf1.format(calll.getTime());
        //TODO Delete SystemOut as it is my checking
        System.out.println(str);
        return Integer.valueOf(str);
        
               
    }
    //</editor-fold>
        
        
//  deteUtil end
}


}
