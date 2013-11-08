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
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.application.AbstractEntryPoint;
import org.eclipse.rap.rwt.client.service.UrlLauncher;
import org.eclipse.rap.rwt.template.Template;
import org.eclipse.rap.rwt.widgets.DialogUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;

import com.eclipsesource.rowtemplate.demo.templates.ExampleTemplate;
import com.eclipsesource.rowtemplate.demo.templates.ImageAlignmentTemplate;
import com.eclipsesource.rowtemplate.demo.templates.ImageFillTemplate;
import com.eclipsesource.rowtemplate.demo.templates.ImageFitTemplate;
import com.eclipsesource.rowtemplate.demo.templates.PrettyTemplate;
import com.eclipsesource.rowtemplate.demo.templates.TextAlignmentTemplate;
import com.eclipsesource.rowtemplate.demo.templates.TextWrapTemplate;

@SuppressWarnings("restriction")
public class RowTemplateDemo extends AbstractEntryPoint {

  private final class SelectionListener extends SelectionAdapter {

    private final Composite parent;

    private SelectionListener( Composite parent ) {
      this.parent = parent;
    }

    @Override
    public void widgetSelected( SelectionEvent e ) {
      if( "phone".equals( e.text ) ) {
        TableItem item = ( TableItem )e.item;
        alert( "Dialing...", "Calling " + item.getText( 2 ) + "!" );
      } else if( "mail".equals( e.text ) ) {
        String mail = ( ( TableItem )e.item ).getText( 3 );
        String firstName = ( ( TableItem )e.item ).getText( 0 );
        UrlLauncher launcher = RWT.getClient().getService( UrlLauncher.class );
        if( launcher != null ) {
          launcher.openURL( "mailto:" + mail + "?subject=RAP%20Rocks!&body=Hello%20" + firstName );
        } else {
          alert( "Now mailing to...", mail );
        }
      } else if( "arrow".equals( e.text ) ) {
        TableItem item = ( TableItem )e.item;
        String firstName = item.getText( 0 );
        alert( "Nothing here", "Lets edit " + firstName + "!" );
      } else if( "like".equals( e.text ) ) {
        TableItem item = ( TableItem )e.item;
        String firstName = item.getText( 0 );
        alert( "I Like You", "Liking " + firstName + " on FB!" );
      } else if( "firstname".equals( e.text ) ) {
        System.out.println( "Clicking firstname" );
      }
    }

    private void alert( String title, String message ) {
      MessageBox messageBox = new MessageBox( parent.getShell(), SWT.ICON_INFORMATION );
      messageBox.setText( title );
      messageBox.setMessage( message );
      DialogUtil.open( messageBox, null );
    }
  }

  private Control exampleControl;
  private Listener createGrid;
  private Combo templateCombo;
  private Combo controlCombo;
  private Button fullSelection;
  private Button headerVisible;
  private Button markup;
  private Integer[] templateHeights;
  private Template[] templates;

  @Override
  protected void createContents( final Composite parent ) {
    createGrid = new Listener() {
      @Override
      public void handleEvent( Event event ) {
        createGrid( parent );
        parent.layout();
      }
    };
    GridLayout layout = new GridLayout( 1, true );
    layout.marginLeft = 0;
    layout.marginTop = 0;
    layout.marginRight = 0;
    layout.marginBottom = 0;
    layout.horizontalSpacing = 0;
    layout.verticalSpacing = 0;
    layout.marginWidth = 0;
    layout.marginHeight = 0;
    parent.setLayout( layout );
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
    templateCombo.setItems( new String[] {
      "no template",
      "ExampleTemplate",
      "PrettyTemplate",
      "TextAlignmentTempalte",
      "TextWrapTempalte",
      "ImageAlignmentTempalte",
      "ImageFitTempalte",
      "ImageFillTempalte"
    } );
    Font defaultFont = parent.getFont();
    templates = new Template[] {
      null,
      new ExampleTemplate( defaultFont ),
      new PrettyTemplate( defaultFont ),
      new TextAlignmentTemplate(),
      new TextWrapTemplate(),
      new ImageAlignmentTemplate(),
      new ImageFitTemplate(),
      new ImageFillTemplate()
    };
    templateHeights = new Integer[] {
      null,
      Integer.valueOf( 92 ),
      Integer.valueOf( 56 ),
      Integer.valueOf( 60 ),
      Integer.valueOf( 100 ),
      Integer.valueOf( 74 ),
      Integer.valueOf( 78 ),
      Integer.valueOf( 78 )
    };
    templateCombo.select( 2 );
    controlCombo = new Combo( area, SWT.READ_ONLY );
    controlCombo.setItems( new String[] { "Table", "Tree" } );
    controlCombo.select( 0 );
    fullSelection = new Button( area, SWT.CHECK );
    fullSelection.setText( "FULL_SELECTION" );
    markup = new Button( area, SWT.CHECK );
    markup.setText( "MARKUP_ENABLED" );
    headerVisible = new Button( area, SWT.CHECK );
    headerVisible.setText( "header" );
    templateCombo.addListener( SWT.Selection, createGrid );
    controlCombo.addListener( SWT.Selection, createGrid );
    fullSelection.addListener( SWT.Selection, createGrid );
    headerVisible.addListener( SWT.Selection, createGrid );
    markup.addListener( SWT.Selection, createGrid );
  }

