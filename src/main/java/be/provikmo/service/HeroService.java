/**
 * (c) 2016 ADMB. All rights reserved.
 */
package be.provikmo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import be.provikmo.model.Hero;

/**
 * @author Glenn Lefevere
 *
 */
@Service
public interface HeroService extends JpaRepository<Hero, Long> {

}
