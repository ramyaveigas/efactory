/*******************************************************************************
 * Copyright (c) 2013 Michael Vorburger and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   Michael Vorburger - Initial API and implementation
 ******************************************************************************/

package com.googlecode.efactory.building;

/**
 * Exception for stuff going wrong in the ModelBuilder.
 * 
 * @author Michael Vorburger
 */
public class ModelBuilderException extends Exception {
	private static final long serialVersionUID = 218749336949211916L;

	public ModelBuilderException(String message) {
		super(message);
	}

	public ModelBuilderException(String message, Throwable e) {
		super(message, e);
	}
}
