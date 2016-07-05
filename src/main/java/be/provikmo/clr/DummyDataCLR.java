/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.clr;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import be.provikmo.model.Hero;
import be.provikmo.service.HeroService;

/**
 * @author Glenn Lefevere
 *
 */
@Component
public class DummyDataCLR implements CommandLineRunner {

	@Autowired
	private HeroService heroService;

	/** {@inheritDoc} */
	@Override
	public void run(String... arg0) throws Exception {
		List<String> names =
			Arrays.asList("Jos", "Pol", "Max", "Jozef", "Hans", "Piet", "Tom", "Tim", "Jan", "Maarten", "Luc");

		List<String> lastNames =
			Arrays.asList("Verstappen", "D'hooge", "Verstappen", "Van Nazareth", "Van Alphen", "De witte", "Waes",
				"Blomme", "De korte", "De grote", "Lidou");

		names.forEach(n -> heroService.save(new Hero(n, lastNames.get(names.indexOf(n)), getRandomDate())));
	}

	private Date getRandomDate() {
		Calendar calendar = Calendar.getInstance();

		int year = randBetween(1900, 2010);

		calendar.set(Calendar.YEAR, year);

		int dayOfYear = randBetween(1, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));

		calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);

		return calendar.getTime();
	}

	private int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

}
