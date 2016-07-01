/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import be.provikmo.model.Hero;
import be.provikmo.service.HeroService;

/**
 * @author Glenn Lefevere
 *
 */
@RestController
@RequestMapping("/api/heroes")
public class HeroController {

	@Autowired
	private HeroService heroService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody List<Hero> index() {
		return heroService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		heroService.delete(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public @ResponseBody Hero update(@PathVariable Long id, @RequestBody Hero hero) {
		return heroService.save(hero);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public @ResponseBody Hero save(@RequestBody Hero hero) {
		return heroService.save(hero);
	}

}
