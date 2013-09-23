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
package com.eclipsesource.rowtemplate.demo;

import org.eclipse.rap.rwt.application.Application;
import org.eclipse.rap.rwt.application.ApplicationConfiguration;

import com.eclipsesource.tabris.TabrisClientInstaller;


public class AppConfig implements ApplicationConfiguration {

  @Override
  public void configure( Application application ) {
    TabrisClientInstaller.install( application );
    application.addEntryPoint( "/template", RowTemplateDemo.class, null );
  }
}
