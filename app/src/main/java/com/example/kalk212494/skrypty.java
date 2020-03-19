package com.example.kalk212494;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;


public class skrypty {

    //Context context;
    boolean blad;

    boolean znak;
    boolean kropka;
    int dzialanie;

    String napis;

    double pierwszy;
    double drugi;

    // znaki
    // 0 brak znaku
    // 1 plus
    // 2 minus
    // 3 mnoznik
    // 4 dzielnik

    public void clear_all (TextView pole)
    {
        blad = false;

        znak = false;
        kropka = false;
        dzialanie = 0;

        napis = "0";

        pierwszy = 0;
        drugi = 0;

        pole.setText(napis);
    }

    void toastowanie(Context context, String message)
    {
        context = context.getApplicationContext();
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, message, duration);
        toast.setGravity(Gravity.TOP|Gravity.RIGHT, 0, 0);

        toast.show();
    }

    public void pisanie (TextView pole, String wartosc) {
        if ((napis == "0") && (wartosc == "0"))
        {
        }
        else if( (wartosc == ".") )
        {
            if( kropka==false )
            {
                napis = napis + wartosc;
                kropka = true;
            }
        }
        else {
            if (napis == "0") {

                napis = "";
            }
            napis = napis + wartosc;
        }


        pole.setText(napis);
    }

    double przeniesienie(String a)
    {
        return Double.parseDouble(a);
    }

    String przeniesienie(double a)
    {
        return Double.toString(a);
    }

    void is_kropka_there()
    {
        kropka = false;
        int i;
        for(i = 0; i<napis.length() ; i++)
        {

            if(napis.charAt(i) == '.') {
                kropka = true;
            }
        }
    }

    void rowna_sie(TextView pole, Context context)
    {
        if(dzialanie==0)
        {
        }
        else if(dzialanie==1)
        {
            drugi = przeniesienie(napis);
            pierwszy = pierwszy + drugi;
        }
        else if(dzialanie==2)
        {
            drugi = przeniesienie(napis);
            pierwszy = pierwszy - drugi;
        }
        else if(dzialanie==3)
        {
            drugi = przeniesienie(napis);
            pierwszy = pierwszy * drugi;
        }
        else if(dzialanie==4)
        {
            drugi = przeniesienie(napis);

            if(drugi==0)
            {
                toastowanie(context, "BŁĄD -> NIE MOZNA DZIELIC PRZEZ 0");
                blad = true;
            }
            else{
                pierwszy = pierwszy / drugi;
            }

        }

        if(dzialanie!=0 && blad==false) {
            napis = przeniesienie(pierwszy);

            dzialanie = 0;
            drugi = 0;

            delete_kropka_kreska();
            is_kropka_there();
            is_znak();
            pole.setText(napis);
        }
        else if(blad == true)
        {
            clear_all(pole);
        }

    }

    void delete_kropka_kreska()
    {
        if(napis.charAt(napis.length()-2) == '.')
        {
            if(napis.charAt(napis.length()-1) == '0')
            {
                napis = napis.substring(0, napis.length() - 2);
            }
        }
    }

    void is_znak()
    {
        if(napis.charAt(0) == '-')
        {
            znak = true;
        }
        else{
            znak = false;
        }
    }

    void zmiana_znaku(TextView pole)
    {
        if(napis == "0")
        {}
        else if(napis == "")
        {}
        else
        {
            if(znak == true)
            {
                napis = napis.substring(1);
                znak = false;
            }
            else {
                napis = "-" + napis;
                znak = true;
            }
            pole.setText(napis);
        }
    }

    void dodawanie(TextView pole)
    {
        pierwszy = przeniesienie(napis);
        dzialanie = 1;
        napis = "";
        is_kropka_there();
    }

    void odejmowanie(TextView pole)
    {
        pierwszy = przeniesienie(napis);
        napis = "";
        is_kropka_there();
        dzialanie = 2;
    }

    void mnozenie(TextView pole)
    {
        pierwszy = przeniesienie(napis);
        napis = "";
        is_kropka_there();
        dzialanie = 3;
    }

    void dzielenie(TextView pole)
    {
        pierwszy = przeniesienie(napis);
        napis = "";
        is_kropka_there();
        dzialanie = 4;
    }

    void backspace(TextView pole)
    {

        if(napis == "0")
        {
        }
        else {

            napis = napis.substring(0,napis.length()-1);

            if(napis.length() == 0)
            {
                napis = "0";
            }


        }
        is_kropka_there();
        pole.setText(napis);
    }

}


class skrypty_advanced extends skrypty
{
    void potega(TextView pole)
    {
        pierwszy = przeniesienie(napis);
        napis = "";
        is_kropka_there();
        dzialanie = 5;
    }

