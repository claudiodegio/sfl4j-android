package org.slf4j.impl;

import android.util.Log;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.MessageFormatter;

/**
 * Logger implementation for slf4j
 * 
 * @author Claudio Degioanni
 * @since 1.2.0
 */
class AndroidLogger implements Logger {

	/* The tag name */
	private String tag = null;

	/* Log descriptor */
	private Descriptor desc = null;

	/**
	 * Create a new android logger
	 * 
	 * @param name
	 *            the name to log also class name or simple name
	 * @param desc
	 *            the log descriptor
	 */
	AndroidLogger(String name, final Descriptor desc) {

		this.desc = desc;

		final int index = name.lastIndexOf(".");

		if (index != -1) {
			name = name.substring(index + 1);
		}

		tag = (desc.getMarker() != null ? desc.getMarker() + ":" + name : name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#debug(java.lang.String)
	 */
	@Override
	public void debug(String msg) {
		if (isDebugEnabled())
			Log.d(tag, MessageFormatterUtil.format(msg));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Object)
	 */
	@Override
	public void debug(String format, Object arg) {
		debug(format, new Object[] { arg });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void debug(String format, Object[] arg) {
		if (isDebugEnabled())
			Log.d(tag, MessageFormatterUtil.format(format, arg));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void debug(String msg, Throwable ex) {
		if (isDebugEnabled())
			Log.d(tag, MessageFormatterUtil.format(msg, ex));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#debug(org.slf4j.Marker, java.lang.String)
	 */
	@Override
	public void debug(Marker arg0, String arg1) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#debug(java.lang.String, java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public void debug(String format, Object arg1, Object arg2) {
		debug(format, new Object[] { arg1, arg2 });

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#debug(org.slf4j.Marker, java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public void debug(Marker arg0, String arg1, Object arg2) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#debug(org.slf4j.Marker, java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public void debug(Marker arg0, String arg1, Object[] arg2) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#debug(org.slf4j.Marker, java.lang.String,
	 * java.lang.Throwable)
	 */
	@Override
	public void debug(Marker arg0, String arg1, Throwable arg2) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#debug(org.slf4j.Marker, java.lang.String,
	 * java.lang.Object, java.lang.Object)
	 */
	@Override
	public void debug(Marker arg0, String arg1, Object arg2, Object arg3) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#error(java.lang.String)
	 */
	@Override
	public void error(String msg) {
		if (isErrorEnabled())
			Log.e(tag, MessageFormatterUtil.format(msg));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#error(java.lang.String, java.lang.Object)
	 */
	@Override
	public void error(String format, Object arg) {
		error(format, new Object[] { arg });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#error(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void error(String format, Object[] arg) {
		if (isErrorEnabled())
			Log.e(tag, MessageFormatter.format(format, arg).getMessage());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#error(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void error(String msg, Throwable ex) {
		if (isErrorEnabled())
			Log.e(tag, MessageFormatterUtil.format(msg, ex));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#error(org.slf4j.Marker, java.lang.String)
	 */
	@Override
	public void error(Marker arg0, String arg1) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#error(java.lang.String, java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public void error(String format, Object arg1, Object arg2) {
		error(format, new Object[] { arg1, arg2 });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#error(org.slf4j.Marker, java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public void error(Marker arg0, String arg1, Object arg2) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#error(org.slf4j.Marker, java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public void error(Marker arg0, String arg1, Object[] arg2) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#error(org.slf4j.Marker, java.lang.String,
	 * java.lang.Throwable)
	 */
	@Override
	public void error(Marker arg0, String arg1, Throwable arg2) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#error(org.slf4j.Marker, java.lang.String,
	 * java.lang.Object, java.lang.Object)
	 */
	@Override
	public void error(Marker arg0, String arg1, Object arg2, Object arg3) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#getName()
	 */
	@Override
	public String getName() {
		return tag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#info(java.lang.String)
	 */
	@Override
	public void info(String msg) {
		if (isInfoEnabled())
			Log.i(tag, MessageFormatterUtil.format(msg));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#info(java.lang.String, java.lang.Object)
	 */
	@Override
	public void info(String format, Object arg) {
		info(format, new Object[] { arg });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#info(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void info(String format, Object[] arg) {
		if (isInfoEnabled())
			Log.i(tag, MessageFormatterUtil.format(format, arg));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#info(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void info(String msg, Throwable ex) {
		if (isWarnEnabled())
			Log.i(tag, MessageFormatterUtil.format(msg, ex));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#info(org.slf4j.Marker, java.lang.String)
	 */
	@Override
	public void info(Marker arg0, String arg1) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#info(java.lang.String, java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public void info(String format, Object arg1, Object arg2) {
		info(format, new Object[] { arg1, arg2 });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#info(org.slf4j.Marker, java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public void info(Marker arg0, String arg1, Object arg2) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#info(org.slf4j.Marker, java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public void info(Marker arg0, String arg1, Object[] arg2) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#info(org.slf4j.Marker, java.lang.String,
	 * java.lang.Throwable)
	 */
	@Override
	public void info(Marker arg0, String arg1, Throwable arg2) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#info(org.slf4j.Marker, java.lang.String,
	 * java.lang.Object, java.lang.Object)
	 */
	@Override
	public void info(Marker arg0, String arg1, Object arg2, Object arg3) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#isDebugEnabled()
	 */
	@Override
	public boolean isDebugEnabled() {
		return desc.isDebugEnabled();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#isDebugEnabled(org.slf4j.Marker)
	 */
	@Override
	public boolean isDebugEnabled(Marker arg0) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#isErrorEnabled()
	 */
	@Override
	public boolean isErrorEnabled() {
		return desc.isErrorEnabled();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#isErrorEnabled(org.slf4j.Marker)
	 */
	@Override
	public boolean isErrorEnabled(Marker arg0) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#isInfoEnabled()
	 */
	@Override
	public boolean isInfoEnabled() {
		return desc.isInfoEnabled();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#isInfoEnabled(org.slf4j.Marker)
	 */
	@Override
	public boolean isInfoEnabled(Marker arg0) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#isTraceEnabled()
	 */
	@Override
	public boolean isTraceEnabled() {
		return desc.isTraceEnabled();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#isTraceEnabled(org.slf4j.Marker)
	 */
	@Override
	public boolean isTraceEnabled(Marker arg0) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#isWarnEnabled()
	 */
	@Override
	public boolean isWarnEnabled() {
		return desc.isWarnEnabled();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#isWarnEnabled(org.slf4j.Marker)
	 */
	@Override
	public boolean isWarnEnabled(Marker arg0) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#trace(java.lang.String)
	 */
	@Override
	public void trace(String msg) {
		if (isTraceEnabled())
			Log.v(tag, MessageFormatterUtil.format(msg));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#trace(java.lang.String, java.lang.Object)
	 */
	@Override
	public void trace(String format, Object arg) {
		trace(format, new Object[] { arg });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#trace(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void trace(String format, Object[] arg) {
		if (isTraceEnabled())
			Log.v(tag, MessageFormatterUtil.format(format, arg));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#trace(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void trace(String msg, Throwable ex) {
		if (isTraceEnabled())
			Log.v(tag, MessageFormatterUtil.format(msg, ex));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#trace(org.slf4j.Marker, java.lang.String)
	 */
	@Override
	public void trace(Marker arg0, String arg1) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#trace(java.lang.String, java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public void trace(String format, Object arg1, Object arg2) {
		trace(format, new Object[] { arg1, arg2 });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#trace(org.slf4j.Marker, java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public void trace(Marker arg0, String arg1, Object arg2) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#trace(org.slf4j.Marker, java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public void trace(Marker arg0, String arg1, Object[] arg2) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#trace(org.slf4j.Marker, java.lang.String,
	 * java.lang.Throwable)
	 */
	@Override
	public void trace(Marker arg0, String arg1, Throwable arg2) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#trace(org.slf4j.Marker, java.lang.String,
	 * java.lang.Object, java.lang.Object)
	 */
	@Override
	public void trace(Marker arg0, String arg1, Object arg2, Object arg3) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#warn(java.lang.String)
	 */
	@Override
	public void warn(String msg) {
		if (isWarnEnabled())
			Log.w(tag, MessageFormatterUtil.format(msg));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Object)
	 */
	@Override
	public void warn(String format, Object arg) {
		warn(format, new Object[] { arg });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void warn(String format, Object[] arg) {
		if (isWarnEnabled())
			Log.w(tag, MessageFormatterUtil.format(format, arg));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Throwable)
	 */
	@Override
	public void warn(String msg, Throwable ex) {
		if (isWarnEnabled())
			Log.w(tag, MessageFormatterUtil.format(msg, ex));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#warn(org.slf4j.Marker, java.lang.String)
	 */
	@Override
	public void warn(Marker arg0, String arg1) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#warn(java.lang.String, java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public void warn(String format, Object arg1, Object arg2) {
		warn(format, new Object[] { arg1, arg2 });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#warn(org.slf4j.Marker, java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public void warn(Marker arg0, String arg1, Object arg2) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#warn(org.slf4j.Marker, java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public void warn(Marker arg0, String arg1, Object[] arg2) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#warn(org.slf4j.Marker, java.lang.String,
	 * java.lang.Throwable)
	 */
	@Override
	public void warn(Marker arg0, String arg1, Throwable arg2) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.slf4j.Logger#warn(org.slf4j.Marker, java.lang.String,
	 * java.lang.Object, java.lang.Object)
	 */
	@Override
	public void warn(Marker arg0, String arg1, Object arg2, Object arg3) {
		throw new UnsupportedOperationException();
	}

}
