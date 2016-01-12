/**
 * Copyright (c) 2004-2011 Claudio Degioanni All rights reserved. Permission is
 * hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the
 * Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions: The above copyright notice and this
 * permission notice shall be included in all copies or substantial portions of
 * the Software. THE SOFTWARE IS PROVIDED "AS  IS", WITHOUT WARRANTY OF ANY
 * KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO
 * EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
 * OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package org.slf4j.impl;

import android.content.Context;

import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;

/**
 * The binding of {@link LoggerFactory} class with an actual instance of
 * {@link ILoggerFactory} is performed using information returned by this class.
 * This class is meant to provide a implementation for android to the slf4j-api
 * module.
 * 
 * @author Claudio Degioanni
 * @since 1.2.0
 */
public class StaticLoggerBinder {

	/**
	 * The unique instance of this class.
	 */
	private static final StaticLoggerBinder instance = new StaticLoggerBinder();

	/**
	 * Return the singleton of this class.
	 * 
	 * @return the StaticLoggerBinder singleton
	 */
	public static final StaticLoggerBinder getSingleton() {
		return instance;
	}

	/**
	 * Declare the version of the SLF4J API this implementation is compiled
	 * against. The value of this field is usually modified with each release.
	 */
	// to avoid constant folding by the compiler, this field must *not* be final
	public static String REQUESTED_API_VERSION = "1.7.13"; // !final

	private AndroidLoggerFactory mFactory = null;

	private StaticLoggerBinder() {
	}

	public ILoggerFactory getLoggerFactory() {
		if (mFactory == null)
			mFactory = new AndroidLoggerFactory(mContext);
		return mFactory;
	}

	public String getLoggerFactoryClassStr() {
		return getClass().getName();
	}

	/**
	 * The android application context
	 */
	static private Context mContext = null;

	/**
	 * Initialize the logging system
	 * 
	 * @param context
	 *            the context of application
	 */
	static public void init(Context context) {
		mContext = context;
	}
}
