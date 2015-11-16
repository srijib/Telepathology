/**
 * Package: MAG - VistA Imaging
 * WARNING: Per VHA Directive 2004-038, this routine should not be modified.
 * @date Jul 21, 2010
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

package gov.va.med.imaging;

import gov.va.med.ProtocolHandlerUtility;
import junit.framework.TestCase;

/**
 * @author vhaiswbeckec
 *
 */
public class TestKnownProtocols
extends TestCase
{

	/**
	 * Test method for {@link gov.va.med.imaging.KnownProtocols#isInstalled()}.
	 */
	public void testIsInstalled()
	{
		//KnownProtocols.uninitializeConnectionHandlers();
		
		//assertFalse(KnownProtocols.AWIV.isInstalled());
		//assertFalse(KnownProtocols.CDTP.isInstalled());
		//assertFalse(KnownProtocols.EXCHANGE.isInstalled());
		//assertFalse(KnownProtocols.VFTP.isInstalled());
		//assertFalse(KnownProtocols.VISTA.isInstalled());
		//assertFalse(KnownProtocols.VISTAIMAGING.isInstalled());
		//assertFalse(KnownProtocols.XCA.isInstalled());
		
		ProtocolHandlerUtility.initialize(true);
		
		assertTrue(KnownProtocols.AWIV.isInstalled());
		assertTrue(KnownProtocols.CDTP.isInstalled());
		assertTrue(KnownProtocols.EXCHANGE.isInstalled());
		assertTrue(KnownProtocols.VFTP.isInstalled());
		assertTrue(KnownProtocols.VISTA.isInstalled());
		assertTrue(KnownProtocols.VISTAIMAGING.isInstalled());
		assertTrue(KnownProtocols.XCA.isInstalled());
	}

}
