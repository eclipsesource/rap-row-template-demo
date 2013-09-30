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
import org.eclipse.rap.rwt.internal.template.Cell;
import org.eclipse.rap.rwt.internal.template.Cells;
import org.eclipse.rap.rwt.internal.template.RowTemplate;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

@SuppressWarnings("restriction")
public class RowTemplateDemo extends AbstractEntryPoint {

  @Override
  protected void createContents( Composite parent ) {
    parent.setLayout( new FillLayout() );
    TableViewer tableViewer = new TableViewer( parent, SWT.NONE );
    tableViewer.getTable().setData( RWT.CUSTOM_ITEM_HEIGHT, Integer.valueOf( 72 ) );
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

  private RowTemplate createRowTemplate( Composite parent, TableViewer tableViewer ) {
    RowTemplate rowTemplate = new RowTemplate();
    Cell imageCell = Cells.createImageCell( rowTemplate, SWT.LEFT | SWT.TOP );
    imageCell.setBindingIndex( 0 );
    imageCell.setTop( 4 );
    imageCell.setLeft( 4 );
    imageCell.setWidth( 64 );
    imageCell.setHeight( 64 );
    imageCell.setName( "image" );
    imageCell.setSelectable( true );
    tableViewer.getTable().addSelectionListener( new SelectionAdapter() {

      @Override
      public void widgetSelected( SelectionEvent e ) {
        if( "image".equals( e.text ) ) {
          System.out.println( "Image Cell was clicked" );
        }
      }
    } );
    Cell firstNameCell = Cells.createTextCell( rowTemplate, SWT.LEFT );
    firstNameCell.setBindingIndex( 0 );
    firstNameCell.setForeground( parent.getDisplay().getSystemColor( SWT.COLOR_DARK_RED ) );
    firstNameCell.setLeft( 72 );
    firstNameCell.setTop( 4 );
    firstNameCell.setRight( 8 );
    firstNameCell.setHeight( 28 );
    firstNameCell.setForeground( parent.getDisplay().getSystemColor( SWT.COLOR_RED ) );
    Font font = parent.getFont();
    FontData fontData = font.getFontData()[ 0 ];
    fontData.setHeight( 20 );
    fontData.setStyle( SWT.BOLD );
    font = new Font( parent.getDisplay(), fontData );
    firstNameCell.setFont( font );
    Cell lastNameCell = Cells.createTextCell( rowTemplate, SWT.LEFT );
    lastNameCell.setBindingIndex( 1 );
    lastNameCell.setLeft( 72 );
    lastNameCell.setTop( 40 );
    lastNameCell.setRight( 8 );
    lastNameCell.setBottom( 8 );
    lastNameCell.setForeground( parent.getDisplay().getSystemColor( SWT.COLOR_WHITE ) );
    lastNameCell.setBackground( parent.getDisplay().getSystemColor( SWT.COLOR_DARK_GREEN ) );
    FontData lastNameFont = tableViewer.getTable().getFont().getFontData()[ 0 ];
    lastNameFont.setHeight( 16 );
    lastNameFont.setStyle( SWT.ITALIC );
    lastNameCell.setFont( new Font( parent.getDisplay(), lastNameFont ) );
    Cell phone = Cells.createImageCell( rowTemplate, SWT.RIGHT );
    phone.setBindingIndex( 2 );
    phone.setTop( 8 );
    phone.setWidth( 48 );
    phone.setRight( 16 );
    phone.setBottom( 8 );
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
