/**
 * 
  Package: MAG - VistA Imaging
  WARNING: Per VHA Directive 2004-038, this routine should not be modified.
  Date Created: Oct 31, 2011
  Site Name:  Washington OI Field Office, Silver Spring, MD
  Developer:  VHAISWWERFEJ
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
package gov.va.med.imaging.router.cache;

import gov.va.med.imaging.exchange.storage.cache.DODSourcedCache;
import gov.va.med.imaging.exchange.storage.cache.VASourcedCache;

/**
 * @author VHAISWWERFEJ
 *
 */
public class ImagingCacheImpl 
implements ImagingCache
{
	private final DODSourcedCache dodSourcedCache;
	private final VASourcedCache vaSourcedCache;
	
	public ImagingCacheImpl(DODSourcedCache extraEnterpriseCache,
			VASourcedCache intraEnterpriseCacheCache)
	{
		this.dodSourcedCache = extraEnterpriseCache;
		this.vaSourcedCache = intraEnterpriseCacheCache;
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.router.cache.ImagingCache#getDODSourcedCache()
	 */
	@Override
	public DODSourcedCache getDODSourcedCache()
	{
		return dodSourcedCache;
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.router.cache.ImagingCache#getVASourcedCache()
	 */
	@Override
	public VASourcedCache getVASourcedCache()
	{
		return vaSourcedCache;
	}

}
