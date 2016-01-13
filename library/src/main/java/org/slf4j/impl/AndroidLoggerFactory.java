package org.slf4j.impl;

import android.content.Context;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 * Factory class implementation for slf4j on android
 * 
 * @author Claudio Degioanni
 */
class AndroidLoggerFactory implements ILoggerFactory {

	/**
	 * The root object descriptor
	 */
	private Descriptor rootDescriptor = null;

	/**
	 * Create a AndroidLoggerFactory object
	 * 
	 * @param context
	 *            the application context
	 */
	AndroidLoggerFactory(final Context context) {
		/* Load the configuration of logging system */
		rootDescriptor = Configurator.loadConfiguration(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.ILoggerFactory#getLogger(java.lang.String)
	 */
	@Override
	public Logger getLogger(String name) {
		final Descriptor desc = Configurator.getConfiguration(rootDescriptor, name);
		return new AndroidLogger(name, desc);
	}
}
