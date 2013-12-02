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
package com.googlecode.efactory.formatting;

import java.util.List;

import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

import com.googlecode.efactory.services.EFactoryGrammarAccess;

public class EFactoryFormatter extends AbstractDeclarativeFormatter {

	private static final String COLON = ":";     //$NON-NLS-1$
	private static final String R_BRACE = "}";   //$NON-NLS-1$
	private static final String L_BRACE = "{";   //$NON-NLS-1$
	private static final String L_PAREN = "(";   //$NON-NLS-1$
	private static final String L_BRACKET = "["; //$NON-NLS-1$
	private static final String R_PAREN = ")";   //$NON-NLS-1$
	private static final String R_BRACKET = "]"; //$NON-NLS-1$
	private static final String DOT = ".";       //$NON-NLS-1$
	private static final String COMMA = ",";     //$NON-NLS-1$

	@Override
	protected void configureFormatting(FormattingConfig c) {
		EFactoryGrammarAccess f = (EFactoryGrammarAccess) getGrammarAccess();
		Iterable<Keyword> keywords = GrammarUtil.containedKeywords(f.getGrammar());
		List<ParserRule> parserRules = GrammarUtil.allParserRules(f.getGrammar());
		addKeywords(c, keywords);
		new IntendationFormatter(L_BRACE, R_BRACE).apply(c, keywords);
		new GenericLineBreakFormatter().apply(c, parserRules);
		addSpecificFormattingRules(c, f);
	}

	private void addSpecificFormattingRules(FormattingConfig c,	EFactoryGrammarAccess f) {
		c.setLinewrap().before(
				f.getFeatureAccess()
						.getEFeatureEStructuralFeatureCrossReference_0_0());
		c.setLinewrap(2).after(
				f.getPackageImportAccess()
						.getEPackageEPackageQualifiedNameParserRuleCall_1_0_1());
	}

	private void addKeywords(FormattingConfig c, Iterable<Keyword> keywords) {

		SimpleKeywordFormatter.create(L_PAREN,
				new Procedure2<FormattingConfig, Keyword>() {
					public void apply(FormattingConfig config, Keyword keyword) {
						config.setNoSpace().around(keyword);
					}
				}).apply(c, keywords);

		SimpleKeywordFormatter.create(L_BRACKET,
				new Procedure2<FormattingConfig, Keyword>() {
					public void apply(FormattingConfig config, Keyword keyword) {
						config.setNoSpace().around(keyword);
					}
				}).apply(c, keywords);

		SimpleKeywordFormatter.create(R_PAREN,
				new Procedure2<FormattingConfig, Keyword>() {
					public void apply(FormattingConfig config, Keyword keyword) {
						config.setNoSpace().around(keyword);
					}
				}).apply(c, keywords);

		SimpleKeywordFormatter.create(R_BRACKET,
				new Procedure2<FormattingConfig, Keyword>() {
					public void apply(FormattingConfig config, Keyword keyword) {
						config.setNoSpace().before(keyword);
					}
				}).apply(c, keywords);

		SimpleKeywordFormatter.create(DOT,
				new Procedure2<FormattingConfig, Keyword>() {
					public void apply(FormattingConfig config, Keyword keyword) {
						config.setNoSpace().around(keyword);
					}
				}).apply(c, keywords);

		SimpleKeywordFormatter.create(COLON,
				new Procedure2<FormattingConfig, Keyword>() {
					public void apply(FormattingConfig config, Keyword keyword) {
						config.setNoSpace().after(keyword);
					}
				}).apply(c, keywords);

		SimpleKeywordFormatter.create(COMMA,
				new Procedure2<FormattingConfig, Keyword>() {
					public void apply(FormattingConfig config, Keyword keyword) {
						config.setNoSpace().before(keyword);
						config.setLinewrap().after(keyword);
					}
				}).apply(c, keywords);

	}
}
