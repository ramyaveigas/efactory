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
package com.googlecode.efactory.serialization;

import org.eclipse.emf.ecore.EObject;

import com.googlecode.efactory.eFactory.NewObject;

/**
 * FactoryBuilder can turn an EObject into a NewObject.
 * 
 * Maybe the NewObject already existed and is just being found and returned,
 * or maybe an entirely new one is being created.
 * 
 * @author Michael Vorburger
 */
public interface IFactoryBuilder {

	NewObject getOrBuildNewObject(EObject eObject);

}