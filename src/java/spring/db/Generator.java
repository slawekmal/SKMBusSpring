/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.db;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.model.Klient;
import spring.model.Kurs;

@Component
public class Generator {

    @Autowired
    private KlientService klientService;
    @Autowired
    private KursService kursService;

    @PostConstruct
    public void wrzucDane() {
        if (klientService.listKlients().isEmpty()) {

            Klient admin = new Klient("Admin", "Admin", "admin@admin.com", "admin");

            Calendar pon = new GregorianCalendar();
            pon.set(2016, 6, 6);
            Calendar wt = new GregorianCalendar();
            wt.set(2016, 6, 7);
            Calendar sr = new GregorianCalendar();
            sr.set(2016, 6, 8);
            Calendar cz = new GregorianCalendar();
            cz.set(2016, 6, 9);
            Calendar pt = new GregorianCalendar();
            pt.set(2016, 6, 10);
            Calendar sb = new GregorianCalendar();
            sb.set(2016, 6, 11);
            Calendar nd = new GregorianCalendar();
            nd.set(2016, 6, 12);

            Kurs pon1 = new Kurs(pon, "6:30", 18, "Hrubieszów - Lublin");
            Kurs pon2 = new Kurs(pon, "8:00", 18, "Hrubieszów - Lublin");
            Kurs pon3 = new Kurs(pon, "9:30", 18, "Hrubieszów - Lublin");
            Kurs pon4 = new Kurs(pon, "11:00", 18, "Hrubieszów - Lublin");
            Kurs pon5 = new Kurs(pon, "13:00", 18, "Hrubieszów - Lublin");
            Kurs pon6 = new Kurs(pon, "15:00", 18, "Hrubieszów - Lublin");
            Kurs pon7 = new Kurs(pon, "16:30", 18, "Hrubieszów - Lublin");
            Kurs pon8 = new Kurs(pon, "7:30", 18, "Lublin - Hrubieszów");
            Kurs pon9 = new Kurs(pon, "9:00", 18, "Lublin - Hrubieszów");
            Kurs pon10 = new Kurs(pon, "11:00", 18, "Lublin - Hrubieszów");
            Kurs pon11 = new Kurs(pon, "13:00", 18, "Lublin - Hrubieszów");
            Kurs pon12 = new Kurs(pon, "15:00", 18, "Lublin - Hrubieszów");
            Kurs pon13 = new Kurs(pon, "16:30", 18, "Lublin - Hrubieszów");
            Kurs pon14 = new Kurs(pon, "18:00", 18, "Lublin - Hrubieszów");

            Kurs wt1 = new Kurs(wt, "6:30", 18, "Hrubieszów - Lublin");
            Kurs wt2 = new Kurs(wt, "8:00", 18, "Hrubieszów - Lublin");
            Kurs wt3 = new Kurs(wt, "9:30", 18, "Hrubieszów - Lublin");
            Kurs wt4 = new Kurs(wt, "11:00", 18, "Hrubieszów - Lublin");
            Kurs wt5 = new Kurs(wt, "13:00", 18, "Hrubieszów - Lublin");
            Kurs wt6 = new Kurs(wt, "15:00", 18, "Hrubieszów - Lublin");
            Kurs wt7 = new Kurs(wt, "16:30", 18, "Hrubieszów - Lublin");
            Kurs wt8 = new Kurs(wt, "7:30", 18, "Lublin - Hrubieszów");
            Kurs wt9 = new Kurs(wt, "9:00", 18, "Lublin - Hrubieszów");
            Kurs wt10 = new Kurs(wt, "11:00", 18, "Lublin - Hrubieszów");
            Kurs wt11 = new Kurs(wt, "13:00", 18, "Lublin - Hrubieszów");
            Kurs wt12 = new Kurs(wt, "15:00", 18, "Lublin - Hrubieszów");
            Kurs wt13 = new Kurs(wt, "16:30", 18, "Lublin - Hrubieszów");
            Kurs wt14 = new Kurs(wt, "18:00", 18, "Lublin - Hrubieszów");

            Kurs sr1 = new Kurs(sr, "6:30", 18, "Hrubieszów - Lublin");
            Kurs sr2 = new Kurs(sr, "8:00", 18, "Hrubieszów - Lublin");
            Kurs sr3 = new Kurs(sr, "9:30", 18, "Hrubieszów - Lublin");
            Kurs sr4 = new Kurs(sr, "11:00", 18, "Hrubieszów - Lublin");
            Kurs sr5 = new Kurs(sr, "13:00", 18, "Hrubieszów - Lublin");
            Kurs sr6 = new Kurs(sr, "15:00", 18, "Hrubieszów - Lublin");
            Kurs sr7 = new Kurs(sr, "16:30", 18, "Hrubieszów - Lublin");
            Kurs sr8 = new Kurs(sr, "7:30", 18, "Lublin - Hrubieszów");
            Kurs sr9 = new Kurs(sr, "9:00", 18, "Lublin - Hrubieszów");
            Kurs sr10 = new Kurs(sr, "11:00", 18, "Lublin - Hrubieszów");
            Kurs sr11 = new Kurs(sr, "13:00", 18, "Lublin - Hrubieszów");
            Kurs sr12 = new Kurs(sr, "15:00", 18, "Lublin - Hrubieszów");
            Kurs sr13 = new Kurs(sr, "16:30", 18, "Lublin - Hrubieszów");
            Kurs sr14 = new Kurs(sr, "18:00", 18, "Lublin - Hrubieszów");

            Kurs cz1 = new Kurs(cz, "6:30", 18, "Hrubieszów - Lublin");
            Kurs cz2 = new Kurs(cz, "8:00", 18, "Hrubieszów - Lublin");
            Kurs cz3 = new Kurs(cz, "9:30", 18, "Hrubieszów - Lublin");
            Kurs cz4 = new Kurs(cz, "11:00", 18, "Hrubieszów - Lublin");
            Kurs cz5 = new Kurs(cz, "13:00", 18, "Hrubieszów - Lublin");
            Kurs cz6 = new Kurs(cz, "15:00", 18, "Hrubieszów - Lublin");
            Kurs cz7 = new Kurs(cz, "16:30", 18, "Hrubieszów - Lublin");
            Kurs cz8 = new Kurs(cz, "7:30", 18, "Lublin - Hrubieszów");
            Kurs cz9 = new Kurs(cz, "9:00", 18, "Lublin - Hrubieszów");
            Kurs cz10 = new Kurs(cz, "11:00", 18, "Lublin - Hrubieszów");
            Kurs cz11 = new Kurs(cz, "13:00", 18, "Lublin - Hrubieszów");
            Kurs cz12 = new Kurs(cz, "15:00", 18, "Lublin - Hrubieszów");
            Kurs cz13 = new Kurs(cz, "16:30", 18, "Lublin - Hrubieszów");
            Kurs cz14 = new Kurs(cz, "18:00", 18, "Lublin - Hrubieszów");

            Kurs pt1 = new Kurs(pt, "6:30", 18, "Hrubieszów - Lublin");
            Kurs pt2 = new Kurs(pt, "8:00", 18, "Hrubieszów - Lublin");
            Kurs pt3 = new Kurs(pt, "9:30", 18, "Hrubieszów - Lublin");
            Kurs pt4 = new Kurs(pt, "11:00", 18, "Hrubieszów - Lublin");
            Kurs pt5 = new Kurs(pt, "13:00", 18, "Hrubieszów - Lublin");
            Kurs pt6 = new Kurs(pt, "15:00", 18, "Hrubieszów - Lublin");
            Kurs pt7 = new Kurs(pt, "16:30", 18, "Hrubieszów - Lublin");
            Kurs pt8 = new Kurs(pt, "7:30", 18, "Lublin - Hrubieszów");
            Kurs pt9 = new Kurs(pt, "9:00", 18, "Lublin - Hrubieszów");
            Kurs pt10 = new Kurs(pt, "11:00", 18, "Lublin - Hrubieszów");
            Kurs pt11 = new Kurs(pt, "13:00", 18, "Lublin - Hrubieszów");
            Kurs pt12 = new Kurs(pt, "15:00", 18, "Lublin - Hrubieszów");
            Kurs pt13 = new Kurs(pt, "16:30", 18, "Lublin - Hrubieszów");
            Kurs pt14 = new Kurs(pt, "18:00", 18, "Lublin - Hrubieszów");

            Kurs sb1 = new Kurs(sb, "6:30", 18, "Hrubieszów - Lublin");
            Kurs sb2 = new Kurs(sb, "8:00", 18, "Hrubieszów - Lublin");
            Kurs sb3 = new Kurs(sb, "9:30", 18, "Hrubieszów - Lublin");
            Kurs sb4 = new Kurs(sb, "11:00", 18, "Hrubieszów - Lublin");
            Kurs sb5 = new Kurs(sb, "13:00", 18, "Hrubieszów - Lublin");
            Kurs sb6 = new Kurs(sb, "15:00", 18, "Hrubieszów - Lublin");
            Kurs sb7 = new Kurs(sb, "16:30", 18, "Hrubieszów - Lublin");
            Kurs sb8 = new Kurs(sb, "7:30", 18, "Lublin - Hrubieszów");
            Kurs sb9 = new Kurs(sb, "9:00", 18, "Lublin - Hrubieszów");
            Kurs sb10 = new Kurs(sb, "11:00", 18, "Lublin - Hrubieszów");
            Kurs sb11 = new Kurs(sb, "13:00", 18, "Lublin - Hrubieszów");
            Kurs sb12 = new Kurs(sb, "15:00", 18, "Lublin - Hrubieszów");
            Kurs sb13 = new Kurs(sb, "16:30", 18, "Lublin - Hrubieszów");
            Kurs sb14 = new Kurs(sb, "18:00", 18, "Lublin - Hrubieszów");

            Kurs nd1 = new Kurs(nd, "6:30", 18, "Hrubieszów - Lublin");
            Kurs nd2 = new Kurs(nd, "8:00", 18, "Hrubieszów - Lublin");
            Kurs nd3 = new Kurs(nd, "9:30", 18, "Hrubieszów - Lublin");
            Kurs nd4 = new Kurs(nd, "11:00", 18, "Hrubieszów - Lublin");
            Kurs nd5 = new Kurs(nd, "13:00", 18, "Hrubieszów - Lublin");
            Kurs nd6 = new Kurs(nd, "15:00", 18, "Hrubieszów - Lublin");
            Kurs nd7 = new Kurs(nd, "16:30", 18, "Hrubieszów - Lublin");
            Kurs nd8 = new Kurs(nd, "7:30", 18, "Lublin - Hrubieszów");
            Kurs nd9 = new Kurs(nd, "9:00", 18, "Lublin - Hrubieszów");
            Kurs nd10 = new Kurs(nd, "11:00", 18, "Lublin - Hrubieszów");
            Kurs nd11 = new Kurs(nd, "13:00", 18, "Lublin - Hrubieszów");
            Kurs nd12 = new Kurs(nd, "15:00", 18, "Lublin - Hrubieszów");
            Kurs nd13 = new Kurs(nd, "16:30", 18, "Lublin - Hrubieszów");
            Kurs nd14 = new Kurs(nd, "18:00", 18, "Lublin - Hrubieszów");

            klientService.createKlient(admin);
            kursService.createKurs(pon1);
            kursService.createKurs(pon2);
            kursService.createKurs(pon3);
            kursService.createKurs(pon4);
            kursService.createKurs(pon5);
            kursService.createKurs(pon6);
            kursService.createKurs(pon7);
            kursService.createKurs(pon8);
            kursService.createKurs(pon9);
            kursService.createKurs(pon10);
            kursService.createKurs(pon11);
            kursService.createKurs(pon12);
            kursService.createKurs(pon13);
            kursService.createKurs(pon14);
            kursService.createKurs(wt1);
            kursService.createKurs(wt2);
            kursService.createKurs(wt3);
            kursService.createKurs(wt4);
            kursService.createKurs(wt5);
            kursService.createKurs(wt6);
            kursService.createKurs(wt7);
            kursService.createKurs(wt8);
            kursService.createKurs(wt9);
            kursService.createKurs(wt10);
            kursService.createKurs(wt11);
            kursService.createKurs(wt12);
            kursService.createKurs(wt13);
            kursService.createKurs(wt14);
            kursService.createKurs(sr1);
            kursService.createKurs(sr2);
            kursService.createKurs(sr3);
            kursService.createKurs(sr4);
            kursService.createKurs(sr5);
            kursService.createKurs(sr6);
            kursService.createKurs(sr7);
            kursService.createKurs(sr8);
            kursService.createKurs(sr9);
            kursService.createKurs(sr10);
            kursService.createKurs(sr11);
            kursService.createKurs(sr12);
            kursService.createKurs(sr13);
            kursService.createKurs(sr14);
            kursService.createKurs(cz2);
            kursService.createKurs(cz3);
            kursService.createKurs(cz4);
            kursService.createKurs(cz5);
            kursService.createKurs(cz6);
            kursService.createKurs(cz7);
            kursService.createKurs(cz8);
            kursService.createKurs(cz9);
            kursService.createKurs(cz10);
            kursService.createKurs(cz11);
            kursService.createKurs(cz12);
            kursService.createKurs(cz13);
            kursService.createKurs(cz14);
            kursService.createKurs(pt1);
            kursService.createKurs(pt2);
            kursService.createKurs(pt3);
            kursService.createKurs(pt4);
            kursService.createKurs(pt5);
            kursService.createKurs(pt6);
            kursService.createKurs(pt7);
            kursService.createKurs(pt8);
            kursService.createKurs(pt9);
            kursService.createKurs(pt10);
            kursService.createKurs(pt11);
            kursService.createKurs(pt12);
            kursService.createKurs(pt13);
            kursService.createKurs(pt14);
            kursService.createKurs(sb1);
            kursService.createKurs(sb2);
            kursService.createKurs(sb3);
            kursService.createKurs(sb4);
            kursService.createKurs(sb5);
            kursService.createKurs(sb6);
            kursService.createKurs(sb7);
            kursService.createKurs(sb8);
            kursService.createKurs(sb9);
            kursService.createKurs(sb10);
            kursService.createKurs(sb11);
            kursService.createKurs(sb12);
            kursService.createKurs(sb13);
            kursService.createKurs(sb14);
            kursService.createKurs(nd1);
            kursService.createKurs(nd2);
            kursService.createKurs(nd3);
            kursService.createKurs(nd4);
            kursService.createKurs(nd5);
            kursService.createKurs(nd6);
            kursService.createKurs(nd7);
            kursService.createKurs(nd8);
            kursService.createKurs(nd9);
            kursService.createKurs(nd10);
            kursService.createKurs(nd11);
            kursService.createKurs(nd12);
            kursService.createKurs(nd13);
            kursService.createKurs(nd14);
        }
    }
}
