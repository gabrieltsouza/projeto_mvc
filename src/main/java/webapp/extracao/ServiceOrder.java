package webapp.extracao;

public class ServiceOrder {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return SERVC_ORD_CD.toString() +'|'+ SLS_ORD_NR.toString() +'|'+ PLNT_CD.toString();
	}

	private String SERVC_ORD_CD;
	private String SLS_ORD_NR;
	private String PLNT_CD;
	
	public ServiceOrder(String SERVC_ORD_CD, String SLS_ORD_NR, String PLNT_CD) {
		setSERVC_ORD_CD(SERVC_ORD_CD);
		setSLS_ORD_NR(SLS_ORD_NR);
		setPLNT_CD(PLNT_CD);
		
		// TODO Auto-generated constructor stub
	}

	public String getSERVC_ORD_CD() {
		return SERVC_ORD_CD;
	}

	public void setSERVC_ORD_CD(String sERVC_ORD_CD) {
		SERVC_ORD_CD = sERVC_ORD_CD;
	}

	public String getSLS_ORD_NR() {
		return SLS_ORD_NR;
	}

	public void setSLS_ORD_NR(String sLS_ORD_NR) {
		SLS_ORD_NR = sLS_ORD_NR;
	}

	public String getPLNT_CD() {
		return PLNT_CD;
	}

	public void setPLNT_CD(String pLNT_CD) {
		PLNT_CD = pLNT_CD;
	}

}
