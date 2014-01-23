     
 
    package studentadventure;
     
    import java.awt.Image;
     
    public class Item extends Przedmiot{
            private int plusDoObrony;
            private int plusDoSily;
            private int plusDoInteligencji;
            private int plusDoWytrzymalosci;
            private int plusDoCharyzmy;
     
            public Item(String name, String desc, int pDO, int pDS, int pDI, int pDW, int pDC)
            {
                    this.nazwa=name;
                    this.opis=desc;
                    setPlusDoObrony(pDO);
                    setPlusDoSily(pDS);
                    setPlusDoInteligencji(pDI);
                    setPlusDoWytrzymalosci(pDW);
                    setPlusDoCharyzmy(pDC);
            }
     
     
            public int getPlusDoObrony() {
                    return plusDoObrony;
            }
     
            public void setPlusDoObrony(int plusDoObrony) {
                    this.plusDoObrony = plusDoObrony;
            }
     
            public int getPlusDoSily() {
                    return plusDoSily;
            }
     
            public void setPlusDoSily(int plusDoSily) {
                    this.plusDoSily = plusDoSily;
            }
     
            public int getPlusDoInteligencji() {
                    return plusDoInteligencji;
            }
     
            public void setPlusDoInteligencji(int plusDoInteligencji) {
                    this.plusDoInteligencji = plusDoInteligencji;
            }
     
            public int getPlusDoWytrzymalosci() {
                    return plusDoWytrzymalosci;
            }
     
            public void setPlusDoWytrzymalosci(int plusDoWytrzymalosci) {
                    this.plusDoWytrzymalosci = plusDoWytrzymalosci;
            }
     
            public int getPlusDoCharyzmy() {
                    return plusDoCharyzmy;
            }
     
            public void setPlusDoCharyzmy(int plusDoCharyzmy) {
                    this.plusDoCharyzmy = plusDoCharyzmy;
            }
    }