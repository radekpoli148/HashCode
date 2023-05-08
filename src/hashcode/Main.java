package hashcode;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Element implements Comparable
{
    int wartosc;
    String opis;
    public Element(int wartosc)
    {
        this.wartosc = wartosc;
    }
    public Element(int wartosc, String opis)
    {
        this(wartosc);
        this.opis = opis;
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
    
    public String pobierzOpis()
    {
        return opis;
    }
    @Override
    public int compareTo(Object o) {
        return wartosc - ((Element)o).wartosc;
    }
}
public class Main {

    public static void main(String[] args) 
    {
        /* poprzednia lekcja - kody i funkcje mieszające
        Element a = new Element(42);
        Element b = new Element(10);
        Element c = null;
        
        System.out.println(a.equals(b));
        
        System.out.println(a.hashCode()%32);
        System.out.println(b.hashCode()%32);*/
        
        /* lekcja HashSet i TreeSet
        long mili = 0;
        long totalMili = 0;
        Set<String> set = new HashSet<String>(512);
        set = new TreeSet<String>();
        try 
        {
            Scanner reader = new Scanner(new BufferedReader(new FileReader("LoremIpsum.txt")));
            
            while(reader.hasNext())
            {
                mili = System.currentTimeMillis();

                set.add(reader.next());

                totalMili+= (System.currentTimeMillis() - mili);
            }
            
            reader.close();
        } 
        catch (FileNotFoundException ex) 
        {
            ex.printStackTrace();
        }
        
        Iterator<String> iter = set.iterator();
        while(iter.hasNext())
            System.out.println(iter.next());
        
        System.out.println("Czas wykonania: "+totalMili+" ms");
        System.out.println("wielkosc zbioru: "+set.size());
        */
        
        Set<Element> set =  new TreeSet<Element>(
                new Comparator<Element>(){
            @Override
            public int compare(Element o1, Element o2) {
                String opisO1 = o1.pobierzOpis();
                String opisO2 = o2.pobierzOpis();
                
                return opisO1.compareTo(opisO2);
            }
        }
                
                );
        
        set.add(new Element(1255, "opis"));
        set.add(new Element(3254, "aopis"));
        set.add(new Element(756, "zopis"));
        
        Iterator<Element> iter = set.iterator();
        while(iter.hasNext())
            System.out.println(iter.next().pobierzOpis());
        
        System.out.println("wielkosc zbioru: "+set.size());
    }
    
}
