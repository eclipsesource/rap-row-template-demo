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

public class Persons {

  public static Person[] get() {
    List<Person> persons = getPersons();
    Person[] personArray = new Person[ persons.size() ];
    persons.toArray( personArray );
    return personArray;
  }

  private static List<Person> getPersons() {
    List<Person> persons = new ArrayList<Person>();
    persons.add( new Person( "Ian", "Bull" ) );
    persons.add( new Person( "Moritz", "Post" ) );
    persons.add( new Person( "Tim", "Buschtöns" ) );
    persons.add( new Person( "Jordi", "Böhme" ) );
    persons.add( new Person( "Holger", "Staudacher" ) );
    persons.add( new Person( "Ian", "Bull" ) );
    persons.add( new Person( "Moritz", "Post" ) );
    persons.add( new Person( "Tim", "Buschtöns" ) );
    persons.add( new Person( "Jordi", "Böhme" ) );
    persons.add( new Person( "Holger", "Staudacher" ) );
    persons.add( new Person( "Ian", "Bull" ) );
    persons.add( new Person( "Moritz", "Post" ) );
    persons.add( new Person( "Tim", "Buschtöns" ) );
    persons.add( new Person( "Jordi", "Böhme" ) );
    persons.add( new Person( "Holger", "Staudacher" ) );
    persons.add( new Person( "Ian", "Bull" ) );
    persons.add( new Person( "Moritz", "Post" ) );
    persons.add( new Person( "Tim", "Buschtöns" ) );
    persons.add( new Person( "Jordi", "Böhme" ) );
    persons.add( new Person( "Holger", "Staudacher" ) );
    persons.add( new Person( "Ian", "Bull" ) );
    persons.add( new Person( "Moritz", "Post" ) );
    persons.add( new Person( "Tim", "Buschtöns" ) );
    persons.add( new Person( "Jordi", "Böhme" ) );
    persons.add( new Person( "Holger", "Staudacher" ) );
    persons.add( new Person( "Ian", "Bull" ) );
    persons.add( new Person( "Moritz", "Post" ) );
    persons.add( new Person( "Tim", "Buschtöns" ) );
    persons.add( new Person( "Jordi", "Böhme" ) );
    persons.add( new Person( "Holger", "Staudacher" ) );
    persons.add( new Person( "Ian", "Bull" ) );
    persons.add( new Person( "Moritz", "Post" ) );
    persons.add( new Person( "Tim", "Buschtöns" ) );
    persons.add( new Person( "Jordi", "Böhme" ) );
    persons.add( new Person( "Holger", "Staudacher" ) );
    persons.add( new Person( "Ian", "Bull" ) );
    persons.add( new Person( "Moritz", "Post" ) );
    persons.add( new Person( "Tim", "Buschtöns" ) );
    persons.add( new Person( "Jordi", "Böhme" ) );
    persons.add( new Person( "Holger", "Staudacher" ) );
    persons.add( new Person( "Ian", "Bull" ) );
    persons.add( new Person( "Moritz", "Post" ) );
    persons.add( new Person( "Tim", "Buschtöns" ) );
    persons.add( new Person( "Jordi", "Böhme" ) );
    persons.add( new Person( "Holger", "Staudacher" ) );
    Collections.shuffle( persons );
    return persons;
  }
}