    void rowna_sie2(TextView pole, Context context)
    {
        if(dzialanie>=0 && dzialanie<=4)
        {

            this.rowna_sie(pole, context);
        }
        else{

            if(dzialanie==5)
            {
                drugi = przeniesienie(napis);
                pierwszy = Math.pow( pierwszy , drugi);
            }


            if(dzialanie!=0 && blad==false) {
                napis = przeniesienie(pierwszy);

                dzialanie = 0;
                drugi = 0;

                delete_kropka_kreska();
                is_kropka_there();
                is_znak();
                pole.setText(napis);
            }
            else if(blad == true)
            {
                clear_all(pole);
            }

        }


    }

    void obliczanie_procentow(TextView pole, Context context) // (pierwszy) dzialanie (pierwszy*drugi%)
    {

        if(dzialanie==0)
        {
        }
        else if(dzialanie==1)
        {
            drugi = przeniesienie(napis);
            pierwszy = pierwszy + (pierwszy*drugi/100);
        }
        else if(dzialanie==2)
        {
            drugi = przeniesienie(napis);
            pierwszy = pierwszy - (pierwszy*drugi/100);
        }
        else if(dzialanie==3)
        {
            drugi = przeniesienie(napis);
            pierwszy = pierwszy * (pierwszy*drugi/100);
        }
        else if(dzialanie==4)
        {
            drugi = przeniesienie(napis);

            if(drugi==0)
            {
                toastowanie(context, "BŁĄD -> NIE MOZNA DZIELIC PRZEZ 0");
                blad = true;
            }
            else{
                pierwszy = pierwszy / (pierwszy*drugi/100);
            }
        }

        if(dzialanie!=0 && blad == false) {
            napis = przeniesienie(pierwszy);

            dzialanie = 0;
            drugi = 0;

            delete_kropka_kreska();
            is_kropka_there();
            is_znak();
            pole.setText(napis);
        }
        else if(blad == true)
        {
            clear_all(pole);
        }
    }

    double obl_sqrt(double war)
    {
        return Math.sqrt(war);
    }

    double obl_log10(double war, Context context)
    {
        if(war == 0)//nieskonczonosc
        {
            toastowanie(context, "BŁĄD -> LOG10 DLA 0 JEST RÓWNY MINUS NIESKOŃCZONOŚCI");
            blad = true;
            return 0;
        }
        else if(war < 0)//blad
        {
            toastowanie(context, "BŁĄD -> LOG10 DLA "+war+" NIE ISTNIEJE");
            blad = true;
            return 0;
        }
        else {
            return Math.log10(war);
        }
    }

    double obl_ln(double war, Context context)
    {
        if(war == 0)//nieskonczonosc
        {
            toastowanie(context, "BŁĄD -> LOGARYTM NATURALNY DLA 0 JEST RÓWNY MINUS NIESKOŃCZONOŚCI");
            blad = true;
            return 0;
        }
        else if(war < 0)//blad
        {
            toastowanie(context, "BŁĄD -> LOGARYTM NATURALNY DLA "+war+" NIE ISTNIEJE");
            blad = true;
            return 0;
        }
        else {
            return Math.log(war);
        }
    }

    double obl_potega_dwa(double war)
    {
        return (war*war);
    }

    double obl_sind(double war_w_stopniach)
    {
        if(war_w_stopniach%180 == 0){return 0;}

        return Math.sin(Math.toRadians(war_w_stopniach));
    }

    double obl_cosd(double war_w_stopniach)
    {
        if(war_w_stopniach%90 == 0)
        {
            if(war_w_stopniach%180 != 0)
            { return 0;}
        }

        return Math.cos(Math.toRadians(war_w_stopniach));
    }

    double obl_tand(double war_w_stopniach, Context context)
    {
        if(war_w_stopniach%90 == 0)
        {
            if(war_w_stopniach%180 != 0)
            {
                toastowanie(context, "BŁĄD -> TANGENS DLA "+war_w_stopniach+" NIE ISTNIEJE");
                blad = true;
            }
            return 0;
        }
        else{
            return Math.tan(Math.toRadians(war_w_stopniach));
        }
    }

    void inne_obl(TextView pole, int nr, Context context)
    {
        double wynik = przeniesienie(napis);

        switch (nr)
        {
            case 1:
                wynik = obl_sqrt(wynik);
                break;
            case 2:
                wynik = obl_log10(wynik, context);
                break;
            case 3:
                wynik = obl_ln(wynik, context);
                break;
            case 5:
                wynik = obl_potega_dwa(wynik);
                break;
            case 6:
                wynik = obl_sind(wynik);
                break;
            case 7:
                wynik = obl_cosd(wynik);
                break;
            case 8:
                wynik = obl_tand(wynik, context);
                break;

        }
        if(blad == true )
        {
            clear_all(pole);
        }
        else {
            napis = przeniesienie(wynik);

            delete_kropka_kreska();
            is_kropka_there();
            is_znak();
            pole.setText(napis);
        }
    }
}