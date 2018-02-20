/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isogenic;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.packager.GenericPackager;

/**
 *
 * @author root
 */
public class ISOgenic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String iso = "";
        String mti = "2210";
        String pan = "98765";
        String amount = "3600000000100000"; //2 digit terakhir itu desimal
        String stan = "000006111152";
        String dt = new SimpleDateFormat("YYYYMMddHHmmss").format(new Date()); 
        String merchant_code = "6021";
        String bank_code = "4510017";
        String cid = "4567898"; 
        String terminal = "0000000000000477";
        String bit48 = "ST145S352001213995910145188175200121399593500080000000SUKRIS BINTARA            52001123              B1000000900000000000201504200420150000000000000152480D00000000000000000000000003000008728000089880000000000000000000000000000000000";
        
        try {
           
            // membuat sebuah packager
            ISOPackager packager = new GenericPackager("iso2003ascii.xml");

            // Create ISO Message
            ISOMsg isoMsg = new ISOMsg();
            isoMsg.setPackager(packager);
            isoMsg.setMTI(mti);
            isoMsg.set(2,pan);
            isoMsg.set(4,amount);
            isoMsg.set(11,String.format("%12s", stan).replace(' ', '0'));
            isoMsg.set(12,dt);
            isoMsg.set(26,merchant_code);
            isoMsg.set(32,bank_code);
            isoMsg.set(33,cid);
            isoMsg.set(39,"0000");
            isoMsg.set(41,terminal);
            isoMsg.set(48,bit48);

            byte[] datax = isoMsg.pack();
            System.out.println("The rebuilt ISO : " + new String(datax));
            iso = new String(datax);
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
