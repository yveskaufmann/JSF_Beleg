package de.htw_berlin.ai_bachelor.kbe;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import java.util.Date;
import java.util.logging.Logger;

@ApplicationScoped
@ManagedBean(name = "clock")
public class ClockMB {

	private final Logger log = Logger.getLogger(ClockMB.class.getName());

	public ClockMB() {
	}

	public Date getNow() {
		return new Date();
	}

	public String goToIndex() {
		return "showTime";
	}

}
