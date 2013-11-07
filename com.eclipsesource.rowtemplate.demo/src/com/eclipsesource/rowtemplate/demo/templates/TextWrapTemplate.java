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

import org.eclipse.rap.rwt.internal.template.RowTemplate;
import org.eclipse.rap.rwt.internal.template.TextCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

@SuppressWarnings("restriction")
public class TextWrapTemplate extends RowTemplate {
  public TextWrapTemplate() {
    super();
    Display display = Display.getCurrent();
    TextCell firstNameLeft = new TextCell( this );
    firstNameLeft.setHorizontalAlignment( SWT.LEFT );
    firstNameLeft.setVerticalAlignment( SWT.TOP );
    firstNameLeft.setBindingIndex( 0 );
    firstNameLeft.setBackground( display.getSystemColor( SWT.COLOR_DARK_GREEN ) );
    firstNameLeft.setLeft( 4 );
    firstNameLeft.setTop( 4 );
    firstNameLeft.setWidth( 150 );
    firstNameLeft.setHeight( 90 );
    firstNameLeft.setSelectable( true );
    firstNameLeft.setForeground( display.getSystemColor( SWT.COLOR_WHITE ) );
    firstNameLeft.setWrap( true );
    TextCell firstNameCenter = new TextCell( this );
    firstNameCenter.setHorizontalAlignment( SWT.CENTER );
    firstNameCenter.setVerticalAlignment( SWT.TOP );
    firstNameCenter.setBindingIndex( 0 );
    firstNameCenter.setBackground( display.getSystemColor( SWT.COLOR_DARK_GREEN ) );
    firstNameCenter.setLeft( 158 );
    firstNameCenter.setTop( 4 );
    firstNameCenter.setWidth( 150 );
    firstNameCenter.setHeight( 90 );
    firstNameCenter.setSelectable( true );
    firstNameCenter.setForeground( display.getSystemColor( SWT.COLOR_WHITE ) );
    firstNameCenter.setWrap( true );
    TextCell firstNameRight = new TextCell( this );
    firstNameRight.setHorizontalAlignment( SWT.RIGHT );
    firstNameRight.setVerticalAlignment( SWT.TOP );
    firstNameRight.setBindingIndex( 0 );
    firstNameRight.setBackground( display.getSystemColor( SWT.COLOR_DARK_GREEN ) );
    firstNameRight.setLeft( 312 );
    firstNameRight.setTop( 4 );
    firstNameRight.setWidth( 150 );
    firstNameRight.setHeight( 90 );
    firstNameRight.setSelectable( true );
    firstNameRight.setForeground( display.getSystemColor( SWT.COLOR_WHITE ) );
    firstNameRight.setWrap( true );
    TextCell somethingElse = new TextCell( this );
    somethingElse.setHorizontalAlignment( SWT.RIGHT );
    somethingElse.setVerticalAlignment( SWT.TOP );
    somethingElse.setText( "No WRAP,\n but a linebreak" );
    somethingElse.setBackground( display.getSystemColor( SWT.COLOR_DARK_GREEN ) );
    somethingElse.setLeft( 472 );
    somethingElse.setTop( 4 );
    somethingElse.setWidth( 150 );
    somethingElse.setHeight( 90 );
    somethingElse.setSelectable( true );
    somethingElse.setForeground( display.getSystemColor( SWT.COLOR_WHITE ) );
    somethingElse.setWrap( false );
  }

}