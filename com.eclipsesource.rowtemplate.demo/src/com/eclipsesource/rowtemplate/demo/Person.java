/*******************************************************************************
 * Copyright (c) 2013 EclipseSource and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors:
 * EclipseSource - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.rowtemplate.demo;

import org.eclipse.swt.graphics.Image;

public class Person {

  private final String firstName;
  private final String lastName;
  private final Image image;

  public Person( String firstName, String lastName, Image image ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.image = image;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Image getImage() {
    return image;
  }
}
