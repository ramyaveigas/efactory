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
package com.googlecode.efactory.ui.contentassist.tests;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.ui.AbstractContentAssistProcessorTest;

import com.google.inject.Injector;
import com.googlecode.efactory.EFactoryUiInjectorProvider;

@SuppressWarnings("restriction")
public abstract class AbstractEFactoryContentAssistProcessorTest extends AbstractContentAssistProcessorTest {

	@Override
	protected ISetup doGetSetup() {
		return new ISetup() {
			public Injector createInjectorAndDoEMFRegistration() {
				return new EFactoryUiInjectorProvider().getInjector();
			}
			@SuppressWarnings("unused")
			public void register(Injector injector) {
				// do nothing
			}
		};
	}

	protected ContentAssistProcessorTestBuilder2 newBuilder() throws Exception {
		return newBuilder(getSetup());
	}
	
	@Override
	protected ContentAssistProcessorTestBuilder2 newBuilder(ISetup setup) throws Exception {
		return new ContentAssistProcessorTestBuilder2(setup, this);
	}

}
