/**
 * Package: MAG - VistA Imaging
 * WARNING: Per VHA Directive 2004-038, this routine should not be modified.
 * @date Jul 29, 2010
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

package gov.va.med.configuration;

import java.net.URI;
import javax.naming.NamingException;

/**
 * @author vhaiswbeckec
 *
 */
public interface MockSubConfiguration
	extends Configuration
{
	public URI getSiteServiceUri();
	public void setSiteServiceUri(URI uri);
	
	public Integer getRefreshHour();
	public Void setRefreshHour(Integer refreshHour);
	
	public Integer getRefreshMinimumDelay();
	public void setRefreshMinimumDelay(Integer refreshMinimumDelay);
	
	public Long getRefreshPeriod();
	public void setRefreshPeriod(Long refreshPeriod);
	
	public String getSiteServiceCacheFileName();
	public void setSiteServiceCacheFileName(String filename);
	
	public String getRegionListCacheFileName();
	public void setRegionListCacheFileName(String filename);
}
