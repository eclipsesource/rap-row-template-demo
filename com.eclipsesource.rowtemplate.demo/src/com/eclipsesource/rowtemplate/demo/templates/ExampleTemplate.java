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

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.rap.rwt.internal.template.Cell.CellAlignment;
import org.eclipse.rap.rwt.internal.template.ImageCell;
import org.eclipse.rap.rwt.internal.template.ImageCell.ScaleMode;
import org.eclipse.rap.rwt.internal.template.RowTemplate;
import org.eclipse.rap.rwt.internal.template.TextCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

@SuppressWarnings("restriction")
public class ExampleTemplate extends RowTemplate {
  public ExampleTemplate( TableViewer tableViewer ) {
    super();
    Display display = tableViewer.getTable().getDisplay();
    ImageCell imageCell = new ImageCell( this );
    imageCell.setAlignment( CellAlignment.BOTTOM, CellAlignment.TOP );
    imageCell.setBindingIndex( 0 );
    imageCell.setTop( 4 );
    imageCell.setLeft( 4 );
    imageCell.setWidth( 64 );
    imageCell.setHeight( 64 );
    imageCell.setSelectable( true );
    imageCell.setName( "face" );
    imageCell.setScaleMode( ScaleMode.NONE );
    TextCell firstNameCell = new TextCell( this );
    firstNameCell.setAlignment( CellAlignment.RIGHT, CellAlignment.BOTTOM );
    firstNameCell.setBindingIndex( 0 );
    firstNameCell.setForeground( display.getSystemColor( SWT.COLOR_DARK_RED ) );
    firstNameCell.setBackground( display.getSystemColor( SWT.COLOR_GRAY ) );
    firstNameCell.setLeft( 72 );
    firstNameCell.setTop( 4 );
    firstNameCell.setWidth( 180 );
    firstNameCell.setHeight( 40 );
    firstNameCell.setName( "firstname" );
    firstNameCell.setSelectable( true );
    firstNameCell.setWrap( true );
    firstNameCell.setForeground( display.getSystemColor( SWT.COLOR_RED ) );
    Font font = tableViewer.getTable().getFont();
    FontData fontData = font.getFontData()[ 0 ];
    fontData.setHeight( 15 );
    fontData.setStyle( SWT.BOLD );
    font = new Font( display, fontData );
    firstNameCell.setFont( font );
    TextCell lastNameCell = new TextCell( this );
    lastNameCell.setAlignment( CellAlignment.LEFT );
    lastNameCell.setBindingIndex( 1 );
    lastNameCell.setLeft( 90 );
    lastNameCell.setTop( 50 );
    lastNameCell.setRight( 8 );
    lastNameCell.setBottom( 8 );
    lastNameCell.setForeground( display.getSystemColor( SWT.COLOR_WHITE ) );
    lastNameCell.setBackground( display.getSystemColor( SWT.COLOR_DARK_GREEN ) );
    FontData lastNameFont = tableViewer.getTable().getFont().getFontData()[ 0 ];
    lastNameFont.setHeight( 16 );
    lastNameFont.setStyle( SWT.ITALIC );
    lastNameCell.setFont( new Font( display, lastNameFont ) );
    TextCell likeCell = new TextCell( this );
    likeCell.setLeft( 4 );
    likeCell.setWidth( 80 );
    likeCell.setBottom( 2 );
    likeCell.setHeight( 20 );
    likeCell.setDefaultText( "Like On FB" );
    likeCell.setName( "like" );
    likeCell.setSelectable( true );
    ImageCell phone = new ImageCell( this );
    phone.setAlignment( CellAlignment.RIGHT );
    final Image phoneImage = new Image( tableViewer.getTable().getDisplay(),
                                        ExampleTemplate.class.getResourceAsStream( "/phone.png" ) );
    phone.setDefaultImage( phoneImage );
    phone.setTop( 8 );
    phone.setWidth( 48 );
    phone.setRight( 16 );
    phone.setBottom( 8 );
    phone.setName( "phone" );
    phone.setSelectable( true );
  }
}