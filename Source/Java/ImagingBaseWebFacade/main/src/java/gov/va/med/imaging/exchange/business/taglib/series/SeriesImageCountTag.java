package gov.va.med.imaging.exchange.business.taglib.series;

import javax.servlet.jsp.JspException;

public class SeriesImageCountTag 
extends AbstractSeriesPropertyTag
{
	private static final long serialVersionUID = 1L;

	@Override
	protected String getElementValue() 
	throws JspException
	{
		return Integer.toString( getSeries().getImageCount() );
	}

}
