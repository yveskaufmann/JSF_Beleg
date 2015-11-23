package de.htw_berlin.ai_bachelor.kbe.counter;

public class App
{
    public static void main( String[] args ) {
        Counter cnt = CounterFactory.getInstance("Simple");
        System.out.println( "CounterState: " + cnt.increment().increment().getCount() );
    }
}
