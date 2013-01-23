/*******************************************************************************
 * Copyright (c) 2009 Sebastian Benz.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Sebastian Benz - initial API and implementation
 ******************************************************************************/
package com.googlecode.efactory.proposal.tests;

public class MultiplicityProposalProviderTest extends
		AbstractContentAssistProcessorTest {

	private static final String body = "use \"http://testmodel/1.0\" "
			+ "TestModel testModelName {\n"
			+ "referenceTestContainer +=ReferenceTestContainer test1 {\n";

	public void testMultiplicityAttribute_One() throws Exception {
		newBuilder().append(body + "oneAttribute ").assertText("=");
	}

	public void testMultiplicityAttribute_Many() throws Exception {
		newBuilder().append(body + "manyAttributes ").assertText("+=");
	}

	public void testMultiplicityContainment_One() throws Exception {
		newBuilder().append(body + "containment ").assertText("=");
	}

	public void testMultiplicityContainment_Many() throws Exception {
		newBuilder().append(body + "containments ").assertText("+=");
	}

	public void testMultiplicityReference_One() throws Exception {
		newBuilder().append(body + "referenceToOne ").assertText("=");
	}

	public void testMultiplicityReference_Many() throws Exception {
		newBuilder().append(body + "referenceToMany ").assertText("+=");
	}

}
