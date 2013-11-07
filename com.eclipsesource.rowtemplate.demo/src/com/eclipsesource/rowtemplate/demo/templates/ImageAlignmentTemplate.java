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

import org.eclipse.rap.rwt.internal.template.ImageCell;
import org.eclipse.rap.rwt.internal.template.RowTemplate;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

@SuppressWarnings("restriction")
public class ImageAlignmentTemplate extends RowTemplate {

  public ImageAlignmentTemplate() {
    super();
    Display display = Display.getCurrent();
    ImageCell leftTop = new ImageCell( this );
    leftTop.setHorizontalAlignment( SWT.LEFT );
    leftTop.setVerticalAlignment( SWT.TOP );
    leftTop.setBindingIndex( 0 );
    leftTop.setBackground( display.getSystemColor( SWT.COLOR_DARK_GREEN ) );
    leftTop.setLeft( 4 );
    leftTop.setTop( 4 );
    leftTop.setWidth( 70 );
    leftTop.setHeight( 70 );
    leftTop.setSelectable( true );
    ImageCell centerCenter = new ImageCell( this );
    centerCenter.setHorizontalAlignment( SWT.CENTER );
    centerCenter.setVerticalAlignment( SWT.CENTER );
    centerCenter.setBindingIndex( 0 );
    centerCenter.setBackground( display.getSystemColor( SWT.COLOR_DARK_GREEN ) );
    centerCenter.setLeft( 78 );
    centerCenter.setTop( 4 );
    centerCenter.setWidth( 70 );
    centerCenter.setHeight( 70 );
    centerCenter.setSelectable( true );
    ImageCell rightBottom = new ImageCell( this );
    rightBottom.setHorizontalAlignment( SWT.RIGHT );
    rightBottom.setVerticalAlignment( SWT.BOTTOM );
    rightBottom.setBindingIndex( 0 );
    rightBottom.setBackground( display.getSystemColor( SWT.COLOR_DARK_GREEN ) );
    rightBottom.setLeft( 152 );
    rightBottom.setTop( 4 );
    rightBottom.setWidth( 70 );
    rightBottom.setHeight( 70 );
    rightBottom.setSelectable( true );
  }

}