/*******************************************************************************
 * Copyright (c) 2013 Michael Vorburger.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Michael Vorburger - initial API and implementation
 ******************************************************************************/
package com.googlecode.efactory.ui.contentassist;

import org.eclipse.emf.ecore.EAttribute;

/**
 * Proposal Provider for an EAttribute in EFactory.
 *
 * @author Michael Vorburger
 */
public interface IEAttributeStringProposalProvider {

	String[] getProposals(EAttribute eAttribute);
	
}
