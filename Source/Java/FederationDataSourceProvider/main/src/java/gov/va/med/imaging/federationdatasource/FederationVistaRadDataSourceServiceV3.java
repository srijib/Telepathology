/**
 * 
Package: MAG - VistA Imaging
  WARNING: Per VHA Directive 2004-038, this routine should not be modified.
  Date Created: Sep 15, 2009
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
package gov.va.med.imaging.federationdatasource;

import gov.va.med.RoutingToken;
import gov.va.med.imaging.StudyURN;
import gov.va.med.imaging.artifactsource.ResolvedArtifactSource;
import gov.va.med.imaging.core.interfaces.exceptions.ConnectionException;
import gov.va.med.imaging.core.interfaces.exceptions.MethodException;
import gov.va.med.imaging.exchange.business.vistarad.ActiveExams;
import gov.va.med.imaging.exchange.business.vistarad.Exam;
import gov.va.med.imaging.exchange.business.vistarad.ExamImages;
import gov.va.med.imaging.exchange.business.vistarad.ExamListResult;
import gov.va.med.imaging.exchange.business.vistarad.PatientRegistration;
import gov.va.med.imaging.federation.proxy.FederationProxyV3;
import gov.va.med.imaging.proxy.services.ProxyServices;
import gov.va.med.imaging.transactioncontext.TransactionContextFactory;
import gov.va.med.imaging.url.federation.exceptions.FederationConnectionException;
import gov.va.med.imaging.url.vftp.VftpConnection;

import java.io.IOException;
import java.util.List;

/**
 * @author vhaiswwerfej
 *
 */
