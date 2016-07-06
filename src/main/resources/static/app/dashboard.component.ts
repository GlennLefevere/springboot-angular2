import { Component, OnInit, Input } from '@angular/core';
import { Router }           from '@angular/router';
import {ROUTER_DIRECTIVES} from '@angular/router';

import {DataTable} from 'primeng/primeng';
import {Column} from 'primeng/primeng';
import {Menu, MenuItem} from 'primeng/primeng';
import {Messages} from 'primeng/primeng';
import {TabView} from 'primeng/primeng';
import {TabPanel} from 'primeng/primeng';
import {Dialog} from 'primeng/primeng';
import {OverlayPanel} from 'primeng/primeng';
import {Button} from 'primeng/primeng';
import {RadioButton} from 'primeng/primeng';

import { Hero }        from './hero';
import { HeroService } from './hero.service';
import { HighlightDirective } from './highlight.directive';

@Component({
    selector: 'my-dashboard',
    templateUrl: 'app/dashboard.component.html',
    styleUrls: ['app/dashboard.component.css'],
    directives: [DataTable, Column, TabPanel, TabView, Dialog, HighlightDirective, OverlayPanel, Button, RadioButton, ROUTER_DIRECTIVES]
})
export class DashboardComponent implements OnInit {

    msgs: Message[];
    heroes: Hero[] = [];
    totalRecords: number;
    display: boolean = false;

    selectedHero: Hero;
    @Input() val2: string = 'lightgreen';

    constructor(
        private router: Router,
        private heroService: HeroService) {
    }

    ngOnInit() {
        this.heroService
            .getHeroes()
            .then(heroes => { this.heroes = heroes; this.totalRecords = this.heroes.length; this.selectedHero = heroes[0] });
    }

    viewHero(hero: Hero) {
        this.msgs = [];
        this.msgs.push({ severity: 'info', summary: 'Hero Selected', detail: hero.id + ' - ' + hero.name });
    }

    gotoDetail(hero: Hero) {
        let link = ['/detail', hero.id];
        this.router.navigate(link);
    }

    showDialog() {
        this.display = true;
    }

    selectCar(event, hero: Hero, overlaypanel: OverlayPanel) {
        this.selectedHero = hero;
        overlaypanel.toggle(event);
    }
}