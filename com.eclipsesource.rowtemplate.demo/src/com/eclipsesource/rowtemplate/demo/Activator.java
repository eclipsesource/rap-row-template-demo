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

import org.eclipse.rap.rwt.application.ApplicationConfiguration;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class Activator implements BundleActivator {

  @Override
  public void start( BundleContext context ) throws Exception {
    context.registerService( ApplicationConfiguration.class, new AppConfig(), null );
  }

  @Override
  public void stop( BundleContext context ) throws Exception {
  }
}
