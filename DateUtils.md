
####线程安全的工具类，当然也可以用第三方的工具类
```
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	//解决线程不安全问题，匿名内部类（试<>后无法实现，只能<XXX>这样后才不会报错）
	private static ThreadLocal<DateFormat> dateFormat = new ThreadLocal<DateFormat>(){
		protected DateFormat initialValue() {return new SimpleDateFormat("yyyy-MM-dd");};
	};
	
	public static  String formatDate(Date date)throws ParseException{
        return dateFormat.get().format(date);
    }
    
    public static Date parse(String strDate) throws ParseException{

        return dateFormat.get().parse(strDate);
    }
}
```