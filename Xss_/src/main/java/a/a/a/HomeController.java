package a.a.a;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("view")
	public void view() {
		
	}
	
	@PostMapping("insert01")
	public void insert01(@RequestParam String txt, HttpServletResponse res) throws IOException {
		txt = replaceParam(txt);
		System.out.println( txt );
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print( txt );
	}
	
	@PostMapping("insert02")
	public void insert02(@RequestParam String txt1,@RequestParam String txt2, HttpServletResponse res) throws IOException {

		System.out.println( txt1 );
		System.out.println( txt2 );
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print( txt1+txt2 );
	}
	@PostMapping("insert03")
	public void insert03(@RequestParam String txt1,@RequestParam MultipartFile file, HttpServletResponse res) throws IOException {
		
		System.out.println( txt1 );
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print( txt1 );
	}
	private String replaceParam(String txt) {
		txt = txt.replace("<", "&lt;");
		txt = txt.replace(">", "&gt;");
		txt = txt.replace("\"", "&quot;");
		return txt;
	}
}