public class FederationVistaRadDataSourceServiceV3 
extends AbstractFederationVistaRadDataSourceService 
{	
	private final static String DATASOURCE_VERSION = "3";
	
	private final VftpConnection federationConnection;
	private FederationProxyV3 proxy = null;

	
	/**
	 * @param resolvedArtifactSource
	 * @param protocol
	 * @throws UnsupportedOperationException
	 */
	public FederationVistaRadDataSourceServiceV3(ResolvedArtifactSource resolvedArtifactSource, String protocol)
		throws UnsupportedOperationException
	{
		super(resolvedArtifactSource, protocol);
		federationConnection = new VftpConnection(getMetadataUrl());
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.datasource.VistaRadDataSource#getActiveExams(java.lang.String)
	 */
	@Override
	public ActiveExams getActiveExams(RoutingToken globalRoutingToken, String listDescriptor)
	throws MethodException, ConnectionException 
	{
		getLogger().info("getActiveExams for list descriptor (" + listDescriptor + 
				"), TransactionContext (" + 				
				TransactionContextFactory.get().getDisplayIdentity() + ").");
		try 
		{
			federationConnection.connect();			
		}
		catch(IOException ioX) 
		{
			getLogger().error("Error getting active exams", ioX);
			throw new FederationConnectionException(ioX);
		}
		
		ActiveExams activeExams = getProxy().getActiveExams(getSite(), listDescriptor);		
		getLogger().info("getActiveExams got [" + (activeExams == null ? "0" : activeExams.size()) + "] active exams from site [" + getSite().getSiteNumber() + "]");			
		return activeExams;			
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.datasource.VistaRadDataSource#getExamImagesForExam(gov.va.med.imaging.StudyURN)
	 */
	@Override
	public ExamImages getExamImagesForExam(StudyURN studyUrn)
	throws MethodException, ConnectionException 
	{
		getLogger().info("getExamImagesForExam for studyURN (" + studyUrn.toString() + 
				"), TransactionContext (" + 				
				TransactionContextFactory.get().getDisplayIdentity() + ").");
		try 
		{
			federationConnection.connect();			
		}
		catch(IOException ioX) 
		{
			getLogger().error("Error getting exam images", ioX);
			throw new FederationConnectionException(ioX);
		}
		ExamImages images = getProxy().getExamImagesForExam(studyUrn);		
		getLogger().info("getExamImagesForExam got [" + (images == null ? "0" : images.size()) + "] exam images from site [" + getSite().getSiteNumber() + "]");			
		return images;		
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.datasource.VistaRadDataSource#getExamReport(gov.va.med.imaging.StudyURN)
	 */
	@Override
	public String getExamReport(StudyURN studyUrn) 
	throws MethodException, ConnectionException 
	{
		getLogger().info("getExamReport for studyURN (" + studyUrn.toString() + 
				"), TransactionContext (" + 				
				TransactionContextFactory.get().getDisplayIdentity() + ").");
		try 
		{
			federationConnection.connect();			
		}
		catch(IOException ioX) 
		{
			getLogger().error("Error getting active exams", ioX);
			throw new FederationConnectionException(ioX);
		}
		String report = getProxy().getExamRadiologyReport(studyUrn);
		TransactionContextFactory.get().setDataSourceBytesReceived(report == null ? 0L : report.length());
		return report;
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.datasource.VistaRadDataSource#getExamRequisitionReport(gov.va.med.imaging.StudyURN)
	 */
	@Override
	public String getExamRequisitionReport(StudyURN studyUrn)
	throws MethodException, ConnectionException 
	{
		getLogger().info("getExamReport for studyURN (" + studyUrn.toString() + 
				"), TransactionContext (" + 				
				TransactionContextFactory.get().getDisplayIdentity() + ").");
		try 
		{
			federationConnection.connect();			
		}
		catch(IOException ioX) 
		{
			getLogger().error("Error getting active exams", ioX);
			throw new FederationConnectionException(ioX);
		}
		String report = getProxy().getExamRequisitionReport(studyUrn);
		TransactionContextFactory.get().setDataSourceBytesReceived(report == null ? 0L : report.length());
		return report;
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.datasource.VistaRadDataSource#getExamsForPatient(java.lang.String, boolean)
	 */
	@Override
	public ExamListResult getExamsForPatient(RoutingToken globalRoutingToken, String patientICN,
			boolean fullyLoadExams, boolean forceRefresh, boolean forceImagesFromJb) 
	throws MethodException, ConnectionException 
	{
		getLogger().info("getExamsForPatient for patient Icn (" + patientICN + 
				"), fullyLoaded ('" + fullyLoadExams + "'), TransactionContext (" + 				
				TransactionContextFactory.get().getDisplayIdentity() + ").");
		try 
		{
			federationConnection.connect();			
		}
		catch(IOException ioX) 
		{
			getLogger().error("Error getting patient exams", ioX);
			throw new FederationConnectionException(ioX);
		}
		
		List<Exam> exams = getProxy().getExamsForPatient(getSite(), patientICN, fullyLoadExams);
		getLogger().info("getExamsForPatient got [" + (exams == null ? "0" : exams.size()) + "] patient exams from site [" + getSite().getSiteNumber() + "]");			
		return ExamListResult.createFullResult(exams);		
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.datasource.VistaRadDataSource#getNextPatientRegistration()
	 */
	@Override
	public PatientRegistration getNextPatientRegistration(RoutingToken globalRoutingToken)
	throws MethodException, ConnectionException 
	{
		getLogger().info("getNextPatientRegistration TransactionContext (" + 				
				TransactionContextFactory.get().getDisplayIdentity() + ").");
		try 
		{
			federationConnection.connect();			
		}
		catch(IOException ioX) 
		{
			getLogger().error("Error getting next patient registration", ioX);
			throw new FederationConnectionException(ioX);
		}
		
		PatientRegistration patientRegistration = getProxy().getNextPatientRegistration(getSite());
		getLogger().info("getNextPatientRegistration got [" + (patientRegistration == null ? "null" : "not null") + "] patient registration from site [" + getSite().getSiteNumber() + "]");			
		return patientRegistration;	
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.datasource.VistaRadDataSource#getRelevantPriorCptCodes(java.lang.String)
	 */
	@Override
	public String[] getRelevantPriorCptCodes(RoutingToken globalRoutingToken, String cptCode)
	throws MethodException, ConnectionException 
	{
		getLogger().info("getRelevantPriorCptCodes for CPT Code (" + cptCode + 
				"), TransactionContext (" + 				
				TransactionContextFactory.get().getDisplayIdentity() + ").");
		try 
		{
			federationConnection.connect();			
		}
		catch(IOException ioX) 
		{
			getLogger().error("Error getting relevant prior CPT codes", ioX);
			throw new FederationConnectionException(ioX);
		}
		String [] result = getProxy().getRelevantPriorCptCodes(getSite(), cptCode);
		getLogger().info("getRelevantPriorCptCodes got [" + (result == null ? "0" : result.length) + "] relevant CPT codes from site [" + getSite().getSiteNumber() + "]");			
		return result;	
	}
	
	
	
	/* (non-Javadoc)
	 * @see gov.va.med.imaging.datasource.VistaRadDataSource#getExam(gov.va.med.imaging.StudyURN)
	 */
	@Override
	public Exam getExam(StudyURN studyUrn) 
	throws MethodException, ConnectionException 
	{
		getLogger().info("getExam for Study URN (" + studyUrn.toString() + 
				"), TransactionContext (" + 				
				TransactionContextFactory.get().getDisplayIdentity() + ").");
		try 
		{
			federationConnection.connect();			
		}
		catch(IOException ioX) 
		{
			getLogger().error("Error getting exam", ioX);
			throw new FederationConnectionException(ioX);
		}
		Exam result = getProxy().getExam(studyUrn);
		getLogger().info("getExam got [" + (result == null ? "null" : "not null") + "] exam for URN [" + studyUrn.toString() + "].");			
		return result;	
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.datasource.VistaRadDataSource#postExamAccessEvent(java.lang.String)
	 */
	@Override
	public boolean postExamAccessEvent(RoutingToken globalRoutingToken, String inputParameter)
	throws MethodException, ConnectionException 
	{
	
		getLogger().info("postExamAccessEvent for input(" + inputParameter + 
				"), TransactionContext (" + 				
				TransactionContextFactory.get().getDisplayIdentity() + ").");
		try 
		{
			federationConnection.connect();			
		}
		catch(IOException ioX) 
		{
			getLogger().error("Error posting exam access", ioX);
			throw new FederationConnectionException(ioX);
		}
		boolean result = getProxy().postExamAccess(getSite(), inputParameter);
		getLogger().info("postExamAccessEvent got [" + (result) + "] from site '" + getSite().getSiteNumber() + "'.");			
		return result;	
	}

	private FederationProxyV3 getProxy()
	throws ConnectionException
	{
		if(proxy == null)
		{
			ProxyServices proxyServices = getFederationProxyServices();
			if(proxyServices == null)
				throw new ConnectionException("Did not receive any applicable services from IDS service for site [" + getSite().getSiteNumber() + "]");
			proxy = new FederationProxyV3(proxyServices, FederationDataSourceProvider.getFederationConfiguration());
		}
		return proxy;
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.federationdatasource.AbstractFederationVistaRadDataSourceService#getDataSourceVersion()
	 */
	@Override
	public String getDataSourceVersion() 
	{
		return DATASOURCE_VERSION;
	}
}
