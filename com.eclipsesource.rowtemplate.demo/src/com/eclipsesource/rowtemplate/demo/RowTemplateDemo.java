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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;

import com.eclipsesource.rowtemplate.demo.templates.ExampleTemplate;

@SuppressWarnings("restriction")
public class RowTemplateDemo extends AbstractEntryPoint {

  private Control exampleControl;
  private Listener createGrid;
  private Combo templateCombo;

  @Override
  protected void createContents( final Composite parent ) {
    createGrid = new Listener() {
      @Override
      public void handleEvent( Event event ) {
        createGrid( parent );
        parent.layout();
      }
    };
    parent.setLayout( new GridLayout( 1, true ) );
    Label label = new Label( parent, SWT.SEPARATOR | SWT.HORIZONTAL );
    label.setLayoutData( new GridData( SWT.FILL, SWT.CENTER, true, false ) );
    createConfigArea( parent );
    createGrid( parent );
  }

  private void createConfigArea( Composite parent ) {
    Composite area = new Composite( parent, SWT.NONE );
    area.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, false ) );
    area.setLayout( new RowLayout() );
    templateCombo = new Combo( area, SWT.READ_ONLY );
    templateCombo.setItems( new String[] { "no template", "ExampleTemplate" } );
    templateCombo.select( 1 );
    templateCombo.addListener( SWT.Selection, createGrid );
  }

  private void createGrid( Composite parent ) {
    if( exampleControl != null ) {
      exampleControl.dispose();
    }
    TableViewer tableViewer = new TableViewer( parent, SWT.NONE );
    tableViewer.getTable().setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );
    tableViewer.getTable().setData( RWT.CUSTOM_ITEM_HEIGHT, Integer.valueOf( 92 ) );
    exampleControl = tableViewer.getTable();
    exampleControl.moveAbove( null );
    tableViewer.setContentProvider( new ArrayContentProvider() );
    addFirstNameColumn( tableViewer );
    addLastNameColumn( tableViewer );
    addFooColumn( tableViewer );
    tableViewer.setInput( Persons.get( parent.getDisplay() ) );
    if( templateCombo.getSelectionIndex() == 1 ) {
      RowTemplate rowTemplate = new ExampleTemplate( tableViewer );
      tableViewer.getTable().setData( RowTemplate.ROW_TEMPLATE, rowTemplate );
    }
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
