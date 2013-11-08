/*******************************************************************************
 * Copyright (c) 2013 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.rowtemplate.demo.templates;

import org.eclipse.rap.rwt.template.Template;
import org.eclipse.rap.rwt.template.TextCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

@SuppressWarnings("restriction")
public class TextAlignmentTemplate extends Template {
  public TextAlignmentTemplate() {
    super();
    Display display = Display.getCurrent();
    TextCell firstNameCell = new TextCell( this );
    firstNameCell.setHorizontalAlignment( SWT.LEFT );
    firstNameCell.setVerticalAlignment( SWT.TOP );
    firstNameCell.setBindingIndex( 0 );
    firstNameCell.setBackground( display.getSystemColor( SWT.COLOR_DARK_GREEN ) );
    firstNameCell.setLeft( 4 );
    firstNameCell.setTop( 4 );
    firstNameCell.setWidth( 100 );
    firstNameCell.setHeight( 50 );
    firstNameCell.setSelectable( true );
    firstNameCell.setForeground( display.getSystemColor( SWT.COLOR_WHITE ) );
    TextCell lastNameCell = new TextCell( this );
    lastNameCell.setHorizontalAlignment( SWT.CENTER );
    lastNameCell.setVerticalAlignment( SWT.CENTER );
    lastNameCell.setBindingIndex( 1 );
    lastNameCell.setLeft( 110 );
    lastNameCell.setTop( 4 );
    lastNameCell.setWidth( 100 );
    lastNameCell.setHeight( 50 );
    lastNameCell.setBackground( display.getSystemColor( SWT.COLOR_DARK_GREEN ) );
    lastNameCell.setForeground( display.getSystemColor( SWT.COLOR_WHITE ) );
    TextCell phoneCell = new TextCell( this );
    phoneCell.setHorizontalAlignment( SWT.RIGHT );
    phoneCell.setVerticalAlignment( SWT.BOTTOM );
    phoneCell.setBindingIndex( 2 );
    phoneCell.setLeft( 220 );
    phoneCell.setTop( 4 );
    phoneCell.setWidth( 150 );
    phoneCell.setHeight( 50 );
    phoneCell.setBackground( display.getSystemColor( SWT.COLOR_DARK_GREEN ) );
    phoneCell.setForeground( display.getSystemColor( SWT.COLOR_WHITE ) );
  }
}