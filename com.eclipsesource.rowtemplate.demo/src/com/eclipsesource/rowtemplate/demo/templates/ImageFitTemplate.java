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

import org.eclipse.rap.rwt.template.ImageCell;
import org.eclipse.rap.rwt.template.ImageCell.ScaleMode;
import org.eclipse.rap.rwt.template.Template;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

public class ImageFitTemplate extends Template {

  public ImageFitTemplate() {
    super();
    Display display = Display.getCurrent();
    ImageCell growVerticalFit = new ImageCell( this );
    growVerticalFit.setHorizontalAlignment( SWT.LEFT ); // must be ignored
    growVerticalFit.setVerticalAlignment( SWT.TOP ); // must be ignored
    growVerticalFit.setBindingIndex( 0 );
    growVerticalFit.setScaleMode( ScaleMode.FIT );
    growVerticalFit.setBackground( display.getSystemColor( SWT.COLOR_DARK_GREEN ) );
    growVerticalFit.setLeft( 4 ).setTop( 4 ).setWidth( 70 ).setHeight( 60 );
    growVerticalFit.setSelectable( true );
    ImageCell growHorizontalFit = new ImageCell( this );
    growHorizontalFit.setScaleMode( ScaleMode.FIT );
    growHorizontalFit.setHorizontalAlignment( SWT.LEFT ); // must be ignored
    growHorizontalFit.setVerticalAlignment( SWT.TOP ); // must be ignored
    growHorizontalFit.setBindingIndex( 0 );
    growHorizontalFit.setBackground( display.getSystemColor( SWT.COLOR_DARK_GREEN ) );
    growHorizontalFit.setLeft( 78 ).setTop( 4 ).setWidth( 60 ).setHeight( 70 );
    growHorizontalFit.setSelectable( true );
    ImageCell shrinkVerticalFit = new ImageCell( this );
    shrinkVerticalFit.setScaleMode( ScaleMode.FIT );
    shrinkVerticalFit.setHorizontalAlignment( SWT.LEFT ); // must be ignored
    shrinkVerticalFit.setVerticalAlignment( SWT.TOP ); // must be ignored
    shrinkVerticalFit.setBindingIndex( 0 );
    shrinkVerticalFit.setBackground( display.getSystemColor( SWT.COLOR_DARK_GREEN ) );
    shrinkVerticalFit.setLeft( 142 ).setTop( 4 ).setWidth( 40 ).setHeight( 30 );
    shrinkVerticalFit.setSelectable( true );
    ImageCell shrinkHorizontalFit = new ImageCell( this );
    shrinkHorizontalFit.setScaleMode( ScaleMode.FIT );
    shrinkHorizontalFit.setHorizontalAlignment( SWT.LEFT ); // must be ignored
    shrinkHorizontalFit.setVerticalAlignment( SWT.TOP ); // must be ignored
    shrinkHorizontalFit.setBindingIndex( 0 );
    shrinkHorizontalFit.setBackground( display.getSystemColor( SWT.COLOR_DARK_GREEN ) );
    shrinkHorizontalFit.setLeft( 186 ).setTop( 4 ).setWidth( 30 ).setHeight( 40 );
    shrinkHorizontalFit.setSelectable( true );
  }

}