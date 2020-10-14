package com.llf.springboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
        public String  GetDate(Date data){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.format(data);
        }
}
