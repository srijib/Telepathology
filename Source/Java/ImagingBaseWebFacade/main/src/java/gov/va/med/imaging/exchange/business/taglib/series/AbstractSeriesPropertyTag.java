/**
 * Package: MAG - VistA Imaging
 * WARNING: Per VHA Directive 2004-038, this routine should not be modified.
 * Date Created: Jan 30, 2008
 * Site Name:  Washington OI Field Office, Silver Spring, MD
 * @author VHAISWBECKEC
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
package gov.va.med.imaging.exchange.business.taglib.series;

import gov.va.med.imaging.exchange.business.Series;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

/**
 * The parent class of tags that display Study properties.
 * Derivations of this class MUST reside within a StudyPresentationTag
 * element.
 * 
 * @author VHAISWBECKEC
 *
 */
public abstract class AbstractSeriesPropertyTag 
extends TagSupport
{
	private final Logger logger = Logger.getLogger(this.getClass());
	
	private AbstractSeriesTag getParentSeriesTag()
	throws JspException
	{
		try
        {
			return (AbstractSeriesTag)TagSupport.findAncestorWithClass(this, AbstractSeriesTag.class);
        } 
		catch (ClassCastException e)
        {
			throw new JspException("Parent tag of AbstractSeriesPropertyTag must be of type AbstractSeriesTag");
        }
	}

	/**
     * @return the logger
     */
    protected Logger getLogger()
    {
    	return logger;
    }

	protected Series getSeries()
	throws JspException
	{
		return getParentSeriesTag().getSeries();
	}
	
	protected Writer getWriter() 
	throws IOException
	{
		return pageContext.getOut();
	}
	
	/**
	 * Derived classes should return the value of their element by implementing
	 * this method.
	 * 
	 * @return
	 * @throws JspException
	 */
	protected abstract String getElementValue()
	throws JspException;

	/**
     * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
     */
    @Override
    public int doEndTag() 
    throws JspException
    {
    	try
        {
	        getWriter().write(getElementValue());
        } 
    	catch (IOException e)
        {
    		throw new JspException(e);
        }
    	
    	return Tag.EVAL_PAGE;
    }
	
	
}