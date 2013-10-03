/*******************************************************************************
 * Copyright (c) 2013 EclipseSource and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors:
 * EclipseSource - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.rowtemplate.demo;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.application.AbstractEntryPoint;
import org.eclipse.rap.rwt.internal.template.Cell.CellAlignment;
import org.eclipse.rap.rwt.internal.template.ImageCell;
import org.eclipse.rap.rwt.internal.template.RowTemplate;
import org.eclipse.rap.rwt.internal.template.TextCell;
import org.eclipse.rap.rwt.widgets.DialogUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;

@SuppressWarnings("restriction")
public class RowTemplateDemo extends AbstractEntryPoint {

  @Override
  protected void createContents( Composite parent ) {
    parent.setLayout( new FillLayout() );
    TableViewer tableViewer = new TableViewer( parent, SWT.NONE );
    tableViewer.getTable().setData( RWT.CUSTOM_ITEM_HEIGHT, Integer.valueOf( 92 ) );
    tableViewer.setContentProvider( new ArrayContentProvider() );
    addFirstNameColumn( tableViewer );
    addLastNameColumn( tableViewer );
    addPhoneColumn( tableViewer );
    addFooColumn( tableViewer );
    tableViewer.setInput( Persons.get( parent.getDisplay() ) );
    RowTemplate rowTemplate = createRowTemplate( parent, tableViewer );
    tableViewer.getTable().setData( RowTemplate.ROW_TEMPLATE, rowTemplate );
  }

  private void addPhoneColumn( final TableViewer tableViewer ) {
    TableViewerColumn phoneColumn = new TableViewerColumn( tableViewer, SWT.NONE );
    phoneColumn.getColumn().setWidth( 48 );
    phoneColumn.getColumn().setText( "Phone" );
    final Image phoneImage = new Image( tableViewer.getTable().getDisplay(),
                                        RowTemplateDemo.class.getResourceAsStream( "/phone.png" ) );
    phoneColumn.setLabelProvider( new ColumnLabelProvider() {

      @Override
      public String getText( Object element ) {
        Person p = ( Person )element;
        return p.getFirstName();
      }

      @Override
      public Image getImage( Object element ) {
        return phoneImage;
      }
    } );
  }

  private void addFirstNameColumn( final TableViewer tableViewer ) {
    TableViewerColumn firstNameColumn = new TableViewerColumn( tableViewer, SWT.NONE );
    firstNameColumn.getColumn().setWidth( 200 );
    firstNameColumn.getColumn().setText( "Firstname" );
    firstNameColumn.setLabelProvider( new ColumnLabelProvider() {

      @Override
      public String getText( Object element ) {
        Person p = ( Person )element;
        return p.getFirstName();
      }

      @Override
      public Image getImage( Object element ) {
        Person p = ( Person )element;
        return p.getImage();
      }
    } );
  }

  private RowTemplate createRowTemplate( final Composite parent, TableViewer tableViewer ) {
    RowTemplate rowTemplate = new RowTemplate();
    ImageCell imageCell = new ImageCell( rowTemplate );
    imageCell.setAlignment( CellAlignment.LEFT, CellAlignment.TOP );
    imageCell.setBindingIndex( 0 );
    imageCell.setTop( 4 );
    imageCell.setLeft( 4 );
    imageCell.setWidth( 64 );
    imageCell.setHeight( 64 );
    imageCell.setSelectable( true );
    imageCell.setName( "face" );
    TextCell firstNameCell = new TextCell( rowTemplate );
    firstNameCell.setAlignment( CellAlignment.LEFT );
    firstNameCell.setBindingIndex( 0 );
    firstNameCell.setForeground( parent.getDisplay().getSystemColor( SWT.COLOR_DARK_RED ) );
    firstNameCell.setBackground( parent.getDisplay().getSystemColor( SWT.COLOR_GRAY ) );
    firstNameCell.setLeft( 72 );
    firstNameCell.setTop( 4 );
    firstNameCell.setRight( 8 );
    firstNameCell.setHeight( 28 );
    firstNameCell.setName( "firstname" );
    firstNameCell.setSelectable( true );
    firstNameCell.setForeground( parent.getDisplay().getSystemColor( SWT.COLOR_RED ) );
    Font font = parent.getFont();
    FontData fontData = font.getFontData()[ 0 ];
    fontData.setHeight( 15 );
    fontData.setStyle( SWT.BOLD );
    font = new Font( parent.getDisplay(), fontData );
    firstNameCell.setFont( font );
    TextCell lastNameCell = new TextCell( rowTemplate );
    lastNameCell.setAlignment( CellAlignment.LEFT );
    lastNameCell.setBindingIndex( 1 );
    lastNameCell.setLeft( 72 );
    lastNameCell.setTop( 50 );
    lastNameCell.setRight( 8 );
    lastNameCell.setBottom( 8 );
    lastNameCell.setForeground( parent.getDisplay().getSystemColor( SWT.COLOR_WHITE ) );
    lastNameCell.setBackground( parent.getDisplay().getSystemColor( SWT.COLOR_DARK_GREEN ) );
    FontData lastNameFont = tableViewer.getTable().getFont().getFontData()[ 0 ];
    lastNameFont.setHeight( 16 );
    lastNameFont.setStyle( SWT.ITALIC );
    lastNameCell.setFont( new Font( parent.getDisplay(), lastNameFont ) );
    ImageCell phone = new ImageCell( rowTemplate );
    phone.setAlignment( CellAlignment.RIGHT );
    final Image phoneImage = new Image( tableViewer.getTable().getDisplay(),
                                        RowTemplateDemo.class.getResourceAsStream( "/phone.png" ) );
    phone.setDefaultImage( phoneImage );
    phone.setTop( 8 );
    phone.setWidth( 48 );
    phone.setRight( 16 );
    phone.setBottom( 8 );
    phone.setName( "phone" );
    phone.setSelectable( true );
    tableViewer.getTable().addSelectionListener( new SelectionAdapter() {

      @Override
      public void widgetSelected( SelectionEvent e ) {
        if( "phone".equals( e.text ) ) {
          MessageBox messageBox = new MessageBox( parent.getShell(), SWT.ICON_INFORMATION );
          messageBox.setText( "Dialing..." );
          TableItem item = ( TableItem )e.item;
          String firstName = item.getText( 0 );
          messageBox.setMessage( "Calling " + firstName + "!" );
          DialogUtil.open( messageBox, null );
        } else if( "firstname".equals( e.text ) ) {
          System.out.println( "Clicking firstname" );
        }
      }
    } );
    return rowTemplate;
  }

  private void addLastNameColumn( TableViewer tableViewer ) {
    TableViewerColumn lastNameColumn = new TableViewerColumn( tableViewer, SWT.NONE );
    lastNameColumn.getColumn().setWidth( 200 );
    lastNameColumn.getColumn().setText( "Firstname" );
    lastNameColumn.setLabelProvider( new ColumnLabelProvider() {

      @Override
      public String getText( Object element ) {
        Person p = ( Person )element;
        return p.getLastName();
      }
    } );
  }

  private void addFooColumn( TableViewer tableViewer ) {
    TableViewerColumn fooColumn = new TableViewerColumn( tableViewer, SWT.NONE );
    fooColumn.getColumn().setWidth( 200 );
    fooColumn.getColumn().setText( "Foo" );
    fooColumn.setLabelProvider( new ColumnLabelProvider() {

      @Override
      public String getText( Object element ) {
        return "foo";
      }
    } );
  }
}
