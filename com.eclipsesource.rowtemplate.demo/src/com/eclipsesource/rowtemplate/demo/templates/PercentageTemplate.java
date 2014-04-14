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

public class PercentageTemplate extends Template {
  public PercentageTemplate() {
    super();
    Display display = Display.getCurrent();
    TextCell firstNameCell = new TextCell( this );
    firstNameCell.setHorizontalAlignment( SWT.CENTER );
    firstNameCell.setVerticalAlignment( SWT.CENTER );
    firstNameCell.setBindingIndex( 0 );
    firstNameCell.setBackground( display.getSystemColor( SWT.COLOR_GREEN ) );
    firstNameCell.setLeft( 50, -90 );
    firstNameCell.setTop( 50, -20 );
    firstNameCell.setWidth( 180 );
    firstNameCell.setHeight( 40 );
    firstNameCell.setName( "firstname" );
    firstNameCell.setSelectable( true );
    firstNameCell.setWrap( true );
    firstNameCell.setForeground( display.getSystemColor( SWT.COLOR_RED ) );
    TextCell twentyP = new TextCell( this );
    twentyP.setText( "20%" );
    twentyP.setBackground( display.getSystemColor( SWT.COLOR_GRAY ) );
    twentyP.setLeft( 20, 0 );
    twentyP.setTop( 40, 0 );
    twentyP.setHeight( 20 );
    twentyP.setWidth( 60 );
    TextCell thirtyPsixty = new TextCell( this );
    thirtyPsixty.setBackground( display.getSystemColor( SWT.COLOR_GRAY ) );
    thirtyPsixty.setText( "20% + 70px" );
    thirtyPsixty.setLeft( 20, 70 );
    thirtyPsixty.setTop( 40, 0 );
    thirtyPsixty.setHeight( 20 );
    thirtyPsixty.setWidth( 120 );
    TextCell round1 = new TextCell( this );
    round1.setBackground( display.getSystemColor( SWT.COLOR_GRAY ) );
    round1.setText( "50% > 66.6%" );
    round1.setLeft( 50, 0 );
    round1.setTop( 40, 0 );
    round1.setHeight( 20 );
    round1.setRight( 33.33f, 0 );
    TextCell attach2 = new TextCell( this );
    attach2.setBackground( display.getSystemColor( SWT.COLOR_GRAY ) );
    attach2.setText( "66.6% + 1px" );
    attach2.setLeft( 66.66f, 1 );
    attach2.setTop( 40, 0 );
    attach2.setHeight( 20 );
    attach2.setRight( 0, 0 );
  }
}