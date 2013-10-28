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

import org.eclipse.rap.rwt.internal.template.Cell.CellAlignment;
import org.eclipse.rap.rwt.internal.template.ImageCell;
import org.eclipse.rap.rwt.internal.template.ImageCell.ScaleMode;
import org.eclipse.rap.rwt.internal.template.RowTemplate;
import org.eclipse.rap.rwt.internal.template.TextCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

@SuppressWarnings("restriction")
public class PrettyTemplate extends RowTemplate {
  private static final String MY_FONT = "Tahoma, Geneva, sans-serif";

  public PrettyTemplate( Font defaultFont ) {
    super();
    createImageCell();
    createLastNameCell();
    createFirstNameCell();
//    createLikeCell();
    createMailLabelCell();
    createMailCell();
    createPhoneLabelCell();
    createSeparatorCell(); // TODO [tb] : do by theming
    createPhoneCell();
    createPhoneIconCell();
  }

  private void createPhoneIconCell() {
    ImageCell phone = new ImageCell( this );
    phone.setAlignment( CellAlignment.RIGHT );
    final Image phoneImage = new Image( Display.getCurrent(),
                                        PrettyTemplate.class.getResourceAsStream( "/phone.png" ) );
    phone.setDefaultImage( phoneImage );
    phone.setTop( 8 );
    phone.setWidth( 48 );
    phone.setRight( 16 );
    phone.setBottom( 8 );
    phone.setName( "phone" );
    phone.setSelectable( true );
  }

  private void createLikeCell() {
    TextCell likeCell = new TextCell( this );
    likeCell.setLeft( 4 );
    likeCell.setWidth( 80 );
    likeCell.setBottom( 2 );
    likeCell.setHeight( 20 );
    likeCell.setDefaultText( "Like On FB" );
    likeCell.setName( "like" );
    likeCell.setSelectable( true );
  }


  private void createLastNameCell() {
    TextCell lastNameCell = new TextCell( this );
    lastNameCell.setAlignment( CellAlignment.RIGHT, CellAlignment.BOTTOM );
    lastNameCell.setBindingIndex( 1 );
    lastNameCell.setLeft( 60 );
    lastNameCell.setTop( 5 );
    lastNameCell.setWidth( 180 );
    lastNameCell.setHeight( 40 );
    lastNameCell.setName( "lastname" );
    Font font = new Font( Display.getCurrent(), new FontData( MY_FONT, 20, SWT.NORMAL ) );
    lastNameCell.setFont( font );
  }

  private void createFirstNameCell() {
    TextCell firstNameCell = new TextCell( this );
    Font font = new Font( Display.getCurrent(), new FontData( MY_FONT, 14, SWT.NORMAL ) );
    firstNameCell.setFont( font );
    firstNameCell.setAlignment( CellAlignment.LEFT );
    firstNameCell.setBindingIndex( 0 );
    firstNameCell.setLeft( 60 );
    firstNameCell.setTop( 30 );
    firstNameCell.setWidth( 180 );
    firstNameCell.setBottom( 8 );
  }

  private void createPhoneLabelCell() {
    TextCell phoneLabelCell = new TextCell( this );
    Font font = new Font( Display.getCurrent(), new FontData( MY_FONT, 14, SWT.BOLD ) );
    phoneLabelCell.setFont( font );
    phoneLabelCell.setAlignment( CellAlignment.LEFT );
    phoneLabelCell.setDefaultText( "Phone:" );
    phoneLabelCell.setLeft( 250 );
    phoneLabelCell.setTop( 30 );
    phoneLabelCell.setRight( 8 );
    phoneLabelCell.setBottom( 8 );
  }

  private void createPhoneCell() {
    TextCell phoneCell = new TextCell( this );
    Font font = new Font( Display.getCurrent(), new FontData( MY_FONT, 14, SWT.NORMAL ) );
    phoneCell.setFont( font );
    phoneCell.setAlignment( CellAlignment.LEFT );
    phoneCell.setBindingIndex( 2 );
    phoneCell.setLeft( 310 );
    phoneCell.setTop( 30 );
    phoneCell.setRight( 8 );
    phoneCell.setBottom( 8 );
  }

  private void createMailLabelCell() {
    TextCell phoneLabelCell = new TextCell( this );
    Font font = new Font( Display.getCurrent(), new FontData( MY_FONT, 14, SWT.BOLD ) );
    phoneLabelCell.setFont( font );
    phoneLabelCell.setAlignment( CellAlignment.LEFT );
    phoneLabelCell.setDefaultText( "E-Mail:" );
    phoneLabelCell.setLeft( 250 );
    phoneLabelCell.setTop( 8 );
    phoneLabelCell.setRight( 8 );
    phoneLabelCell.setBottom( 8 );
  }

  private void createMailCell() {
    TextCell phoneCell = new TextCell( this );
    Font font = new Font( Display.getCurrent(), new FontData( MY_FONT, 14, SWT.NORMAL ) );
    phoneCell.setFont( font );
    phoneCell.setAlignment( CellAlignment.LEFT );
    phoneCell.setBindingIndex( 3 );
    phoneCell.setLeft( 310 );
    phoneCell.setTop( 8 );
    phoneCell.setRight( 8 );
    phoneCell.setBottom( 8 );
  }

  private void createImageCell() {
    ImageCell imageCell = new ImageCell( this );
    imageCell.setAlignment( CellAlignment.BOTTOM, CellAlignment.TOP );
    imageCell.setBindingIndex( 0 );
    imageCell.setTop( 4 );
    imageCell.setLeft( 4 );
    imageCell.setWidth( 48 );
    imageCell.setHeight( 48 );
    imageCell.setSelectable( true );
    imageCell.setName( "face" );
    imageCell.setScaleMode( ScaleMode.NONE );
  }

  private void createSeparatorCell() {
    TextCell cell = new TextCell( this );
    cell.setLeft( 0 );
    cell.setBottom( 0 );
    cell.setRight( 0 );
    cell.setHeight( 1 );
    cell.setBackground( new Color( Display.getCurrent(), 130, 130, 130 ) );
  }

}