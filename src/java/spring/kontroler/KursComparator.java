package spring.kontroler;

import java.util.Comparator;
import spring.model.Kurs;

    public class KursComparator implements Comparator<Kurs> {

        @Override
        public int compare(Kurs k1, Kurs k2) {
            return k1.getId().compareTo(k2.getId());
        }
    }