package studentadventure;

public class Odziez extends Przedmiot {
	private int pktDoObrony;
	private int pktDoSTR;
	private int pktDoINT;
	private int pktDoEND;
	private int pktDoCHAR;
	
	public Odziez(String name,String desc, int pDO, int pDS, int pDI, int pDE, int pDC) {
		setPktDoCHAR(pDC);
		setPktDoObrony(pDO);
		setPktDoEND(pDE);
		setPktDoSTR(pDS);
		setPktDoINT(pDI);
		this.nazwa=name;
		this.opis=desc;
	}

	public int getPktDoObrony() {
		return pktDoObrony;
	}

	public void setPktDoObrony(int pktDoObrony) {
		this.pktDoObrony = pktDoObrony;
	}

	public int getPktDoSTR() {
		return pktDoSTR;
	}

	public void setPktDoSTR(int pktDoSTR) {
		this.pktDoSTR = pktDoSTR;
	}

	public int getPktDoINT() {
		return pktDoINT;
	}

	public void setPktDoINT(int pktDoINT) {
		this.pktDoINT = pktDoINT;
	}

	public int getPktDoEND() {
		return pktDoEND;
	}

	public void setPktDoEND(int pktDoEND) {
		this.pktDoEND = pktDoEND;
	}

	public int getPktDoCHAR() {
		return pktDoCHAR;
	}

	public void setPktDoCHAR(int pktDoCHAR) {
		this.pktDoCHAR = pktDoCHAR;
	}
}