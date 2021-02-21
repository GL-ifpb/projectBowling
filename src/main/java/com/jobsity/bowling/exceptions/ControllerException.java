/**
 * @author Giuliano Lins
 * 
 */

package com.jobsity.bowling.exceptions;

public class ControllerException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1429565420779678800L;

	public ControllerException(String message, Throwable t) {
		super(message, t);
	}
	
}
