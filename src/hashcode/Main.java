package hashcode;

import java.util.Objects;

class Element
{
    public Element(int wartosc)
    {
        this.wartosc = wartosc;
    }
    @Override //po nadpisaniu metody equals można porównać artości obu elementów
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || this.getClass() != obj.getClass()) 
            return false;
        return this.wartosc == ((Element)obj).wartosc;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 16 * hash + this.wartosc;
        /*hash = 37 * hash + (int) (Double.doubleToLongBits(this.cos) ^ (Double.doubleToLongBits(this.cos) >>> 32));
        hash = 37 * hash + (int) (this.cos2 ^ (this.cos2 >>> 32));
        hash = 37 * hash + Objects.hashCode(this.cos3);*/
        return hash;
    }

    
    int wartosc;
    double cos;
    long cos2;
    String cos3;
}
public class Main {

    public static void main(String[] args) 
    {
        Element a = new Element(42);
        Element b = new Element(10);
        Element c = null;
        
        System.out.println(a.equals(b));
        
        System.out.println(a.hashCode()%32);
        System.out.println(b.hashCode()%32);
    }
    
}
