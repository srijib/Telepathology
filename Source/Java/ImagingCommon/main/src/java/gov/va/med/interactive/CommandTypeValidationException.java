/**
 * Package: MAG - VistA Imaging
 * WARNING: Per VHA Directive 2004-038, this routine should not be modified.
 * @date Jun 22, 2010
 * Site Name:  Washington OI Field Office, Silver Spring, MD
 * @author vhaiswbeckec
 * @version 1.0
 *
 * ----------------------------------------------------------------
 * Property of the US Government.
 * No permission to copy or redistribute this software is given.
 * Use of unreleased versions of this software requires the user
 * to execute a written test agreement with the VistA Imaging
 * Development Office of the Department of Veterans Affairs,
 * telephone (301) 734-0100.
 * 
 * The Food and Drug Administration classifies this software as
 * a Class II medical device.  As such, it may not be changed
 * in any way.  Modifications to this software may result in an
 * adulterated medical device under 21CFR820, the use of which
 * is considered to be a violation of US Federal Statutes.
 * ----------------------------------------------------------------
 */

package gov.va.med.interactive;

/**
 * @author vhaiswbeckec
 *
 */
public class CommandTypeValidationException
extends CommandValidationException
{
	private static final long serialVersionUID = 1L;

	private static String buildMessage(String commandParameterName, Class<?> commandParameterType)
	{
		return "Parameter '" + commandParameterName + "' must be of type " + commandParameterType.toString();
	}
	
	private static String buildMessage(String commandParameterName, Class<?> commandParameterType, String value)
	{
		return "Parameter '" + commandParameterName + "' must be of type " + commandParameterType.toString() + " value is '" + value + "'.";
	}
	
	/**
	 * @param message
	 */
	public CommandTypeValidationException(String commandParameterName, Class<?> commandParameterType)
	{
		super(buildMessage(commandParameterName, commandParameterType));
	}

	public CommandTypeValidationException(String commandParameterName, Class<?> commandParameterType, String value)
	{
		super(buildMessage(commandParameterName, commandParameterType, value));
	}
}