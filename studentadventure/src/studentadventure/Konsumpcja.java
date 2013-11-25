package studentadventure;

public class Konsumpcja extends Przedmiot {
	private int doHP;
	private int doMP;
	private int doSTR;
	private int doEND;
	private int doINT;
	private int doCHAR;
	
	public Konsumpcja(String name, String desc, int dHP, int dMP, int dS,int dE,int dI,int dC) {
		this.nazwa=name;
		this.opis=desc;
		doHP=dHP;
		doMP=dMP;
		doSTR=dS;
		doINT=dI;
		doCHAR=dC;
		doEND=dE;
	}
	
//	void uzyj(Bohater bohater) {
//		bohater.getHP()+=doHP;
//	}

	public int getDoHP() {
		return doHP;
	}

	public void setDoHP(int doHP) {
		this.doHP = doHP;
	}

	public int getDoMP() {
		return doMP;
	}

	public void setDoMP(int doMP) {
		this.doMP = doMP;
	}

	public int getDoSTR() {
		return doSTR;
	}

	public void setDoSTR(int doSTR) {
		this.doSTR = doSTR;
	}

	public int getDoEND() {
		return doEND;
	}

	public void setDoEND(int doEND) {
		this.doEND = doEND;
	}

	public int getDoINT() {
		return doINT;
	}

	public void setDoINT(int doINT) {
		this.doINT = doINT;
	}

	public int getDoCHAR() {
		return doCHAR;
	}

	public void setDoCHAR(int doCHAR) {
		this.doCHAR = doCHAR;
	}
}
