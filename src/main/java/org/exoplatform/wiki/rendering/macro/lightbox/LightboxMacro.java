package org.exoplatform.wiki.rendering.macro.lightbox;

/*
 * Copyright (C) 2003-2012 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */

import java.util.Collections;
import java.util.List;

import org.xwiki.component.annotation.Component;
import org.xwiki.rendering.block.Block;
import org.xwiki.rendering.block.RawBlock;
import org.xwiki.rendering.macro.AbstractMacro;
import org.xwiki.rendering.macro.MacroExecutionException;
import org.xwiki.rendering.syntax.Syntax;
import org.xwiki.rendering.syntax.SyntaxType;
import org.xwiki.rendering.transformation.MacroTransformationContext;

/**
 * Simple Lightbox Macro.
 */
@Component("lightbox")
public class LightboxMacro extends AbstractMacro<LightboxMacroParameters> {
	/**
	 * The description of the macro.
	 */
	private static final String DESCRIPTION = "Simple Lightbox Macro for eXo Wiki";

	/**
	 * The syntax representing the output of this macro (used for the RawBlock).
	 */
	private static final Syntax XHTML_SYNTAX = new Syntax(SyntaxType.XHTML,
			"1.0");

	/**
	 * Create and initialize the descriptor of the macro.
	 */
	public LightboxMacro() {
		super("Lightbox", DESCRIPTION, LightboxMacroParameters.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.xwiki.rendering.macro.Macro#execute(Object, String,
	 *      MacroTransformationContext)
	 */
	public List<Block> execute(LightboxMacroParameters parameters, String content,
			MacroTransformationContext context) throws MacroExecutionException {
		 StringBuilder sb = new StringBuilder();
		 String imageURL = parameters.getImageURL();
		 sb.append("<p><a href = 'javascript:void(0)' onclick =\"document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'\"> <img src='" + imageURL + "' height='25%' width='25%' /></a></p>");		  
		 sb.append("<div align='center' id='light' style='display: none; position: absolute; top: 25%; left: 25%; width: 50%;  padding: 5px; background-color: white; z-index:1002; overflow: auto;'><a href = 'javascript:void(0)' onclick = \"document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'\"><img src='" + imageURL + "'  width='100%' /></a></div>");
		 sb.append("<div id='fade' style='display: none; position: absolute; top: 0%; left: 0%; width: 100%; height: 100%; background-color: black; z-index:1001; -moz-opacity: 0.8; opacity:.80; filter: alpha(opacity=80);'></div>");
		 RawBlock rawBlock = new RawBlock(sb.toString(), XHTML_SYNTAX);
		
		 return Collections.singletonList((Block) rawBlock);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.xwiki.rendering.macro.Macro#supportsInlineMode()
	 */
	public boolean supportsInlineMode() {
		return true;
	}
	
}
