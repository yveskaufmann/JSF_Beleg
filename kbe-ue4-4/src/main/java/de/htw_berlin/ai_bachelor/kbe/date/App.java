package de.htw_berlin.ai_bachelor.kbe.date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		Date date = new Date(15,10,2015);
        System.out.println(DateFormatterFactory.getInstance().format(date));
        System.out.println(DateFormatterFactory.getInstance("iso").format(date));
    }
}
