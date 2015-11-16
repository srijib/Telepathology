/**
 * Package: MAG - VistA Imaging
 * WARNING: Per VHA Directive 2004-038, this routine should not be modified.
 * Date Created: Jul 1, 2008
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
package gov.va.med.imaging.access.je.taglib;

import gov.va.med.imaging.access.TransactionLogEntry;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.*;

/**
 * @author VHAISWBECKEC
 * This tag MUST live within a TransactionLogTag, which maintains the 
 * collection and the enumeration of the collection.  The TransactionLogTag also
 * collects and maintains statistics, which is why the enumeration of the list
 * must be managed by it.
 */
public class TransactionLogEntriesTag 
extends TagSupport
implements TransactionLogEnumerationParent
{
	private static final long serialVersionUID = 1L;

	/**
	 * Get the surrounding TransactionLogTag instance.
	 * @return
	 */
	private TransactionLogTag getTransactionLogParent()
	{
		return (TransactionLogTag)TagSupport.findAncestorWithClass(this, TransactionLogTag.class);
	}

	/**
     * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
     */
    @Override
    public int doStartTag() 
    throws JspException
    {
    	if (getCurrentTransactionLogEntry() == null)
    	{
    		return Tag.SKIP_BODY;
    	}
    	else
    	{
    		getTransactionLogParent().incrementPerPageRowCount();
    		return Tag.EVAL_BODY_INCLUDE;
    	}
    }


	@Override
    public TransactionLogEntry getCurrentTransactionLogEntry()
    {
	    return getTransactionLogParent().getCurrentTransactionLogEntry();
    }

	/**
     * @see javax.servlet.jsp.tagext.TagSupport#doAfterBody()
     */
    @Override
    public int doAfterBody() 
    throws JspException
    {
    	if( getTransactionLogParent().nextLogEntryElement() )
    	{
    		getTransactionLogParent().incrementPerPageRowCount();
    		return IterationTag.EVAL_BODY_AGAIN;
    	}
    	else
    	{
    		return Tag.SKIP_BODY;
    	}
    }
}
