/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.clr;

import java.util.Arrays;
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

		names.forEach(n -> heroService.save(new Hero(n)));
	}

}