  private void createGrid( Composite parent ) {
    if( exampleControl != null ) {
      exampleControl.dispose();
    }
    switch( controlCombo.getSelectionIndex() ) {
      case 0:
        createTable( parent );
      break;
      case 1:
        createTree( parent );
      break;
    }
    exampleControl.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );
    exampleControl.setData( RWT.MARKUP_ENABLED, Boolean.valueOf( markup.getSelection() ) );
    int tempalteIndex = templateCombo.getSelectionIndex();
    exampleControl.setData( RWT.ROW_TEMPLATE, templates[ tempalteIndex ] );
    exampleControl.setData( RWT.CUSTOM_ITEM_HEIGHT, templateHeights[ tempalteIndex ] );
    exampleControl.moveAbove( null );
  }

  private void createTable( Composite parent ) {
    TableViewer tableViewer = new TableViewer( parent, getStyle() );
    exampleControl = tableViewer.getTable();
    tableViewer.setContentProvider( new ArrayContentProvider() );
    configColumnViewer( tableViewer );
    tableViewer.getTable().setHeaderVisible( headerVisible.getSelection() );
    tableViewer.getTable().setLinesVisible( headerVisible.getSelection() );
    tableViewer.getTable().addSelectionListener( new SelectionListener( parent ) );
  }

  private void createTree( Composite parent ) {
    TreeViewer treeViewer = new TreeViewer( parent, getStyle() );
    exampleControl = treeViewer.getTree();
    treeViewer.setContentProvider( new ITreeContentProvider() {
      @Override
      public void inputChanged( Viewer viewer, Object oldInput, Object newInput ) {
      }
      @Override
      public void dispose() {
      }
      @Override
      public boolean hasChildren( Object element ) {
        return ( ( Person )element ).getChildren() != null;
      }
      @Override
      public Object getParent( Object element ) {
        return null;
      }
      @Override
      public Object[] getElements( Object inputElement ) {
        return ( Person[] )inputElement;
      }
      @Override
      public Object[] getChildren( Object parentElement ) {
        return ( ( Person )parentElement ).getChildren();
      }
    } );
    configColumnViewer( treeViewer );
    treeViewer.getTree().addSelectionListener( new SelectionListener( parent ) );
    treeViewer.getTree().setHeaderVisible( headerVisible.getSelection() );
    treeViewer.getTree().setLinesVisible( headerVisible.getSelection() );
  }

  private int getStyle() {
    int style = fullSelection.getSelection() ? SWT.FULL_SELECTION : SWT.NONE;
    return style;
  }

  private void configColumnViewer( ColumnViewer viewer ) {
    addFirstNameColumn( viewer );
    addLastNameColumn( viewer );
    addPhoneColumn( viewer );
    addMailColumn( viewer );
    addFooColumn( viewer );
    viewer.setInput( Persons.get( viewer.getControl().getDisplay() ) );
  }

  private void addFirstNameColumn( final ColumnViewer viewer ) {
    ViewerColumn firstNameColumn = createViewerColumn( viewer, "First Name", 200 );
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

  private void addLastNameColumn( ColumnViewer viewer ) {
    ViewerColumn lastNameColumn = createViewerColumn( viewer, "Last Name", 200 );
    lastNameColumn.setLabelProvider( new ColumnLabelProvider() {
      @Override
      public String getText( Object element ) {
        Person p = ( Person )element;
        return p.getLastName();
      }
    } );
  }

  private void addPhoneColumn( ColumnViewer viewer ) {
    ViewerColumn pohoneColumn = createViewerColumn( viewer, "Phone", 130 );
    pohoneColumn.setLabelProvider( new ColumnLabelProvider() {
      @Override
      public String getText( Object element ) {
        Person p = ( Person )element;
        return p.getPhone();
      }
    } );
  }

  private void addMailColumn( ColumnViewer viewer ) {
    ViewerColumn pohoneColumn = createViewerColumn( viewer, "E-Mail", 180 );
    pohoneColumn.setLabelProvider( new ColumnLabelProvider() {
      @Override
      public String getText( Object element ) {
        Person p = ( Person )element;
        return p.getMail();
      }
    } );
  }

  private void addFooColumn( ColumnViewer viewer ) {
    ViewerColumn fooColumn = createViewerColumn( viewer, "Foo", 200 );
    fooColumn.setLabelProvider( new ColumnLabelProvider() {
      @Override
      public String getText( Object element ) {
        return "foo";
      }
    } );
  }

  private ViewerColumn createViewerColumn( final ColumnViewer viewer, String name, int width ) {
    ViewerColumn viewerColumn = null;
    if( viewer instanceof TableViewer ) {
      TableViewer tableViewer = ( TableViewer )viewer;
      TableViewerColumn tableColumn = new TableViewerColumn( tableViewer, SWT.NONE );
      //tableColumn.getColumn().setWidth( width );
      tableColumn.getColumn().setText( name );
      viewerColumn = tableColumn;
    } else if( viewer instanceof TreeViewer ) {
      TreeViewer treeViewer = ( TreeViewer )viewer;
      TreeViewerColumn treeColumn = new TreeViewerColumn( treeViewer, SWT.NONE );
      //treeColumn.getColumn().setWidth( width );
      treeColumn.getColumn().setText( name );
      viewerColumn = treeColumn;
    }
    return viewerColumn;
  }

}
