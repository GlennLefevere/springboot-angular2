import { Component, OnInit } from '@angular/core';
import { Router }           from '@angular/router';

import {DataTable} from 'primeng/primeng';
import {Column} from 'primeng/primeng';
import {Menu, MenuItem} from 'primeng/primeng';
import {Messages} from 'primeng/primeng';
import {TabView} from 'primeng/primeng';
import {TabPanel} from 'primeng/primeng';
import {Dialog} from 'primeng/primeng';

import { Hero }        from './hero';
import { HeroService } from './hero.service';
import { HighlightDirective } from './highlight.directive';

@Component({
    selector: 'my-dashboard',
    templateUrl: 'app/dashboard.component.html',
    styleUrls: ['app/dashboard.component.css'],
    directives: [DataTable, Column, TabPanel, TabView, Dialog, HighlightDirective]
})
export class DashboardComponent implements OnInit {

    msgs: Message[];
    heroes: Hero[] = [];
    cols: any[];
    totalRecords: number;
    display: boolean = false;

    selectedHero: Hero;

    items: MenuItem[];

    constructor(
        private router: Router,
        private heroService: HeroService) {
    }

    ngOnInit() {
        this.heroService
            .getHeroes()
            .then(heroes => { this.heroes = heroes; this.totalRecords = this.heroes.length });

        this.cols = [
            { field: 'id', header: 'Id', sortable: true },
            { field: 'name', header: 'Name', sortable: true }
        ];

        this.items = [
            { label: 'View', icon: 'fa-search', command: (event) => this.viewCar(this.selectedCar) }
        ];

        console.log(this.heroes);
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
}