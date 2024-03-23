import java.util.Scanner;

class Dugum {
    int veri;
    Dugum onceki, sonraki;

    public Dugum(int veri) {
        this.veri = veri;
        this.onceki = null;
        this.sonraki = null;
    }
}

class CiftBagliListe {
    private Dugum bas;

    public CiftBagliListe() {
        this.bas = null;
    }

    public void ekle(int veri) {
        Dugum yeniDugum = new Dugum(veri);
        if (bas == null) {
            bas = yeniDugum;
        } else {
            Dugum mevcut = bas;
            while (mevcut.sonraki != null) {
                mevcut = mevcut.sonraki;
            }
            mevcut.sonraki = yeniDugum;
            yeniDugum.onceki = mevcut;
        }
    }

    public void yazdir() {
        Dugum mevcut = bas;
        while (mevcut != null) {
            System.out.print(mevcut.veri + " ");
            mevcut = mevcut.sonraki;
        }
        System.out.println();
    }

    public void sirala() {
        if (bas == null || bas.sonraki == null) {
            return;
        }

        boolean degisti;
        do {
            degisti = false;
            Dugum mevcut = bas;
            while (mevcut.sonraki != null) {
                if (mevcut.veri > mevcut.sonraki.veri) {
                    int temp = mevcut.veri;
                    mevcut.veri = mevcut.sonraki.veri;
                    mevcut.sonraki.veri = temp;
                    degisti = true;
                }
                mevcut = mevcut.sonraki;
            }
        } while (degisti);
    }
}

public class CiftYonluBagliListe{
    public static void main(String[] args) {
        CiftBagliListe bagliListe = new CiftBagliListe();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Elemanlar ekleniyor (Çıkış için 'q' tuşuna basın):");

        while (true) {
            System.out.print("Bir sayı girin (Çıkış için 'q'): ");
            String kullaniciGirdisi = scanner.next();

            if (kullaniciGirdisi.equalsIgnoreCase("q")) {
                break;
            }

            try {
                int sayi = Integer.parseInt(kullaniciGirdisi);
                bagliListe.ekle(sayi);
                bagliListe.yazdir();
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz giriş. Bir sayı girin veya 'q' tuşuna basın.");
            }
        }

        
        System.out.println("\nSıralamadan Önce:");
        bagliListe.yazdir();

        
        bagliListe.sirala();

        
        System.out.println("\nSıralamadan Sonra:");
        bagliListe.yazdir();

        scanner.close();
    }
}
