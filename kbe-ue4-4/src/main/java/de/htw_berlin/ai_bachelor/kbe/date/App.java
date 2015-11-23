package de.htw_berlin.ai_bachelor.kbe.date;

import de.htw_berlin.ai_bachelor.kbe.date.format.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FormatedDate fDate = new FormatedDate(15, 10, 2015); 
        System.out.println(fDate);
        fDate.setDateFormat(new DateFormatISO());
        System.out.println(fDate);
    }
}
