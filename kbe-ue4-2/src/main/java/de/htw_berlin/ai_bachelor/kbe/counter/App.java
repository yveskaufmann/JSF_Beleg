package de.htw_berlin.ai_bachelor.kbe.counter;

public class App 
{
    public static void main( String[] args ) {
        Counter cnt = CounterFactory.getInstance("Simple");
        cnt.increment();
        cnt.increment();
        cnt.increment();
        System.out.println( "CounterState: " + cnt.getCount() );
    }
}