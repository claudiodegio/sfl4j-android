package org.slf4j.impl;

import org.slf4j.helpers.MessageFormatter;

abstract class MessageFormatterUtil {

	/**
	 * Performs X argument substitution for the 'messagePattern' passed as
	 * parameter.
	 * 
	 * @param messagePattern
	 *            The message pattern which will be parsed and formatted
	 * @param argArray
	 *            The arguments to be substituted in place of the formatting
	 *            anchor
	 * @return The formatted message
	 * @see MessageFormatter it's used in this method
	 */

	static String format(final String messagePattern, final Object[] argArray) {

		String result = messagePattern;

		switch (argArray.length) {
		case 0:
			break;
		case 1:
			result = MessageFormatter.format(messagePattern, argArray[0]).getMessage();
			break;
		case 2:
			result = MessageFormatter.format(messagePattern, argArray[0], argArray[1]).getMessage();
			break;
		default:
			result = MessageFormatter.arrayFormat(messagePattern, argArray).getMessage();
			break;
		}

		return result;
	}

	/**
	 * Performs argument substitution for passed {@link Throwable} parameter.
	 * 
	 * @param message
	 *            The message to display (can be null)
	 * @param throwable
	 *            The {@link Throwable} to format
	 * @return The formatted message
	 * @see MessageFormatter it's used in this method
	 */

	static String format(final String message, final Throwable throwable) {
		if (message == null)
			return MessageFormatter.format("ExMsg: {}", throwable.toString()).getMessage();

		return MessageFormatter.format("{} ExMsg: {}", message, throwable.toString()).getMessage();
	}

	/**
	 * Performs formatting of a message
	 * 
	 * @param message
	 *            The message to display (can be null), if null display the
	 *            caller function
	 * @return The formatted message
	 */

	static String format(final String message) {

		if (message == null) {

			final StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];

			return stackTraceElement.getMethodName() + "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber()
					+ ")";
		}

		return message;
	}

	private MessageFormatterUtil() {
	}
}
