/**
 * 
  Package: MAG - VistA Imaging
  WARNING: Per VHA Directive 2004-038, this routine should not be modified.
  Date Created: 
  Site Name:  Washington OI Field Office, Silver Spring, MD
  Developer:  vhaiswpeterb
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

package gov.va.med.imaging.dicom.common.stats;

public class ModalityCodeStatistics implements ModalityCodeStatisticsMBean {
	
	private String modalityCode;
	private int totalStudiesProcessed;
	private int totalDicomObjectsProcessed;
	private int totalDicomObjectsRejected;
	
	public ModalityCodeStatistics(String modalityCode){
		this.modalityCode = modalityCode;
		this.totalStudiesProcessed = 0;
		this.totalDicomObjectsProcessed = 0;
		this.totalDicomObjectsRejected = 0;
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.dicom.common.stats.ModalityCodeStatisticsMBean#getModalityCode()
	 */
	public String getModalityCode() {
		return modalityCode;
	}

	/**
	 * @param modalityCode the modalityCode to set
	 */
	public void setModalityCode(String modalityCode) {
		this.modalityCode = modalityCode;
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.dicom.common.stats.ModalityCodeStatisticsMBean#getTotalStudiesProcessed()
	 */
	public int getTotalStudiesProcessed() {
		return totalStudiesProcessed;
	}
	
	public synchronized void incrementStudiesProcessedCount(){
		this.totalStudiesProcessed++;
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.dicom.common.stats.ModalityCodeStatisticsMBean#getTotalDicomObjectsProcessed()
	 */
	public int getTotalDicomObjectsProcessed() {
		return totalDicomObjectsProcessed;
	}
	
	public synchronized void incrementDicomObjectsProcessedCount(){
		this.totalDicomObjectsProcessed++;
	}

	/* (non-Javadoc)
	 * @see gov.va.med.imaging.dicom.common.stats.ModalityCodeStatisticsMBean#getTotalDicomObjectsRejected()
	 */
	public int getTotalDicomObjectsRejected() {
		return totalDicomObjectsRejected;
	}
	
	public synchronized void incrementDicomObjectsRejectedCount(){
		this.totalDicomObjectsRejected++;
	}
	
}