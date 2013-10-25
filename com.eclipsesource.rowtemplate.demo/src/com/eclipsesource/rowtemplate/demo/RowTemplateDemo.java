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
import org.eclipse.rap.rwt.internal.template.RowTemplate;
import org.eclipse.rap.rwt.widgets.DialogUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;

import com.eclipsesource.rowtemplate.demo.templates.ExampleTemplate;

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
    addFooColumn( tableViewer );
    tableViewer.setInput( Persons.get( parent.getDisplay() ) );
    RowTemplate rowTemplate = new ExampleTemplate( tableViewer );
    tableViewer.getTable().setData( RowTemplate.ROW_TEMPLATE, rowTemplate );
    addListener( parent, tableViewer );
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

  private void addListener( final Composite parent, TableViewer tableViewer ) {
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
        } else if( "like".equals( e.text ) ) {
          MessageBox messageBox = new MessageBox( parent.getShell(), SWT.ICON_INFORMATION );
          messageBox.setText( "I Like You" );
          TableItem item = ( TableItem )e.item;
          String firstName = item.getText( 0 );
          messageBox.setMessage( "Liking " + firstName + " on FB!" );
          DialogUtil.open( messageBox, null );
        } else if( "firstname".equals( e.text ) ) {
          System.out.println( "Clicking firstname" );
        }
      }
    } );
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
