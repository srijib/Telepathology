/**
 * 
  Package: MAG - VistA Imaging
  WARNING: Per VHA Directive 2004-038, this routine should not be modified.
  Date Created: Oct 7, 2009
  Site Name:  Washington OI Field Office, Silver Spring, MD
  Developer:  vhaiswwerfej
  Description: 

        ;; +--------------------------------------------------------------------+
        ;; Property of the US Government.
        ;; No permission to copy or redistribute this software is given.
        ;; Use of unreleased versions of this software requires the user
        ;;  to execute a written test agreement with the VistA Imaging
        ;;  Development Office of the Department of Veterans Affairs,
        ;;  telephone (301) 734-0100.
        ;;
        ;; The Food and Drug Administration classifies this software as
        ;; a Class II medical device.  As such, it may not be changed
        ;; in any way.  Modifications to this software may result in an
        ;; adulterated medical device under 21CFR820, the use of which
        ;; is considered to be a violation of US Federal Statutes.
        ;; +--------------------------------------------------------------------+

 */
package gov.va.med.imaging.core.interfaces.exceptions;

/**
 * Exception occurs when credentials to access a data source
 * have expired.  This exception should be used to indicate the credentials should be
 * updated and the same data source can be tried again. This exception does not indicate
 * any other sort of communication malfunction.
 * 
 * @author vhaiswwerfej
 *
 */
public class SecurityCredentialsExpiredException 
extends SecurityException
{
	private static final long serialVersionUID = 1L;
	
	public SecurityCredentialsExpiredException()
	{
		super();
	}

	public SecurityCredentialsExpiredException(String message)
	{
		super(message);
	}

	public SecurityCredentialsExpiredException(Throwable cause)
	{
		super(cause);
	}

	public SecurityCredentialsExpiredException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
