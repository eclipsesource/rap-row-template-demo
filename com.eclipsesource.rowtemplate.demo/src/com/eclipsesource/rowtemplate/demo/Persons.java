/*******************************************************************************
 * Copyright (c) 2013 EclipseSource and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors:
 * EclipseSource - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.rowtemplate.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class Persons {

  public static Person[] get( Display display ) {
    List<Person> persons = getPersons( display );
    Person[] personArray = new Person[ persons.size() ];
    persons.toArray( personArray );
    return personArray;
  }

  private static List<Person> getPersons( Display display ) {
    List<Person> persons = new ArrayList<Person>();
    Person ian = new Person( "Ian", "Bull", loadImage( display, "/ian.jpeg" ) );
    Person moritz = new Person( "Moritz", "Post", loadImage( display, "/moritz.jpeg" ) );
    Person holger = new Person( "Holger", "Staudacher", loadImage( display, "/holger.jpeg" ) );
    Person jordi = new Person( "Jordi", "Böhme", loadImage( display, "/jordi.jpeg" ) );
    Person tim = new Person( "Tim", "Buschtöns", loadImage( display, "/tim.png" ) );
    for( int i = 0; i < 10; i++ ) {
      persons.add( ian );
      persons.add( moritz );
      persons.add( holger );
      persons.add( jordi );
      persons.add( tim );
    }
    Collections.shuffle( persons );
    return persons;
  }

  private static Image loadImage( Display display, String name ) {
    Image image = new Image( display, Persons.class.getResourceAsStream( name ) );
    return ImageUtil.resizeImage( image, 48, 48 );
  }
}
