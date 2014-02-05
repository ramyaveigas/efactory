/*******************************************************************************
 * Copyright (c) 2009 Sebastian Benz.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Sebastian Benz - initial API and implementation
 *     Michael Vorburger - completely valid text, and use of cursorBack()
 ******************************************************************************/
package com.googlecode.efactory.ui.contentassist.tests;

import org.junit.Test;

public class FeatureProposalProviderTest extends AbstractEFactoryContentAssistProcessorTest {

	private static final String body = "use testmodel.* "
			+ "TestModel testModelName {\n"
			+ "referenceTestContainer: [ ReferenceTestContainer test1 {  } ] }";

	@Test
	public void testCompleteFeatures_All() throws Exception {
		newBuilder().append(body).cursorBack(6).assertText("containments", "referenceToOne",
				"referenceToMany", "name", "containment", "oneAttribute",
				"manyAttributes");
	}

	@Test
	public void testCompleteFeaturesWithSingleContainmentAlreadyUsed() throws Exception {
		newBuilder().append(body).cursorBack(6)
				.insert("containment: ReferenceTarget target1 {  }\n")
				.assertText("containments", "referenceToOne",
						"referenceToMany", "name",
						"oneAttribute", "manyAttributes");
						// NOTE: does not contain "containment"
	}

	@Test
	public void testCompleteFeaturesWithMultiValueContainmentAlreadyUsed() throws Exception {
		newBuilder().append(body).cursorBack(6)
				.insert("containments: [ ReferenceTarget target1 { } ]\n")
				.assertText("containment", "referenceToOne",
						"referenceToMany", "name", "oneAttribute",
						"manyAttributes");
						// NOTE: does not contain "containments"
	}

}
