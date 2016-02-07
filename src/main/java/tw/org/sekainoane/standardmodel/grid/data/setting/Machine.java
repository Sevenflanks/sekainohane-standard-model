package tw.org.sekainoane.standardmodel.grid.data.setting;

/**
 * 機器, 上層為子部門
 * @author RHYS
 */
public enum Machine {

	PT02(SubDept.PT),
	PT04(SubDept.PT),
	PT03(SubDept.PT),
	MD03(SubDept.MAG),
	MD04(SubDept.MAG),
	MD05(SubDept.MAG),
	MD27(SubDept.MAG),
	MD01(SubDept.MAG),
	MD02(SubDept.MAG),
	MD09(SubDept.LAM),
	MD19(SubDept.LAM),
	MD11(SubDept.LAM),
	MD12(SubDept.DIE),
	MD13(SubDept.DIE),
	MD14(SubDept.DIE),
	MD15(SubDept.DIE),
	MD18(SubDept.DIE),
	MD16(SubDept.DIE),
	MD17(SubDept.DIE),
	MD22(SubDept.DIE),
	MD28(SubDept.DIE),
	MD24(SubDept.LAM),
	MD06(SubDept.HOT),
	MD21(SubDept.HOT),
	MD25(SubDept.HOT),
	MD26(SubDept.HOT),
	PZ01(SubDept.PZ),
	PZ02(SubDept.PZ),
	PZ13(SubDept.PZ),
	PZ14(SubDept.PZ),
	PZ03(SubDept.PZ),
	PZ04(SubDept.PZ),
	PZ05(SubDept.PZ),
	PZ06(SubDept.PZ),
	PZ07(SubDept.PZ),
	PZ08(SubDept.PZ),
	PZ15(SubDept.PZ),
	PZ16(SubDept.PZ),
	PZ09(SubDept.PZ),
	PZ10(SubDept.PZ),
	QAR01(SubDept.QAR),
	TP01(SubDept.TP),
	TP02(SubDept.TP),
	TP03(SubDept.TP),
	TP04(SubDept.TP),
	TP05(SubDept.TP),
	MP01(SubDept.MP),
	MP02(SubDept.MP),
	MP03(SubDept.MP),
	MP08(SubDept.MP),
	MP04(SubDept.MP),
	MP06(SubDept.MP),
	MP07(SubDept.MP),
	HS01(SubDept.HS),
	HS02(SubDept.HS),
	HS03(SubDept.HS),
	HS04(SubDept.HS),
	HS05(SubDept.HS),
	HS06(SubDept.HS),
	HS07(SubDept.HS),
	HS08(SubDept.HS),
	PK03(SubDept.SWP),
	PK05(SubDept.SWP),
	PK07(SubDept.SWP),
	PK04(SubDept.SWP),
	PK01(SubDept.SWP),
	PK02(SubDept.SWP),
	PK08(SubDept.SWP),
	PK09(SubDept.SWP),
	PK10(SubDept.SWP),
	PK11(SubDept.SWP),
	PK13(SubDept.SWP),
	PK14(SubDept.SWP),
	;
	
	private SubDept subDept;
	
	public SubDept getSubDept() {
		return subDept;
	}

	private Machine(SubDept subDept) {
		this.subDept = subDept;
	}
}
