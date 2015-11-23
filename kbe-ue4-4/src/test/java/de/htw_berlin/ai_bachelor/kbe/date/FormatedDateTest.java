package de.htw_berlin.ai_bachelor.kbe.date;

import de.htw_berlin.ai_bachelor.kbe.date.format.*;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class FormatedDateTest {
	@Test
	public void setFormatStandard () {
		FormatedDate fDate = new FormatedDate();
		
		assertEquals(DateFormatCH.class, fDate.getDateFormat().getClass()); 
	}
	
	@Test
	public void setFormatStandardPreDate () {
		FormatedDate fDate = new FormatedDate(12, 3, 2015);
		
		assertEquals(DateFormatCH.class, fDate.getDateFormat().getClass()); 
	}
	
	@Test
	public void setFormatPreConfig () {
		FormatedDate fDate = new FormatedDate(new DateFormatUS(), 12, 3, 2015);
		
		assertEquals(DateFormatUS.class, fDate.getDateFormat().getClass()); 
	}
	
	@Test
	public void setFormatChange () {
		FormatedDate fDate = new FormatedDate(new DateFormatUS(), 12, 3, 2015);
		fDate.setDateFormat(new DateFormatISO());
		
		assertEquals(DateFormatISO.class, fDate.getDateFormat().getClass()); 
	}
}