package tw.org.sekainoane.standardmodel.grid.data.setting;

/**
 * 子部門, 上層為部門
 * @author RHYS
 */
public enum SubDept {
	
	PT(Dept.PT),
	MAG(Dept.MID),
	HOT(Dept.MID),
	LAM(Dept.MID),
	DIE(Dept.MID),
	PZ(Dept.PZ),
	QA(Dept.QA),
	QAR(Dept.QA),
	MP(Dept.MP),
	HS(Dept.MP),
	TP(Dept.TP),
	SWP(Dept.PK);
	
	private Dept dept;
	
	public Dept getDept() {
		return dept;
	}

	private SubDept(Dept dept) {
		this.dept = dept;
	}

}
