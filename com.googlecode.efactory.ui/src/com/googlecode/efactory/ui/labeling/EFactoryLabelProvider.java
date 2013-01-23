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
/*
 * generated by Xtext
 */
package com.googlecode.efactory.ui.labeling;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.AbstractLabelProvider;

import com.google.inject.Inject;
import com.googlecode.efactory.building.NameAccessor;
import com.googlecode.efactory.building.NoNameFeatureMappingException;
import com.googlecode.efactory.resource.EFactoryResource;

/**
 * 
 */
public class EFactoryLabelProvider extends AbstractLabelProvider {

	@Inject
	private NameAccessor nameAccessor;

	@Inject
	protected EFactoryLabelProvider(AdapterFactory adapterFactory) {
		super(new AdapterFactoryLabelProvider(adapterFactory));
	}

	@Override
	protected Object doGetText(Object element) {
		if (element instanceof DynamicEObjectImpl) {
			DynamicEObjectImpl eObject = (DynamicEObjectImpl) element;
			if (eObject.eResource() instanceof EFactoryResource) {
				EFactoryResource eFactoryResource = (EFactoryResource) eObject
						.eResource();
				EObject context = eFactoryResource.getFactory();
				try {
					return nameAccessor.getName(context, eObject);
				} catch (NoNameFeatureMappingException e) {
					return eObject.eClass().getName();
				}
			}
		}
		return super.doGetText(element);
	}

}
