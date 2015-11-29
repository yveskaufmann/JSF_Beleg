package de.htw_berlin.ai_bachelor.kbe.date;

public class App 
{
    public static void main( String[] args )
    {
		Date date = Date.today();
        System.out.println(DateFormatterFactory.getInstance().format(date));
        System.out.println(DateFormatterFactory.getInstanceByName("iso").format(date));
		System.out.println(date);
	}
}
